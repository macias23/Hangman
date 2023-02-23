import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Game extends PrepareGame {
    private final char[] gameInProgress;
    private int numberOfTry;
    private ArrayList<Character> usedLetters;

    Game(Dictionary dictionary) {
        super(dictionary);
        gameInProgress = emptyGame;
        numberOfTry=1;
        usedLetters = new ArrayList<Character>();
        System.out.println("Witaj w wisielcu!");
        String displayedText = "Plansza do gry: " + Arrays.toString(gameInProgress) + " " +
                "wykorzystane litery: "+usedLetters;
        System.out.println("Próba nr "+numberOfTry);
        System.out.println(displayedText);
        gameLoop();

    }

    public void gameLoop() {
        Scanner scanner = new Scanner(System.in);
        while (!Arrays.equals(wordToBeGuessed,gameInProgress)) {
            char typedChar = scanner.next().charAt(0);
            if (!(letterPresence(typedChar, wordToBeGuessed, gameInProgress))) usedLetters.add(typedChar);
            String displayedText = "Plansza do gry: " + Arrays.toString(gameInProgress) + " " +
                    "wykorzystane litery: "+usedLetters;
            numberOfTry++;
            System.out.println("Próba nr "+numberOfTry);
            System.out.println(displayedText);
        }
        System.out.println("Wygrana w " + numberOfTry +" próbach! Słowo do zgadnięcia to " + String.valueOf(wordToBeGuessed));
    }

    public boolean letterPresence(char x, char[] fullWord, char[] game) {
        boolean letterPresence = false;
        for (int i = 0; i < fullWord.length; i++) {
            if (x == fullWord[i]) {
                game[i] = x;
                letterPresence = true;
            }
        }
        return letterPresence;
    }

}
