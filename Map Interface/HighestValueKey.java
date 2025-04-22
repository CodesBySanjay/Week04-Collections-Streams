import java.util.HashMap;
import java.util.Map;

public class HighestValueKey {
    public static void main(String[] args) {
        Map<String, Integer> scoresMap = new HashMap<>();
        scoresMap.put("A", 10);
        scoresMap.put("B", 20);
        scoresMap.put("C", 15);
        String topKey = "";
        int maxScore = Integer.MIN_VALUE;
        for (Map.Entry<String, Integer> entry : scoresMap.entrySet()) {
            String currentLabel = entry.getKey();
            int currentScore = entry.getValue();
            if (currentScore > maxScore) {
                maxScore = currentScore;
                topKey = currentLabel;
            }
        }
        System.out.println(topKey);
    }
}
