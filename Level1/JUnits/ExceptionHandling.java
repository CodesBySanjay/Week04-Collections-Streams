import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class ExceptionHandling {
    public int divide(int x, int y) {
        if (y == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return x / y;
    }

    @Test
    public void testDivideValid() {
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