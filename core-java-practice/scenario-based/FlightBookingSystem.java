import java.util.*;

abstract class Flight{
    String name;
    int age;
    String cl;


    Flight(String name,int age,String cl){
        this.name = name;
        this.age = age;
        this.cl=cl;
    }
}


class Booking extends Flight{

    static int id=1;
    int bookingsId;
    Booking(String name, int age, String cl,int id){
        super(name, age, cl);
        this.bookingsId=id++;
    }
}

public class FlightBookingSystem{
    public static void main(String[] args) {
        
    }

    public static ArrayList<Booking> UserBooking(String name,int age,String cl){

        Booking booking =new Booking(name, age, cl, age);
        booking.add(booking);
         System.out.println("Booking created with ID: " + booking.bookingsId);
    }

    public static void searching(int id){
        for(Booking b:bookings){
            if(b.bookingsId==id){
                System.out.println("Name: "+b.name+" Age: "+b.age+" Class: "+b.cl);
            }else{
                System.out.println("No found");
            }
        }
    }
}