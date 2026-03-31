import java.util.Scanner;

class Node {
    int rollno;
    String name;
    int age;
    char grade;
    Node next;

    Node(int rollno, String name, int age, char grade) {
        this.rollno = rollno;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

public class StudentRecord {

    static Node head = null;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n----- Student Record Menu -----");
            System.out.println("1. Add record at beginning");
            System.out.println("2. Add record at end");
            System.out.println("3. Delete record by roll number");
            System.out.println("4. Search record by roll number");
            System.out.println("5. Display all records");
            System.out.println("6. Update grade by roll number");
            System.out.println("7. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addAtBeginning(sc);
                    break;
                case 2:
                    addAtEnd(sc);
                    break;
                case 3:
                    System.out.print("Enter roll number to delete: ");
                    delete(sc.nextInt());
                    break;
                case 4:
                    System.out.print("Enter roll number to search: ");
                    search(sc.nextInt());
                    break;
                case 5:
                    display();
                    break;
                case 6:
                    updateGrade(sc);
                    break;
                case 7:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    // Add at beginning
    static void addAtBeginning(Scanner sc) {
        System.out.print("Enter rollno, name, age, grade: ");
        int roll = sc.nextInt();
        String name = sc.next();
        int age = sc.nextInt();
        char grade = sc.next().charAt(0);

        Node newNode = new Node(roll, name, age, grade);
        newNode.next = head;
        head = newNode;
    }

    // Add at end
    static void addAtEnd(Scanner sc) {
        System.out.print("Enter rollno, name, age, grade: ");
        int roll = sc.nextInt();
        String name = sc.next();
        int age = sc.nextInt();
        char grade = sc.next().charAt(0);

        Node newNode = new Node(roll, name, age, grade);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Delete by roll number
    static void delete(int roll) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.rollno == roll) {
            head = head.next;
            System.out.println("Record deleted");
            return;
        }

        Node prev = head;
        Node curr = head.next;

        while (curr != null) {
            if (curr.rollno == roll) {
                prev.next = curr.next;
                System.out.println("Record deleted");
                return;
            }
            prev = curr;
            curr = curr.next;
        }

        System.out.println("Record not found");
    }

    // Search by roll number
    static void search(int roll) {
        Node temp = head;

        while (temp != null) {
            if (temp.rollno == roll) {
                System.out.println("Found: " + temp.name + ", Age: " + temp.age + ", Grade: " + temp.grade);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Record not found");
    }

    // Display all records
    static void display() {
        if (head == null) {
            System.out.println("No records");
            return;
        }

        Node temp = head;
        while (temp != null) {
            System.out.println("Roll: " + temp.rollno +
                    " Name: " + temp.name +
                    " Age: " + temp.age +
                    " Grade: " + temp.grade);
            temp = temp.next;
        }
    }

    // Update grade
    static void updateGrade(Scanner sc) {
        System.out.print("Enter roll number: ");
        int roll = sc.nextInt();
        System.out.print("Enter new grade: ");
        char newGrade = sc.next().charAt(0);

        Node temp = head;
        while (temp != null) {
            if (temp.rollno == roll) {
                temp.grade = newGrade;
                System.out.println("Grade updated");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Record not found");
    }
}
