import java.util.HashSet;
import java.util.Set;

public class SymmetricDifference {
    public static void main(String[] args) {
        Set<Integer> firstSet = new HashSet<>();
        Set<Integer> secondSet = new HashSet<>();

        int[] inputA = {1, 2, 3};
        int[] inputB = {3, 4, 5};

        for (int num : inputA) {
            firstSet.add(num);
        }
        for (int num : inputB) {
            secondSet.add(num);
        }

        Set<Integer> symDiff = new HashSet<>(firstSet);
        symDiff.addAll(secondSet);

        Set<Integer> commonValues = new HashSet<>(firstSet);
        commonValues.retainAll(secondSet);

        symDiff.removeAll(commonValues);

        System.out.println(symDiff);
    }
}
