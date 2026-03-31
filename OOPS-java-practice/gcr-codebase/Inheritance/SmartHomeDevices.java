class Device{
	int id;
	String status;
	
	Device(int id, String status){
		this.id = id;
		this.status = status;
	}
	
	void Display() {
		System.out.print("Device ID: " + id + " Status: " + status);
	}
}

class Thermostat extends Device{
	int set;
	
	Thermostat(int id, String status, int set){
		super(id, status);
		this.set = set;
	}
	
	void Display() {
		super.Display();
		System.out.print(" Temperature: " + set);
	}
}

public class SmartHomeDevices {
	public static void main(String[] args) {
		Thermostat t1 = new Thermostat(101, "On", 24);
		Thermostat t2 = new Thermostat(102, "Off", 20);
		t1.Display();
		System.out.println();
		t2.Display();
	}
}
