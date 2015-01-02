import java.io.File;
import java.io.IOException;

/**
 * Created by thomas on 12/12/2014.
 */
public class Application {

    public static void main(String[] args) throws IOException {

        Parser pr = new Parser();
        File repertoire = new File("rss\\csv\\");
        String [] listefichiers;
        listefichiers=repertoire.list();
        for(int i=0;i<listefichiers.length;i++) {
            System.out.println(listefichiers[i]);
            if (listefichiers[i].endsWith(".csv") == true) {
                pr.setPath("rss\\csv\\"+listefichiers[i]);
                pr.parse();

                String intValue = listefichiers[i].replaceAll("[^0-9]", "");
                int annee = Integer.parseInt(intValue);
                pr.creerPersonne(annee);
            }
        }
        Fenetre f = new Fenetre();

    }

}
