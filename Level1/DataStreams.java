import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStreams {
    public static void main(String[] args) {
        try {
            DataOutputStream dos = new DataOutputStream(new FileOutputStream("studentData.dat"));
            int rollNumber = 101;
            String name = "John Doe";
            double gpa = 3.75;

            dos.writeInt(rollNumber);
            dos.writeUTF(name);
            dos.writeDouble(gpa);
            dos.close();

            DataInputStream dis = new DataInputStream(new FileInputStream("studentData.dat"));
            int readRollNumber = dis.readInt();
            String readName = dis.readUTF();
            double readGpa = dis.readDouble();
            dis.close();

            System.out.println("Roll Number: " + readRollNumber);
            System.out.println("Name: " + readName);
            System.out.println("GPA: " + readGpa);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
