package review.LibraryManage;
import java.util.*;
import java.time.*;

class BookNotAvailableException extends Exception {
    BookNotAvailableException(String message) {
        super(message);
    }
}

interface FineCalculator {
    double calculateFine(int daysLate);
}


abstract class User {
    String id, name, email;
    
    User(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}


class Member extends User implements FineCalculator {
    String memberType;
    ArrayList<String> borrowedBooks = new ArrayList<>();
    
    Member(String id, String name, String email, String memberType) {
        super(id, name, email);
        this.memberType = memberType;
    }
    
    
    public double calculateFine(int daysLate) {
        if (memberType.equals("Student")) {
            return daysLate * 2.0; 
        } else if (memberType.equals("Staff")) {
            return daysLate * 1.0;
        }
        return daysLate * 3.0; 
    }
    
    public String toString() {
        return id + " - " + name + " (" + memberType + ")";
    }
}


class Book {
    String bookId, title, author;
    boolean isAvailable = true;
    String borrowedBy;
    LocalDate issueDate, dueDate;
    
    Book(String bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }
    
    public String toString() {
        return bookId + " - " + title + " by " + author + (isAvailable ? " (Available)" : " (Issued)");
    }
}


class Transaction {
    String transactionId, memberId, bookId;
    LocalDate issueDate;
    
    Transaction(String transactionId, String memberId, String bookId, LocalDate issueDate) {
        this.transactionId = transactionId;
        this.memberId = memberId;
        this.bookId = bookId;
        this.issueDate = issueDate;
    }
    
    public String toString() {
        return transactionId + ": " + memberId + " borrowed " + bookId + " on " + issueDate;
    }
}

public class LibraryManagementSystem {
   
    HashMap<String, Book> books = new HashMap<>();
    HashMap<String, Member> members = new HashMap<>();
    ArrayList<Transaction> transactions = new ArrayList<>();
    Queue<String> waitingList = new LinkedList<>(); 
    int transactionCounter = 1;
    
   
    void addBook(String bookId, String title, String author) {
        books.put(bookId, new Book(bookId, title, author));
        System.out.println("Book added: " + title);
    }
    
    
    void registerMember(String memberId, String name, String email, String memberType) {
        members.put(memberId, new Member(memberId, name, email, memberType));
        System.out.println("Member registered: " + name);
    }
    
    void issueBook(String memberId, String bookId) throws BookNotAvailableException {
        Book book = books.get(bookId);
        Member member = members.get(memberId);
        
        
        if (book == null) {
            throw new BookNotAvailableException("Book not found: " + bookId);
        }
        if (member == null) {
            throw new BookNotAvailableException("Member not found: " + memberId);
        }
        
       
        if (!book.isAvailable) {
            waitingList.add(memberId + ":" + bookId);
            throw new BookNotAvailableException("Book not available.");
        }
        
      
        book.isAvailable = false;
        book.borrowedBy = memberId;
        book.issueDate = LocalDate.now();
        book.dueDate = LocalDate.now().plusDays(10); 
        
        member.borrowedBooks.add(bookId);
        
       
        String transactionId = "T" + transactionCounter++;
        transactions.add(new Transaction(transactionId, memberId, bookId, LocalDate.now()));
        
        System.out.println("Book issued: " + book.title + " to " + member.name);
    }
    
   
    void returnBook(String memberId, String bookId) {
        Book book = books.get(bookId);
        Member member = members.get(memberId);
        
        if (book == null || member == null) {
            System.out.println("Invalid book or member ID");
            return;
        }
        
        if (book.isAvailable) {
            System.out.println("Book was not issued");
            return;
        }
        
      
        LocalDate returnDate = LocalDate.now();
        if (returnDate.isAfter(book.dueDate)) {
            int daysLate = (int) book.dueDate.until(returnDate).getDays();
            double fine = member.calculateFine(daysLate);
            System.out.println("Late return! Fine: Rs" + fine + " (" + daysLate + " days late)");
        }
        
        
        book.isAvailable = true;
        book.borrowedBy = null;
        member.borrowedBooks.remove(bookId);
        
        System.out.println("Book returned: " + book.title);
        
        
        checkWaitingList(bookId);
    }
    
   
    void checkWaitingList(String bookId) {
        Iterator<String> iterator = waitingList.iterator();
        while (iterator.hasNext()) {
            String request = iterator.next();
            if (request.endsWith(":" + bookId)) {
                String memberId = request.split(":")[0];
                iterator.remove();
                System.out.println("Notifying member " + memberId + " that book " + bookId + " is available");
                break;
            }
        }
    }
    
   
    void showBooks() {
        System.out.println("All Books ");
        for (Book book : books.values()) {
            System.out.println(book);
        }
    }
    
    
    void showMembers() {
        System.out.println("All Members ");
        for (Member member : members.values()) {
            System.out.println(member + " - Books borrowed: " + member.borrowedBooks.size());
        }
    }
    
    
    void showTransactions() {
        System.out.println(" All Transactions ");
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }
    
    
    void showWaitingList() {
        System.out.println(" Waiting List ");
        if (waitingList.isEmpty()) {
            System.out.println("No one waiting");
        } else {
            for (String request : waitingList) {
                System.out.println(request);
            }
        }
    }
    
    public static void main(String[] args) {
        LibraryManagementSystem library = new LibraryManagementSystem();
        
        
        library.addBook("B001", "Java Basics", "J.S");
        library.addBook("B002", "Python Guide", "John");
        library.addBook("B003", "Web Development", "William");
        
        
        library.registerMember("001", "Anmol Tiwari", "Anmol@email.com", "Student");
        library.registerMember("002", "Amit Agrawal", "Amit@email.com", "Staff");
        library.registerMember("003", "Shivam Dubey", "Shivam@email.com", "Student");
        
        try {
           
            library.issueBook("001", "B001");
            library.issueBook("002", "B002");
            library.issueBook("003", "B003"); 
            
            library.showBooks();
            library.showMembers();
            library.showWaitingList();
            
            
            library.returnBook("001", "B001");
            
            library.showBooks();
            library.showWaitingList();
            library.showTransactions();
            
        } catch (BookNotAvailableException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}