package comparators;

import java.util.Comparator;

import cli.*;
import evaluations.*;
import nfl.*;

public class DefenseComparator implements Comparator<TeamEvaluation> {

    @Override
    public int compare(TeamEvaluation o1, TeamEvaluation o2) {
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
