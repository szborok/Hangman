package hangman.game;

import hangman.logic.Definition;
import hangman.logic.Game;
import hangman.logic.Graphic;

public class HangmanGame {
    public static void main(String[] args) throws Exception {
        
        Graphic.printLogo();
        Graphic.printIntro();

        Game newGame = new Game();

        while (newGame.isAlive && !newGame.isWon) {
            newGame.addUserInput();
            newGame.letterCheck();
            Graphic.printHangman(newGame.numberOfWrongLetters);
            Graphic.printWrongLetters(newGame.wrongLetters);
            newGame.printCurrentState();
            newGame.updateIsAlive();
            newGame.updateIsWon();
        }

        Graphic.printResult(newGame.isAlive,newGame.isWon,newGame.chosenWord);
        System.out.println(newGame.chosenWord);
        Definition.getDefinition(newGame.chosenWord);
    
    }
}