public class Vehicle {
    
    String ownerName, vehicleType;
    static double registrationFee;


    Vehicle(String ownerName,String vehicleType){
        this.ownerName=ownerName;
        this.vehicleType=vehicleType;
    }

    public void displayVehicleDetails(){
        System.out.println("Owner Name is : "+ownerName);
        System.out.println("Vehicle Type is : "+vehicleType);
        System.out.println("Registration fee is : "+registrationFee);
    }

    public void updateRegistrationFee(double newRegistrationFee){
        registrationFee=newRegistrationFee;
    }
}
