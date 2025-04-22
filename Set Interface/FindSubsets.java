import java.util.HashSet;
import java.util.Set;

public class FindSubsets {
    public static void main(String[] args) {
        Set<Integer> smallerGroup = new HashSet<>(Set.of(2, 3));
        Set<Integer> largerGroup = new HashSet<>(Set.of(1, 2, 3, 4));
        System.out.println(largerGroup.containsAll(smallerGroup));
    }
}
