import java.util.LinkedList;

class MyHashMap {
    private class Node {
        int key, value;
        Node(int k, int v) { key = k; value = v; }
    }

    private final int SIZE = 1000;
    private LinkedList<Node>[] map;

    @SuppressWarnings("unchecked")
    public MyHashMap() {
        map = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) map[i] = new LinkedList<>();
    }

    private int hash(int key) {
        return key % SIZE;
    }

    public void put(int key, int value) {
        int h = hash(key);
        for (Node node : map[h]) {
            if (node.key == key) {
                node.value = value;
                return;
            }
        }
        map[h].add(new Node(key, value));
    }

    public int get(int key) {
        int h = hash(key);
        for (Node node : map[h]) if (node.key == key) return node.value;
        return -1; // not found
    }

    public void remove(int key) {
        int h = hash(key);
        map[h].removeIf(node -> node.key == key);
    }
}

public class CustomHashMap {
    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        map.put(1, 10);
        map.put(2, 20);
        System.out.println(map.get(1)); // 10
        map.remove(1);
        System.out.println(map.get(1)); // -1
    }
}
