
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;


public class TableauResultats extends AbstractTableModel {
    private final static String PATH_TO_IMG = "rss\\img\\";
    private ArrayList<Coureur> hm;
    private Object[][] data1;
    private String[] columnTitles = { "#", "Nom", "Naissance", "Club", "Temps",
            "Classement catégorie", "Pays" };

    public TableauResultats(ArrayList<Coureur> data) {
        hm=data;
        data1 = new Object[hm.size()][7];
        int n = 0;
        Iterator<Coureur> it = hm.iterator();
        while (it.hasNext()) {
            Coureur tmpc = it.next();
            data1[n][0] = tmpc.getClassement();
            data1[n][1] = tmpc.getNom();
            data1[n][2] = tmpc.getNaissance();
            data1[n][3] = tmpc.getClub();
            data1[n][4] = tmpc.getTemps();
            data1[n][5] = tmpc.getClassement_cat();
            data1[n][6] = new ImageIcon(PATH_TO_IMG + tmpc.getNationalite().toLowerCase() + ".gif");
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
