import java.util.Comparator;

public class DefenseComparator implements Comparator<Team> {

    @Override
    public int compare(Team o1, Team o2) {
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
