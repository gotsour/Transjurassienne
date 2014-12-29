import java.util.TreeSet;

public class Epreuve {
    protected int distance;
    protected int annee;
    protected boolean gender;
    private TreeSet<Coureur> participants;

    public Epreuve(int annee, boolean sexe, int distance) {
        annee = annee;
        sexe = sexe;
        distance = distance;
        participants = new TreeSet<Coureur>();
    }

    public void addParticipant(Coureur participant) {
        participants.add(participant);
    }

    public TreeSet<Coureur> getParticipants() {
        return participants;
    }
}