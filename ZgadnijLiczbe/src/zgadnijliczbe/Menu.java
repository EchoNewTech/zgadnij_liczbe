package zgadnijliczbe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private Scanner scanner;

    public Menu() {
        this.scanner = new Scanner(System.in);
    }

    public void show() {
        while (true) {
            printHeader();
            System.out.println("1. Gra - Zgadnij liczbę (za wysoka/niska)");
            System.out.println("2. Gra - Wyszukaj liczbę (na poprawnym/złym miejscu)");
            System.out.println("\u001B[31m3. Wyjście\u001B[0m");
            
            int choice = getUserChoice();
            
            switch (choice) {
                case 1 -> new NumberGuessingGame().start();
                case 2 -> new NumberFeedbackGame().start();
                case 3 -> {
                    System.out.println("Dziękujemy za grę! Do widzenia.");
                    return;
                }
                default -> System.out.println("\u001B[31mNiepoprawny wybór. Spróbuj ponownie.\u001B[0m");
            }
        }
    }

    private int getUserChoice() {
        while (true) {
            try {
                System.out.print("Wybór: ");
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("\u001B[31mBłąd: Wprowadź liczbę całkowitą.\u001B[0m");
                scanner.next(); // Wyczyść niewłaściwe dane
            }
        }
    }

    private void printHeader() {
        System.out.println("==============================");
        System.out.println("    Witaj w grze Zgadnij Liczbę    ");
        System.out.println("==============================");
    }
}
