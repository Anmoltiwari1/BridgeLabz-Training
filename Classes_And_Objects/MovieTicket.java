package Classes_And_Objects;

public class MovieTicket {
    
    String movieName;
    String seatNumber;
    double price;
    boolean isBooked;

    MovieTicket(String movieName){
        this.movieName=movieName;
        this.seatNumber="Null";
        this.price=0.0;
        this.isBooked=false;
    }

    public void bookTicket(String seatNumber,double price){
        if(isBooked){
            System.out.println("House Full!! .. Sorry ,please try after some time");
        }else{
            this.seatNumber=seatNumber;
            this.price=price;
            this.isBooked=true;
            System.out.println("Ticket booked for movie: " + this.movieName);
            System.out.println("Seat Number: " + this.seatNumber);
           System.out.println("Price: $" + this.price);
        }
    }

    public void displayTicket(){
        if(this.isBooked) {
			System.out.println("Ticket booked for movie: " + this.movieName);
           System.out.println("Seat Number: " + this.seatNumber);
           System.out.println("Price: $" + this.price);	
		}
		//displaying message If failed to book the ticket
		else {
			System.out.println("Ticket have not booked yet....");
		}
    }

    public static void main(String[] args) {
        MovieTicket ticket1=new MovieTicket("Dragon");
		
		//calling the method
		ticket1.displayTicket();
		ticket1.bookTicket("A10",120.0);
		ticket1.bookTicket("B10", 120.0);
		ticket1.bookTicket("A11", 120.0);//booking the ticket which is already booked
		ticket1.displayTicket();
    }
}
