abstract class FoodItem {
    private String itemName;
    private int price;
    private int quantity;

    FoodItem(String itemName, int price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getItemDetails() {
        return "Item: " + itemName + " | Price: " + price + " | Quantity: " + quantity;
    }

    public abstract double calculateTotalPrice();
}

class VegItem extends FoodItem implements Discountable {
    private final double discountRate = 0.1; 

    VegItem(String itemName, int price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }

    @Override
    public void applyDiscount() {
        double totalPrice = calculateTotalPrice();
        double discount = totalPrice * discountRate;
        System.out.println("Discount Applied: " + discount);
    }

    @Override
    public String getDiscountDetails() {
        return "Veg items get a 10% discount.";
    }
}

class NonVegItem extends FoodItem implements Discountable {
    private final double discountRate = 0.05; 

    NonVegItem(String itemName, int price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity() + 20; 
    }

    @Override
    public void applyDiscount() {
        double totalPrice = calculateTotalPrice();
        double discount = totalPrice * discountRate;
        System.out.println("Discount Applied: " + discount);
    }

    @Override
    public String getDiscountDetails() {
        return "Non-Veg items get a 5% discount.";
    }
}

interface Discountable {
    void applyDiscount();

    String getDiscountDetails();
}

class OrderProcessor {
    public static void processOrder(FoodItem foodItem) {
        System.out.println(foodItem.getItemDetails());
        System.out.println("Total Price: " + foodItem.calculateTotalPrice());
        if (foodItem instanceof Discountable) {
            Discountable discountable = (Discountable) foodItem;
            discountable.applyDiscount();
            System.out.println(discountable.getDiscountDetails());
        }
    }
}

public class OnlineFoodDeliverySystem {
    public static void main(String[] args) {
        FoodItem vegItem1 = new VegItem("Veg Pizza", 150, 2);
        FoodItem nonVegItem1 = new NonVegItem("Chicken Burger", 120, 3);

        System.out.println("Processing Veg Item Order:");
        OrderProcessor.processOrder(vegItem1);

        System.out.println("\nProcessing Non-Veg Item Order:");
        OrderProcessor.processOrder(nonVegItem1);
    }
}
