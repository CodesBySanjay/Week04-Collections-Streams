import java.util.ArrayList;
import java.util.List;

class Filter{
    public static void main(String[] args){
        List<Integer> list = List.of(3,1,2,2,3,4);
        List<Integer> unique = new ArrayList<>();
        for(int i : list){
            if(!unique.contains(i)) unique.add(i);
        }
        System.out.println("Unique List : "+unique.toString());
    }
}