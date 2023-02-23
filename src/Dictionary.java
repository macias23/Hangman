import java.util.ArrayList;
import java.util.Arrays;

public class Dictionary {
    private ArrayList<String> wordlist;
    private ArrayList<char[]> processedWordlist;

    Dictionary(ArrayList<String> wordlist) {
        this.wordlist = wordlist;
        processedWordlist = processWordlist(this.wordlist);
    }

    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>();
        words.add("rondo");
        words.add("pióro");
        words.add("laska");
        words.add("miara");
        words.add("miska");
        words.add("kołek");
        words.add("karta");
        words.add("klucz");
        words.add("słoik");
        words.add("szafa");
        Dictionary dictionary1 = new Dictionary(words);
        new Game(dictionary1);
    }

    public ArrayList<char[]> processWordlist(ArrayList<String> wordlist) {
        ArrayList<char[]> processedWordlist = new ArrayList<char[]>();
        for (String word : wordlist) {
            char[] wordCharArr = word.toCharArray();
            processedWordlist.add(wordCharArr);
        }
        return processedWordlist;
    }

    public ArrayList<String> getWordlist() {
        return wordlist;
    }

    public void setWordlist(ArrayList<String> wordlist) {
        this.wordlist = wordlist;
    }

    public ArrayList<char[]> getProcessedWordlist() {
        return processedWordlist;
    }

    public void setProcessedWordlist(ArrayList<char[]> processedWordlist) {
        this.processedWordlist = processedWordlist;
    }
}
