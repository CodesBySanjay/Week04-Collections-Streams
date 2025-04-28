import java.util.List;
import java.util.stream.Collectors;

public class FilteringList {
    public static List<String> filter(List<String> list) {
        return list.stream()
            .filter(s -> !s.startsWith("A"))
            .collect(Collectors.toList());
    }
}
