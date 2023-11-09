import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner s = new Scanner(System.in);
        int score = 0;
        int length = 2;
        boolean gameStart = false;
        boolean gameOver = false;

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
            }
        }

        while (!gameOver) {
            Combination lock = new Combination(length);
            Values values = new Values(score, length);
            String secretCombination = lock.generateNumCombination(length); // generates a new combination

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
                Values.increaseScore(); // increases the score and length by 1 if the user guesses correctly
                Values.increaseLength();
            } else {
                System.out.println(Combination.toString(score)); // the user's final stats are printed when they lose
                gameOver = true;
            }

            score = values.getScore(); // keeps track of the score and length throughout the game
            length = values.getLength();
        }
    }
}