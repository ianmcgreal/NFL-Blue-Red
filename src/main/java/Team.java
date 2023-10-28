import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Team {

    private List<Player> roster = new ArrayList<>();
    private String name;
    private int overallScore;
    private int offenseScore;
    private int defenseScore;

    public Team(String name) {
        this.name = name;
    }

    public void rateTeam(Map<Position, Integer[]> positionWeights) {
        int score = 0;
        for (Player player : roster) {
            if (player.isBlue()) {
                score += positionWeights.get(player.getPosition())[0];
            }
            else {
                score += positionWeights.get(player.getPosition())[1];
            }
        }
        this.overallScore = score;
    }

    public void rateOffense(Map<Position, Integer[]> positionWeights) {
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
        this.offenseScore = score;
    }

    public void rateDefense(Map<Position, Integer[]> positionWeights) {
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
        this.defenseScore = score;
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

    public int getOverallScore() {
        return overallScore;
    }

    public int getOffenseScore() {
        return offenseScore;
    }

    public int getDefenseScore() {
        return defenseScore;
    }

    public int size() {
        return roster.size();
    }



}