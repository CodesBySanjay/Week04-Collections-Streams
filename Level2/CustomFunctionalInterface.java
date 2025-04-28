@FunctionalInterface
interface Square {
    int calc(int n);

    default void show(int n) {
        System.out.println("Square is: " + calc(n));
    }
}

public class CustomFunctionalInterface {
    public static void main(String[] args) {
        Square s = x -> x * x;
        s.show(6);
    }
}
