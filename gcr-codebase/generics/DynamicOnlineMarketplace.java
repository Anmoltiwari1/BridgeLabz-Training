interface Category{
    double minPrice();
    double maxPrice();
}

class BookCategory implements Category{
    public double minPrice(){
        return 100.0;
    }
    public double maxPrice(){
        return 1000.0;
    }
}

class ClothingCategory implements Category{
    public double minPrice(){
        return 2000.0;
    }

    public double maxPrice(){
        return 4000.0;
    }
}

class GadgetCategory implements Category {
    
    public double minPrice() {
         return 1000; 
        }
    public double maxPrice() { 
        return 100000; 
    }
}

class Product<T extends Category>{

    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName(){
        return name;

    }

    public double getPrice(){
        return price;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public T getCategory(){
        return category;
    }
}


public class DynamicOnlineMarketplace {
     public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double discountedPrice =
                product.getPrice() - (product.getPrice() * percentage / 100);
        product.setPrice(discountedPrice);
    }
}
