class State {
    String text;
    State prev, next;
    State(String t) { text = t; }
}

public class UndoRedo {
    static State current = null;
    static int size = 0, LIMIT = 10;

    static void add(String text) {
        State s = new State(text);
        if (current != null) {
            current.next = s;
            s.prev = current;
        }
        current = s;
        size++;
    }

    static void undo() {
        if (current != null && current.prev != null)
            current = current.prev;
    }

    static void redo() {
        if (current != null && current.next != null)
            current = current.next;
    }
}
