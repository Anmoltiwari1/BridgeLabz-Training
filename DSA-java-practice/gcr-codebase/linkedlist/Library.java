class Book {
    int id;
    String title, author, genre;
    boolean available;
    Book next, prev;

    Book(int id, String t, String a, String g) {
        this.id = id;
        title = t; author = a; genre = g;
        available = true;
    }
}

public class Library {
    static Book head = null, tail = null;

    static void add(Book b) {
        if (head == null) {
            head = tail = b;
            return;
        }
        tail.next = b;
        b.prev = tail;
        tail = b;
    }

    static void remove(int id) {
        Book t = head;
        while (t != null) {
            if (t.id == id) {
                if (t.prev != null) t.prev.next = t.next;
                if (t.next != null) t.next.prev = t.prev;
                if (t == head) head = t.next;
                if (t == tail) tail = t.prev;
                return;
            }
            t = t.next;
        }
    }

    static void displayForward() {
        for (Book b = head; b != null; b = b.next)
            System.out.println(b.title);
    }

    static void displayBackward() {
        for (Book b = tail; b != null; b = b.prev)
            System.out.println(b.title);
    }
}
