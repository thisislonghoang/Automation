import java.util.concurrent.ThreadLocalRandom;

public class WinningNumberPredictor {
    public static void main(String[] args) {
        int totalNumbers = 55;
        int chosenNumbers = 6;

        int[] winningNumberCombo = generateWinningNumberCombo(totalNumbers, chosenNumbers);

        System.out.println("Winning number combination:");
        for (int num : winningNumberCombo) {
            System.out.print(num + " ");
        }
    }

    public static int[] generateWinningNumberCombo(int totalNumbers, int chosenNumbers) {
        int[] combo = new int[chosenNumbers];

        for (int i = 0; i < chosenNumbers; i++) {
            combo[i] = generateUniqueRandomNumber(combo, totalNumbers);
        }

        return combo;
    }

    public static int generateUniqueRandomNumber(int[] existingNumbers, int totalNumbers) {
        int randomNumber;
        do {
            randomNumber = ThreadLocalRandom.current().nextInt(1, totalNumbers + 1);
        } while (contains(existingNumbers, randomNumber));
        return randomNumber;
    }

    public static boolean contains(int[] array, int value) {
        for (int num : array) {
            if (num == value) {
                return true;
            }
        }
        return false;
    }
}
