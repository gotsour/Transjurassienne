import java.io.IOException;
import java.util.TreeSet;

/**
 * Created by thomas on 12/12/2014.
 */
public class Application {

    public static void main(String[] args){
        Parser pr = new Parser(new String("rss\\csv\\2012.csv"));
        try {
            pr.parse();
        } catch (IOException e) {
            e.printStackTrace();
        }
        pr.creerPersonne(2012);
        Fenetre f = new Fenetre();

    }

}
