import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        HashMap<String, Integer> wordTrack = new HashMap<>();

        try (BufferedReader fileReader = new BufferedReader(new FileReader("input.txt"))) {
            String currentLine;
            while ((currentLine = fileReader.readLine()) != null) {
                currentLine = currentLine.replaceAll("[^a-zA-Z ]", "").toLowerCase();
                String[] splitWords = currentLine.split("\\s+");
                for (String currentWord : splitWords) {
                    if (currentWord.isEmpty()) continue;
                    wordTrack.put(currentWord, wordTrack.getOrDefault(currentWord, 0) + 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String currentWord : wordTrack.keySet()) {
            System.out.println(currentWord + " = " + wordTrack.get(currentWord));
        }
    }
}