import java.util.*;

class Flight {
    String flightId, from, to;
    double price;
    int seats;
    
    Flight(String flightId, String from, String to, double price, int seats) {
        this.flightId = flightId;
        this.from = from;
        this.to = to;
        this.price = price;
        this.seats = seats;
    }
    
    public String toString() {
        return flightId + ": " + from + " -> " + to + " ($" + price + ", " + seats + " seats)";
    }
}

class Booking {
    String bookingId, passengerName, flightId;
    
    Booking(String bookingId, String passengerName, String flightId) {
        this.bookingId = bookingId;
        this.passengerName = passengerName;
        this.flightId = flightId;
    }
    
    public String toString() {
        return "Booking " + bookingId + ": " + passengerName + " on flight " + flightId;
    }
}

public class FlightBookingSystem {
    Flight[] flights;
    List<Booking> bookings = new ArrayList<>();
    int bookingCounter = 1;
    
    FlightBookingSystem() {
        // Initialize flight data using array
        flights = new Flight[] {
            new Flight("AI101", "Delhi", "Mumbai", 5500.0, 50),
            new Flight("SG202", "Mumbai", "Bangalore", 4200.0, 30),
            new Flight("UK303", "Delhi", "Kolkata", 6800.0, 40),
            new Flight("AI404", "Chennai", "Delhi", 7200.0, 25),
            new Flight("SG505", "Bangalore", "Hyderabad", 3500.0, 35)
        };
    }
    
    // Case-insensitive flight search
    void searchFlights(String from, String to) {
        System.out.println("\nSearching flights from " + from + " to " + to + ":");
        boolean found = false;
        
        for (Flight flight : flights) {
            if (flight.from.toLowerCase().contains(from.toLowerCase()) && 
                flight.to.toLowerCase().contains(to.toLowerCase()) && 
                flight.seats > 0) {
                System.out.println(flight);
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("No flights found.");
        }
    }
    
    // Book a flight
    boolean bookFlight(String flightId, String passengerName) {
        for (Flight flight : flights) {
            if (flight.flightId.equalsIgnoreCase(flightId)) {
                if (flight.seats > 0) {
                    flight.seats--;
                    String bookingId = "BK" + String.format("%03d", bookingCounter++);
                    bookings.add(new Booking(bookingId, passengerName, flightId));
                    System.out.println("Booking successful! Booking ID: " + bookingId);
                    return true;
                } else {
                    System.out.println("No seats available on flight " + flightId);
                    return false;
                }
            }
        }
        System.out.println("Flight " + flightId + " not found.");
        return false;
    }
    
    // Display all bookings
    void displayBookings() {
        System.out.println("\n=== All Bookings ===");
        if (bookings.isEmpty()) {
            System.out.println("No bookings found.");
        } else {
            for (Booking booking : bookings) {
                System.out.println(booking);
            }
        }
    }
    
    // Display available flights
    void displayFlights() {
        System.out.println("\n=== Available Flights ===");
        for (Flight flight : flights) {
            if (flight.seats > 0) {
                System.out.println(flight);
            }
        }
    }
    
    public static void main(String[] args) {
        FlightBookingSystem system = new FlightBookingSystem();
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n=== Flight Booking System ===");
            System.out.println("1. View Flights");
            System.out.println("2. Search Flights");
            System.out.println("3. Book Flight");
            System.out.println("4. View Bookings");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline
            
            switch (choice) {
                case 1:
                    system.displayFlights();
                    break;
                    
                case 2:
                    System.out.print("From: ");
                    String from = sc.nextLine();
                    System.out.print("To: ");
                    String to = sc.nextLine();
                    system.searchFlights(from, to);
                    break;
                    
                case 3:
                    System.out.print("Flight ID: ");
                    String flightId = sc.nextLine();
                    System.out.print("Passenger Name: ");
                    String name = sc.nextLine();
                    system.bookFlight(flightId, name);
                    break;
                    
                case 4:
                    system.displayBookings();
                    break;
                    
                case 5:
                    System.out.println("Thank you for using Flight Booking System!");
                    sc.close();
                    return;
                    
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}