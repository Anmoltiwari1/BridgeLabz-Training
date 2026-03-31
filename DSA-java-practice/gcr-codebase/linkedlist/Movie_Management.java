import java.util.Scanner;

class Node {
    String movieTitle;
    String director;
    int year;
    double rating;
    Node next;
    Node prev;

    Node(String movieTitle, String director, int year, double rating) {
        this.movieTitle = movieTitle;
        this.director = director;
        this.year = year;
        this.rating = rating;
    }
}

public class Movie_Management {

    static Node head = null;
    static Node tail = null;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n----- Movie Management Menu -----");
            System.out.println("1. Add movie at beginning");
            System.out.println("2. Add movie at end");
            System.out.println("3. Delete movie by title");
            System.out.println("4. Search movie by director & rating");
            System.out.println("5. Display all movies");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    addMovie(sc, true);
                    break;

                case 2:
                    addMovie(sc, false);
                    break;

                case 3:
                    System.out.print("Enter movie title to delete: ");
                    delete(sc.nextLine());
                    break;

                case 4:
                    System.out.print("Enter director name: ");
                    String dir = sc.nextLine();
                    System.out.print("Enter minimum rating: ");
                    double rating = sc.nextDouble();
                    System.out.println(search(dir, rating)
                            ? "Movie found"
                            : "Movie not found");
                    break;

                case 5:
                    display();
                    break;

                case 6:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    // Helper to read movie data
    static void addMovie(Scanner sc, boolean atBegin) {
        System.out.print("Enter movie title: ");
        String title = sc.nextLine();
        System.out.print("Enter director: ");
        String director = sc.nextLine();
        System.out.print("Enter year: ");
        int year = sc.nextInt();
        System.out.print("Enter rating: ");
        double rating = sc.nextDouble();
        sc.nextLine();

        if (atBegin)
            addAtBegin(title, director, year, rating);
        else
            addAtEnd(title, director, year, rating);
    }

    static void addAtBegin(String mt, String dir, int year, double rating) {
        Node newNode = new Node(mt, dir, year, rating);

        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    static void addAtEnd(String mt, String dir, int year, double rating) {
        Node newNode = new Node(mt, dir, year, rating);

        if (head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    static void delete(String movieTitle) {
        Node temp = head;

        while (temp != null) {
            if (temp.movieTitle.equalsIgnoreCase(movieTitle)) {

                if (temp == head)
                    head = temp.next;
                if (temp == tail)
                    tail = temp.prev;

                if (temp.prev != null)
                    temp.prev.next = temp.next;
                if (temp.next != null)
                    temp.next.prev = temp.prev;

                System.out.println("Movie deleted");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found");
    }

    static boolean search(String director, double rating) {
        Node temp = head;

        while (temp != null) {
            if (temp.director.equalsIgnoreCase(director)
                    && temp.rating >= rating)
                return true;
            temp = temp.next;
        }
        return false;
    }

    static void display() {
        if (head == null) {
            System.out.println("No movies to display");
            return;
        }

        System.out.println("\nForward Display:");
        Node temp = head;
        while (temp != null) {
            printMovie(temp);
            temp = temp.next;
        }

        System.out.println("\nBackward Display:");
        temp = tail;
        while (temp != null) {
            printMovie(temp);
            temp = temp.prev;
        }
    }

    static void printMovie(Node n) {
        System.out.println(
                "Title: " + n.movieTitle +
                ", Director: " + n.director +
                ", Year: " + n.year +
                ", Rating: " + n.rating
        );
    }
}
