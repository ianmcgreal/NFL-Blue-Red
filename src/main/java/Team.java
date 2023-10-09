import java.util.ArrayList;
import java.util.List;

public class Team {

    private List<Player> roster = new ArrayList<>();

    public List<Player> getRoster() {
        return roster;
    }

    public void addPlayerToTeam(Player player) {
        roster.add(player);
    }

}