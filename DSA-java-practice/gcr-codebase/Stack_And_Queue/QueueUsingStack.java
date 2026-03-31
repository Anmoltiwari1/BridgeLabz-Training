import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class QueueUsingStack {

    static Node top1 = null; // Stack 1
    static Node top2 = null; // Stack 2

    // Stack push
    static void push1(int data) {
        Node n = new Node(data);
        n.next = top1;
        top1 = n;
    }

    static void push2(int data) {
        Node n = new Node(data);
        n.next = top2;
        top2 = n;
    }

    // Stack pop
    static int pop1() {
        if (top1 == null) return -1;
        int x = top1.data;
        top1 = top1.next;
        return x;
    }

    static int pop2() {
        if (top2 == null) return -1;
        int x = top2.data;
        top2 = top2.next;
        return x;
    }

    // Enqueue
    static void enqueue(int data) {
        push1(data);
        System.out.println("Enqueued: " + data);
    }

    // Dequeue
    static void dequeue() {
        if (top1 == null && top2 == null) {
            System.out.println("Queue is empty");
            return;
        }

        if (top2 == null) {
            while (top1 != null) {
                push2(pop1());
            }
        }

        System.out.println("Dequeued: " + pop2());
    }

    // Display queue
    static void display() {
        if (top1 == null && top2 == null) {
            System.out.println("Queue is empty");
            return;
        }

        System.out.print("Queue: ");

        // First print stack2 (front of queue)
        Node temp = top2;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        // Then print stack1 in reverse order
        printReverse(top1);
        System.out.println();
    }

    static void printReverse(Node node) {
        if (node == null) return;
        printReverse(node.next);
        System.out.print(node.data + " ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Display");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter data: ");
                    enqueue(sc.nextInt());
                    break;
                case 2:
                    dequeue();
                    break;
                case 3:
                    display();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 4);
    }
}
