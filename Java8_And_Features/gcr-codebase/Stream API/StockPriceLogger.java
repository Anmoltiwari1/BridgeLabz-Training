import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

class Stock {
    private String symbol;
    private double price;
    private LocalDateTime timestamp;
    
    public Stock(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
        this.timestamp = LocalDateTime.now();
    }
    
    public String getSymbol() { return symbol; }
    public double getPrice() { return price; }
    public LocalDateTime getTimestamp() { return timestamp; }
    
    @Override
    public String toString() {
        return String.format("[%s] %s: $%.2f", 
            timestamp.format(DateTimeFormatter.ofPattern("HH:mm:ss")), 
            symbol, price);
    }
}

public class StockPriceLogger {
    public static void main(String[] args) {
        List<Stock> stockPrices = Arrays.asList(
            new Stock("AAPL", 175.50),
            new Stock("GOOGL", 2800.25),
            new Stock("MSFT", 330.75),
            new Stock("TSLA", 245.80),
            new Stock("AMZN", 3200.40),
            new Stock("META", 320.15),
            new Stock("NFLX", 450.90),
            new Stock("NVDA", 480.25)
        );
        
        System.out.println("=== Live Stock Price Feed ===");
        
        stockPrices.forEach(stock -> {
            System.out.println("📈 " + stock);
            try {
                Thread.sleep(500); // Simulate live feed delay
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        
        System.out.println("\n=== High-Value Stocks (>$400) ===");
        stockPrices.stream()
            .filter(stock -> stock.getPrice() > 400)
            .forEach(stock -> System.out.println("💰 " + stock));
        
        System.out.println("\n=== Price Alert Summary ===");
        stockPrices.forEach(stock -> {
            if (stock.getPrice() > 1000) {
                System.out.println("🔴 HIGH: " + stock.getSymbol() + " - $" + stock.getPrice());
            } else if (stock.getPrice() > 300) {
                System.out.println("🟡 MEDIUM: " + stock.getSymbol() + " - $" + stock.getPrice());
            } else {
                System.out.println("🟢 LOW: " + stock.getSymbol() + " - $" + stock.getPrice());
            }
        });
    }
}