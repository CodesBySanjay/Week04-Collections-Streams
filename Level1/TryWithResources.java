import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

class FileProcessor {
    void processFiles(List<String> paths) {
        for (String p : paths) {
            try (BufferedReader br = new BufferedReader(new FileReader(p))) {
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                System.out.println("Error reading: " + p);
            }
        }
    }

    public static void main(String[] args) {
        List<String> files = List.of("file1.txt", "file2.txt");
        new FileProcessor().processFiles(files);
    }
}
