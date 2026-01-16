public class Product{

    String productName;
    double price;
    static int totalProduct=0;


    //Paramterized Constructor
    Product(String productName,double price){
        this.productName=productName;
        this.price=price;
        totalProduct++;
    }

    //Method to display the Product Details
    public void displayProductDetails(){
        System.out.println("Name of the Product : "+productName);
        System.out.println("Price of the Product : "+price);
    }


    //Displays the total Product
    public static void displayTotalProducts(){
        System.out.println("Total number of product created : "+totalProduct);
    }
}