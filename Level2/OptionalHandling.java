import java.util.List;
import java.util.Optional;

public class OptionalHandling {
    public static Optional<Integer> findMax(List<Integer> nums) {
        return nums.stream().max(Integer::compareTo);
    }
}
