import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.Assertions;

public class ParametrizedTest {
    public boolean isEven(int n) {
        return n % 2 == 0;
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6})
    public void testEvenNumbers(int val) {
        Assertions.assertTrue(isEven(val));
    }

    @ParameterizedTest
    @ValueSource(ints = {7, 9})
    public void testOddNumbers(int val) {
        Assertions.assertFalse(isEven(val));
    }
}
