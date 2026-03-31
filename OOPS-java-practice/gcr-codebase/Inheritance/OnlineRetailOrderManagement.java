class Order{
	int id;
	String d;
	
	Order(int id, String d){
		this.id = id;
		this.d = d;
	}
	
	void Display() {
		System.out.print("Order ID: " + id + " Date: " + d);
	}
	
	String Status(){
		return "Order Placed";
	}
}

class ShippedOrder extends Order{
	int num;
	
	ShippedOrder(int id, String d, int num){
		super(id, d);
		this.num = num;
	}
	
	void Display() {
		System.out.println("Order Details");
		super.Display();
		System.out.print(" Tracking Number: " + num);
		System.out.println();
	}
	
	String Status(){
		return "Order Shipped";
	}
}

class DeliveredOrder extends ShippedOrder{ 
	String dd;
	
	DeliveredOrder(int id, String d, int num, String dd){
		super(id, d, num);
		this.dd = dd;
	}
	
	void Display() {
		System.out.println("Order Details");
		System.out.println("Order ID: " + id + " Date: " + d + " Tracking Number: " + num + " Delivered Date: " + dd);
	}
	
	String Status(){
		return "Order Delivered";
	}
}

public class OnlineRetailOrderManagement {
	public static void main(String[] args) {
		ShippedOrder s1 = new ShippedOrder(1001, "02-10-2025", 4562145);
		s1.Display();
		System.out.println("Order Status: " + s1.Status());
		DeliveredOrder d1 = new DeliveredOrder(1004, "03-10-2025", 4568945, "10-10-2025");
		d1.Display();
		System.out.println("Order Status: " + d1.Status());
	}
}
