import java.util.*;

class Product {
    String name;
    double price;
    int quantity;
    
    Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    
    public String toString() {
        return name + " - $" + price + " x" + quantity + " = $" + (price * quantity);
    }
}

public class ShoppingCart {
    HashMap<String, Double> productPrices = new HashMap<>();
    LinkedHashMap<String, Product> cartOrder = new LinkedHashMap<>();
    
    ShoppingCart() {
        // Initialize product prices
        productPrices.put("Laptop", 999.99);
        productPrices.put("Mouse", 25.50);
        productPrices.put("Keyboard", 75.00);
        productPrices.put("Monitor", 299.99);
        productPrices.put("Headphones", 150.00);
    }
    
    void addItem(String productName, int quantity) {
        if (productPrices.containsKey(productName)) {
            double price = productPrices.get(productName);
            if (cartOrder.containsKey(productName)) {
                Product existing = cartOrder.get(productName);
                existing.quantity += quantity;
            } else {
                cartOrder.put(productName, new Product(productName, price, quantity));
            }
            System.out.println("Added " + quantity + " " + productName + "(s) to cart");
        } else {
            System.out.println("Product " + productName + " not available");
        }
    }
    
    void displayCart() {
        System.out.println("\n=== Shopping Cart (Order Added) ===");
        double total = 0;
        for (Product product : cartOrder.values()) {
            System.out.println(product);
            total += product.price * product.quantity;
        }
        System.out.println("Total: $" + String.format("%.2f", total));
    }
    
    void displayCartSortedByPrice() {
        System.out.println("\n=== Cart Sorted by Price ===");
        TreeMap<Double, List<Product>> sortedByPrice = new TreeMap<>();
        
        for (Product product : cartOrder.values()) {
            sortedByPrice.computeIfAbsent(product.price, k -> new ArrayList<>()).add(product);
        }
        
        double total = 0;
        for (Map.Entry<Double, List<Product>> entry : sortedByPrice.entrySet()) {
            for (Product product : entry.getValue()) {
                System.out.println(product);
                total += product.price * product.quantity;
            }
        }
        System.out.println("Total: $" + String.format("%.2f", total));
    }
    
    void displayAvailableProducts() {
        System.out.println("\n=== Available Products ===");
        TreeMap<Double, String> sortedProducts = new TreeMap<>();
        for (Map.Entry<String, Double> entry : productPrices.entrySet()) {
            sortedProducts.put(entry.getValue(), entry.getKey());
        }
        
        for (Map.Entry<Double, String> entry : sortedProducts.entrySet()) {
            System.out.println(entry.getValue() + " - $" + entry.getKey());
        }
    }
    
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        
        cart.displayAvailableProducts();
        
        // Add items to cart
        cart.addItem("Laptop", 1);
        cart.addItem("Mouse", 2);
        cart.addItem("Keyboard", 1);
        cart.addItem("Mouse", 1); // Add more mice
        
        cart.displayCart();
        cart.displayCartSortedByPrice();
    }
}