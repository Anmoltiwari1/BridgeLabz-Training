import java.util.*;
import java.util.stream.Collectors;

class Book {
    private String title;
    private String genre;
    private int pages;
    
    public Book(String title, String genre, int pages) {
        this.title = title;
        this.genre = genre;
        this.pages = pages;
    }
    
    public String getTitle() { return title; }
    public String getGenre() { return genre; }
    public int getPages() { return pages; }
    
    @Override
    public String toString() {
        return title + " (" + genre + "): " + pages + " pages";
    }
}

public class LibraryBookStatistics {
    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
            new Book("The Great Gatsby", "Fiction", 180),
            new Book("To Kill a Mockingbird", "Fiction", 324),
            new Book("1984", "Fiction", 328),
            new Book("A Brief History of Time", "Science", 256),
            new Book("The Selfish Gene", "Science", 360),
            new Book("Cosmos", "Science", 365),
            new Book("The Art of War", "Philosophy", 273),
            new Book("Meditations", "Philosophy", 254),
            new Book("The Republic", "Philosophy", 380)
        );
        
        Map<String, IntSummaryStatistics> statsByGenre = books.stream()
            .collect(Collectors.groupingBy(
                Book::getGenre,
                Collectors.summarizingInt(Book::getPages)
            ));
        
        System.out.println("Book statistics by genre:");
        statsByGenre.forEach((genre, stats) -> {
            System.out.println("\n" + genre + ":");
            System.out.println("  Total books: " + stats.getCount());
            System.out.println("  Total pages: " + stats.getSum());
            System.out.println("  Average pages: " + String.format("%.1f", stats.getAverage()));
            System.out.println("  Min pages: " + stats.getMin());
            System.out.println("  Max pages: " + stats.getMax());
        });
        
        IntSummaryStatistics overallStats = books.stream()
            .collect(Collectors.summarizingInt(Book::getPages));
        
        System.out.println("\nOverall library statistics:");
        System.out.println("Total books: " + overallStats.getCount());
        System.out.println("Total pages: " + overallStats.getSum());
        System.out.println("Average pages per book: " + String.format("%.1f", overallStats.getAverage()));
        System.out.println("Shortest book: " + overallStats.getMin() + " pages");
        System.out.println("Longest book: " + overallStats.getMax() + " pages");
    }
}