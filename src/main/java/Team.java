import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Team {

    private List<Player> roster = new ArrayList<>();
    private String name = "";

    public Team(String name) {
        this.name = name;
    }

    public int rateTeam(Map<Position, Integer[]> positionWeights) {
        int score = 0;
        for (Player player : roster) {
            if (player.isBlue()) {
                score += positionWeights.get(player.getPosition())[0];
            }
            else {
                score += positionWeights.get(player.getPosition())[1];
            }
        }
        return score;
    }

    public int rateOffense(Map<Position, Integer[]> positionWeights) {
        int score = 0;
        for (Player player : roster) {
            if (player.isOffense()) {
                if (player.isBlue()) {
                    score += positionWeights.get(player.getPosition())[0];
                }
                else {
                    score += positionWeights.get(player.getPosition())[1];
                }
            }
        }
        return score;
    }

    public int rateDefense(Map<Position, Integer[]> positionWeights) {
        int score = 0;
        for (Player player : roster) {
            if (!player.isOffense()) {
                if (player.isBlue()) {
                    score += positionWeights.get(player.getPosition())[0];
                }
                else {
                    score += positionWeights.get(player.getPosition())[1];
                }
            }
        }
        return score;
    }

    public void addPlayerToTeam(Player player) {
        roster.add(player);
    }

    public void printPlayers() {
        for (Player player : roster) {
            System.out.println(player.getPosition() + ": " + player.getName());
        }
    }

    public String getName() {
        return name;
    }

    public int size() {
        return roster.size();
    }



}