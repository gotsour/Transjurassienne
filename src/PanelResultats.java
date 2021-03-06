import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.util.ArrayList;


public class PanelResultats extends JPanel {
    private JTable table;

    public PanelResultats(ArrayList<Coureur> data) {
        super();
        this.updateField(data);
    }

    public void setData(ArrayList<Coureur> data) {
        this.table = new JTable(new TableauResultats(data));
    }

    public void updateField(ArrayList<Coureur> data) {
        this.removeAll();

        if(data.size() != 0) {
            setLayout(new GridLayout(1, 1));
            table = new JTable(new TableauResultats(data));
            table.getColumn("#").setPreferredWidth(100);
            table.getColumn("Nom").setPreferredWidth(800);
            table.getColumn("Naissance").setPreferredWidth(300);
            table.getColumn("Club").setPreferredWidth(700);
            table.getColumn("Temps").setPreferredWidth(400);
            table.getColumn("Classement catégorie").setPreferredWidth(400);
            table.getColumn("Pays").setPreferredWidth(200);

            table.setAutoCreateRowSorter(true);
            table.setColumnSelectionAllowed(false);

            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(JLabel.CENTER);

            JTableHeader header = table.getTableHeader();
            header.setCursor(new Cursor(Cursor.HAND_CURSOR));
            header.setReorderingAllowed(false);

            table.setAutoCreateRowSorter(true);
            DefaultRowSorter<?, ?> sorter = ((DefaultRowSorter<?, ?>) table.getRowSorter());
            ArrayList<RowSorter.SortKey> list = new ArrayList<RowSorter.SortKey>();
            list.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
            sorter.setSortKeys(list);
            sorter.sort();

            table.setDefaultRenderer(Integer.class, centerRenderer);
            add(new JScrollPane(table));
        }else{
            JOptionPane.showMessageDialog(null,"Cette course n'existe pas pour cette année");
        }
        this.revalidate();
    }
}
