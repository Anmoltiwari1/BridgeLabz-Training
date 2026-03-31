import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class LoggingTransactions {
    public static void main(String[] args) {
        List<String> transactionIds = Arrays.asList(
            "TXN001",
            "TXN002", 
            "TXN003",
            "TXN004",
            "TXN005",
            "TXN006",
            "TXN007",
            "TXN008"
        );
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        
        System.out.println("=== Transaction Logging ===");
        
        transactionIds.forEach(id -> 
            System.out.println(LocalDateTime.now().format(formatter) + " - Transaction: " + id));
        
        System.out.println("\n=== Detailed Transaction Logging ===");
        transactionIds.forEach(id -> {
            LocalDateTime timestamp = LocalDateTime.now();
            System.out.println(String.format("[%s] Processing transaction %s - Status: INITIATED", 
                timestamp.format(formatter), id));
            
            // Simulate processing time
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            
            System.out.println(String.format("[%s] Transaction %s - Status: COMPLETED", 
                LocalDateTime.now().format(formatter), id));
        });
        
        System.out.println("\n=== High Priority Transactions ===");
        transactionIds.stream()
            .filter(id -> id.endsWith("1") || id.endsWith("5"))
            .forEach(id -> 
                System.out.println("🔴 HIGH PRIORITY: " + 
                    LocalDateTime.now().format(formatter) + " - Transaction: " + id));
        
        System.out.println("\n=== Transaction Summary ===");
        transactionIds.forEach(id -> 
            System.out.println("📊 Logged transaction: " + id + " at " + 
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"))));
        
        System.out.println("\nTotal transactions logged: " + transactionIds.size());
    }
}