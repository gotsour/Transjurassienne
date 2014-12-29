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

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNaissance() {
        return naissance;
    }

    public void setNaissance(int naissance) {
        this.naissance = naissance;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getTemps() {
        return temps;
    }

    public void setTemps(String temps) {
        this.temps = temps;
    }

    public int getClassement_cat() {
        return classement_cat;
    }

    public void setClassement_cat(int classement_cat) {
        this.classement_cat = classement_cat;
    }

    public int getClassement() {
        return classement;
    }

    public void setClassement(int classement) {
        this.classement = classement;
    }
}
