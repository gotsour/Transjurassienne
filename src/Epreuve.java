import java.util.TreeSet;

public class Epreuve {
    protected int distance;
    protected int annee;
    protected boolean sexe;
    private TreeSet<Coureur> participants;

    public Epreuve(int annee, boolean sexe, int distance) {
        this.annee = annee;
        this.sexe = sexe;
        this.distance = distance;
        participants = new TreeSet<Coureur>();
    }

    public void addParticipant(Coureur participant) {
        participants.add(participant);
    }

    public TreeSet<Coureur> getParticipants() {
        return participants;
    }
}