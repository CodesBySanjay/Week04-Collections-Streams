import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InvertMap {
    public static void main(String[] args) {
        Map<String, Integer> originalMap = new HashMap<>();
        originalMap.put("A", 1);
        originalMap.put("B", 2);
        originalMap.put("C", 1);

        Map<Integer, List<String>> invertedMap = new HashMap<>();

        for (Map.Entry<String, Integer> pair : originalMap.entrySet()) {
            String currentKey = pair.getKey();
            Integer currentValue = pair.getValue();

            if (!invertedMap.containsKey(currentValue)) {
                invertedMap.put(currentValue, new ArrayList<>());
            }
            invertedMap.get(currentValue).add(currentKey);
        }

        System.out.println(invertedMap);
    }
}
