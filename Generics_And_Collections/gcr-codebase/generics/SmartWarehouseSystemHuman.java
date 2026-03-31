import java.util.*;

// Base class for warehouse items
abstract class WarehouseItem {
    String id, name;
    double price;
    
    WarehouseItem(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    
    String getId() { return id; }
    
    public String toString() {
        return name + " (ID: " + id + ", $" + price + ")";
    }
}

class Electronics extends WarehouseItem {
    String brand;
    
    Electronics(String id, String name, double price, String brand) {
        super(id, name, price);
        this.brand = brand;
    }
}

class Groceries extends WarehouseItem {
    String expiryDate;
    
    Groceries(String id, String name, double price, String expiryDate) {
        super(id, name, price);
        this.expiryDate = expiryDate;
    }
}

class Furniture extends WarehouseItem {
    String material;
    
    Furniture(String id, String name, double price, String material) {
        super(id, name, price);
        this.material = material;
    }
}

// Generic storage with bounded type
class Storage<T extends WarehouseItem> {
    List<T> items = new ArrayList<>();
    
    void add(T item) {
        items.add(item);
    }
    
    T find(String id) {
        for (T item : items) {
            if (item.getId().equals(id)) return item;
        }
        return null;
    }
    
    List<T> getAll() { return items; }
    int size() { return items.size(); }
}

public class SmartWarehouseSystem {
    Storage<Electronics> electronics = new Storage<>();
    Storage<Groceries> groceries = new Storage<>();
    Storage<Furniture> furniture = new Storage<>();
    
    void addElectronics(Electronics item) { electronics.add(item); }
    void addGroceries(Groceries item) { groceries.add(item); }
    void addFurniture(Furniture item) { furniture.add(item); }
    
    // Wildcard method - accepts any list of WarehouseItem subtypes
    void showItems(List<? extends WarehouseItem> items, String type) {
        System.out.println("\n" + type + " (" + items.size() + " items):");
        for (WarehouseItem item : items) {
            System.out.println("  " + item);
        }
    }
    
    void showInventory() {
        showItems(electronics.getAll(), "Electronics");
        showItems(groceries.getAll(), "Groceries");
        showItems(furniture.getAll(), "Furniture");
        
        int total = electronics.size() + groceries.size() + furniture.size();
        System.out.println("\nTotal warehouse items: " + total);
    }
    
    public static void main(String[] args) {
        SmartWarehouseSystem warehouse = new SmartWarehouseSystem();
        
        // Add some items
        warehouse.addElectronics(new Electronics("E001", "Laptop", 999.99, "Dell"));
        warehouse.addElectronics(new Electronics("E002", "Phone", 699.99, "Samsung"));
        
        warehouse.addGroceries(new Groceries("G001", "Milk", 3.99, "2024-01-15"));
        warehouse.addGroceries(new Groceries("G002", "Bread", 2.49, "2024-01-10"));
        
        warehouse.addFurniture(new Furniture("F001", "Chair", 199.99, "Leather"));
        warehouse.addFurniture(new Furniture("F002", "Desk", 299.99, "Wood"));
        
        warehouse.showInventory();
    }
}