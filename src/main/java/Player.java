public class Player {

    private String name;

    private Position position;

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