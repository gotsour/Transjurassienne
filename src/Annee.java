import java.util.HashMap;

public class Annee {
    private int annee;
    private HashMap<String, Epreuve> Epreuve;

    public Annee(int annee) {
        annee = annee;
        Epreuve = new HashMap<String, Epreuve>();
        Epreuve.put("25CTF", new Classique(annee, true, 25));
        Epreuve.put("25FTF", new Libre(annee, true, 25));
        Epreuve.put("50CTF", new Classique(annee, true, 50));
        Epreuve.put("76FTF", new Libre(annee, true, 76));
        Epreuve.put("25FTM", new Libre(annee, false, 25));
        Epreuve.put("25CTM", new Classique(annee, false, 25));
        Epreuve.put("50CTM", new Classique(annee, false, 50));
        Epreuve.put("76FTM", new Libre(annee, false, 76));
    }

    public HashMap<String, Epreuve> getEpreuve() {
        return Epreuve;
    }

    public int getAnnee() {
        return annee;
    }


}