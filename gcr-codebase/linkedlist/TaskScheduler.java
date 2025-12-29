class TaskNode {
    int id;
    String name;
    int priority;
    String dueDate;
    TaskNode next;

    TaskNode(int id, String name, int priority, String dueDate) {
        this.id = id;
        this.name = name;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = this;
    }
}

public class TaskScheduler {
    static TaskNode head = null;
    static TaskNode current = null;

    static void addAtEnd(int id, String name, int p, String date) {
        TaskNode n = new TaskNode(id, name, p, date);
        if (head == null) {
            head = current = n;
            return;
        }
        TaskNode temp = head;
        while (temp.next != head) temp = temp.next;
        temp.next = n;
        n.next = head;
    }

    static void remove(int id) {
        if (head == null) return;
        TaskNode curr = head, prev = null;
        do {
            if (curr.id == id) {
                if (prev != null) prev.next = curr.next;
                if (curr == head) head = curr.next;
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);
    }

    static void nextTask() {
        if (current != null) {
            System.out.println("Current Task: " + current.name);
            current = current.next;
        }
    }

    static void display() {
        if (head == null) return;
        TaskNode t = head;
        do {
            System.out.println(t.id + " " + t.name + " " + t.priority);
            t = t.next;
        } while (t != head);
    }
}
