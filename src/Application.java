import java.io.IOException;
import java.util.TreeSet;

/**
 * Created by thomas on 12/12/2014.
 */
public class Application {

    public static void main(String[] args){
        Parser pr = new Parser(new String("C:\\Users\\thomas\\Documents\\GitHub\\Transjurassienne\\rss\\csv\\2011.csv"));
        try {
            pr.parse();
        } catch (IOException e) {
            e.printStackTrace();
        }
        pr.creerPersonne();
        Fenetre f = new Fenetre();

    }

}
