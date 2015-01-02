/**
 * Created by mathieu on 08/12/2014.
 */

public class Coureur {
    protected String nom;
    protected int naissance;
    protected String club;
    protected String nationalite;
    protected String categorie;
    protected int classement;
    protected String temps;
    protected int classement_cat;

    protected Coureur(String nom, int naissance, String club, String nationalite, String categorie, int classement, String temps, int classement_cat) {
        this.nom = nom;
        this.naissance= naissance;
        this.club = club;
        this.nationalite = nationalite;
        this.categorie = categorie;
        this.classement = classement;
        this.temps = temps;
        this.classement_cat = classement_cat;
    }


    public String getNom() {
        return nom;
    }


    public int getNaissance() {
        return naissance;
    }


    public String getClub() {
        return club;
    }


    public String getNationalite() {
        return nationalite;
    }


    public String getTemps() {
        return temps;
    }


    public int getClassement_cat() {
        return classement_cat;
    }


    public int getClassement() {
        return classement;
    }
}
