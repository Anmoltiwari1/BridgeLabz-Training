import java.util.Scanner;

public class UserInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Utility utility = new Utility();
        
        System.out.println("Enter the Goods Transport details");
        String input = scanner.nextLine();
        
        String[] parts = input.split(":");
        String transportId = parts[0];
        
        if (!utility.validateTransportId(transportId)) {
            System.out.println("Please provide a valid record");
            return;
        }
        
        GoodsTransport goodsTransport = utility.parseDetails(input);
        
        if (goodsTransport != null) {
            String objectType = utility.findObjectType(goodsTransport);
            
            System.out.println("Transporter id : " + goodsTransport.getTransportId());
            System.out.println("Date of transport : " + goodsTransport.getTransportDate());
            System.out.println("Rating of the transport : " + goodsTransport.getTransportRating());
            
            if (objectType.equals("BrickTransport")) {
                BrickTransport brickTransport = (BrickTransport) goodsTransport;
                System.out.println("Quantity of bricks : " + brickTransport.getBrickQuantity());
                System.out.println("Brick price : " + brickTransport.getBrickPrice());
            } else if (objectType.equals("TimberTransport")) {
                TimberTransport timberTransport = (TimberTransport) goodsTransport;
                System.out.println("Type of the timber : " + timberTransport.getTimberType());
                System.out.println("Timber price per kilo : " + timberTransport.getTimberPrice());
            }
            
            System.out.println("Vehicle for transport : " + goodsTransport.vehicleSelection());
            System.out.println("Total charge : " + goodsTransport.calculateTotalCharge());
        }
        
        scanner.close();
    }
}