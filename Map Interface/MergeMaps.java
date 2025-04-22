import java.util.HashMap;
import java.util.Map;

public class MergeMaps {
    public static void main(String[] args) {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);
        Map<String, Integer> map2 = new HashMap<>();
        map2.put("B", 3);
        map2.put("C", 4);
        Map<String, Integer> resultMap = new HashMap<>(map1);

        for (Map.Entry<String, Integer> pair : map2.entrySet()) {
            String currentKey = pair.getKey();
            int incomingValue = pair.getValue();

            resultMap.put(currentKey, resultMap.getOrDefault(currentKey, 0) + incomingValue);
        }

        System.out.println(resultMap);
    }
}
