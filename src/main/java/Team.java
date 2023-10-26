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

    public int getTotalNumBluesAndReds() {
        return roster.size();
    }

//    public int getNumBlues() {
//        int numBlues = 0;
//        for (Player player : roster) {
//            if (player.isBlue()) {
//                numBlues++;
//            }
//        }
//        return numBlues;
//    }
//
//    public int getNumReds() {
//        int numReds = 0;
//        for (Player player : roster) {
//            if (!player.isBlue()) {
//                numReds++;
//            }
//        }
//        return numReds;
//    }
//
//
//    public int getTeamBlueValueByPosition(int bluePositionWeight, Position position) {
//        int blueValue = 0;
//        for (Player player : roster) {
//            if (player.isBlue() && player.getPosition() == position) {
//                blueValue += bluePositionWeight;
//            }
//        }
//        return blueValue;
//    }
//
//    public int getTeamRedValueByPosition(int redPositionWeight, Position position) {
//        int redValue = 0;
//        for (Player player : roster) {
//            if (!player.isBlue() && player.getPosition() == position) {
//                redValue += redPositionWeight;
//            }
//        }
//        return redValue;
//    }

    public void printPlayers() {
        for (Player player : roster) {
            System.out.println(player.getPosition() + ": " + player.getName());
        }
    }

}