package zgadnijliczbe;

import java.util.Random;

public class NumberGenerator {
    private Random random;

    public NumberGenerator() {
        this.random = new Random();
    }

    public int generateNumber(int numberOfDigits) {
        if (numberOfDigits < 1 || numberOfDigits > 9) {
            throw new IllegalArgumentException("Liczba cyfr musi być pomiędzy 1 a 9.");
        }
        int lowerBound = (int) Math.pow(10, numberOfDigits - 1);
        int upperBound = (int) Math.pow(10, numberOfDigits) - 1;
        return random.nextInt(upperBound - lowerBound + 1) + lowerBound;
    }
}
