import java.util.HashSet;
import java.util.Set;

public class EqualityCheck {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        int[] arr1 = {1, 2, 3};
        int[] arr2 = {3, 2, 1};

        for (int num : arr1) {
            set1.add(num);
        }
        for (int num : arr2) {
            set2.add(num);
        }

        System.out.println(set1.equals(set2));
    }
}
