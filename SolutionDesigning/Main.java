import java.util.ArrayList;
import java.util.List;

interface Observer{
    void update(String message);
}

interface User extends Observer{

    void showRole();
}

interface Subject{

    void registerUser(Observer observer);
    void removeUser(Observer observer);
    void notifyUser(String message);
}

class Student implements User{

    private String name;

    Student(String name) {
        this.name=name;
    }


    @Override
    public void showRole(){
        System.out.println("Name is :"+name);
    }

    @Override
    public void update(String message){
        System.out.println("Message is:"+message);

   }
}

class Librarian implements User{

    private final String name;

    Librarian(String name) {
        this.name=name;
    }


    @Override
    public void showRole(){
        System.out.println("Name of Librarian :"+name);
    }

    @Override
    public void update(String message){
        System.out.println("Message is:"+message);

   }
}

class Faculty implements User{

    private final String name;

    Faculty(String name) {
        this.name=name;
    }


    @Override
    public void showRole(){
        System.out.println("Name of faculty :"+name);
    }

    @Override
    public void update(String message){
        System.out.println("Message is:"+message);

   }
}

class Book{

    private final String title;
    private final String author;
    private final String edition;
    private final String genre;

    private Book(Builder builder){
        this.title=builder.title;
        this.author=builder.author;
        this.edition=builder.edition;
        this.genre=builder.genre;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getEdition() { return edition; }
    public String getGenre() { return genre; }

    public static class Builder {
        private String title;
        private String author;
        private String edition;
        private String genre;

        public Builder(String title) {
            this.title = title;
        }

        public Builder setAuthor(String author) {
            this.author = author;
            return this;
        }

        public Builder setEdition(String edition) {
            this.edition = edition;
            return this;
        }

        public Builder setGenre(String genre) {
            this.genre = genre;
            return this;
        }

        public Book build() {
            return new Book(this);
        }
}
}


class LibraryCatalog implements Subject {

     private static LibraryCatalog instance; 

    private LibraryCatalog() {               
    }

    public static LibraryCatalog getInstance() {
        if (instance == null) {
            instance = new LibraryCatalog();
        }
        return instance;
    }


    List<Observer> o=new ArrayList<>();

    @Override
    public void registerUser(Observer observer){
        o.add(observer);
     }

    @Override 
    public void removeUser(Observer observer){
        o.remove(observer);
    }

    @Override
    public void notifyUser(String message){
        for(Observer observer:o){
            observer.update(message);
        }
    }

     private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        notifyUser("New book added: " + book.getTitle());
    }

    public List<Book> getBooks() {
        return books;
    }
}

class Main{
    public static void main(String[] args) {
        
        LibraryCatalog catalog=LibraryCatalog.getInstance();

        Student s1=new Student("Amit");
        Faculty f1=new Faculty("Abhay");
        Librarian l1=new Librarian("Seema");

        catalog.registerUser(s1);
        catalog.registerUser(f1);
        catalog.registerUser(l1);

        Book b1=new Book.Builder("Java")
                        .setAuthor("Selina")
                        .setEdition("1st")
                        .setGenre("prgramming")
                        .build();

        catalog.addBook(b1);

        s1.showRole();
        f1.showRole();
        l1.showRole();
    }
}
