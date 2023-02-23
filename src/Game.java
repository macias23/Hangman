import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Game extends PrepareGame {
    private final char[] gameInProgress;
    private int numberOfTry;
    private ArrayList<Character> usedLetters;
    private GUI gui;
    Game(Dictionary dictionary) {
        super(dictionary);
        gameInProgress = emptyGame;
        numberOfTry=1;
        usedLetters = new ArrayList<Character>();
        String displayedText2 = ("Próba nr "+numberOfTry);
        String displayedText1 = "Plansza do gry: " + Arrays.toString(gameInProgress) + " " +
                "wykorzystane litery: "+usedLetters;
        gui = new GUI("Zgadnij słowo");
        gui.board.setText("<html>"+displayedText1+"<br>"+displayedText2+"</html>");
        gui.setVisible(true);
        gameLoop(gui.textField);

    }

    public void gameLoop(JTextField textField) {
        while (!Arrays.equals(wordToBeGuessed,gameInProgress)) {
            textField.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String typed = textField.getText();
                    char typedChar = typed.charAt(0);
                    textField.setText("");
                    if (!(letterPresence(typedChar, wordToBeGuessed, gameInProgress))) usedLetters.add(typedChar);
                    String displayedText1 = "Plansza do gry: " + Arrays.toString(gameInProgress) + " " +
                            "wykorzystane litery: "+usedLetters;
                    numberOfTry++;
                    String displayedText2="Próba nr "+numberOfTry;
                    gui.board.setText("<html>"+displayedText1+"<br>"+displayedText2+"</html>");
                }
            });
        }
        gui.board.setText("Wygrana w " + numberOfTry +" próbach! Słowo do zgadnięcia to " + String.valueOf(wordToBeGuessed));
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
