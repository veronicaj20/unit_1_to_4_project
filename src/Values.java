public class Values {
    private static int score;
    private static int length;

    public Values(int score, int length) {
        this.score = score;
        this.length = length;
    }

    public int getScore() {
        return score;
    }

    public int getLength() {
        return length;
    }

    public static void increaseScore() {
        score++;
    }

    public static void increaseLength() {
        length++;
    }
}
