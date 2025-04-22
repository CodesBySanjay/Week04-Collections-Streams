import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

class Frequency{
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of("apple", "banana", "apple", "orange"));
        Map<String, Integer> map = new LinkedHashMap<>();
        for(String element : list){
            map.merge(element, 1, Integer::sum);
        }
        System.out.println(map.toString());
    }
}