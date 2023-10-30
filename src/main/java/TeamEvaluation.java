import java.util.Map;

public class TeamEvaluation {

    private Team team;
    private Map<Position, Integer[]> weights;
    private int offenseScore;
    private int defenseScore;
    private int overallScore;

    public TeamEvaluation(Team team, Map<Position, Integer[]> weights) {
        this.team = team;
        this.weights = weights;
    }

    public void rateTeam(Map<Position, Integer[]> positionWeights) {
        int score = 0;
        for (Player player : team.getRoster()) {
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
        for (Player player : team.getRoster()) {
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
        for (Player player : team.getRoster()) {
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

    public int getOffenseScore() {
        return offenseScore;
    }

    public int getDefenseScore() {
        return defenseScore;
    }

    public int getOverallScore() {
        return overallScore;
    }
}
