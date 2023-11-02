import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner s = new Scanner(System.in);
        int score = 0;
        int length = 2;
        boolean gameOver = false;

        System.out.println("Welcome to the Combination Game! Guess the combination correctly to unlock the lock and keep playing.");
        while (!gameOver) {
            Combination lock = new Combination(length);
            Values values = new Values(score, length);
            String secretCombination = lock.generateCombination(length);
            System.out.println("Level " + (length - 1) + ": A random combination has been generated.");
            System.out.println("The combination is: " + secretCombination);
            Thread.sleep(1500);
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }
            System.out.print("Enter the combination: ");
            String userGuess = s.next();
            if (userGuess.equals(secretCombination)) {
                System.out.println("Combination lock unlocked! You've entered the correct combination.");
                Values.increaseScore();
                Values.increaseLength();
            } else {
                System.out.println("Game over! You guessed the wrong combination.\nYour final score: ");
                gameOver = true;
            }
            score = values.getScore();
            length = values.getLength();
        }
    }
}