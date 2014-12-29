

import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;

import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;
import javax.swing.text.html.HTMLDocument;


public class TableauResultats extends AbstractTableModel {
    private final static String PATH_TO_IMG = "./assets/img/";
    private TreeSet<Coureur> hm;
    private Object[][] data1;
    private String[] columnTitles = { "#", "Nom", "Naissance", "Club", "Temps",
            "Classement catégorie", "Pays" };

    public TableauResultats(TreeSet<Coureur> data) {
        Object[][] data1 = hm.toArray(new Object[hm.size()][7]);
        int n = 0;
        Iterator<Coureur> it = hm.iterator();
        while (it.hasNext()) {
            data1[n][0] = it.next().getClassement();
            data1[n][1] = it.next().getNom();
            data1[n][2] = it.next().getNaissance();
            data1[n][3] = it.next().getClub();
            data1[n][4] = it.next().getTemps();
            data1[n][5] = it.next().getClassement_cat();
            data1[n][6] = new ImageIcon(PATH_TO_IMG + it.next().getNationalite().toLowerCase() + ".gif");
            n += 1;
        }
    }

    @Override
    public Class<?> getColumnClass(int col) {
        return getValueAt(0, col).getClass();
    }

    @Override
    public int getColumnCount() {
        return columnTitles.length;
    }

    @Override
    public int getRowCount() {
        return data1.length;
    }

    @Override
    public Object getValueAt(int row, int col) {
        return data1[row][col];
    }

    public String getColumnName(int col) {
        return columnTitles[col];
    }
}
