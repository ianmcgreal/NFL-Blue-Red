import java.util.Comparator;

public class TeamComparator implements Comparator<Team> {

    @Override
    public int compare(Team o1, Team o2) {
        if (o1.getOverallScore() < o2.getOverallScore()) {
            return -1;
        }
        else if (o1.getOverallScore() > o2.getDefenseScore()) {
            return 1;
        }
        else {
            return 0;
        }
    }

    public int compareOffense(Team o1, Team o2) {
        if (o1.getOffenseScore() < o2.getOffenseScore()) {
            return -1;
        }
        else if (o1.getOffenseScore() > o2.getOffenseScore()) {
            return 1;
        }
        else {
            return 0;
        }
    }

    public int compareDefense(Team o1, Team o2) {
        if (o1.getDefenseScore() < o2.getDefenseScore()) {
            return -1;
        }
        else if (o1.getDefenseScore() > o2.getDefenseScore()) {
            return 1;
        }
        else {
            return 0;
        }
    }


}
