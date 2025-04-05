package zgadnijliczbe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NumberGuessingGame {
    private Scanner scanner;
    private NumberGenerator numberGenerator;
    private int targetNumber;
    private int numberOfDigits;

    public NumberGuessingGame() {
        this.scanner = new Scanner(System.in);
        this.numberGenerator = new NumberGenerator();
    }

    public void start() {
        System.out.println("Witaj w grze 'Zgadnij liczbę'!");
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
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("\u001B[31mBłąd: Wprowadź liczbę całkowitą.\u001B[0m");
                    scanner.next(); // Wyczyść niewłaściwe dane
                }
            }

            if (guess > targetNumber) {
                System.out.println("Za wysoka!");
            } else if (guess < targetNumber) {
                System.out.println("Za niska!");
            } else {
                System.out.println("\u001B[32mGratulacje! Zgadłeś liczbę.\u001B[0m\n");
                hasGuessedCorrectly = true;
            }
        }
    }
}
