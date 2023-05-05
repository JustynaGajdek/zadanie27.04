package org.example;

import java.nio.file.attribute.UserPrincipalLookupService;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class App {
    public static void main(String[] args) {
//        calculator();
//        spaceVacuum();
//        checkWord();
//        checkSentence();
        checkSentences();
    }
    // Zad.1.
    // Kalkulator: napisz program kalkulator, który wspiera działania dodawania, odejmowania, mnożenia i dzielenia.
    // Użytkownik wpisuje działanie, np 4 + 5 i otrzymuje wynik: 4 + 5 = 9.

    // Poproś użytkownika o wpisanie działania w szyku: liczba, operator działania, liczba
    // Podziel odczytany wiersz na fragmenty
    // Wykonaj odpowiednie działanie
    // Wypisz działanie i jego wynik, np.  4 + 5 = 9.

    public static void calculator() {
        String[] inputData = getInputData();
        Float firstNumber = Float.parseFloat(inputData[0]);
        Float secondNumber = Float.parseFloat(inputData[2]);
        char symbol = inputData[1].charAt(0);
        Float result = calculate(firstNumber, secondNumber, symbol);
        String messageFormatted = result == null ? "Oops, something went wrong..." : String.format("%4.2f %s %4.2f = %4.2f", firstNumber, symbol, secondNumber, result);
        System.out.println(messageFormatted);
    }

    public static String[] getInputData() {
        System.out.println("Enter numbers and operator (number operator number):");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().trim().split(" ");
    }

    public static Float calculate(Float a, Float b, char symbol) {
        switch (symbol) {
            case '+':
                return add(a, b);
            case '-':
                return subtract(a, b);
            case '*':
                return multiply(a, b);
            case '/':
                return divide(a, b);
            default:
                return null;
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

    public static void spaceVacuum() {
        System.out.println("Write your sentence with many spaces:");
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        System.out.println(inputLine.trim().replaceAll("\\s+", " "));
        }


    // Zad.3.
    // Analiza stringów: napisz program, który sprawdza, czy dany string jest:
    // - palindromem (odczytuje się go tak samo od przodu, jak i od tyłu, np Anna),
    // - heterogramem (żadna litera się nie powtarza, np Mateusz),
    // - pangramem (zawiera wszystkie litery alfabetu łacińskiego, np The quick brown fox jumps over a lazy dog), oraz,
    // - czy dane dwa stringi są anagramami (składają się z tych samych liter, np Tom Marvolo Riddle - I am Lord Voldemort)

    public static void checkWord() {
        System.out.println("Please write a word: ");
        Scanner scanner = new Scanner(System.in);
        String userWord = scanner.nextLine();
        boolean isPalindrom = checkPalindrome(userWord);
        System.out.println("Palindrom: " + isPalindrom);
        boolean isHeterogram = checkHeterogram(userWord);
        System.out.println("Heterogram: " + isHeterogram);
    }
    private static String cleanText(String text) {
        return text.trim().replace(" ", "").toLowerCase();
    }

    public static boolean checkPalindrome(String text) {
        String newText = cleanText(text);
        if (newText.length() < 1) {
            return false;
        }
        for (int i = 0; i < newText.length()/2; i++) {
            if (newText.charAt(i) != newText.charAt(newText.length()-i-1)) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkHeterogram(String text) {
        Set<Character> setOfLetters = new HashSet<>();
        String newText = cleanText(text);
        for (char letter : newText.toCharArray()) {
            setOfLetters.add(letter);
        }
        return newText.length() == setOfLetters.size();
    }
    public static void checkSentence() {
        System.out.println("Please write a sentence: ");
        Scanner scanner = new Scanner(System.in);
        String userSentence = scanner.nextLine();
        boolean isPanagram = checkPangram(userSentence);
        System.out.println("Panagram: " + isPanagram);
    }
    public static boolean checkPangram(String sentence) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        Set<Character> setAlphabet = new HashSet<>();
        for (char i : alphabet.toCharArray()) {
            setAlphabet.add(i);
        }
        Set<Character> setSentence = new HashSet<>();
        for (char i : cleanText(sentence).toCharArray()) {
            setSentence.add(i);
        }
        return setSentence.equals(setAlphabet);
    }

    public static void checkSentences() {
        System.out.println("Please write first sentence: ");
        Scanner scanner = new Scanner(System.in);
        String sentence1 = scanner.nextLine();
        System.out.println("Please write second sentence: ");
        String sentence2 = scanner.nextLine();
        boolean isAnagram = checkAnagram(sentence1, sentence2);
        System.out.println("Anagram: " + isAnagram);
    }
    private static String cleanSentence(String sentence) {
        return sentence.trim().replaceAll("\\s+","").toLowerCase();
    }
    public static boolean checkAnagram(String sentence1, String sentence2) {
        sentence1 = cleanSentence(sentence1);
        sentence2 = cleanSentence(sentence2);
        char[] sentence1Array = sentence1.toCharArray();
        char[] sentence2Array = sentence2.toCharArray();
        Arrays.sort(sentence1Array);
        Arrays.sort(sentence2Array);
        return Arrays.equals(sentence2Array, sentence1Array);
    }

}


