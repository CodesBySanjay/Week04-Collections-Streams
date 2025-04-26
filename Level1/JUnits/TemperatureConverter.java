import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class TemperatureConverter {

    public double celsiusToFahrenheit(double c) {
        return (c * 9 / 5) + 32;
    }

    public double fahrenheitToCelsius(double f) {
        return (f - 32) * 5 / 9;
    }

    @Test
    public void testCelsiusToFahrenheit() {
        TemperatureConverter t = new TemperatureConverter();
        Assertions.assertEquals(98.6, t.celsiusToFahrenheit(37), 0.01);
    }

    @Test
    public void testFahrenheitToCelsius() {
        TemperatureConverter t = new TemperatureConverter();
        Assertions.assertEquals(37, t.fahrenheitToCelsius(98.6), 0.01);
    }
}
