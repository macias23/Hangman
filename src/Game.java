import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.*;

public class Game extends PrepareGame {
    private char[] gameInProgress;
    private int numberOfTry;
    private HashSet<Character> wrongUsedLetters;
    private HashSet<Character> correctUsedLetters;
    private GUI gui;
    private String tryInfo;
    private String gameInfo;
    private String boardText;
    private String message;
    Game()throws IOException {
        super("dictionary");
        gameInProgress = emptyGame;
        numberOfTry=1;
        wrongUsedLetters = new HashSet<>();
        correctUsedLetters = new HashSet<>();
        tryInfo = "Próba nr "+numberOfTry;
        gameInfo = "Plansza do gry: " + Arrays.toString(gameInProgress) + " " + "wykorzystane litery: "+ wrongUsedLetters;
        message = "Witaj w wiesielcu!";
        boardText = "<html>"+tryInfo+"<br>"+gameInfo+"<br>"+message+"</html>";
        gui = new GUI("Zgadnij słowo");
        gui.board.setText(boardText);
        gui.setVisible(true);
        gameLoop();

    }

    public void gameLoop() {
            while (!Arrays.equals(wordToBeGuessed, gameInProgress)) {
                gui.textField.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String typed = gui.textField.getText();
                        char typedChar = typed.charAt(0);
                        if (typed.length()>1){
                            if (typed.equals(fullWord)) {
                                gameInProgress = wordToBeGuessed;
                            } else {
                                message="<html>"+"Wyraz do zgadnięcia to nie " + "<strong style=color:red>"+typed+"</strong>";
                                numberOfTry++;
                            }
                        } else {
                            if (wrongUsedLetters.contains(typedChar)|| correctUsedLetters.contains(typedChar)){
                                message = "<html>"+"Już pytałeś o literę " + "<strong>"+typedChar+"</strong>"+".";
                            } else if (!(letterPresence(typedChar, wordToBeGuessed, gameInProgress))) {
                                wrongUsedLetters.add(typedChar);
                                message = "<html>"+"Litera " + "<strong style=color:red>"+typedChar+"</strong>"+ " nie znajduje się w wyrazie.";
                                numberOfTry++;
                            } else {
                                message = "<html>"+"Litera " + "<strong style=color:green>"+typedChar+"</strong>"+ " znajduje się w wyrazie.";
                                correctUsedLetters.add(typedChar);
                                numberOfTry++;
                            }
                        }
                        tryInfo = "Próba nr "+numberOfTry;
                        gameInfo = "Plansza do gry: " + Arrays.toString(gameInProgress) + " " + "wykorzystane litery: "+ wrongUsedLetters;
                        boardText = "<html>"+tryInfo+"<br>"+gameInfo+"<br>"+message+"</html>";
                        gui.board.setText(boardText);
                        gui.textField.setText("");
                    }
                });
            }
            gui.board.setText("Wygrana w " + numberOfTry + " próbach! Słowo do zgadnięcia to " + String.valueOf(wordToBeGuessed));
        }

    public static void main(String[] args) throws IOException{
    new Game();
    }
}
