class Ticket {
    int id;
    String customer, movie, seat;
    Ticket next;

    Ticket(int id, String c, String m, String s) {
        this.id = id;
        customer = c; movie = m; seat = s;
        next = this;
    }
}

public class TicketSystem {
    static Ticket head = null;

    static void add(Ticket t) {
        if (head == null) {
            head = t;
            return;
        }
        Ticket x = head;
        while (x.next != head) x = x.next;
        x.next = t;
        t.next = head;
    }

    static int count() {
        if (head == null) return 0;
        int c = 0;
        Ticket t = head;
        do {
            c++;
            t = t.next;
        } while (t != head);
        return c;
    }
}
