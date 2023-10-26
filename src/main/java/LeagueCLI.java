import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class LeagueCLI {

    private static final Scanner userInput = new Scanner(System.in);
    private static League nfl = new League();

//    private static int blueQB, redQB;
//    private static int blueRB, redRB;
//    private static int blueTE, redTE;
//    private static int blueWR, redWR;
//    private static int blueT, redT;
//    private static int blueG, redG;
//    private static int blueC, redC;
//    private static int blueEDGE, redEDGE;
//    private static int blueDT, redDT;
//    private static int blueLB, redLB;
//    private static int blueCB, redCB;
//    private static int blueS, redS;

    private static Map<Position, Integer[]> positionWeights;

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        nfl.readIn(askForInputFile());
        askForChipWeights();
        nfl.printLeagueTeamsWithRosters();
    }

    public static File askForInputFile() {
//        System.out.println("Please enter the path of the input file");
//        System.out.print(">>> ");
//        String inputPath = userInput.nextLine();
//        try {
//            return new File(inputPath);
//        } catch (NullPointerException e) {
//            System.err.println("Null file path.");
//            askForInputFile();
//        }
        File inputFile;
        do {
            System.out.println("Please enter the path of the input file");
            System.out.print(">>> ");
            String inputPath = userInput.nextLine();
            inputFile = new File(inputPath);
        } while (!inputFile.exists());
        return inputFile;
    }

    public static void askForChipWeights() {
        System.out.println("\nThis program evaluates NFL teams by means of their players appearing on a top 10 list for" +
                " their respective positions.");
        pause();
        System.out.println("Generally, a top 5 player is considered a \"blue chip\", while a player" +
                " in the 6-10 range is considered a \"red chip.\"");
        pause();
        System.out.println("To carry out these calculations, you must assign a point value to the \"blue chip\"" +
                " and a value to the \"red chip.\" for each position. The blue chip value must be greater than the red chip value.");
        pause();
        System.out.println("For example, a blue chip G could be worth 5 points while a red chip G is worth 3. However," +
                " maybe a blue chip QB is worth 7 while a red chip QB is worth 4.");

        Integer[] qb = { askPositionalBlueWeight(Position.QB), askPositionalRedWeight(Position.QB) };
        positionWeights.put(Position.QB, qb);
//        blueQB = askPositionalBlueWeight(Position.QB);
//        redQB = askPositionalRedWeight(Position.QB);

        Integer[] rb = { askPositionalBlueWeight(Position.RB), askPositionalRedWeight(Position.RB) };
        positionWeights.put(Position.RB, rb);
//        blueRB = askPositionalBlueWeight(Position.RB);
//        redRB = askPositionalRedWeight(Position.RB);

        Integer[] te = { askPositionalBlueWeight(Position.TE), askPositionalRedWeight(Position.TE) };
        positionWeights.put(Position.TE, te);
//        blueTE = askPositionalBlueWeight(Position.TE);
//        redTE = askPositionalRedWeight(Position.TE);

        Integer[] wr = { askPositionalBlueWeight(Position.WR), askPositionalRedWeight(Position.WR) };
        positionWeights.put(Position.WR, wr);
//        blueWR = askPositionalBlueWeight(Position.WR);
//        redWR = askPositionalRedWeight(Position.WR);

        Integer[] t = { askPositionalBlueWeight(Position.T), askPositionalRedWeight(Position.T) };
        positionWeights.put(Position.T, t);
//        blueT = askPositionalBlueWeight(Position.T);
//        redT = askPositionalRedWeight(Position.T);

        Integer[] g = { askPositionalBlueWeight(Position.G), askPositionalRedWeight(Position.G) };
        positionWeights.put(Position.G, g);
//        blueG = askPositionalBlueWeight(Position.G);
//        redG = askPositionalRedWeight(Position.G);

        Integer[] c = { askPositionalBlueWeight(Position.C), askPositionalRedWeight(Position.C) };
        positionWeights.put(Position.C, c);
//        blueC = askPositionalBlueWeight(Position.C);
//        redC = askPositionalRedWeight(Position.C);

        Integer[] edge = { askPositionalBlueWeight(Position.EDGE), askPositionalRedWeight(Position.EDGE) };
        positionWeights.put(Position.EDGE, edge);
//        blueEDGE = askPositionalBlueWeight(Position.EDGE);
//        redEDGE = askPositionalRedWeight(Position.EDGE);

        Integer[] dt = { askPositionalBlueWeight(Position.DT), askPositionalRedWeight(Position.DT) };
        positionWeights.put(Position.DT, dt);
//        blueDT = askPositionalBlueWeight(Position.DT);
//        redDT = askPositionalRedWeight(Position.DT);

        Integer[] lb = { askPositionalBlueWeight(Position.LB), askPositionalRedWeight(Position.LB) };
        positionWeights.put(Position.LB, lb);
//        blueLB = askPositionalBlueWeight(Position.LB);
//        redLB = askPositionalRedWeight(Position.LB);

        Integer[] cb = { askPositionalBlueWeight(Position.CB), askPositionalRedWeight(Position.CB) };
        positionWeights.put(Position.CB, cb);
//        blueCB = askPositionalBlueWeight(Position.CB);
//        redCB = askPositionalRedWeight(Position.CB);

        Integer[] s = { askPositionalBlueWeight(Position.S), askPositionalRedWeight(Position.S) };
        positionWeights.put(Position.S, s);
//        blueS = askPositionalBlue Weight(Position.S);
//        redS = askPositionalRedWeight(Position.S);
        System.err.println("************** MAP SIZE = " + positionWeights.size());
    }

    public static void pause() {
        System.out.println("Press Enter to continue...");
        userInput.nextLine();
    }

    public static int askPositionalBlueWeight(Position position) {
        System.out.print("How much should a blue chip " + position + " be worth? >>> ");
        while (!userInput.hasNextInt()) {
            System.err.println("Value entered is not an integer");
            System.out.print("Please enter an integer for the value of a blue chip " + position + " >>> ");
            userInput.next();
        }
        return userInput.nextInt();

//        try {
//            System.out.print("How much should a blue chip " + position + " be worth? >>> ");
//            return userInput.nextInt();
//        }
//        catch (InputMismatchException e) {
//            System.err.print("Entered value was not an integer value. Please try again.");
//            return askPositionalBlueWeight(position);
//        }

    }

    public static int askPositionalRedWeight(Position position) {
        System.out.print("How much should a red chip " + position + " be worth? >>> ");
        return userInput.nextInt();
    }

}
