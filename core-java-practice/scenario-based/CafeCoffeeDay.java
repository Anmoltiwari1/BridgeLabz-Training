import java.util.Scanner;

public class CafeCoffeeDay {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int choice, quantity;
        double price = 0;
        double totalBill = 0;
        final double GST_RATE = 0.18;

        while (true) {

            System.out.println("Type 'exit' to stop or press Enter to continue:");
            sc.nextLine(); // clear buffer
            String input = sc.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.println("Choose Coffee Type:");
            System.out.println("1. Espresso (₹90)");
            System.out.println("2. Cappuccino (₹120)");
            System.out.println("3. Cafe Latte (₹110)");
            System.out.println("4. Americano (₹100)");

            choice = sc.nextInt();

            switch (choice) {
                case 1 -> price = 90;
                case 2 -> price = 120;
                case 3 -> price = 110;
                case 4 -> price = 100;
                default -> {
                    System.out.println("Invalid choice");
                    continue;
                }
            }

            System.out.println("Enter quantity:");
            quantity = sc.nextInt();

            totalBill += price * quantity;
        }

        double gstAmount = totalBill * GST_RATE;
        double finalBill = totalBill + gstAmount;

        System.out.println("Total Bill: ₹" + totalBill);
        System.out.println("GST (18%): ₹" + gstAmount);
        System.out.println("Final Payable Amount: ₹" + finalBill);
    }
}
