package comparators;

import java.util.Comparator;

import evaluations.*;

public class CombBluesAndRedsComparator implements Comparator<TeamEvaluation> {

    @Override
    public int compare(TeamEvaluation o1, TeamEvaluation o2) {
        if (o1.getNumBluesAndReds() < o2.getNumBluesAndReds()) {
            return -1;
        }
        else if (o1.getNumBluesAndReds() > o2.getNumBluesAndReds()) {
            return 1;
        }
        else {
            return 0;
        }
    }
}

