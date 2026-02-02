import java.util.*;

public class TransformingNamesForDisplay {
    public static void main(String[] args) {
        List<String> customerNames = Arrays.asList(
            "john doe",
            "alice smith",
            "bob johnson",
            "charlie brown",
            "diana prince",
            "eve adams",
            "frank miller",
            "grace kelly"
        );
        
        System.out.println("Original customer names:");
        customerNames.forEach(System.out::println);
        
        System.out.println("\nTransformed names (uppercase and sorted):");
        customerNames.stream()
            .map(String::toUpperCase)
            .sorted()
            .forEach(System.out::println);
        
        System.out.println("\nFormatted for display (Title Case):");
        customerNames.stream()
            .map(name -> Arrays.stream(name.split(" "))
                .map(word -> word.substring(0, 1).toUpperCase() + 
                           word.substring(1).toLowerCase())
                .reduce("", (a, b) -> a.isEmpty() ? b : a + " " + b))
            .sorted()
            .forEach(System.out::println);
        
        System.out.println("\nCustomer initials:");
        customerNames.stream()
            .map(name -> Arrays.stream(name.split(" "))
                .map(word -> word.substring(0, 1).toUpperCase())
                .reduce("", String::concat))
            .sorted()
            .forEach(initials -> System.out.println(initials));
    }
}