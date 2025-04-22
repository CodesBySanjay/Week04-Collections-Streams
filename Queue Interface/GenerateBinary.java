import java.util.LinkedList;
import java.util.Queue;

public class GenerateBinary {
    public static void main(String[] args) {
        int n = 5;
        generateBinaryNumbers(n);
    }

    public static void generateBinaryNumbers(int count) {
        Queue<String> binaryQueue = new LinkedList<>();
        binaryQueue.add("1");
        for (int i = 0; i < count; i++) {
            String current = binaryQueue.remove();
            System.out.print(current + " ");
            binaryQueue.add(current + "0");
            binaryQueue.add(current + "1");
        }
    }
}
