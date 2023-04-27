package org.example;

import java.nio.file.attribute.UserPrincipalLookupService;
import java.util.Scanner;

public class App 
{


    // Zad.3.
    // Analiza stringów: napisz program, który sprawdza, czy dany string jest palindromem (odczytuje się go tak samo od
    // przodu, jak i od tyłu, np Anna), heterogramem (żadna litera się nie powtarza, np Mateusz), pangramem
    // (zawiera wszystkie litery alfabetu łacińskiego, np The quick brown fox jumps over a lazy dog), oraz, czy dane
    // dwa stringi są anagramami (składają się z tych samych liter, np Tom Marvolo Riddle - I am Lord Voldemort)

    public static void main( String[] args )
    {
//        calculator();
        spaceVacuum();
    }
    // Zad.1.
    // Kalkulator: napisz program kalkulator, który wspiera działania dodawania, odejmowania, mnożenia i dzielenia.
    // Użytkownik wpisuje działanie, np 4 + 5 i otrzymuje wynik: 4 + 5 = 9.

    // Poproś użytkownika o wpisanie działania w szyku: liczba, operator działania, liczba
    // Podziel odczytany wiersz na fragmenty
    // Wykonaj odpowiednie działanie
    // Wypisz działanie i jego wynik, np.  4 + 5 = 9.

    public static void calculator() {
        String inputLine = getInputData();
        String[] operationSplit = inputLine.trim().split(" ");
        Float result = calculate(Float.parseFloat(operationSplit[0]), Float.parseFloat(operationSplit[2]), operationSplit[1].charAt(0));
        String messageFormatted = String.format("%s %s %s = %f", operationSplit[0], operationSplit[1], operationSplit[2], result);
        System.out.println(messageFormatted);
    }

    public static String getInputData() {
        System.out.println("Enter numbers and operator (number operator number):");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static Float calculate(Float a, Float b, char symbol) {
        switch (symbol) {
            case '+': return add(a, b);
            case '-': return subtract(a, b);
            case '*': return multiply(a, b);
            case '/': return divide(a, b);
            default: return null;
        }
    }
    public static Float add(Float a, Float b) {
        return a + b;
    }
    public static Float subtract(Float a, Float b) {
        return a - b;
    }
    public static Float multiply(Float a, Float b) {
        return a * b;
    }
    public static Float divide(Float a, Float b) {
        if (b != 0f) {
            return a / b;
        }
        return null;
    }



    // Zad.2.
    // Odkurzacz do spacji: napisz program, który oczyszcza dany tekst ze wszystkich nadmiarowych spacji, pozostawiając
    // tylko pojedyncze między słowami. Np Ala   ma           kota                 -> Ala ma kota

    public static void spaceVacuum () {
        System.out.println(" Write your sentence with many spaces.");
        Scanner scanner = new Scanner(System.in);
        String inPutLine = scanner.nextLine();
        String[] lineSplit = inPutLine.trim().split(" ");
        String newString = lineSplit[0];
        for (Integer i = 1; i < lineSplit.length; i++) {
           if (lineSplit[i] != "") {newString = newString.concat(" ") ;
            newString = newString.concat(lineSplit[i]) ;
        }
        }
        System.out.println(newString);
    }
}


