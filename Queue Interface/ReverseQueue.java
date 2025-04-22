import java.util.LinkedList;
import java.util.Queue;

public class ReverseQueue {
    public static void main(String[] args) {
        Queue<Integer> numbers = new LinkedList<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        reverse(numbers);
        System.out.println(numbers);
    }

    public static void reverse(Queue<Integer> queue) {
        if (queue.isEmpty()) return;
        int front = queue.remove();
        reverse(queue);
        queue.add(front);
    }
}
