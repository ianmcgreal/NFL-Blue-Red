package comparators;

import java.util.Comparator;

import evaluations.*;

public class NumBlueComparator implements Comparator<TeamEvaluation> {

    @Override
    public int compare(TeamEvaluation o1, TeamEvaluation o2) {
        if (o1.getNumBlues() < o2.getNumBlues()) {
            return -1;
        }
        else if (o1.getNumBlues() > o2.getNumBlues()) {
            return 1;
        }
        else {
            return 0;
        }
    }
}
