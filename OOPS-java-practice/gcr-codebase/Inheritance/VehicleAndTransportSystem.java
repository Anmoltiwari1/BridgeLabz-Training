class Vehicle{
	int max;
	String fuel;
	
	Vehicle(int max, String fuel){
		this.max = max;
		this.fuel = fuel;
	}
	
	void Display() {
		System.out.println("Max Speed: " + max + " km/h Fuel Type: " + fuel);
	}
}

class Car extends Vehicle{
	int seat;
	
	Car(int max, String fuel, int seat){
		super(max, fuel);
		this.seat = seat;
	}
	
	void Display() {
		super.Display();
		System.out.println("Seat Capacity: " + seat);
	}
}

class Truck extends Vehicle{
	int load;
	
	Truck(int max, String fuel, int load){
		super(max, fuel);
		this.load = load;
	}
	
	void Display() {
		super.Display();
		System.out.println("Load Capacity: " + load);
	}
}

class Motorcycle extends Vehicle{
	
	Motorcycle(int max, String fuel){
		super(max, fuel);
	}
	
	void Display() {
		super.Display();
	}
}

public class VehicleAndTransportSystem {
	public static void main(String[] args) {
		Vehicle [] v = new Vehicle[3];
		v[0] = new Car(120, "Petrol", 5);
		v[1] = new Truck(80, "Diesel", 500);
		v[2] = new Motorcycle(100, "Petrol");
		for(int i = 0; i < v.length; i++) {
			Vehicle ve = v[i];
			ve.Display();
		}
	}
}
