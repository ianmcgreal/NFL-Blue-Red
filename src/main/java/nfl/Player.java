package nfl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Player {

    private final String name;
    private Position position;
    private boolean isBlue;
    private static Set<Position> offensePositions = new HashSet<>(Arrays.asList(
            Position.QB,
            Position.RB,
            Position.TE,
            Position.WR,
            Position.T,
            Position.G,
            Position.C
    ));

    public Player(String name, String position, boolean isBlue) {
        this.name = name;
        this.isBlue = isBlue;
        this.position = readPosition(position);
    }

    public Position readPosition(String position) {
        if (position.equalsIgnoreCase("quarterback")
                || position.equalsIgnoreCase("quarter back")
                || position.equalsIgnoreCase("quarter_back")
                || position.equalsIgnoreCase("QB"))
        {
            return Position.QB;
        }

        else if (position.equalsIgnoreCase("running back")
                || position.equalsIgnoreCase("running_back")
                || position.equalsIgnoreCase("RB"))
        {
            return Position.RB;
        }

        else if (position.equalsIgnoreCase("tight end")
                || position.equalsIgnoreCase("tight_end")
                || position.equalsIgnoreCase("TE"))
        {
            return Position.TE;
        }

        else if (position.equalsIgnoreCase("wide receiver")
                || position.equalsIgnoreCase("wide_receiver")
                || position.equalsIgnoreCase("WR"))
        {
            return Position.WR;
        }

        else if (position.equalsIgnoreCase("tackle")
                || position.equalsIgnoreCase("T")
                || position.equalsIgnoreCase("left tackle")
                || position.equalsIgnoreCase("left_tackle")
                || position.equalsIgnoreCase("LT")
                || position.equalsIgnoreCase("right tackle")
                || position.equalsIgnoreCase("right_tackle")
                || position.equalsIgnoreCase("RT")) {
            return Position.T;
        }

        else if (position.equalsIgnoreCase("guard")
                || position.equalsIgnoreCase("G")
                || position.equalsIgnoreCase("left guard")
                || position.equalsIgnoreCase("left_guard")
                || position.equalsIgnoreCase("LG")
                || position.equalsIgnoreCase("right guard")
                || position.equalsIgnoreCase("right_guard")
                || position.equalsIgnoreCase("RG"))
        {
            return Position.G;
        }

        else if (position.equalsIgnoreCase("center")
                || position.equalsIgnoreCase("C"))
        {
            return Position.C;
        }

        else if (position.equalsIgnoreCase("pass rusher")
                || position.equalsIgnoreCase("pass_rusher")
                || position.equalsIgnoreCase("edge defender")
                || position.equalsIgnoreCase("edge_defender")
                || position.equalsIgnoreCase("edge rusher")
                || position.equalsIgnoreCase("edge_rusher")
                || position.equalsIgnoreCase("EDGE")
                || position.equalsIgnoreCase("left end")
                || position.equalsIgnoreCase("left_end")
                || position.equalsIgnoreCase("LE")
                || position.equalsIgnoreCase("right end")
                || position.equalsIgnoreCase("right_end")
                || position.equalsIgnoreCase("RE"))
        {
            return Position.EDGE;
        }

        else if (position.equalsIgnoreCase("defensive tackle")
                || position.equalsIgnoreCase("defensive_tackle")
                || position.equalsIgnoreCase("interior defensive tackle")
                || position.equalsIgnoreCase("interior_defensive_tackle")
                || position.equalsIgnoreCase("DT"))
        {
            return Position.DT;
        }

        else if (position.equalsIgnoreCase("linebacker")
                || position.equalsIgnoreCase("line backer")
                || position.equalsIgnoreCase("line_backer")
                || position.equalsIgnoreCase("LB")
                || position.equalsIgnoreCase("middle linebacker")
                || position.equalsIgnoreCase("middle_linebacker")
                || position.equalsIgnoreCase("middle line backer")
                || position.equalsIgnoreCase("middle_line_backer"))
        {
            return Position.LB;
        }

        else if (position.equalsIgnoreCase("cornerback")
                || position.equalsIgnoreCase("corner_back")
                || position.equalsIgnoreCase("CB")
                || position.equalsIgnoreCase("slot corner")
                || position.equalsIgnoreCase("slot_corner"))
        {
            return Position.CB;
        }

        else if (position.equalsIgnoreCase("safety")
                || position.equalsIgnoreCase("S")
                || position.equalsIgnoreCase("free safety")
                || position.equalsIgnoreCase("free_safety")
                || position.equalsIgnoreCase("FS")
                || position.equalsIgnoreCase("strong safety")
                || position.equalsIgnoreCase("strong_safety")
                || position.equalsIgnoreCase("SS"))
        {
            return Position.S;
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    public boolean isBlue() {
        return isBlue;
    }

    public boolean isOffense() {
        return offensePositions.contains(position);
    }

    public void printPlayer() {
        String blueRed = isBlue ? "Blue" : "Red";
        System.out.println(position + " " + name + " (" + blueRed + ")");
    }
}
