
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

public class Menu extends JMenuBar {
    private JMenu file, help;
    private JMenuItem open, delete, close, credits;

    public Menu() {
        super();
        file = new JMenu("File");
        help = new JMenu("?");

        open = new JMenuItem("Open");
        delete = new JMenuItem("Delete");
        close = new JMenuItem("Close");

        file.add(open);
        file.add(delete);
        file.add(new JSeparator());
        file.add(close);

        add(file);
        add(help);
    }

    /**
     * @return the open
     */
    public JMenuItem getOpen() {
        return open;
    }

    /**
     * @return the delete
     */
    public JMenuItem getDelete() {
        return delete;
    }

    /**
     * @return the close
     */
    public JMenuItem getClose() {
        return close;
    }

    /**
     * @return the credits
     */
    public JMenuItem getCredits() {
        return credits;
    }
}
