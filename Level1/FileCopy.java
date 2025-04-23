import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
    public static void main(String[] args){
        String input = "input.txt";
        String output = "output.txt";

        try{
        BufferedInputStream bi = new BufferedInputStream(new FileInputStream(input));
        BufferedOutputStream bo = new BufferedOutputStream(new FileOutputStream(output));
        long t1 = System.nanoTime();
        byte[] buffer = new byte[4096];
        int bytesRead;
        while((bytesRead=bi.read(buffer))!=-1){
            bo.write(buffer,0,bytesRead);
        }
        bo.flush();
        long t2 = System.nanoTime();
        System.out.println("Time taken: "+(t2-t1)+" ns");
        bi.close();
        bo.close();
        } catch(IOException e){
            System.out.println("Error: "+e.getMessage());
        }
    }
}
