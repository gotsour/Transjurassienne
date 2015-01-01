/**
 * Created by mathieu on 08/12/2014.
 */
public class Femme extends Coureur implements Comparable{

    public Femme(String nom, int naissance, String club, String nationalite, String categorie, int classement, String temps, int classement_cat) {
        super(nom, naissance, club, nationalite, categorie, classement, temps, classement_cat);
    }


    @Override
    public int compareTo(Object o) {
        return 0;
    }
}