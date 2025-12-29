import java.util.*;
class Book{
	String title;
	String author;
	
	Book(String title, String author){
		this.title = title;
		this.author = author;
	}
	
	void Display(){
		System.out.println("Title: " + title + " | Author: " + author);
	}
}

class Library{
	String name;
	ArrayList<Book> books = new ArrayList<>();
	
	Library(String name){
		this.name = name;
	}
	
	void Add(Book b){
		books.add(b);
	}
	
	void DisplayL() {
		System.out.println("Books " + name);
		for(int i = 0; i < books.size(); i++) {
			Book b = books.get(i);
			b.Display();
		}
	}
}
public class LibraryAndBooks {
	public static void main(String[] args) {
		Book b1 = new Book("1984", "Orwell");
	    Book b2 = new Book("Sapiens", "Harari");
	    Library l1 = new Library("City Library");
	    Library l2 = new Library("School Library");
	    l1.Add(b1);
	    l1.Add(b2);
	    l1.DisplayL();
	    l2.Add(b2);
	    l2.DisplayL();
	}
}
