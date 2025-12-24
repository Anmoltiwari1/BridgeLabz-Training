public class HotelBooking {
    
    String guestName;
    String roomType;
    int nights;

    //default Constructor
    HotelBooking(){
        guestName="Unknown";
        roomType="Unknown";
        nights=0;
    }

    //parameterized Constructor
    HotelBooking(String guestName,String roomType,int nights){
        this.guestName=guestName;
        this.roomType=roomType;
        this.nights=nights;
    }

    //copy constructor
    HotelBooking(HotelBooking other){
        this.guestName=other.guestName;
        this.roomType=other.roomType;
        this.nights=other.nights;
    }
}
