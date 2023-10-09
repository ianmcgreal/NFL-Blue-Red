public class Player {

    private String name;

    private Position position;

    public Player(String name, String position) {
        this.name = name;

        if (position.equalsIgnoreCase("quarterback")
                || position.equalsIgnoreCase("quarter back")
                || position.equalsIgnoreCase("quarter_back")
                || position.equalsIgnoreCase("QB"))
        {
            this.position = Position.QUARTERBACK;
        }

        else if (position.equalsIgnoreCase("running back")
                || position.equalsIgnoreCase("running_back")
                || position.equalsIgnoreCase("RB"))
        {
            this.position = Position.RUNNING_BACK;
        }

        else if (position.equalsIgnoreCase("tight end")
                || position.equalsIgnoreCase("tight_end")
                || position.equalsIgnoreCase("TE"))
        {
            this.position = Position.TIGHT_END;
        }

        else if (position.equalsIgnoreCase("wide receiver")
                || position.equalsIgnoreCase("wide_receiver")
                || position.equalsIgnoreCase("WR"))
        {
            this.position = Position.WIDE_RECEIVER;
        }

        else if (position.equalsIgnoreCase("tackle")
                || position.equalsIgnoreCase("T")
                || position.equalsIgnoreCase("left tackle")
                || position.equalsIgnoreCase("left_tackle")
                || position.equalsIgnoreCase("LT")
                || position.equalsIgnoreCase("right tackle")
                || position.equalsIgnoreCase("right_tackle")
                || position.equalsIgnoreCase("RT")) {
            this.position = Position.TACKLE;
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
            this.position = Position.GUARD;
        }

        else if (position.equalsIgnoreCase("center")
                || position.equalsIgnoreCase("C"))
        {
            this.position = Position.CENTER;
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
            this.position = Position.EDGE_RUSHER;
        }

        else if (position.equalsIgnoreCase("defensive tackle")
                || position.equalsIgnoreCase("defensive_tackle")
                || position.equalsIgnoreCase("interior defensive tackle")
                || position.equalsIgnoreCase("interior_defensive_tackle")
                || position.equalsIgnoreCase("DT"))
        {
            this.position = Position.DEFENSIVE_TACKLE;
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
            this.position = Position.LINEBACKER;
        }

        else if (position.equalsIgnoreCase("cornerback")
                || position.equalsIgnoreCase("corner_back")
                || position.equalsIgnoreCase("CB")
                || position.equalsIgnoreCase("slot corner")
                || position.equalsIgnoreCase("slot_corner"))
        {
            this.position = Position.CORNERBACK;
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
            this.position = Position.SAFETY;
        }
    }

    public String getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }
}

enum Position {
    QUARTERBACK,
    RUNNING_BACK,
    TIGHT_END,
    WIDE_RECEIVER,
    TACKLE,
    GUARD,
    CENTER,
    DEFENSIVE_TACKLE,
    EDGE_RUSHER,
    LINEBACKER,
    CORNERBACK,
    SAFETY
}
