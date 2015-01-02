
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;


public class Parser {

    private ArrayList<Coureur> coureurList;
    private HashMap<String, Annee> annees;
    private String path;
    private ArrayList<HashMap<String, String>> data;

    private static Parser instance = null;

    public static Parser getInstance() {
        if (null == instance)
            instance = new Parser();
        return instance;
    }

    public Parser() {
        instance = this;
        coureurList = new ArrayList<Coureur>();
        data = new ArrayList<HashMap<String, String>>();
        annees = new HashMap<String, Annee>();
    }


    public void parse() throws IOException {
        data.clear();
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
    }

    public void creerPersonne(int entre) {
        Annee tmpYear;
        Coureur tmpCoureur;

        String nom = "";
        int naissance = 0;
        String club = "";
        String nationalite = "";
        String categorie = "";
        int classement = 0;
        int classement_cat = 0;
        String temps = "";


        tmpYear = new Annee(entre);
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
                if ('F' == entry.get("Course").charAt(entry.get("Course").length() - 1)) {
                    tmpCoureur = new Femme(nom, naissance, club, nationalite, categorie, classement, temps, classement_cat);
                } else {
                    tmpCoureur = new Homme(nom, naissance, club, nationalite, categorie, classement, temps, classement_cat);
                }
                coureurList.add(tmpCoureur);
                tmpYear.getEpreuve().get(entry.get("Course")).addParticipant(tmpCoureur);
            }
        }
        this.annees.put("" + entre, tmpYear);
    }

    public HashMap<String, Annee> getYears() {
        return annees;
    }

    public int numberOfParticipants(Annee year, String category) {
        int anneeInt = year.getAnnee();
        Annee an = this.getYears().get("" + anneeInt);
        int taille = an.getEpreuve().get(category).getParticipants().size();
        return taille;
    }
    
    public void setPath(String path) {
        this.path = path;
    }

}