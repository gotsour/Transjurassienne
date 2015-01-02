import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.TreeSet;

public class Epreuve {
    protected int distance;
    protected int annee;
    protected boolean sexe;
    private ArrayList<Coureur> participants;

    public Epreuve(int annee, boolean sexe, int distance) {
        this.annee = annee;
        this.sexe = sexe;
        this.distance = distance;
        participants = new ArrayList<Coureur>();
    }

    public void addParticipant(Coureur participant) {
        participants.add(participant);
    }

    public ArrayList<Coureur> getParticipants() {
        return participants;
    }
}