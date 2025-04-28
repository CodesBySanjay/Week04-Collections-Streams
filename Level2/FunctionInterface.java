import java.util.function.Function;

public class FunctionInterface {
    public static double computeArea(double radius) {
        Function<Double, Double> area = r -> Math.PI * r * r;
        return area.apply(radius);
    }
}
