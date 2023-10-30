package comparators;

import java.util.Comparator;

import cli.*;
import evaluations.*;
import nfl.*;

public class OffenseComparator implements Comparator<TeamEvaluation> {

    @Override
    public int compare(TeamEvaluation o1, TeamEvaluation o2) {
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
