import java.math.BigInteger;

public class ProbabilityCalculator {
    public static void main(String[] args) {
        int totalNumbers = 55;
        int chosenNumbers = 6;

        BigInteger totalWays = calculateCombination(totalNumbers, chosenNumbers);
        BigInteger waysToWin = BigInteger.ONE; // There is only one way to win (all numbers chosen correctly)

        double probability = waysToWin.divide(totalWays).doubleValue(); // Use BigInteger.divide()

        System.out.println("Probability of winning Power 6/55: " + probability);
    }

    public static BigInteger calculateCombination(int n, int k) {
        BigInteger numerator = factorial(n);
        BigInteger denominator = factorial(k).multiply(factorial(n - k));
        return numerator.divide(denominator);
    }

    public static BigInteger factorial(int n) {
        if (n == 0 || n == 1) {
            return BigInteger.ONE;
        }
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
}
