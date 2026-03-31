import java.util.*;
import java.util.stream.Collectors;

class Order {
    private String customer;
    private double amount;
    
    public Order(String customer, double amount) {
        this.customer = customer;
        this.amount = amount;
    }
    
    public String getCustomer() { return customer; }
    public double getAmount() { return amount; }
    
    @Override
    public String toString() {
        return customer + ": $" + amount;
    }
}

public class OrderRevenueSummary {
    public static void main(String[] args) {
        List<Order> orders = Arrays.asList(
            new Order("Alice", 150.50),
            new Order("Bob", 200.75),
            new Order("Alice", 300.25),
            new Order("Charlie", 175.00),
            new Order("Bob", 125.50),
            new Order("Alice", 225.75)
        );
        
        Map<String, Double> revenueByCustomer = orders.stream()
            .collect(Collectors.groupingBy(
                Order::getCustomer,
                Collectors.summingDouble(Order::getAmount)
            ));
        
        System.out.println("Revenue summary by customer:");
        revenueByCustomer.entrySet().stream()
            .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
            .forEach(entry -> 
                System.out.printf("%s: $%.2f%n", entry.getKey(), entry.getValue()));
        
        double totalRevenue = orders.stream()
            .collect(Collectors.summingDouble(Order::getAmount));
        
        System.out.printf("\nTotal Revenue: $%.2f%n", totalRevenue);
    }
}