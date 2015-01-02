import java.util.HashMap;

public class Annee {
    private int annee;
    private HashMap<String, Epreuve> Epreuve;

    public Annee(int annee) {
        this.annee = annee;
        Epreuve = new HashMap<String, Epreuve>();
        Epreuve.put("25CTF", new Classique(annee, true, 25));
        Epreuve.put("25FTF", new Libre(annee, true, 25));
        Epreuve.put("50CTF", new Classique(annee, true, 50));
        Epreuve.put("76FTF", new Libre(annee, true, 76));
        Epreuve.put("25FTM", new Libre(annee, false, 25));
        Epreuve.put("25CTM", new Classique(annee, false, 25));
        Epreuve.put("50CTM", new Classique(annee, false, 50));
        Epreuve.put("76FTM", new Libre(annee, false, 76));
        Epreuve.put("30FTM", new Libre(annee, false, 30));
        Epreuve.put("30FTF", new Libre(annee, true, 30));
        Epreuve.put("50FTM", new Libre(annee, false, 50));
        Epreuve.put("50FTF", new Libre(annee, true, 50));
        Epreuve.put("70FTM", new Libre(annee, false, 70));
        Epreuve.put("70FTF", new Libre(annee, true, 70));
    }

    public HashMap<String, Epreuve> getEpreuve() {
        return Epreuve;
    }

    public int getAnnee() {
        return annee;
    }


}