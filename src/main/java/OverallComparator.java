import java.util.Comparator;

public class OverallComparator implements Comparator<TeamEvaluation> {

    @Override
    public int compare(TeamEvaluation o1, TeamEvaluation o2) {
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
}
