package hangman.logic;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Vocabulary {
    private List<String> words;
    private String sourceFileName;
    private InputStream sourceFile;
    
    public Vocabulary() {
        this.sourceFileName = "words_alpha.txt";
        this.sourceFile = getSource();
        this.words = initializeWords();
    }
    
    private List<String> initializeWords() {
        List<String> returnList = new ArrayList<>();
        Scanner scanner = new Scanner(this.sourceFile);
        
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            returnList.add(line);
        }
        return returnList;
    }
    
    private InputStream getSource() {
        InputStream inputStream = Vocabulary.class.getClassLoader().getResourceAsStream(this.sourceFileName);
        return inputStream;
    }
    
    public String randomWord() {
        Random rnd = new Random();
        int randomIndex = rnd.nextInt(0,this.words.size());
        return this.words.get(randomIndex);
    }
    
    public String randomWordByDifficulty(Difficulty difficulty) {
        List<String> chosenListOfWords = new ArrayList<>();
        
        for (int i = 0; i < this.words.size(); i++) {
            String currentWord = this.words.get(i);
            Integer currentWordsLength = currentWord.split("").length;
            
            if (currentWordsLength >= difficulty.minLetter && currentWordsLength <= difficulty.maxLetter) {
                chosenListOfWords.add(currentWord);
            }
        }
        
        Random rnd = new Random();
        int randomIndex = rnd.nextInt(0,chosenListOfWords.size());
        return chosenListOfWords.get(randomIndex);
    }
    
    
    
    
    
    
    
}
