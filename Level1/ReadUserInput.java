import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadUserInput {
    public static void main(String[] args){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter your name: ");
            String name = br.readLine();
            System.out.print("Enter your age: ");
            String age = br.readLine();
            System.out.print("Enter your favorite programming language: ");
            String language = br.readLine();
            FileWriter fw = new FileWriter("output.txt");
            fw.write(name+"\n"+age+"\n"+language);

            br.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
