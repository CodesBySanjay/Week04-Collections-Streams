import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImageToByteArray {
    public static void main(String[] args) {
        try {
            FileInputStream fi = new FileInputStream("original.jpg");
            ByteArrayOutputStream bao = new ByteArrayOutputStream();
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fi.read(buffer)) != -1) {
                bao.write(buffer, 0, bytesRead);
            }
            fi.close();

            byte[] imageBytes = bao.toByteArray();

            ByteArrayInputStream bai = new ByteArrayInputStream(imageBytes);

            FileOutputStream fos = new FileOutputStream("copy.jpg");
            while ((bytesRead = bai.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
            fos.close();
            bai.close();
            bao.close();
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
