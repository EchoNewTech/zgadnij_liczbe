package zgadnijliczbe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NumberFeedbackGame {
    private Scanner scanner;
    private NumberGenerator numberGenerator;
    private int targetNumber;
    private int numberOfDigits;

    public NumberFeedbackGame() {
        this.scanner = new Scanner(System.in);
        this.numberGenerator = new NumberGenerator();
    }

    public void start() {
        System.out.println("Witaj w grze 'Wyszukaj liczbę'!");
        setNumberOfDigits();
        targetNumber = numberGenerator.generateNumber(numberOfDigits);
        play();
    }

    private void setNumberOfDigits() {
        while (true) {
            try {
                System.out.print("Podaj liczbę cyfr do zgadywania (od 1 do 9): ");
                numberOfDigits = scanner.nextInt();
                if (numberOfDigits < 1 || numberOfDigits > 9) {
                    System.out.println("\u001B[31mLiczba cyfr musi być pomiędzy 1 a 9. Spróbuj ponownie.\u001B[0m");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("\u001B[31mBłąd: Wprowadź liczbę całkowitą.\u001B[0m");
                scanner.next(); // Wyczyść niewłaściwe dane
            }
        }
    }

    private void play() {
        int guess;
        boolean hasGuessedCorrectly = false;

        while (!hasGuessedCorrectly) {
            while (true) {
                try {
                    System.out.print("Zgadnij liczbę: ");
                    guess = scanner.nextInt();
                    if (Integer.toString(guess).length() != numberOfDigits) {
                        System.out.println("\u001B[31mLiczba musi mieć " + numberOfDigits + " cyfr.\u001B[0m");
                    } else {
                        break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("\u001B[31mBłąd: Wprowadź liczbę całkowitą.\u001B[0m");
                    scanner.next(); // Wyczyść niewłaściwe dane
                }
            }

            String feedback = getFeedback(guess);
            System.out.println("\u001B[36m" + feedback + "\u001B[0m");

            if (guess == targetNumber) {
                System.out.println("\u001B[32mGratulacje! Zgadłeś liczbę.\u001B[0m\n");
                hasGuessedCorrectly = true;
            }
        }
    }

    private String getFeedback(int guess) {
        String targetStr = Integer.toString(targetNumber);
        String guessStr = Integer.toString(guess);

        int correctPosition = 0;
        int correctDigit = 0;

        for (int i = 0; i < numberOfDigits; i++) {
            if (i < guessStr.length() && i < targetStr.length()) {
                if (guessStr.charAt(i) == targetStr.charAt(i)) {
                    correctPosition++;
                } else if (targetStr.indexOf(guessStr.charAt(i)) != -1) {
                    correctDigit++;
                }
            }
        }

        return String.format("Poprawnie ustawione cyfry: %d, Cyfry na złym miejscu: %d", correctPosition, correctDigit);
    }
}
