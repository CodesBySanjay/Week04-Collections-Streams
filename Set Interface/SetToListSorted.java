import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetToListSorted {
    public static void main(String[] args) {
        Set<Integer> numberPool = new HashSet<>(Arrays.asList(5, 3, 9, 1));
        List<Integer> sortedNumbers = new ArrayList<>(numberPool);
        Collections.sort(sortedNumbers);
        System.out.println(sortedNumbers);
    }
}
