import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class FileProcessor {
    public void writeToFile(String fname, String txt) throws IOException {
        FileWriter fw = new FileWriter(fname);
        fw.write(txt);
        fw.close();
    }

    public String readFromFile(String fname) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fname));
        String s = br.readLine();
        br.close();
        return s;
    }

    @Test
    public void testWriteAndRead() throws IOException {
        String name = "testfile.txt";
        String msg = "hello world";
        writeToFile(name, msg);
        String res = readFromFile(name);
        Assertions.assertEquals(msg, res);
    }

    @Test
    public void testFileExists() throws IOException {
        String name = "anotherfile.txt";
        writeToFile(name, "data");
        File f = new File(name);
        Assertions.assertTrue(f.exists());
    }

    @Test
    public void testIOException() {
        Assertions.assertThrows(IOException.class, () -> {
            readFromFile("missingfile.txt");
        });
    }
}
