abstract class Vehicle{
	private int vehicleNumber; 
	private String type;
	private int rentalRate;
	
	Vehicle(int vehicleNumber, String type, int rentalRate){
		this.vehicleNumber = vehicleNumber;
		this.type = type;
		this.rentalRate = rentalRate;
	}
	
	void SetVN(int vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	
	int GetVN() {
		return vehicleNumber;
	}
	
	void SetT(String type) {
		this.type = type;
	}
	
	String GetT() {
		return type;
	}
	
	void SetR(int rentalRate) {
		this.rentalRate = rentalRate;
	}
	
	int GetR() {
		return rentalRate;
	}
	
	abstract int calculateRentalCost(int days);
}

interface Insurable{
	void calculateInsurance();
	int getInsuranceDetails();
}

class Car extends Vehicle implements Insurable{
	int days;
	int cost;
	int insurancepd;
	int insur;
	
	Car(int vehicleNumber, String type, int rentalRate, int days, int insurancepd){
		super(vehicleNumber, type, rentalRate);
		this.days = days;
		this.insurancepd = insurancepd;
	}
	
	int calculateRentalCost(int days) {
		int cost = days * GetR();
		return cost;
	}
	
	public void calculateInsurance() {
		int i = insurancepd * days;
		this.insur = i;
	}
	
	public int getInsuranceDetails() {
		return insur;
	}
	
	void Display() {
		System.out.println("Vehicle Number: " + GetVN() + " | Type: " + GetT() + " | Rental Rate (per Day): " + GetR() + " | Rental Days: " + days + " | Total Cost: " + calculateRentalCost(days) +  " | Insurance Cost: " + getInsuranceDetails());
	}
}

class Bike extends Vehicle implements Insurable{
	int days;
	int cost;
	int insurancepd;
	int insur;
	
	Bike(int vehicleNumber, String type, int rentalRate, int days, int insurancepd){
		super(vehicleNumber, type, rentalRate);
		this.days = days;
		this.insurancepd = insurancepd;
	}
	
	int calculateRentalCost(int days) {
		int cost = days * GetR();
		return cost;
	}
	
	public void calculateInsurance() {
		int i = insurancepd * days;
		this.insur = i;
	}
	
	public int getInsuranceDetails() {
		return insur;
	}
	
	void Display() {
		System.out.println("Vehicle Number: " + GetVN() + " | Type: " + GetT() + " | Rental Rate (per Day): " + GetR() + " | Rental Days: " + days + " | Total Cost: " + calculateRentalCost(days) + " | Insurance Cost: " + getInsuranceDetails());
	}
}

class Truck extends Vehicle implements Insurable{
	int days;
	int cost;
	int insurancepd;
	int insur;
	
	Truck(int vehicleNumber, String type, int rentalRate, int days, int insurancepd){
		super(vehicleNumber, type, rentalRate);
		this.days = days;
		this.insurancepd = insurancepd;
	}
	
	int calculateRentalCost(int days) {
		int cost = days * GetR();
		return cost;
	}
	
	int GetRC() {
		return cost;
	}
	
	public void calculateInsurance() {
		int i = insurancepd * days;
		this.insur = i;
	}
	
	public int getInsuranceDetails() {
		return insur;
	}
	
	void Display() {
		System.out.println("Vehicle Number: " + GetVN() + " | Type: " + GetT() + " | Rental Rate (per Day): " + GetR() + " | Rental Days: " + days  + " | Total Cost: " + calculateRentalCost(days) +   " | Insurance Cost: " + getInsuranceDetails());
	}
}

public class VehicleRentalSystem {
	public static void main(String[] args) {     
		Car c = new Car(2001, "Car", 1500, 3, 100);         
		Bike b = new Bike(3001, "Bike", 500, 2, 50);
		Truck t = new Truck(1001, "Truck", 3000, 4, 200);
		c.calculateInsurance();
		c.Display();
		b.calculateInsurance();
		b.Display();
		t.calculateInsurance();
		t.Display();
	}
}
