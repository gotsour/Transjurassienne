import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;


public class PanelStats extends JPanel {

    JTable table;
    Annee year;
    String raceCat;
    JLabel nbParticipantsLabel;
    JLabel averageTimeLabel;
    JLabel nbOfCountryLabel;
    JLabel minTimeLabel;
    JLabel maxTimeLabel;
    JLabel timeGapLabel;
    JTextField nbParticipants;
    JTextField averageTime;
    JTextField nbOfCountry;
    JTextField minTime;
    JTextField maxTime;
    JTextField timeGap;
    Insets insets;

    public PanelStats(Annee annee, String raceCat) {


        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();
        GridBagConstraints gc2 = new GridBagConstraints();
        insets = new Insets(10, 0, 0, 0);
        gc.insets = insets;
        gc2.insets = insets;

        //First row //////////////////////////////////////////////////////////
        gc.gridy = 0;
       // gc2.gridy = 50;

        gc.gridx = 0;
       // gc2.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.fill = GridBagConstraints.NONE;
       // gc2.anchor = GridBagConstraints.LINE_END;
        //gc2.fill = GridBagConstraints.NONE;
        nbParticipantsLabel = new JLabel("Nombre de participants: ");
       // averageTimeLabel = new JLabel("Temps Moyen: ");
        add(nbParticipantsLabel, gc);
       // add(averageTimeLabel,gc2);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
       // gc2.gridx = 1;
       // gc2.anchor = GridBagConstraints.LINE_START;
        nbParticipants = new JTextField(10);
      //  averageTime = new JTextField(10);
        nbParticipants.setEditable(false);
        //averageTime.setEditable(false);
        nbParticipants.setBackground(Color.WHITE);
        //averageTime.setBackground(Color.WHITE);
        nbParticipants.setText("" + Parser.getInstance().numberOfParticipants(annee, raceCat));
        //averageTime.setText("" + Parser.getInstance().averageTime(annee,raceCat));
        add(nbParticipants, gc);
        //add(averageTime,gc2);

    }

    public void updateField(Annee annee, String raceCat) {
        nbParticipants.setText("" + Parser.getInstance().numberOfParticipants(annee, raceCat));
        //averageTime.setText("" + Parser.getInstance().averageTime(annee,raceCat));
    }
}
