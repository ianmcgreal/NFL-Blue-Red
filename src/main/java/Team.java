import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Team {

    private String name;
    private List<Player> roster = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public void addPlayerToTeam(Player player) {
        roster.add(player);
    }

    public String getName() {
        return name;
    }

    public List<Player> getRoster() {
        return roster;
    }

    public int size() {
        return roster.size();
    }

    public void printPlayers() {
        for (Player player : roster) {
            player.printPlayer();
        }
    }
}