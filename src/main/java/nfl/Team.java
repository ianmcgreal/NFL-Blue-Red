package nfl;

import java.util.ArrayList;
import java.util.List;

import cli.*;
import comparators.*;
import evaluations.*;

public class Team {

    private String name;
    private List<Player> roster = new ArrayList<>();
    private int numBlues;
    private int numReds;

    public Team(String name) {
        this.name = name;
    }

    public void addPlayerToTeam(Player player) {
        if (player.isBlue()) {
            numBlues++;
        }
        else {
            numReds++;
        }
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