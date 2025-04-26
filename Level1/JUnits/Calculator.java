import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class Calculator {
    public int add(int x, int y) {
        return x + y;
    }

    public int subtract(int x, int y) {
        return x - y;
    }

    public int multiply(int x, int y) {
        return x * y;
    }

    public int divide(int x, int y) {
        if (y == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return x / y;
    }

    @Test
    public void testAdd() {
        int val = add(5, 3);
        Assertions.assertEquals(8, val);
    }

    @Test
    public void testSubtract() {
        int val = subtract(9, 4);
        Assertions.assertEquals(5, val);
    }

    @Test
    public void testMultiply() {
        int val = multiply(6, 7);
        Assertions.assertEquals(42, val);
    }

    @Test
    public void testDivide() {
        int val = divide(10, 2);
        Assertions.assertEquals(5, val);
    }

    @Test
    public void testDivideByZero() {
        Assertions.assertThrows(ArithmeticException.class, () -> {
            divide(10, 0);
        });
    }
}
