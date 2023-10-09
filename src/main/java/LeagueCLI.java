import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LeagueCLI {

    private static final Scanner userInput = new Scanner(System.in);
    private static League nfl = new League();

    public static void main(String[] args) throws InterruptedException {
        run();
    }

    public static void run() {
        nfl.readIn(askForInputFile());
        askForChipWeights();
    }

    public static File askForInputFile() {
        System.out.println("Please enter the path of the input file");
        System.out.println(">>> ");
        String inputPath = userInput.nextLine();
        return new File(inputPath);
    }

    public static void askForChipWeights() {
        System.out.println("This program evaluates NFL teams by means of their players appearing on a top 10 list for" +
                " their respective position.");
        System.out.println("Generally, a top 5 player is considered a \"blue chip\", while a player" +
                " in the 6-10 range is considered a \"red chip.\"");
        System.out.println("To carry out these calculations, you must assign a point value to the \"blue chip\"" +
                " and a value to the \"red chip.\" The blue chip value must be greater than the red chip value.");
        System.out.println("For example, a blue chip could be worth 5 points while a red chip is worth 3. However," +
                " maybe a blue chip QB is worth 7 while a red chip QB is worth 4.");

        System.out.println("How many points should a blue chip QB be worth?");
        System.out.println(">>> ");
        int blueQB = userInput.nextInt();

        System.out.println("How many points should a red chip QB be worth?");
        System.out.println(">>> ");
        int redQB = userInput.nextInt();

        System.out.println("How many points should a blue chip RB be worth?");
        System.out.println(">>> ");
        int blueRB = userInput.nextInt();

        System.out.println("How many points should a red chip RB be worth?");
        System.out.println(">>> ");
        int redRB = userInput.nextInt();

        System.out.println("How many points should a blue chip TE be worth?");
        System.out.println(">>> ");
        int blueTE = userInput.nextInt();

        System.out.println("How many points should a red chip TE be worth?");
        System.out.println(">>> ");
        int redTE = userInput.nextInt();

        System.out.println("How many points should a blue chip WR be worth?");
        System.out.println(">>> ");
        int blueWR = userInput.nextInt();

        System.out.println("How many points should a red chip WR be worth?");
        System.out.println(">>> ");
        int redWR = userInput.nextInt();

        System.out.println("How many points should a blue chip tackle be worth?");
        System.out.println(">>> ");
        int blueT = userInput.nextInt();

        System.out.println("How many points should a red chip tackle be worth?");
        System.out.println(">>> ");
        int redT = userInput.nextInt();

        System.out.println("How many points should a blue chip guard be worth?");
        System.out.println(">>> ");
        int blueG = userInput.nextInt();

        System.out.println("How many points should a red chip guard be worth?");
        System.out.println(">>> ");
        int redG = userInput.nextInt();

        System.out.println("How many points should a blue chip center be worth?");
        System.out.println(">>> ");
        int blueC = userInput.nextInt();

        System.out.println("How many points should a red chip center be worth?");
        System.out.println(">>> ");
        int redC = userInput.nextInt();

        System.out.println("How many points should a blue chip EDGE be worth?");
        System.out.println(">>> ");
        int blueEDGE = userInput.nextInt();

        System.out.println("How many points should a red chip EDGE be worth?");
        System.out.println(">>> ");
        int redEDGE = userInput.nextInt();

        System.out.println("How many points should a blue chip DT be worth?");
        System.out.println(">>> ");
        int blueDT = userInput.nextInt();

        System.out.println("How many points should a red chip DT be worth?");
        System.out.println(">>> ");
        int redDT = userInput.nextInt();

        System.out.println("How many points should a blue chip LB be worth?");
        System.out.println(">>> ");
        int blueLB = userInput.nextInt();

        System.out.println("How many points should a red chip LB be worth?");
        System.out.println(">>> ");
        int redLB = userInput.nextInt();

        System.out.println("How many points should a blue chip CB be worth?");
        System.out.println(">>> ");
        int blueCB = userInput.nextInt();

        System.out.println("How many points should a red chip CB be worth?");
        System.out.println(">>> ");
        int redCB = userInput.nextInt();

        System.out.println("How many points should a blue chip S be worth?");
        System.out.println(">>> ");
        int blueS = userInput.nextInt();

        System.out.println("How many points should a red chip S be worth?");
        System.out.println(">>> ");
        int redS = userInput.nextInt();
    }



}
