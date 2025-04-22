import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Reverse{
    static class Node{
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
        }

    }
    public static void reverseAL(List<Integer> arr){
        int i = 0;
        int j = arr.size()-1;
        while(i<j){
            Integer temp = arr.get(i);
            arr.set(i, arr.get(j));
            arr.set(j, temp);
            i++;
            j--;
        }
    }

    public static Node createNodeLink(List<Integer> list){
        if(list==null || list.isEmpty()) return null;
        Node head = new Node(list.get(0));
        Node current = head;
        for(int i=1;i<list.size();i++){
            Node node = new Node(list.get(i));
            current.next = node;
            node.prev = current;
            current = node;
        }
        return head;

    }

    public static Node reverseLL(Node head){
        Node current = head;
        Node previous = null;
        Node next = null;
        while(current!=null){
            next = current.next;
            current.next = previous;
            current.prev = next;
            previous = current;
            current = next;
        }
        return previous;
    }

    public static void main(String[] args){
        // ArrayList reversal
        List<Integer> list;
        list = new ArrayList<>(List.of(1,2,3,4,5));
        reverseAL(list);
        System.out.println("Reversed ArrayList : " + list.toString());

        // LinkedList reversal
        list = new LinkedList<>(List.of(6,7,8,9,10));
        Node head = createNodeLink(list);
        Node current = reverseLL(head);
        list = new LinkedList<>();
        while(current!=null){
            list.add(current.data);
            current = current.next;
        }
        System.out.println("Reversed LinkedList : " + list.toString());
    }
}