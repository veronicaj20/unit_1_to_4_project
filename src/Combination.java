/* The Combination class represents a lock the user has to open.
The lock is represented by a combination.
*/
public class Combination {
    private static String combination;

/* This is the constructor for the Combination class. This creates a new
instance of the Combination given the parameters:
@param length represents how long the combination is
*/
    public Combination(int length) {
        combination = generateCombination(length);
    }

/* The generateCombination method creates a new combination that
the user has to guess.
@param length is an integer representing the length of the combination
@return returns a String, secretCombo, that represents the newly generated
combination. The program generates a random integer from 0-9 until
it completes the length of the combination and concatenates them to secretCombo.
*/
    public String generateCombination(int length) {
        String secretCombo = "";
        for (int i = 0; i < length; i++) {
            int random = (int) (Math.random() * 10);
            secretCombo += random;
        }
        return secretCombo;
    }

/* The toString method for the Combination class returns a String
that prints all the information about the user's final stats when
they lose the game.

@returns returns a String in three properly formatted sentences that
contains all the information about the game after it ends.
*/
    public static String toString(int score) {
        String str = "Game over! You guessed the wrong combination.";
        String str2 = "The length of the combinaton was " + combination.length() + ".";
        String str3 = "Your final score was: " + score + ".";
        return str + '\n' + str2 + '\n' + str3;
    }
}
