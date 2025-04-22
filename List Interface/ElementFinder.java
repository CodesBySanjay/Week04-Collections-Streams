import java.util.LinkedList;
import java.util.ListIterator;

public class ElementFinder {
    public static void main(String[] args) {
        int n = 2;
        String[] elements = {"A", "B", "C", "D", "E"};
        LinkedList<String> list = new LinkedList<>();
        for (String e : elements) {
            list.add(e);
        }
        int posStart = list.size() - n;
        ListIterator<String> iterator = list.listIterator();
        for (int i = 0; i < posStart; i++) {
            iterator.next();
        }
        System.out.println(iterator.next());
    }
}
