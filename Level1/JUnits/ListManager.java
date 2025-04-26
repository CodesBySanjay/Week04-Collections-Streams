import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.util.ArrayList;
import java.util.List;

public class ListManager {
    public void addElement(List<Integer> list, int element) {
        list.add(element);
    }

    public void removeElement(List<Integer> list, int element) {
        list.remove(Integer.valueOf(element));
    }

    public int getSize(List<Integer> list) {
        return list.size();
    }

    @Test
    public void testAddElement() {
        List<Integer> list = new ArrayList<>();
        addElement(list, 5);
        Assertions.assertTrue(list.contains(5));
    }

    @Test
    public void testRemoveElement() {
        List<Integer> list = new ArrayList<>();
        addElement(list, 5);
        removeElement(list, 5);
        Assertions.assertFalse(list.contains(5));
    }

    @Test
    public void testGetSize() {
        List<Integer> list = new ArrayList<>();
        addElement(list, 5);
        addElement(list, 10);
        int size = getSize(list);
        Assertions.assertEquals(2, size);
    }
}
