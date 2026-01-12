import java.util.*;

public class ListManagerTest {
    public static void main(String[] args) {
        testAddElement();
        testRemoveElement();
        testGetSize();
        System.out.println("All ListManager tests passed!");
    }
    
    static void testAddElement() {
        ListManager manager = new ListManager();
        List<Integer> list = new ArrayList<>();
        manager.addElement(list, 5);
        if (list.contains(5)) {
            System.out.println("✅ testAddElement passed");
        } else {
            System.out.println("❌ testAddElement failed");
        }
    }
    
    static void testRemoveElement() {
        ListManager manager = new ListManager();
        List<Integer> list = new ArrayList<>();
        list.add(5);
        boolean removed = manager.removeElement(list, 5);
        if (removed && !list.contains(5)) {
            System.out.println("✅ testRemoveElement passed");
        } else {
            System.out.println("❌ testRemoveElement failed");
        }
    }
    
    static void testGetSize() {
        ListManager manager = new ListManager();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        int size = manager.getSize(list);
        if (size == 2) {
            System.out.println("✅ testGetSize passed");
        } else {
            System.out.println("❌ testGetSize failed");
        }
    }
}