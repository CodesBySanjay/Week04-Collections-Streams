import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ReadWriteFile{
    public static void main(String[] args){
        String input = "input.txt";
        String output = "output.txt";
        try{
        FileInputStream fi = new FileInputStream(input);
        FileOutputStream fo = new FileOutputStream(output);

        int data;
        while((data=fi.read()) != -1){
            fo.write(data);
        }
        fi.close();
        fo.close();
        } catch (IOException e){
            System.out.println("Error: "+e.getMessage());
        }
    }
}