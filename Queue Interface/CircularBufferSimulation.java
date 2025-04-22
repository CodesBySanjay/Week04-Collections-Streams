public class CircularBufferSimulation {
    private int[] buffer;
    private int head = 0;
    private int size = 0;

    public CircularBufferSimulation(int capacity) {
        buffer = new int[capacity];
    }

    public void insert(int value) {
        buffer[(head + size) % buffer.length] = value;
        if (size < buffer.length) {
            size++;
        } else {
            head = (head + 1) % buffer.length;
        }
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(buffer[(head + i) % buffer.length] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularBufferSimulation cb = new CircularBufferSimulation(3);
        cb.insert(1);
        cb.insert(2);
        cb.insert(3);
        cb.display();
        cb.insert(4);
        cb.display();
    }
}
