interface Adder {
    int add(int a, int b);
}

public class FunctionalInterfaceImplementation {
    public static void main(String[] args) {
        Adder sum = (a, b) -> a + b;
        System.out.println(sum.add(10, 20));
    }
}
