class PersonR{
	String name;
	int id;
	
	PersonR(String name, int id){
		this.name = name;
		this.id = id;
	}
}

interface Worker{
	void PerformDuties();
}

class Chef extends PersonR implements Worker{
	
	Chef(String name, int id){
		super(name, id);
	}
	
	public void PerformDuties() {
		System.out.println(name +  " (Chef) is cooking meals");
	}
}

class Waiter extends PersonR implements Worker{
	
	Waiter(String name, int id){
		super(name, id);
	}
	
	public void PerformDuties() {
		System.out.println(name +  " (Waiter) is serving customers");
	}
}

public class RestaurantManagementSystem {
	public static void main(String[] args) {
		Chef c1 = new Chef("Alice", 124);
		Waiter w1 = new Waiter("Bob", 102);
		c1.PerformDuties();
		w1.PerformDuties();
	}
}
