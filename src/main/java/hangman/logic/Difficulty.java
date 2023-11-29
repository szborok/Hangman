package hangman.logic;

public class Difficulty {
    public static final Difficulty EASY = new Difficulty("Easy",1,4);
    public static final Difficulty MEDIUM = new Difficulty("Medium",5,7);
    public static final Difficulty HARD = new Difficulty("Hard",7,99);
    
    public String name;
    public Integer minLetter;
    public Integer maxLetter;
    
    public Difficulty(String name, Integer minLetter, Integer maxLetter) {
        this.name = name;
        this.minLetter = minLetter;
        this.maxLetter = maxLetter;
    }
}
