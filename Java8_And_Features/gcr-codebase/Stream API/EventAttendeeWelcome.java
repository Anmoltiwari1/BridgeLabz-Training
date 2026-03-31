import java.util.*;

class Attendee {
    private String name;
    private String email;
    private String ticketType;
    
    public Attendee(String name, String email, String ticketType) {
        this.name = name;
        this.email = email;
        this.ticketType = ticketType;
    }
    
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getTicketType() { return ticketType; }
}

public class EventAttendeeWelcome {
    public static void main(String[] args) {
        List<Attendee> attendees = Arrays.asList(
            new Attendee("Alice Johnson", "alice@email.com", "VIP"),
            new Attendee("Bob Smith", "bob@email.com", "Regular"),
            new Attendee("Charlie Brown", "charlie@email.com", "VIP"),
            new Attendee("Diana Prince", "diana@email.com", "Student"),
            new Attendee("Eve Adams", "eve@email.com", "Regular"),
            new Attendee("Frank Miller", "frank@email.com", "VIP"),
            new Attendee("Grace Kelly", "grace@email.com", "Student")
        );
        
        System.out.println("=== Welcome Messages for All Attendees ===");
        
        attendees.forEach(attendee -> {
            String welcomeMessage = generateWelcomeMessage(attendee);
            System.out.println(welcomeMessage);
        });
        
        System.out.println("\n=== VIP Attendee Special Welcome ===");
        attendees.stream()
            .filter(attendee -> "VIP".equals(attendee.getTicketType()))
            .forEach(attendee -> 
                System.out.println("🌟 SPECIAL VIP WELCOME: " + attendee.getName() + 
                    " - Thank you for choosing our premium experience!"));
        
        System.out.println("\n=== Student Discount Notification ===");
        attendees.stream()
            .filter(attendee -> "Student".equals(attendee.getTicketType()))
            .forEach(attendee -> 
                System.out.println("🎓 " + attendee.getName() + 
                    " - Don't forget to show your student ID for additional perks!"));
        
        System.out.println("\n=== Email List for Follow-up ===");
        attendees.forEach(attendee -> 
            System.out.println("📧 Sending follow-up to: " + attendee.getEmail()));
    }
    
    private static String generateWelcomeMessage(Attendee attendee) {
        String emoji = getTicketEmoji(attendee.getTicketType());
        return String.format("%s Welcome %s! Your %s ticket is confirmed. Email: %s", 
            emoji, attendee.getName(), attendee.getTicketType(), attendee.getEmail());
    }
    
    private static String getTicketEmoji(String ticketType) {
        switch (ticketType) {
            case "VIP": return "👑";
            case "Student": return "🎓";
            default: return "🎫";
        }
    }
}