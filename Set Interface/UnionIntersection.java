import java.util.HashSet;
import java.util.Set;

public class UnionIntersection {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        int[] arr1 = {1, 2, 3};
        int[] arr2 = {3, 4, 5};

        for (int num : arr1) {
            set1.add(num);
        }
        for (int num : arr2) {
            set2.add(num);
        }

        Set<Integer> union = new HashSet<>(set1);
        union.addAll(set2);

        Set<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);

        System.out.println("Union: " + union);
        System.out.println("Intersection: " + intersection);
    }
}
