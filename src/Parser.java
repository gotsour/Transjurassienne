import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;

public class Parser {

    private TreeSet<Coureur> coureurTreeSet;
    private HashMap<String, Annee> annees;
    private String path;

    private static Parser instance = null;
    public static Parser getInstance() {
        if (null == instance)
            instance = new Parser(new String("C:\\Users\\thomas\\workspace\\Transjurassienne\\rss\\csv\\2011.csv"));
        return instance;
    }

    public Parser(String file_path) {
        path = file_path;
    }

    ArrayList<HashMap<String, String>> data = new ArrayList<HashMap<String, String>>();

    public void parse() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "ISO-8859-1"));
        String line = "";
        int lineNumber = 0;
        int col = 0;
        HashMap<String, String> tmpLine;
        line = br.readLine();
        String[] keys = line.split(";");
        while (null != (line = br.readLine())) {
            if (0 != lineNumber) {
                tmpLine = new HashMap<String, String>();
                col = 0;
                for (String key : keys) {
                    tmpLine.put(key, line.split(";")[col]);
                    col += 1;
                }
                data.add(tmpLine);
            }
            lineNumber += 1;
        }
        br.close();
        System.out.println(data);
    }

    public void creerPersonne() {
        Annee tmpYear;
        HashMap<String, Annee> annees;
        Coureur tmpCoureur;

        String nom = "";
        int naissance = 0;
        String club = "";
        String nationalite = "";
        String categorie = "";
        int classement = 0;
        int classement_cat = 0;
        String temps = "";

        annees = new HashMap<String, Annee>();


        tmpYear = new Annee(2011);
        for (HashMap<String, String> entry : data) {
            if (!entry.get("Nom").isEmpty()
                    && !entry.get("Nation").isEmpty()
                    && !(null == entry.get("Course"))
                    && !entry.get("Naissance").isEmpty()) {
                nom = entry.get("Nom");
                try {
                    naissance = Integer.parseInt(entry.get("Naissance"));
                } catch (NumberFormatException e) {
                    naissance = 0;
                }
                club = entry.get("Club");
                nationalite = entry.get("Nation");
                categorie = entry.get("Nom_Categorie");
                classement = Integer.parseInt(entry.get("Classement"));
                classement_cat = Integer.parseInt(entry.get("Classement_cat"));
                temps = entry.get("Arrivee");
                if ('F' == entry.get("Course").charAt(entry.get("Course").length() - 1))
                    tmpCoureur = new Femme(nom, naissance, club, nationalite, categorie, classement, temps, classement_cat);
                else
                    tmpCoureur = new Homme(nom, naissance, club, nationalite, categorie, classement, temps, classement_cat);
                tmpYear.getEpreuve().get(entry.get("Course")).addParticipant(tmpCoureur);
                coureurTreeSet.add(tmpCoureur);
            }
        }
        annees.put("2011", tmpYear);
    }

    public HashMap<String, Annee> getYears() {
        return instance.annees;
    }

    public int numberOfParticipants(String year, String category) {
        return instance.getYears().get(year).getEpreuve().get(category).getParticipants().size();
    }

    public static String formatTime(int time) {
        StringBuilder strb = new StringBuilder();
        int h, m, s, cs;
        h = (time - (time % 360000)) / 360000;
        time -= h * 360000;
        m = (time - (time % 6000)) / 6000;
        time -= m * 6000;
        s = (time - (time % 100)) / 100;
        time -= s * 100;
        cs = time;
        if (0 < h)
            strb.append(h + ":");
        if (10 > m)
            strb.append("0");
        strb.append(m + ".");
        if (10 > s)
            strb.append("0");
        strb.append(s + ",");
        if (10 > cs)
            strb.append("0");
        strb.append(cs);
        return strb.toString();
    }
}