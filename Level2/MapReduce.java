import java.util.List;

public class MapReduce {
    public static int sumOfEvenSquares(List<Integer> nums) {
        return nums.stream()
            .filter(n -> n % 2 == 0)
            .map(n -> n * n)
            .reduce(0, Integer::sum);
    }
}
