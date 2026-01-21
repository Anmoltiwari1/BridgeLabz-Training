class Item {
    int id, qty;
    String name;
    double price;
    Item next;

    Item(int id, String name, int qty, double price) {
        this.id = id;
        this.name = name;
        this.qty = qty;
        this.price = price;
    }
}

public class Inventory {
    static Item head = null;

    static void add(Item n) {
        n.next = head;
        head = n;
    }

    static void remove(int id) {
        Item t = head, p = null;
        while (t != null) {
            if (t.id == id) {
                if (p == null) head = t.next;
                else p.next = t.next;
                return;
            }
            p = t;
            t = t.next;
        }
    }

    static void updateQty(int id, int q) {
        Item t = head;
        while (t != null) {
            if (t.id == id) {
                t.qty = q;
                return;
            }
            t = t.next;
        }
    }

    static double totalValue() {
        double sum = 0;
        Item t = head;
        while (t != null) {
            sum += t.qty * t.price;
            t = t.next;
        }
        return sum;
    }
}
