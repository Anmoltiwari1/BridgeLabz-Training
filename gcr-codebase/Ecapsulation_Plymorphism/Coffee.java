import java.util.*;
public class Coffee {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("1. Coffee -> 80₹");
		System.out.println("2. Cold Coffee -> 100₹");
		System.out.println("3. Capuchino -> 120₹");
		System.out.println("4. Exit");
		int q;
		sc.close();
		while(true) {
			System.out.print("What do you want to purchase: ");
			int c1 = sc.nextInt();
			if(c1 == 4) break;
			switch(c1) {
			case 1:
				System.out.print("Enter Quantity: ");
				q = sc.nextInt();
				System.out.println("The Price is 80₹");
				CCalculate(q);
				break;
				
			case 2:
				System.out.print("Enter Quantity: ");
				q = sc.nextInt();
				System.out.println("The Price is 100₹");
				CCCalculate(q);
				break;
				
			case 3:
				System.out.print("Enter Quantity: ");
				q = sc.nextInt();
				System.out.println("The Price is 120₹");
				CCCCalculate(q);
				break;
				
			case 4:
				break;
				
			default:
				System.out.println("Invalid Choice");
			}
		}
	}
	static void CCalculate(int q){
		int t = 80 * q;
		double tt = t + (t * 0.18);
		System.out.println("The Total Price is: " + tt);
	}
	static void CCCalculate(int q) {
		int t = 100 * q;
		double tt = t + (t * 0.18);
		System.out.println("The Total Price is: " + tt);
	}
	static void CCCCalculate(int q) {
		int t = 100 * q;
		double tt = t + (t * 0.18);
		System.out.println("The Total Price is: " + tt);
	}
}
