import java.util.*;

class Product{
    String name;
    double price;
    double rating;
    double discount;

    Product(String name,double price,double rating,double discount){
        this.name=name;
        this.price=price;
        this.rating=rating;
        this.discount=discount;
    }
}

public class CustomSortingEcommerce {
    public static void main(String[] args){

        List<Product> product=new ArrayList<>();

        product.add(new Product("Iphone15", 78000, 8.4, 15));
        product.add(new Product("Samsung", 48000, 7.4, 7));
        product.add(new Product("Realme", 28000, 5.6, 9));

        product.sort((p1,p2)-> Double.compare(p1.price, p2.price));

        product.sort((r1, r2) -> Double.compare(r1.rating,r2.rating));

        product.sort((d1,d2)-> Double.compare(d1.discount, d2.discount));
    }
}
