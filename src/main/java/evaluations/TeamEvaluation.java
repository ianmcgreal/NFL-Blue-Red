package evaluations;

import cli.*;
import comparators.*;
import nfl.*;

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
        rateOverall();
        rateOffense();
        rateDefense();
    }

    public void rateOverall() {
        int score = 0;
        for (Player player : team.getRoster()) {
            if (player.isBlue()) {
                score += weights.get(player.getPosition())[0];
            }
            else {
                score += weights.get(player.getPosition())[1];
            }
        }
        this.overallScore = score;
    }

    public void rateOffense() {
        int score = 0;
        for (Player player : team.getRoster()) {
            if (player.isOffense()) {
                if (player.isBlue()) {
                    score += weights.get(player.getPosition())[0];
                }
                else {
                    score += weights.get(player.getPosition())[1];
                }
            }
        }
        this.offenseScore = score;
    }

    public void rateDefense() {
        int score = 0;
        for (Player player : team.getRoster()) {
            if (!player.isOffense()) {
                if (player.isBlue()) {
                    score += weights.get(player.getPosition())[0];
                }
                else {
                    score += weights.get(player.getPosition())[1];
                }
            }
        }
        this.defenseScore = score;
    }

    public Team getTeam() {
        return team;
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
}
