import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
public class Fenetre extends JFrame {
    private PanelTop panelTop;
    private PanelResultats panelResultats;
    private PanelStats panelStatistiques;
    private JTabbedPane tabs;
    private Annee currentYear;
    private String raceCat;
    public Fenetre() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(800, 600));
        setLocationRelativeTo(null);
        tabs = new JTabbedPane();
        setLayout(new BorderLayout());
        panelTop = new PanelTop();
        currentYear = Parser.getInstance().getYears().get(panelTop.getSelectedYear());
        System.out.println(currentYear.getAnnee());
        raceCat = new String();
        raceCat = panelTop.getSelectedRace();
        System.out.println(raceCat);
        panelResultats = new PanelResultats(currentYear.getEpreuve().get(raceCat).getParticipants());
        tabs.addTab("Resultats", panelResultats);
        panelStatistiques = new PanelStats(currentYear, raceCat);
        tabs.addTab("Statistiques", panelStatistiques);
        panelTop.setDataListener(new DataListener() {
            public void dataEmitted(DataEvent e) {
                if (Parser.getInstance().getYears().get(panelTop.getSelectedYear()) != currentYear) {
                    currentYear = Parser.getInstance().getYears().get(panelTop.getSelectedYear());
                }
                raceCat = e.getRaceCat();
                panelResultats.updateField(currentYear.getEpreuve().get(raceCat).getParticipants());
                panelStatistiques.updateField(currentYear, raceCat);
            }
        });
        add(panelTop, BorderLayout.NORTH);
        add(tabs, BorderLayout.CENTER);
        setVisible(true);
    }
}