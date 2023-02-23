import java.util.ArrayList;
import java.util.Arrays;

public class PrepareGame {
    protected char[] wordToBeGuessed;
    protected char[] emptyGame;

    PrepareGame(Dictionary dictionary) {
        char[] emptyGame = {'*', '*', '*', '*', '*'};
        wordToBeGuessed = chooseRandomWord(dictionary);
        this.emptyGame = emptyGame;
    }

    public char[] chooseRandomWord(Dictionary dictionary) {
        ArrayList<char[]> processedWordlist = dictionary.getProcessedWordlist();
        int index = (int) (Math.random() * processedWordlist.size());
        char[] chosenWord = processedWordlist.get(index);
        return chosenWord;
    }
}
