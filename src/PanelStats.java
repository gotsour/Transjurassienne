import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class PanelStats extends JPanel {
    JLabel nbParticipantsLabel;
    JTextField nbParticipants;
    JLabel temps;
    JTextField tempsMoyen;
    Insets insets;

    public PanelStats(Annee annee, String raceCat) {


        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();
        GridBagConstraints gc2 = new GridBagConstraints();
        insets = new Insets(10, 0, 0, 0);
        gc.insets = insets;
        gc2.insets = insets;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.fill = GridBagConstraints.NONE;
        nbParticipantsLabel = new JLabel("Nombre de participants: ");
        add(nbParticipantsLabel, gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        nbParticipants = new JTextField(10);
        nbParticipants.setEditable(false);
        nbParticipants.setBackground(Color.WHITE);
        nbParticipants.setText("" + Parser.getInstance().numberOfParticipants(annee, raceCat));

        gc.gridx = 2;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.fill = GridBagConstraints.NONE;
        temps = new JLabel("Temps moyen de l'épreuve : ");
        add(temps, gc);

        gc.gridx = 3;
        gc.anchor = GridBagConstraints.LINE_START;
        tempsMoyen = new JTextField(10);
        tempsMoyen.setEditable(false);
        tempsMoyen.setBackground(Color.WHITE);
        int anneeInt = annee.getAnnee();
        String anneeString = Integer.toString(anneeInt);
        tempsMoyen.setText("" + Parser.getInstance().averageTime(anneeString, raceCat));
        add(tempsMoyen, gc);
    }

    public void updateField(Annee annee, String raceCat) {
        nbParticipants.setText("" + Parser.getInstance().numberOfParticipants(annee, raceCat));
    }
}
