package com.example.Collectors;

import java.util.*;
import java.util.stream.*;

class Book {
    private String title;
    private String genre;
    private int pages;

    public Book(String title, String genre, int pages) {
        this.title = title;
        this.genre = genre;
        this.pages = pages;
    }

    public String getGenre() {
        return genre;
    }

    public int getPages() {
        return pages;
    }
}

public class BookStats {
    public static void main(String[] args) {
        List<Book> books = List.of(
            new Book("Java Basics", "Tech", 300),
            new Book("Spring Boot", "Tech", 450),
            new Book("Harry Potter", "Fiction", 500),
            new Book("Hobbit", "Fiction", 350)
        );

        Map<String, IntSummaryStatistics> statsByGenre =
            books.stream()
                 .collect(Collectors.groupingBy(
                     Book::getGenre,
                     Collectors.summarizingInt(Book::getPages)
                 ));

        System.out.println(statsByGenre);
    }
}
