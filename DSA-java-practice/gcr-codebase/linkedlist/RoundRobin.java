class Process {
    int pid, bt;
    Process next;

    Process(int pid, int bt) {
        this.pid = pid;
        this.bt = bt;
        this.next = this;
    }
}

public class RoundRobin {
    static Process head = null;

    static void add(int pid, int bt) {
        Process p = new Process(pid, bt);
        if (head == null) {
            head = p;
            return;
        }
        Process t = head;
        while (t.next != head) t = t.next;
        t.next = p;
        p.next = head;
    }

    static void execute(int tq) {
        Process curr = head;
        while (head != null) {
            if (curr.bt > tq) curr.bt -= tq;
            else {
                remove(curr.pid);
            }
            curr = curr.next;
        }
    }

    static void remove(int pid) {
        Process c = head, p = null;
        do {
            if (c.pid == pid) {
                if (p != null) p.next = c.next;
                if (c == head) head = c.next;
                return;
            }
            p = c;
            c = c.next;
        } while (c != head);
    }
}
