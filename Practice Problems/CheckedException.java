import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CheckedException{
    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new FileReader("data.txt"));
            br.readLine();
        } catch(IOException e){
            System.out.println("File not found");
        }
    }
}