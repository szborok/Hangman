package hangman.logic;

import java.util.List;

public class Graphic {

    public static void printHangman(Integer numberOfWrongGuesses) {
        if (numberOfWrongGuesses == 0) {
            System.out.println(" ");
        } else {
            
            String a = (numberOfWrongGuesses >= 1) ? "-" : " ";
            String b = (numberOfWrongGuesses >= 2) ? "|" : " ";
            String c = (numberOfWrongGuesses >= 3) ? "_" : " ";
            String d = (numberOfWrongGuesses >= 4) ? "|" : " ";
            String e = (numberOfWrongGuesses >= 5) ? "(-_-)" : "     ";
            String f = (numberOfWrongGuesses >= 6) ? "|" : " ";
            String g = (numberOfWrongGuesses >= 7) ? "-" : " ";
            String h = (numberOfWrongGuesses >= 8) ? "-" : " ";
            String i = (numberOfWrongGuesses >= 9) ? "/" : " ";
            String j = (numberOfWrongGuesses >= 10) ? "\\" : " ";
            
            System.out.println(
                            "            " + c + c + c + c + c + c + c + c + c + c + c + c + c + "      \n" +
                            "            " + b + "           " + d + "                                  \n" +
                            "            " + b + "         " + e + "                                    \n" +
                            "            " + b + "        " + g + g + g + f + h + h + h + "             \n" +
                            "            " + b + "           " + f + "                                  \n" +
                            "            " + b + "          " + i + " " + j + "                         \n" +
                            "            " + b + "         " + i + "   " + j + "                        \n" +
                            "            " + b + "                                                      \n" +
                            "        " + a + a + a + a + a + a + a + a + a + "                          \n"
            );
        }
    }
    
    public static void printWrongLetters(List<String> wrongLettersList) {
        
        System.out.print("Wrong letter:");
        for (int i = 0; i < wrongLettersList.size(); i++) {
            String currentLetter = wrongLettersList.get(i);
            System.out.print(" " + currentLetter + ",");
        }
        System.out.println();
    }
    
    public static void printResult(Boolean isAlive, Boolean isWon, String choosenWord) {
        if (isAlive && isWon) {
            Graphic.printCongratulation();
            System.out.println("Well done, you saved Me from hanging.");
        } else {
            Graphic.printGameOver();
            System.out.println("Better luck next time!");
            printReveal(choosenWord);
        }
    }
    
    public static void printIntro() {
        System.out.println("Welcome to Hangman.\nYour task is to save Me from hanging. \n\nBefore We start, choose the difficulty.");
    }
    
    public static void printReveal(String word) {
        System.out.println("The mysterious word was: " + word);
    }
    
    
    public static void printLogo() {
        System.out.println(
                "::::::::::::::::::::::::::::::::::::::::::::::::::::::\n" +
                "::::::::::::::::::::::::::::::::::::::::::::::::::::::\n" +
                "::                                                  ::\n" +
                "::  _   _    _    _   _  ____ __  __    _    _   _  ::\n" +
                ":: | | | |  / \\  | \\ | |/ ___|  \\/  |  / \\  | \\ | | ::\n" +
                ":: | |_| | / _ \\ |  \\| | |  _| |\\/| | / _ \\ |  \\| | ::\n" +
                ":: |  _  |/ ___ \\| |\\  | |_| | |  | |/ ___ \\| |\\  | ::\n" +
                ":: |_| |_/_/   \\_\\_| \\_|\\____|_|  |_/_/   \\_\\_| \\_| ::\n" +
                "::                                                  ::\n" +
                "::                                                  ::\n" +
                "::::::::::::::::::::::::::::::::::::::::::::::::::::::\n" +
                "::::::::::::::::::::::::::::::::::::::::::::::::::::::");
    }
    
    public static void printGameOver() {
        System.out.println(
                "  ____    _    __  __ _____    _____     _______ ____  \n" +
                " / ___|  / \\  |  \\/  | ____|  / _ \\ \\   / / ____|  _ \\ \n" +
                "| |  _  / _ \\ | |\\/| |  _|   | | | \\ \\ / /|  _| | |_) |\n" +
                "| |_| |/ ___ \\| |  | | |___  | |_| |\\ V / | |___|  _ < \n" +
                " \\____/_/   \\_\\_|  |_|_____|  \\___/  \\_/  |_____|_| \\_\\");
    }
    
    public static void printCongratulation() {
        System.out.println(
                "  ____ ___  _   _  ____ ____      _  _____ _   _ _        _  _____ ___ ___  _   _ \n" +
                " / ___/ _ \\| \\ | |/ ___|  _ \\    / \\|_   _| | | | |      / \\|_   _|_ _/ _ \\| \\ | |\n" +
                "| |  | | | |  \\| | |  _| |_) |  / _ \\ | | | | | | |     / _ \\ | |  | | | | |  \\| |\n" +
                "| |__| |_| | |\\  | |_| |  _ <  / ___ \\| | | |_| | |___ / ___ \\| |  | | |_| | |\\  |\n" +
                " \\____\\___/|_| \\_|\\____|_| \\_\\/_/   \\_\\_|  \\___/|_____/_/   \\_\\_| |___\\___/|_| \\_|");
    }
    
    
}
