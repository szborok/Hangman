package hangman.logic;

import java.util.*;

public class Game {
    public Difficulty difficulty;
    public Boolean isAlive;
    public Boolean isWon;
    public String chosenWord;
    public List<String> guessedLetters;
    public List<String> wrongLetters;
    public Integer numberOfWrongLetters;
    public Integer limit;
    
    public Game() {
        this.limit = 10;
        this.numberOfWrongLetters = 0;
        this.isAlive = true;
        this.isWon = false;
        this.difficulty = askForDifficulty();
        this.chosenWord = new Vocabulary().randomWordByDifficulty(this.difficulty).toUpperCase();
        this.guessedLetters = new ArrayList<>();
        this.wrongLetters = new ArrayList<>();
    }
    
    
    
    public void letterCheck() {
        List<String> goodLetters = List.of(this.chosenWord.toUpperCase().split(""));
        
        for (int i = 0; i < this.guessedLetters.size(); i++) {
            String currentLetter = this.guessedLetters.get(i);
            if (!goodLetters.contains(currentLetter) && !this.wrongLetters.contains(currentLetter)) {
                this.wrongLetters.add(currentLetter);
                this.numberOfWrongLetters++;
            }
        }
    }
    
    public void printCurrentState() {
        String[] lettersOfChosenWord = this.chosenWord.split("");
        System.out.println();
        
        for (int i = 0; i < lettersOfChosenWord.length; i++) {
            String currentLetter = lettersOfChosenWord[i];
            if (this.guessedLetters.contains(currentLetter)) {
                System.out.print(" " + currentLetter + " ");
            } else {
                System.out.print(" _ ");
            }
        }
        System.out.println();
    }
    
    public void addUserInput() {
        String currentInput = Game.getUserInput().toUpperCase();
        if (!this.guessedLetters.contains(currentInput)) {
            this.guessedLetters.add(currentInput);
        } else {
            System.out.println("You already tried this letter, please try another one.");
            addUserInput();
        }
    }
    
    public static String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        String userInputLetter = null;
        Boolean validInput = false;
        
        while (!validInput) {
            System.out.println();
            System.out.println("Guess a letter.");
            
            if (scanner.hasNext("[a-zA-Z]")) {
                userInputLetter = String.valueOf(scanner.next().charAt(0));
                validInput = true;
            } else {
                System.out.println("Invalid input. Please enter a single letter.");
                scanner.next();
            }
        }
        return userInputLetter;
    }
    
    public void updateIsAlive() {
        if (Objects.equals(this.numberOfWrongLetters, this.limit)) {
            this.isAlive = false;
        }
    }
    
    public void updateIsWon() {
        String[] chosenWordLetters = this.chosenWord.split("");
        Integer counter = 0;
        for (int i = 0; i < chosenWordLetters.length; i++) {
            if (this.guessedLetters.contains(chosenWordLetters[i])) {
                counter++;
            }
        }
        if (chosenWordLetters.length == counter) {
            this.isWon = true;
        }
    }
    
    public Difficulty askForDifficulty() {
        System.out.println("Choose a difficulty level:");
        System.out.println("1. Easy");
        System.out.println("2. Medium");
        System.out.println("3. Hard");
        
        int choice = getUserDifficultyChoice(1,3);
        
        switch (choice) {
            case 1:
                return Difficulty.EASY;
            case 2:
                return Difficulty.MEDIUM;
            case 3:
                return Difficulty.HARD;
            default:
                // Handle invalid input
                return Difficulty.MEDIUM; // Default to medium in case of invalid input
        }
    }
    
    private static int getUserDifficultyChoice(int min, int max) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        
        while (true) {
            System.out.print("Enter your choice (number): ");
            
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice >= min && choice <= max) {
                    break;
                } else {
                    System.out.println("Invalid choice. Please enter a number between " + min + " and " + max + ".");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Consume invalid input
            }
        }
        
        return choice;
    }
    
    
    
    
}
