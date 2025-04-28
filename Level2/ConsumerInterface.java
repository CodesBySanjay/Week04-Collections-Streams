import java.util.List;
import java.util.function.Consumer;

public class ConsumerInterface {
    public static void printUpper(List<String> list) {
        Consumer<String> upperPrinter = s -> System.out.println(s.toUpperCase());
        list.forEach(upperPrinter);
    }
}
