import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class PrepareGame {
    protected char[] wordToBeGuessed;
    protected char[] emptyGame;

    PrepareGame(String dictionary) throws IOException {
        Dictionary dictionary1 = new Dictionary(dictionary);
        wordToBeGuessed = chooseRandomWord(dictionary1);
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
}
