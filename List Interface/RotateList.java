import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Rotate{
    public static void main(String[] args){
        List<Integer> list;
        int n = 0;
        list = new ArrayList<>(List.of(10,20,30,40,50));
        try(Scanner sc = new Scanner(System.in)){
            n = sc.nextInt();
        }
        if(n>list.size()) n = n%list.size();
        List<Integer> l1 = list.subList(0, n);
        List<Integer> l2 = list.subList(n, list.size());
        System.out.println("Original list : "+list.toString());
        list = new ArrayList<>();
        list.addAll(l2);
        list.addAll(l1);
        System.out.println("Rotated list : "+list.toString());
    }
}