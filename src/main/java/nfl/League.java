package nfl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import cli.LeagueCLI;

import static java.util.Map.entry;

public class League {

    private final Map<String, Team> leagueTeams;
    private int numOfLeaguePlayers;

    public League() {
        this.leagueTeams = Map.ofEntries(
                entry("Arizona Cardinals", new Team("Arizona Cardinals")),
                entry("Atlanta Falcons", new Team("Atlanta Falcons")),
                entry("Baltimore Ravens", new Team("Baltimore Ravens")),
                entry("Buffalo Bills", new Team("Buffalo Bills")),
                entry("Carolina Panthers", new Team("Carolina Panthers")),
                entry("Chicago Bears", new Team("Chicago Bears")),
                entry("Cincinnati Bengals", new Team("Cincinnati Bengals")),
                entry("Cleveland Browns", new Team("Cleveland Browns")),
                entry("Dallas Cowboys", new Team("Dallas Cowboys")),
                entry("Denver Broncos", new Team("Denver Broncos")),
                entry("Detroit Lions", new Team("Detroit Lions")),
                entry("Green Bay Packers", new Team("Green Bay Packers")),
                entry("Houston Texans", new Team("Houston Texans")),
                entry("Indianapolis Colts", new Team("Indianapolis Colts")),
                entry("Jacksonville Jaguars", new Team("Jacksonville Jaguars")),
                entry("Kansas City Chiefs", new Team("Kansas City Chiefs")),
                entry("Las Vegas Raiders", new Team("Las Vegas Raiders")),
                entry("Los Angeles Chargers", new Team("Los Angeles Chargers")),
                entry("Los Angeles Rams", new Team("Los Angeles Rams")),
                entry("Miami Dolphins", new Team("Miami Dolphins")),
                entry("Minnesota Vikings", new Team("Minnesota Vikings")),
                entry("New England Patriots", new Team("New England Patriots")),
                entry("New Orleans Saints", new Team("New Orleans Saints")),
                entry("New York Giants", new Team("New York Giants")),
                entry("New York Jets", new Team("New York Jets")),
                entry("Philadelphia Eagles", new Team("Philadelphia Eagles")),
                entry("Pittsburgh Steelers", new Team("Pittsburgh Steelers")),
                entry("San Francisco 49ers", new Team("San Francisco 49ers")),
                entry("Seattle Seahawks", new Team("Seattle Seahawks")),
                entry("Tampa Bay Buccaneers", new Team("Tampa Bay Buccaneers")),
                entry("Tennessee Titans", new Team("Tennessee Titans")),
                entry("Washington Commanders", new Team("Washington Commanders"))
        );
    }

    public void readIn(File input) {
        try (Scanner fileReader = new Scanner(input)) {
            while (fileReader.hasNextLine()) {
                String[] playerInfo = fileReader.nextLine().split(",");
                boolean blueChip = playerInfo[3].equalsIgnoreCase("Blue");
                // addPlayerToLeague(team name, new player (name, position), blue chip or not)
                this.addPlayerToLeague(playerInfo[2], new Player(playerInfo[0], playerInfo[1], blueChip));
            }
        } catch (FileNotFoundException e) {
            System.err.println("File could not be found.");
            LeagueCLI.askForInputFile();
        }
    }

    public void addPlayerToLeague(String team, Player player){
        leagueTeams.get(team).addPlayerToTeam(player);
        numOfLeaguePlayers++;
    }

    public Map<String, Team> getLeagueTeams() {
        return this.leagueTeams;
    }

    public int getNumOfLeaguePlayers() {
        return numOfLeaguePlayers;
    }

    public void printAllRosters() {
        for (String team : leagueTeams.keySet()) {
            System.out.println("\n*******************************");
            System.out.println(team);
            System.out.println("*******************************");
            leagueTeams.get(team).printPlayers();
            System.out.println();
        }
    }
}

