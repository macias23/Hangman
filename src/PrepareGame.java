import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class PrepareGame {
    protected final char[] wordToBeGuessed;
    protected char[] emptyGame;
    protected String fullWord;

    PrepareGame(String dictionary) throws IOException {
        Dictionary dictionary1 = new Dictionary(dictionary);
        fullWord = chooseRandomWord(dictionary1);
        wordToBeGuessed=fullWord.toCharArray();
        emptyGame = new char[wordToBeGuessed.length];
        for (int i = 0; i < emptyGame.length; i++) {
            emptyGame[i]='*';
        }
    }

    public String chooseRandomWord(Dictionary dictionary) {
        ArrayList<String> wordlist = dictionary.getWordlist();
        int index = (int) (Math.random() * wordlist.size());
        String chosenWord = wordlist.get(index);
        return chosenWord;
    }

}
