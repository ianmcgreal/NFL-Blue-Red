package comparators;

import java.util.Comparator;

import evaluations.*;

public class NumRedComparator implements Comparator<TeamEvaluation> {

    @Override
    public int compare(TeamEvaluation o1, TeamEvaluation o2) {
        if (o1.getNumReds() < o2.getNumReds()) {
            return -1;
        }
        else if (o1.getNumReds() > o2.getNumReds()) {
            return 1;
        }
        else {
            return 0;
        }
    }
}