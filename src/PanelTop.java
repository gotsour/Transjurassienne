
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.*;
import javax.swing.border.Border;

public class PanelTop extends JPanel implements ActionListener {
    private JLabel yearLabel;
    private JLabel raceCatLabel;
    private JLabel searchFieldLabel;
    private JComboBox raceCat;
    private JComboBox year;
    private JTextField searchField;
    private DataListener listener;

    private String[] yearsString;
    private String[] raceCategoryString = { "25CTF", "25CTM", "25FTF", "25FTM",
            "50CTF", "50CTM", "76FTF", "76FTM", "30FTM", "30FTF", "50FTM", "50FTF", "70FTM", "70FTF" };

    public PanelTop() {
        super();

        yearLabel = new JLabel("Year : ");

        raceCatLabel = new JLabel("Category : ");

        // Set up the pannel
        setLayout(new FlowLayout(FlowLayout.CENTER));
        Border outter = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        Border inner = BorderFactory.createEtchedBorder();
        setBorder(BorderFactory.createCompoundBorder(outter, inner));

        // Set up the yearLabel
        yearLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
        add(yearLabel, this);

        // Set up the year ComboBox
        yearsString = new String[4];
        yearsString[0] = "2011";
        yearsString[1] = "2012";
        yearsString[2] = "2013";
        yearsString[3] = "2014";


        Arrays.sort(yearsString);
        year = new JComboBox(yearsString);
        year.setName("year");
        year.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 30));
        year.addActionListener(this);
        add(year, this);

        // Set up the raceCatLabel
        raceCatLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
        add(raceCatLabel, this);

        // Set up the raceCat ComboBox
        raceCat = new JComboBox(raceCategoryString);
        raceCat.setName("race");
        raceCat.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 30));
        raceCat.addActionListener(this);
        add(raceCat, this);

        /*// Set up the searchFieldLabel
        searchFieldLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
        add(searchFieldLabel, this);

        // Set up the search TextField
        searchField.setBorder(BorderFactory.createEtchedBorder());
        add(searchField, this);*/
    }

    public void setDataListener(DataListener listener) {
        this.listener = listener;
    }

    public void actionPerformed(ActionEvent e) {
        if (listener != null) {
            String yearData = (String) year.getSelectedItem();
            String raceCatData = (String) raceCat.getSelectedItem();

            DataEvent dataEvent = new DataEvent(yearData, raceCatData);

            listener.dataEmitted(dataEvent);

        }
    }

    public String getSelectedYear() {
        return yearsString[year.getSelectedIndex()];
    }

    public String getSelectedRace() {
        return raceCategoryString[raceCat.getSelectedIndex()];
    }
}
