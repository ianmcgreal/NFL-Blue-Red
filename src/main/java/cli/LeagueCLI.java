package cli;

import java.io.File;
import java.util.*;

import comparators.*;
import evaluations.*;
import nfl.*;

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
        nfl.printAllRosters();

        System.out.println("\n**************** Total Sum Rankings (Blues + Reds) ****************");

        System.out.println("\n-------------- Overall Rankings --------------");
        printList(makeSortedList(new OverallComparator()), true, false);

        System.out.println("\n-------------- Offense Rankings --------------");
        printList(makeSortedList(new OffenseComparator()), false, true);

        System.out.println("\n-------------- Defense Rankings --------------");
        printList(makeSortedList(new DefenseComparator()), false, false);

        System.out.println("\n**************** Number of Chips Rankings ****************");

        System.out.println("\n-------------- Number of Combined Blues and Reds Rankings --------------");
        printListNum(makeSortedList(new CombBluesAndRedsComparator()), true, false);

        System.out.println("\n-------------- Number of Blues Rankings --------------");
        printListNum(makeSortedList(new NumBlueComparator()), false, true);

        System.out.println("\n-------------- Number of Reds Rankings --------------");
        printListNum(makeSortedList(new NumRedComparator()), false, false);
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
        System.out.println("\nWould you like to enter your own csv file or use an existing preloaded file?");
        System.out.println("1) Enter CSV file");
        System.out.println("2) Use preloaded file");
        String response = userInput.nextLine();
        while (!response.equals("1") && !response.equals("2")) {
            System.out.println("Please enter (1) for option 1, or (2) for option 2.");
            response = userInput.nextLine();
        }
        return response.equals("1");
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

//        // TE Laptop
//        if (response.equals("1")) {
//            return new File("C:\\Users\\Student\\Desktop\\NFL-Blue-Red\\IanPlayerRankings");
//        }
//        else {
//            return new File("C:\\Users\\Student\\Desktop\\NFL-Blue-Red\\KennyPlayerRankings");
//        }

        // Macbook
        if (response.equals("1")) {
            return new File("/Users/ianmcgreal/NFL-Blue-Red/IanPlayerRankings");
        }
        else {
            return new File("/Users/ianmcgreal/NFL-Blue-Red/KennyPlayerRankings");
        }

//        // PC
//        if (response.equals("1")) {
//            return new File("");
//        }
//        else {
//            return new File("");
//        }
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
        System.out.println("***** WEIGHTS *****");
        for (Position p : Position.values()) {
            System.out.println("\nBlue " + p + ": " + positionWeights.get(p)[0]);
            System.out.println("Red " + p + ": " + positionWeights.get(p)[1]);
        }
    }

    public static void pause() {
        System.out.print("\nPress Enter to continue...");
        userInput.nextLine();
        System.out.println();
    }

    public static List<TeamEvaluation> makeSortedList(Comparator<TeamEvaluation> comparator) {
        List<TeamEvaluation> toSort = new ArrayList<>();
        for (Team team : nfl.getLeagueTeams().values()) {
            toSort.add(new TeamEvaluation(team, positionWeights));
        }
        toSort.sort(comparator);
        Collections.reverse(toSort);
        return toSort;
    }

    public static void printList(List<TeamEvaluation> evals, boolean forOverall, boolean forOffense) {
        int ordinal = 1;
        for (TeamEvaluation eval : evals) {
            if (forOverall) {
                System.out.println(ordinal + ". " + eval.getTeam().getName() + " (" + eval.getOverallScore() + ")");
            }
            else if (forOffense) {
                System.out.println(ordinal + ". " + eval.getTeam().getName() + " (" + eval.getOffenseScore() + ")");
            }
            else {
                System.out.println(ordinal + ". " + eval.getTeam().getName() + " (" + eval.getDefenseScore() + ")");
            }
            ordinal++;
        }
    }

    public static void printListNum(List<TeamEvaluation> evals, boolean combined, boolean forBlue) {
        int ordinal = 1;
        for (TeamEvaluation eval : evals) {
            if (combined) {
                System.out.println(ordinal + ". " + eval.getTeam().getName() + " (" + eval.getNumBluesAndReds() + ")");
            }
            else if (forBlue) {
                System.out.println(ordinal + ". " + eval.getTeam().getName() + " (" + eval.getNumBlues() + ")");
            }
            else {
                System.out.println(ordinal + ". " + eval.getTeam().getName() + " (" + eval.getNumReds() + ")");
            }
            ordinal++;
        }
    }
}
