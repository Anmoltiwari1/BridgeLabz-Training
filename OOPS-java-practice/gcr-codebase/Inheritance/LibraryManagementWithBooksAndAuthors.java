class Book{
	String title;
	int year;
	
	Book(String title, int year){
		this.title = title;
		this.year = year;
	}
	
	void Display() {
		System.out.print("Book Title: " + title + " | Publication Year: " + year);
	}
}

class Author extends Book{
	String name;
	String bio;
	
	Author(String title, int year, String name, String bio){
		super(title, year);
		this.name = name;
		this.bio = bio;
	}
	
	void Display() {
		super.Display();
		System.out.print(" | Author: " + name + " | Bio: " + bio);
	}
}

public class LibraryManagementWithBooksAndAuthors {
	public static void main(String[] args) {
		Book b = new Book("Harry Porter", 1980);
		Author a1 = new Author("Harry Porter", 1980, "JK Rowling", "J.K. Rowling is a British author best known for writing the globally successful Harry Potter fantasy series.");
		Author a2 = new Author("The Casual Vacancy", 2012, "JK Rowling", "British author of the Harry Potter series.");
		a1.Display();
		System.out.println();
		a2.Display();
	}
}
