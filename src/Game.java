import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.*;
import java.util.Dictionary;

public class Game extends PrepareGame {
    private final char[] gameInProgress;
    private int numberOfTry;
    private HashSet<Character> usedLetters;
    private GUI gui;
    Game()throws IOException {
        super("dictionary");
        gameInProgress = emptyGame;
        numberOfTry=1;
        usedLetters = new HashSet<Character>();
        gui = new GUI("wisielec");
        String displayedText2 = ("Próba nr "+numberOfTry);
        String displayedText1 = "Plansza do gry: " + Arrays.toString(gameInProgress) + " " +
                "wykorzystane litery: "+usedLetters;
        gui = new GUI("Zgadnij słowo");
        gui.board.setText("<html>"+displayedText1+"<br>"+displayedText2+"</html>");
        gui.setVisible(true);
        gameLoop();

    }

    public void gameLoop() throws IOException{
            while (!Arrays.equals(wordToBeGuessed, gameInProgress)) {
                gui.textField.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String typed = gui.textField.getText();
                        char typedChar = typed.charAt(0);
                        gui.textField.setText("");
                        if (!(letterPresence(typedChar, wordToBeGuessed, gameInProgress))) usedLetters.add(typedChar);
                        String displayedText1 = "Plansza do gry: " + Arrays.toString(gameInProgress) + " " +
                                "wykorzystane litery: " + usedLetters;
                        numberOfTry++;
                        String displayedText2 = "Próba nr " + numberOfTry;
                        gui.board.setText("<html>" + displayedText1 + "<br>" + displayedText2 + "</html>");
                    }
                });
            }
            gui.board.setText("Wygrana w " + numberOfTry + " próbach! Słowo do zgadnięcia to " + String.valueOf(wordToBeGuessed));
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
    public static void main(String[] args) throws IOException{
    new Game();
    }
}
