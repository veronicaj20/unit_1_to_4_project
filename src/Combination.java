/* The Combination class represents a lock the user has to open.
*/
public class Combination {


    public static String chooseCombination(String difficulty, int length) {
        String secretCombination = "";
        if (difficulty.equalsIgnoreCase("numbers")) {
            secretCombination = Combination.generateNumCombination(length);
            return secretCombination;
        } else if (difficulty.equalsIgnoreCase("letters")) {
            secretCombination = Combination.generateLetterCombination(length);
            return secretCombination;
        } else {
            secretCombination = Combination.generateMixedCombination(length);
            return secretCombination;
        }
    }

/* The generateNumCombination method creates a new combination that
the user has to guess, but with numbers.
@param length is an integer representing the length of the combination
@return returns a String, secretCombo, that represents the newly generated
combination. The program generates a random integer from 0-9 until
it completes the length of the combination and concatenates them to secretCombo.
*/
    private static String generateNumCombination(int length) {
        String secretCombo = "";
        for (int i = 0; i < length; i++) {
            int randomInt = (int) (Math.random() * 10);
            secretCombo += randomInt;
        }
        return secretCombo;
    }

/* The generateLetterCombination method creates a new combination that the user
has to guess, but with uppercase letters.
@param length is an integer representing the length of the combination
@return returns a String, secretCombo, that represents the newly generated
combination. The program generates a random letter from A-Z, all
uppercase, until it completes the length of the combination and concatenates
them to secretCombo.
*/
    private static String generateLetterCombination(int length) {
        String secretCombo = "";
        for (int i = 0; i < length; i++) {
            char randomLetter = (char) ('A' + (int) (Math.random() * 26));
            secretCombo += randomLetter;
        }
        return secretCombo;
    }

/* The generateMixedCombination method creates a new combination that the
user has to guess, mixed with both uppercase letters and numbers.
@param length is an integer representing the length of the combination
@return returns a String, secretCombo, that represents the newly generated
combination. The program chooses a random character from the string "chars"
until it completes the length of the combination and concatenates them
to secretCombo.
*/
    private static String generateMixedCombination(int length) {
        String secretCombo = "";
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
        for (int i = 0; i < length; i++) {
            char randomChar = chars.charAt((int) (Math.random() * chars.length()));
            secretCombo += randomChar;
        }
        return secretCombo;
    }

/* The toString method for the Combination class returns a String
that prints all the information about the user's final stats when
they lose the game.

@returns returns a String in three properly formatted sentences that
contains all the information about the game after it ends.
*/
    public static String toString(int score, int length) {
        String str = "Game over! You guessed the wrong combination.";
        String str2 = "The length of the combinaton was " + length + ".";
        String str3 = "Your final score was: " + score + ".";
        return str + '\n' + str2 + '\n' + str3;
    }
}
