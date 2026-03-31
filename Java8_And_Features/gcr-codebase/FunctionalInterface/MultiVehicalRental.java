interface vehicle{

    void rent();
    void returnVehicle();
}

class Cars implements vehicle{

    public void rent(){
        System.out.println("You have rented the car");
    }
    public void returnVehicle(){
        System.out.println("You have returned the car");
    }   

}

class Bikes implements vehicle{

    public void rent(){
        System.out.println("You have rented the bikes");
    }
    public void returnVehicle(){
        System.out.println("You have returned the bikes");
    }   

}


class buses implements vehicle{

    public void rent(){
        System.out.println("You have rented the buses");
    }
    public void returnVehicle(){
        System.out.println("You have returned the buses");
    }   

}


public class MultiVehicalRental {
    public static void main(String[] args) {
        
        vehicle car=new Cars();
        car.rent();
        car.returnVehicle();
    }
}
