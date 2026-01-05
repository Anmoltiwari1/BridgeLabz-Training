import java.util.*;

public class NthFromEnd {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>(Arrays.asList("A", "B", "C", "D", "E"));
        int n = 2;
        
        System.out.println("List: " + list);
        System.out.println("N=" + n + " from end: " + findNthFromEnd(list, n));
    }
    
    static String findNthFromEnd(LinkedList<String> list, int n) {
        if (n <= 0 || list.isEmpty()) return null;
        
        Iterator<String> fast = list.iterator();
        Iterator<String> slow = list.iterator();
        
        // Move fast pointer n steps ahead
        for (int i = 0; i < n && fast.hasNext(); i++) {
            fast.next();
        }
        
        // Move both pointers until fast reaches end
        while (fast.hasNext()) {
            fast.next();
            slow.next();
        }
        
        return slow.next();
    }
}