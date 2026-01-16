abstract class Product{
	private int productId;
	private String name; 
	private int price;
	
	Product(int productId, String name, int price){
		this.productId = productId;
		this.name = name;
		this.price = price;
	}
	
	void SetID(int productId) {
		this.productId = productId;
	}
	
	int GetID() {
		return productId;
	}
	
	void SetN(String name) {
		this.name = name;
	}
	
	String GetN() {
		return name;
	}
	
	void SetP(int price) {
		this.price = price;
	}
	
	int GetP() {
		return price;
	}
	
	abstract double calculateDiscount();
}

interface Taxable{
	void calculateTax();
	double getTaxDetails();
}

class Electronics extends Product implements Taxable{
	double discount;
	double tax;
	double f;
	
	Electronics(int productId, String name, int price, double discount){
		super(productId, name, price);
		this.discount = discount;
	}
	
	public double calculateDiscount() {
		double d = GetP() * (discount/100);
		return d;
	}
	
	public void calculateTax() {
		double t = (GetP() * 0.18);
		this.tax = t;
	}
	
	public double getTaxDetails() {
		return tax;
	}
	
	public void Final() {
		f = GetP() + getTaxDetails() - calculateDiscount();
		System.out.println("The Final Price is: " + f);
	}
	
	void Display() {
		System.out.println("Product ID: " + GetID() + " | Name: " + GetN() + " | Price: " + GetP() + " | Discount (%): " + discount + " | Tax: " + getTaxDetails());
	}
}

class Clothing extends Product implements Taxable{ 
	double discount;
	double tax;
	double f;
	
	Clothing(int productId, String name, int price, double discount){
		super(productId, name, price);
		this.discount = discount;
	}
	
	public double calculateDiscount() {
		double d = GetP() * (discount/100);
		return d;
	}
	
	public void calculateTax() {
		double t = (GetP() * 0.18);
		this.tax = t;
	}
	
	public double getTaxDetails() {
		return tax;
	}
	
	public void Final() {
		f = GetP() + getTaxDetails() - calculateDiscount();
		System.out.println("The Final Price is: " + f);
	}
	
	void Display() {
		System.out.println("Product ID: " + GetID() + " | Name: " + GetN() + " | Price: " + GetP() + " | Discount (%): " + discount + " | Tax: " + getTaxDetails());
	}
}

class Groceries extends Product implements Taxable{
	double discount;
	double tax;
	double f;
	
	Groceries(int productId, String name, int price, double discount){
		super(productId, name, price);
		this.discount = discount;
	}
	
	public double calculateDiscount() {
		double d = GetP() * (discount/100);
		return d;
	}
	
	public void calculateTax() {
		double t = (GetP() * 0.18);
		this.tax = t;
	}
	
	public double getTaxDetails() {
		return tax;
	}
	
	public void Final() {
		f = GetP() + getTaxDetails() - calculateDiscount();
		System.out.println("The Final Price is: " + f);
	}
	
	void Display() {
		System.out.println("Product ID: " + GetID() + " | Name: " + GetN() + " | Price: " + GetP() + " | Discount (%): " + discount + " | Tax: " + getTaxDetails());
	}
}

public class ECommercePlatform {
	public static void main(String[] args) {
		Electronics e = new Electronics(101, "Smartphone", 50000, 10.0);
        Clothing c = new Clothing(202, "T-Shirt", 1500, 5.0);
        Groceries g = new Groceries(303, "Rice Bag", 1000, 2.5);
        e.calculateTax();
        e.Display();
        e.Final();
        c.calculateTax();
        c.Display();
        c.Final();
        g.calculateTax();
        g.Display();
        g.Final();
	}
}
