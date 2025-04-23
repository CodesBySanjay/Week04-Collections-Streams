import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipedCommunication {
    public static void main(String[] args) {
        PipedOutputStream pos = new PipedOutputStream();
        PipedInputStream pis = new PipedInputStream();
        try {
            pis.connect(pos);
        } catch (IOException e) {
            System.out.println("Error connecting pipes: " + e.getMessage());
            return;
        }

        Thread writer = new Thread(() -> {
            String data = "Hello from writer thread!";
            try {
                synchronized (pos) {
                    pos.write(data.getBytes());
                    pos.flush();
                }
            } catch (IOException e) {
                System.out.println("Writer thread IOException: " + e.getMessage());
            } finally {
                try {
                    pos.close();
                } catch (IOException e) {
                    System.out.println("Error closing PipedOutputStream: " + e.getMessage());
                }
            }
        });

        Thread reader = new Thread(() -> {
            try {
                int byteRead;
                synchronized (pis) {
                    while ((byteRead = pis.read()) != -1) {
                        System.out.print((char) byteRead);
                    }
                }
            } catch (IOException e) {
                System.out.println("Reader thread IOException: " + e.getMessage());
            } finally {
                try {
                    pis.close();
                } catch (IOException e) {
                    System.out.println("Error closing PipedInputStream: " + e.getMessage());
                }
            }
        });

        reader.start();
        writer.start();

        try {
            writer.join();
            reader.join();
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted: " + e.getMessage());
        }
    }
}
