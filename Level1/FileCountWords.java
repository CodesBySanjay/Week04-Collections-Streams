import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileCountWords {
    public static void main(String[] args) {
        Map<String, Integer> words = new HashMap<>();
        try {
            FileReader fi = new FileReader("input.txt");
            BufferedReader br = new BufferedReader(fi);
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.toLowerCase().split("\\W+");
                for (String w : parts) {
                    if (!w.isEmpty()) {
                        words.put(w, words.getOrDefault(w, 0) + 1);
                    }
                }
            }
            br.close();
            List<Map.Entry<String, Integer>> list = new ArrayList<>(words.entrySet());
            Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
                public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
                    return b.getValue().compareTo(a.getValue());
                }
            });
            for (int i = 0; i < Math.min(5, list.size()); i++) {
                Map.Entry<String, Integer> entry = list.get(i);
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        } catch (IOException e) {
            System.out.println("error: " + e.getMessage());
        }
    }
}