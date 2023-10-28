import java.util.Comparator;

public class OffenseComparator implements Comparator<Team> {

    @Override
    public int compare(Team o1, Team o2) {
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

}
