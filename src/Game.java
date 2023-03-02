import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;

public class Game extends PrepareGame {
    protected char[] gameInProgress;
    private int numberOfTry;
    private HashSet<Character> wrongUsedLetters;
    private HashSet<Character> correctUsedLetters;
    private GUI gui;
    private String tryInfo;
    private String gameInfo;
    private String boardText;
    private String message;
    boolean solvedByUser;

    Game() throws IOException {
        super("dictionary");
        gameInProgress = emptyGame;
        numberOfTry = 1;
        solvedByUser=true;
        wrongUsedLetters = new HashSet<>();
        correctUsedLetters = new HashSet<>();
        tryInfo = "Próba nr " + numberOfTry;
        gameInfo = "Plansza do gry: " + Arrays.toString(gameInProgress) + " " + "wykorzystane litery: " + wrongUsedLetters;
        message = "Witaj w wiesielcu!";
        boardText = "<html>" + tryInfo + "<br>" + gameInfo + "<br>" + message + "</html>";
        gui = new GUI("Zgadnij słowo");
        gui.board.setText(boardText);
        gui.setVisible(true);
        gui.pack();
        gameLoop();

    }

    public void gameLoop() {
        while (!Arrays.equals(wordToBeGuessed, gameInProgress)) {
            gui.solve.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    gameInProgress=wordToBeGuessed;
                    solvedByUser=false;
                }
            });
            gui.textField.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String typed = gui.textField.getText();
                    char typedChar = typed.charAt(0);
                    if (typed.length() > 1) {
                        if (typed.equals(fullWord)) {
                            gameInProgress = wordToBeGuessed;
                        } else {
                            message = "<html>" + "Wyraz do zgadnięcia to nie " + "<strong style=color:red>" + typed + "</strong>";
                            numberOfTry++;
                        }
                    } else {
                        if (wrongUsedLetters.contains(typedChar) || correctUsedLetters.contains(typedChar)) {
                            message = "<html>" + "Już pytałeś o literę " + "<strong>" + typedChar + "</strong>" + ".";
                        } else if (!(letterPresence(typedChar, wordToBeGuessed, gameInProgress))) {
                            wrongUsedLetters.add(typedChar);
                            message = "<html>" + "Litera " + "<strong style=color:red>" + typedChar + "</strong>" + " nie znajduje się w wyrazie.";
                            numberOfTry++;
                        } else {
                            message = "<html>" + "Litera " + "<strong style=color:green>" + typedChar + "</strong>" + " znajduje się w wyrazie.";
                            correctUsedLetters.add(typedChar);
                            numberOfTry++;
                        }
                    }
                    tryInfo = "Próba nr " + numberOfTry;
                    gameInfo = "Plansza do gry: " + Arrays.toString(gameInProgress) + " " + "wykorzystane litery: " + wrongUsedLetters;
                    boardText = "<html>" + tryInfo + "<br>" + gameInfo + "<br>" + message + "</html>";
                    gui.board.setText(boardText);
                    gui.textField.setText("");
                    gui.pack();
                }
            });
        }
        if(solvedByUser) {
            gui.board.setText("<html>" + "<strong style=color:green>" + "Wygrana " + "</strong>"+"w " + numberOfTry + " próbach!" + "<br>"+"Słowo do zgadnięcia to " +
                    "<strong style=color:green>" + String.valueOf(wordToBeGuessed) + "</strong>" + "</html>");
            gui.pack();
        }
        else{
            gui.board.setText("<html>" +  "<strong style=color:red>" + "Przegrana :( "+ "</strong>" +"<br>" +"Słowo do zgadnięcia to " +
                    "<strong style=color:red>" + String.valueOf(wordToBeGuessed) + "</strong>" + "</html>");
            gui.pack();
        }

    }

    public static void main(String[] args) throws IOException {
        new Game();
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
