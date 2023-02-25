import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dictionary {
    private ArrayList<String> wordlist;
    private ArrayList<char[]> processedWordlist;

    Dictionary(String fileName) {
        wordlist=readWordlist(fileName);
        processedWordlist = processWordlist(wordlist);
    }

    public ArrayList<String> readWordlist(String filename) {
        String csvFile = filename+".csv";
        String line = "";
        String csvSplitBy = ",";

        ArrayList<String> wordsList = new ArrayList<String>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                // odczytaj wyrazy z pliku CSV
                String[] words = line.split(csvSplitBy);

                // dodaj wyrazy do listy
                for (String word : words) {
                    wordsList.add(word);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return wordsList;
    }


    public ArrayList<char[]> processWordlist(ArrayList<String> wordlist) {
        ArrayList<char[]> processedWordlist = new ArrayList<char[]>();
        for (String word : wordlist) {
            char[] wordCharArr = word.toCharArray();
            processedWordlist.add(wordCharArr);
        }
        return processedWordlist;
    }

    public ArrayList<char[]> getProcessedWordlist() {
        return processedWordlist;
    }

    public void setProcessedWordlist(ArrayList<char[]> processedWordlist) {
        this.processedWordlist = processedWordlist;
    }
}
