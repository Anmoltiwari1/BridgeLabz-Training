import java.util.*;

public class EmailNotifications {
    
    public static void sendEmailNotification(String email) {
        System.out.println("📧 Sending notification to: " + email);
        // Simulate email sending delay
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("✅ Email sent successfully to: " + email);
    }
    
    public static void main(String[] args) {
        List<String> emails = Arrays.asList(
            "alice@company.com",
            "bob@company.com",
            "charlie@company.com",
            "diana@company.com",
            "eve@company.com",
            "frank@company.com",
            "grace@company.com"
        );
        
        System.out.println("=== Sending Email Notifications ===");
        
        emails.forEach(email -> sendEmailNotification(email));
        
        System.out.println("\n=== Priority Notifications (Company Emails) ===");
        emails.stream()
            .filter(email -> email.contains("@company.com"))
            .forEach(email -> {
                System.out.println("🔔 PRIORITY: Sending urgent notification to " + email);
                sendEmailNotification(email);
            });
        
        System.out.println("\n=== Bulk Email Summary ===");
        emails.forEach(email -> 
            System.out.println("📋 Queued for newsletter: " + email));
        
        System.out.println("\n=== Email Validation ===");
        emails.forEach(email -> {
            if (email.contains("@") && email.contains(".")) {
                System.out.println("✅ Valid email: " + email);
            } else {
                System.out.println("❌ Invalid email: " + email);
            }
        });
        
        System.out.println("\nTotal emails processed: " + emails.size());
    }
}