public class Combination {
    private String combination;

    public Combination(int length) {
        combination = generateCombination(length);
    }

    public String generateCombination(int length) {
        String secretCombo = "";
        for (int i = 0; i < length; i++) {
            int random = (int) (Math.random() * 10);
            secretCombo += random;
        }
        return secretCombo;
    }

}
