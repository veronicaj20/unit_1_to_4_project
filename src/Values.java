/* The Values class represents the Values traced throughout the game.
The Values are represented by the user's score and the length of the combination.
*/
public class Values {
    private int score;
    private int length;

/* This is the constructor for the Values class. This creates a new
instance of the Values given the parameters:
@param score represents the user's score after every level
@param length represents the length of the combination the user is guessing
*/
    public Values(int score, int length) {
        this.score = score;
        this.length = length;
    }

/* The getScore method retrieves the user's score throughout the
game.
@return returns an integer representing the user's score
*/
    public int getScore() {
        return score;
    }

/* The getLength method retrieves the length of the combination
the user has to guess.
@return returns an integer representing the combination's length
*/
    public int getLength() {
        return length;
    }

/* The increaseScore method increases the user's score by 1
every time they guess the combination correctly.
*/
    public void increaseScore() {
        score++;
    }

/* The increaseLength method increases the combination's length
by 1 every time they guess the combination correctly.
*/
    public void increaseLength() {
        length++;
    }
}
