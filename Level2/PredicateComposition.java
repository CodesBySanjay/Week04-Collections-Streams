import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateComposition {
    public static List<String> filter(List<String> list, String sub) {
        Predicate<String> longStr = s -> s.length() > 5;
        Predicate<String> hasSub = s -> s.contains(sub);
        return list.stream()
            .filter(longStr.and(hasSub))
            .collect(Collectors.toList());
    }
}
