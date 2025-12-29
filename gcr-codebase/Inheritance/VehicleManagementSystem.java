class VehicleM{
	int max;
	String model;
	
	VehicleM(int max, String model){
		this.max = max;
		this.model = model;
	}
	
	void Display() {
		System.out.println("Max Speed: " + max + " km/h  Model: " + model);
	}
}

interface Refuelable{
	void refuel();
}

class ElectricVehicle extends VehicleM{
	
	ElectricVehicle(int max, String model){
		super(max, model);
	}
	
	void charge(){
		System.out.println(model + " requires Charging");
	}
	
	void Display() {
		super.Display();
	}
}

class PetrolVehicle extends VehicleM implements Refuelable{
	
	PetrolVehicle(int max, String model){
		super(max, model);
	}
	
	public void refuel(){
		System.out.println(model + " requires Refueling");
	}
	
	void Display() {
		super.Display();
	}
}

public class VehicleManagementSystem {
	public static void main(String[] args) {
		ElectricVehicle e1 = new ElectricVehicle(160, "Creta");
		PetrolVehicle p1 = new PetrolVehicle(190, "Grand Vitara");
		e1.Display();
		e1.charge();
		p1.Display();
		p1.refuel();
	}
}
