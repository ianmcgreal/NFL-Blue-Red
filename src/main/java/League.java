import java.util.Map;

import static java.util.Map.entry;

public class League {

    private Map<String, Team> leagueTeams;

    public League() {
        this.leagueTeams = Map.ofEntries(
                entry("Arizona Cardinals", new Team()),
                entry("Atlanta Falcons", new Team()),
                entry("Baltimore Ravens", new Team()),
                entry("Buffalo Bills", new Team()),
                entry("Carolina Panthers", new Team()),
                entry("Chicago Bears", new Team()),
                entry("Cincinnati Bengals", new Team()),
                entry("Cleveland Browns", new Team()),
                entry("Dallas Cowboys", new Team()),
                entry("Denver Broncos", new Team()),
                entry("Detroit Lions", new Team()),
                entry("Green Bay Packers", new Team()),
                entry("Houston Texans", new Team()),
                entry("Indianapolis Colts", new Team()),
                entry("Jacksonville Jaguars", new Team()),
                entry("Kansas City Chiefs", new Team()),
                entry("Las Vegas Raiders", new Team()),
                entry("Los Angeles Chargers", new Team()),
                entry("Los Angeles Rams", new Team()),
                entry("Miami Dolphins", new Team()),
                entry("Minnesota Vikings", new Team()),
                entry("New England Patriots", new Team()),
                entry("New Orleans Saints", new Team()),
                entry("New York Giants", new Team()),
                entry("New York Jets", new Team()),
                entry("Philadelphia Eagles", new Team()),
                entry("Pittsburgh Steelers", new Team()),
                entry("San Francisco 49ers", new Team()),
                entry("Seattle Seahawks", new Team()),
                entry("Tampa Bay Buccaneers", new Team()),
                entry("Tennessee Titans", new Team()),
                entry("Washington Commanders", new Team())
        );
    }

    public Map<String, Team> getLeagueTeams() {
        return this.leagueTeams;
    }

}

