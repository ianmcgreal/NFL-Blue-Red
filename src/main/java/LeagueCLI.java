import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LeagueCLI {

    private static final Scanner userInput = new Scanner(System.in);
    private static League nfl = new League();

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        nfl.readIn(askForInputFile());
        askForChipWeights();
        nfl.printLeagueTeamsWithRosters();
    }

    // Revisit, not working as intended
    public static File askForInputFile() {
        System.out.println("Please enter the path of the input file");
        System.out.print(">>> ");
        String inputPath = userInput.nextLine();
        try {
            return new File(inputPath);
        } catch (NullPointerException e) {
            System.err.println("Null file path.");
            askForInputFile();
        }
        return null;
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

        int blueQB = askPositionalBlueWeight(Position.QB);
        int redQB = askPositionalRedWeight(Position.QB);

        int blueRB = askPositionalBlueWeight(Position.RB);
        int redRB = askPositionalRedWeight(Position.RB);

        int blueTE = askPositionalBlueWeight(Position.TE);
        int redTE = askPositionalRedWeight(Position.TE);

        int blueWR = askPositionalBlueWeight(Position.WR);
        int redWR = askPositionalRedWeight(Position.WR);

        int blueT = askPositionalBlueWeight(Position.T);
        int redWT = askPositionalRedWeight(Position.T);

        int blueG = askPositionalBlueWeight(Position.G);
        int redG = askPositionalRedWeight(Position.G);

        int blueC = askPositionalBlueWeight(Position.C);
        int redC = askPositionalRedWeight(Position.C);

        int blueEDGE = askPositionalBlueWeight(Position.EDGE);
        int redEDGE = askPositionalRedWeight(Position.EDGE);

        int blueDT = askPositionalBlueWeight(Position.DT);
        int redDT = askPositionalRedWeight(Position.DT);

        int blueLB = askPositionalBlueWeight(Position.LB);
        int redLB = askPositionalRedWeight(Position.LB);

        int blueCB = askPositionalBlueWeight(Position.CB);
        int redCB = askPositionalRedWeight(Position.CB);

        int blueS = askPositionalBlueWeight(Position.S);
        int redS = askPositionalRedWeight(Position.S);
    }

    public static void pause() {
        System.out.println("Press Enter to continue...");
        userInput.nextLine();
    }

    public static int askPositionalBlueWeight(Position position) {
        System.out.print("How much should a blue chip " + position + " be worth? >>> ");
        return userInput.nextInt();
    }

    public static int askPositionalRedWeight(Position position) {
        System.out.print("How much should a red chip " + position + " be worth? >>> ");
        return userInput.nextInt();
    }


}
