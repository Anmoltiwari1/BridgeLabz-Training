import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Author {
    String name();
}

@Author(name = "John Doe")
class Book {
    private String title = "Java Programming";
}

public class RetrieveAnnotations {
    public static void main(String[] args) {
        try {
            Class<?> clazz = Book.class;
            
            if (clazz.isAnnotationPresent(Author.class)) {
                Author author = clazz.getAnnotation(Author.class);
                System.out.println("Author: " + author.name());
            } else {
                System.out.println("No Author annotation found");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}