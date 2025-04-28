import java.util.function.BiFunction;

public class BiFunctionInterface {
    public static String concatWithSpace(String a, String b) {
        BiFunction<String, String, String> join = (x, y) -> x + " " + y;
        return join.apply(a, b);
    }
}
