package Book_Library_System;

public class Ebook extends Book{
    
    Ebook( long ISBN,String title,String author){
        super(ISBN, title, author);
    }

     public void showTitle() {
        System.out.println("Student name: " + title); // name is protected
    }
}
