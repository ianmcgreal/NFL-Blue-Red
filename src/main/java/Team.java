import java.util.ArrayList;
import java.util.List;

public class Team {

    private List<Player> roster = new ArrayList<>();

    public void addPlayerToTeam(Player player) {
        roster.add(player);
    }

    public void printPlayers() {
        for (Player player : roster) {
            System.out.println(player.getPosition() + ": " + player.getName());
        }
    }

    public int getTotalScore(int blue, int red) {
        int score = 0;
        for (Player player : roster) {
            if (player.isBlue()) {
                score += blue;
            }
            else {
                score += red;
            }
        }
        return score;
    }

    public int getOffenseScore(int blue, int red) {
        int score = 0;
        for (Player player : roster) {
            if (player.isOffense()) {
                if (player.isBlue()) {
                    score += blue;
                }
                else {
                    score += red;
                }
            }
        }
        return score;
    }

    public int getDefenseScore(int blue, int red) {
        int score = 0;
        for (Player player : roster) {
            if (!player.isOffense()) {
                if (player.isBlue()) {
                    score += blue;
                }
                else {
                    score += red;
                }
            }
        }
        return score;
    }

}