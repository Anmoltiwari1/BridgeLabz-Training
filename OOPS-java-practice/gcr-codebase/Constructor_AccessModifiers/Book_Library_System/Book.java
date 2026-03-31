package Book_Library_System;
public class Book {
    
    public long ISBN;
    protected String title;
    private String author;

    Book(long ISBN,String title,String author){
        this.ISBN=ISBN;
        this.title=title;
        this.author=author;
    }

    public void setAuthor(String authorname){
        this.author=authorname;
    }

    public String getAuthor(){
        return author;
    }
}
