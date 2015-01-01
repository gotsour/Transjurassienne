import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;


public class Fenetre extends JFrame {
    private PanelTop panelTop;
    private PanelResultats panelResultats;
    private PanelStats panelStatistiques;
    private PanelGraph panelGraph;

    private Menu menu;
    private JTabbedPane tabs;

    private Annee currentYear;
    private String raceCat;

    public Fenetre() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(800, 600));
        setLocationRelativeTo(null);

        // Set menu
        menu = new Menu();
        setJMenuBar(menu);

        // Set up tabbed pane
        tabs = new JTabbedPane();

        // Set the main panel with a border layout
        setLayout(new BorderLayout());

        // Add northPannel to the main panel
        panelTop = new PanelTop();
        currentYear = Parser.getInstance().getYears().get(panelTop.getSelectedYear());
        raceCat = new String();
        raceCat = panelTop.getSelectedRace();
        // Tab results
        panelResultats = new PanelResultats(currentYear.getEpreuve().get(raceCat).getParticipants());
        tabs.addTab("Resultats", panelResultats);

        // Tab stats
        panelStatistiques = new PanelStats(currentYear, raceCat);
        tabs.addTab("Statistiques", panelStatistiques);

        // Tab graphs
        panelGraph = new PanelGraph(currentYear, raceCat);
        tabs.addTab("Graphics", panelGraph);

        // Listening event from northPanel
        panelTop.setDataListener(new DataListener() {
            public void dataEmitted(DataEvent e) {
                int anneeInt = Integer.parseInt(e.getYear());
                currentYear = new Annee(anneeInt);
                raceCat = e.getRaceCat();
                panelResultats.updateField(currentYear.getEpreuve().get(raceCat).getParticipants());
                panelStatistiques.updateField(currentYear, raceCat);
                panelGraph.updateField(currentYear, raceCat);
            }
        });

        add(panelTop, BorderLayout.NORTH);
        add(tabs, BorderLayout.CENTER);

        setVisible(true);
    }

}
