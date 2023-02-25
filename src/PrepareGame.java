import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class PrepareGame {
    protected final char[] wordToBeGuessed;
    protected char[] emptyGame;
    protected String fullWord;

    PrepareGame(String dictionary) throws IOException {
        Dictionary dictionary1 = new Dictionary(dictionary);
        wordToBeGuessed = chooseRandomWord(dictionary1);
        fullWord = String.valueOf(wordToBeGuessed);
        emptyGame = new char[wordToBeGuessed.length];
        for (int i = 0; i < emptyGame.length; i++) {
            emptyGame[i]='*';
        }
    }

    public char[] chooseRandomWord(Dictionary dictionary) {
        ArrayList<char[]> processedWordlist = dictionary.getProcessedWordlist();
        int index = (int) (Math.random() * processedWordlist.size());
        char[] chosenWord = processedWordlist.get(index);
        return chosenWord;
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
    private boolean checkFullWord(String word){
        if (word.equals(fullWord)) return true;
        else return false;
    }
}
