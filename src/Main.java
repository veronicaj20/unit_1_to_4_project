import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner s = new Scanner(System.in);
        int score = 0;
        int length = 2;
        boolean gameStart = false;
        boolean gameOver = false;
        boolean difficultyChosen = false;


        System.out.println("Welcome to the Combination Game! Guess the combination correctly to unlock the lock and keep playing.");
        // starts the game and the timer
        while (!gameStart) {
            System.out.print("Enter 'start' to start: ");
            String userStart = s.next();
            if (userStart.equalsIgnoreCase("start")) {
                gameStart = true;
                System.out.println();
            } else {
                System.out.println("Sorry! That's not a valid command. Please enter 'start'.");
                System.out.println();
            }
        }

        // creates the objects and initializes the variables to an empty string
        Values values = new Values(score, length);
        String secretCombination = "";
        String difficulty = "";

        // game loop
        while (!gameOver) {
            // determines the difficulty level
            while (!difficultyChosen) {
                System.out.print("Please enter your difficulty (enter 'numbers', 'letters', or 'mixed'): ");
                difficulty = s.next();
                if (difficulty.equalsIgnoreCase("numbers") || difficulty.equalsIgnoreCase("letters") || difficulty.equalsIgnoreCase("mixed")) {
                    difficultyChosen = true;
                    System.out.println();
                } else {
                    System.out.println("Sorry! That's not a valid command. Please enter 'numbers', 'letters', or 'mixed': ");
                    System.out.println();
                }
            }

            // generate combination based on difficulty
            if (difficulty.equalsIgnoreCase("numbers")) {
                secretCombination = Combination.generateNumCombination(length);
            } else if (difficulty.equalsIgnoreCase("letters")) {
                secretCombination = Combination.generateLetterCombination(length);
            } else if (difficulty.equalsIgnoreCase("mixed")) {
                secretCombination = Combination.generateMixedCombination(length);
            }

            // actual game starts
            System.out.println("Level " + (length - 1) + ": A random combination has been generated.");
            System.out.println("The combination is: " + secretCombination);
            Thread.sleep(2000); // waits 2s before the user has to guess
            for (int i = 0; i < 50; i++) {
                System.out.println(); // prints 50 lines so the user can't see the combination
            }
            System.out.print("Enter the combination: ");
            String userGuess = s.next();


            if (userGuess.equals(secretCombination)) {
                System.out.println("Combination lock unlocked! You've entered the correct combination.");
                values.increaseScore(); // increases the score and length by 1 if the user guesses correctly
                values.increaseLength();
            } else {
                System.out.println(Combination.toString(score, length)); // the user's final stats are printed when they lose
                gameOver = true;
            }


            score = values.getScore(); // keeps track of the score and length throughout the game
            length = values.getLength();
        }
    }
}





