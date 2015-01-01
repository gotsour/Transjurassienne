import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class PanelStats extends JPanel {
    Parser dm;
    JLabel nbParticipantsLabel;
    JTextField nbParticipants;
    Insets insets;

    public PanelStats(Annee annee, String raceCat) {
        dm = Parser.getInstance();

        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();
        insets = new Insets(10, 0, 0, 0);
        gc.insets = insets;

        //First row //////////////////////////////////////////////////////////
        gc.gridy = 0;

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
        nbParticipants.setText("" + dm.numberOfParticipants("" + annee.getAnnee(), raceCat));
        add(nbParticipants, gc);

    }

    public void updateField(Annee annee, String raceCat) {
        nbParticipants.setText("" + dm.numberOfParticipants(""+annee.getAnnee(), raceCat));
    }
}
