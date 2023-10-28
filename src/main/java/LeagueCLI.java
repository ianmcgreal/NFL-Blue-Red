import java.io.File;
import java.util.*;

public class LeagueCLI {

    private static final Scanner userInput = new Scanner(System.in);
    private static League nfl = new League();
    private static Map<Position, Integer[]> positionWeights = new HashMap<>();

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        intro();
        if (isEnteringOwnFile()) {
            nfl.readIn(askForInputFile());
        }
        else {
            nfl.readIn(ianOrKenny());
        }
        askForChipWeights();
        printWeights();
        nfl.rateAllTeams(positionWeights);
        List<Team> descending = new ArrayList<>(nfl.getLeagueTeams().values());

        descending.sort(new OverallComparator());
        descending = descending.reversed();
        printList(descending, "overall");

        descending.sort(new OffenseComparator());
        descending = descending.reversed();
        printList(descending, "offense");

        descending.sort(new DefenseComparator());
        descending = descending.reversed();
        printList(descending, "defense");
    }

    public static void intro() {
        System.out.println("\nThis program evaluates NFL teams by means of their players appearing on a top 10 list for" +
                " their respective positions.");
        pause();
        System.out.println("Generally, a top 5 player is considered a \"blue chip\", while a player" +
                " in the 6-10 range is considered a \"red chip.\"");
        pause();
        System.out.println("This program requires a csv file of player rankings.");
    }

    public static boolean isEnteringOwnFile() {
        System.out.println("Would you like to enter your own csv file or use an existing preloaded file?");
        System.out.println("1) Enter CSV file");
        System.out.println("2) Use preloaded file");
        String response = userInput.nextLine();
        while (!response.equals("1") && !response.equals("2")) {
            System.out.println("Please enter (1) for option 1, or (2) for option 2.");
            response = userInput.nextLine();
        }
        if (response.equals("1")) {
            return true;
        }
        else {
            return false;
        }
    }

    public static File askForInputFile() {
        while (true) {
            System.out.print("Please enter the file path >>> ");
            String inputPath = userInput.nextLine();
            while (inputPath == null) {
                System.out.print("Null file path. Please enter a valid file path >>> ");
                inputPath = userInput.nextLine();
            }
            File inputFile = new File(inputPath);
            if (inputFile.isFile()) {
                return inputFile;
            }
        }
    }

    public static File ianOrKenny() {
        System.out.println("Would you like to use Ian's rankings (1) or Kenny's (2) ?");
        System.out.println("1) Ian");
        System.out.println("2) Kenny");
        String response = userInput.nextLine();
        while (!response.equals("1") && !response.equals("2")) {
            System.out.println("\nPlease enter 1 for option 1, or 2 for option 2.");
            response = userInput.nextLine();
        }
        if (response.equals("1")) {
            return new File("C:\\Users\\Student\\Desktop\\NFL-Blue-Red\\IanPlayerRankings");
        }
        else {
            return new File("C:\\Users\\Student\\Desktop\\NFL-Blue-Red\\KennyPlayerRankings");
        }
    }

    public static void askForChipWeights() {
        System.out.println("\nTo carry out these calculations, you must assign a point value to the \"blue chip\"" +
                " and a value to the \"red chip\" for each position. The blue chip value must be greater than the red chip value.");
        System.out.println("\nFor example, a blue chip G could be worth 5 points while a red chip G is worth 3. However," +
                " maybe a blue chip QB is worth 7 while a red chip QB is worth 4.\n");

        Integer[] qb = { askPositionalBlueWeight(Position.QB), askPositionalRedWeight(Position.QB) };
        positionWeights.put(Position.QB, qb);
        System.out.println();

        Integer[] rb = { askPositionalBlueWeight(Position.RB), askPositionalRedWeight(Position.RB) };
        positionWeights.put(Position.RB, rb);
        System.out.println();

        Integer[] te = { askPositionalBlueWeight(Position.TE), askPositionalRedWeight(Position.TE) };
        positionWeights.put(Position.TE, te);
        System.out.println();

        Integer[] wr = { askPositionalBlueWeight(Position.WR), askPositionalRedWeight(Position.WR) };
        positionWeights.put(Position.WR, wr);
        System.out.println();

        Integer[] t = { askPositionalBlueWeight(Position.T), askPositionalRedWeight(Position.T) };
        positionWeights.put(Position.T, t);
        System.out.println();

        Integer[] g = { askPositionalBlueWeight(Position.G), askPositionalRedWeight(Position.G) };
        positionWeights.put(Position.G, g);
        System.out.println();

        Integer[] c = { askPositionalBlueWeight(Position.C), askPositionalRedWeight(Position.C) };
        positionWeights.put(Position.C, c);
        System.out.println();

        Integer[] edge = { askPositionalBlueWeight(Position.EDGE), askPositionalRedWeight(Position.EDGE) };
        positionWeights.put(Position.EDGE, edge);
        System.out.println();

        Integer[] dt = { askPositionalBlueWeight(Position.DT), askPositionalRedWeight(Position.DT) };
        positionWeights.put(Position.DT, dt);
        System.out.println();

        Integer[] lb = { askPositionalBlueWeight(Position.LB), askPositionalRedWeight(Position.LB) };
        positionWeights.put(Position.LB, lb);
        System.out.println();

        Integer[] cb = { askPositionalBlueWeight(Position.CB), askPositionalRedWeight(Position.CB) };
        positionWeights.put(Position.CB, cb);
        System.out.println();

        Integer[] s = { askPositionalBlueWeight(Position.S), askPositionalRedWeight(Position.S) };
        positionWeights.put(Position.S, s);
    }

    public static int askPositionalBlueWeight(Position position) {
        System.out.print("How much should a blue chip " + position + " be worth? >>> ");
        while (!userInput.hasNextInt()) {
            System.err.println("Value entered is not an integer.");
            System.out.print("Please enter an integer for the value of a blue chip " + position + " >>> ");
            userInput.next();
        }
        return userInput.nextInt();
    }

    public static int askPositionalRedWeight(Position position) {
        System.out.print("How much should a red chip " + position + " be worth? >>> ");
        while (!userInput.hasNextInt()) {
            System.out.println("Value entered is not an integer.");
            System.out.print("Please enter an integer for the value of a red chip " + position + " >>> ");
            userInput.next();
        }
        return userInput.nextInt();
    }

    private static void printWeights() {
        for (Position p : Position.values()) {
            System.out.println("\nBlue " + p + ": " + positionWeights.get(p)[0]);
            System.out.println("Red " + p + ": " + positionWeights.get(p)[1]);
        }
    }

    private static void printList(List<Team> sorted, String whichField) {
        System.out.println("\n***************************");
        System.out.println(whichField + " Scores");
        int ordinalRank = 1;
        for (Team team : sorted) {
            if (whichField.equalsIgnoreCase("offense")) {
                System.out.println(ordinalRank++ + ". " + team.getName() + " (" + team.getOffenseScore() + ")");
            }
            else if (whichField.equalsIgnoreCase("defense")) {
                System.out.println(ordinalRank++ + ". " + team.getName() + " (" + team.getDefenseScore() + ")");
            }
            else {
                System.out.println(ordinalRank++ + ". " + team.getName() + " (" + team.getOverallScore() + ")");
            }
        }
    }

    public static void pause() {
        System.out.print("\nPress Enter to continue...");
        userInput.nextLine();
        System.out.println();
    }
}
