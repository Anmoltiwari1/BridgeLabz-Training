public class CarRental {
    
    String customerName;
    String carModel;
    int rentalDays;


    CarRental(){
        this("Unknown", "Unknown", 1);
    }

    CarRental(String customerName,String carModel,int rentalDays){
        this.customerName=customerName;
        this.carModel=carModel;
        this.rentalDays=rentalDays;
    }

    public double calculateTotalCost(){
        double bill=0;
        double costPerDay=1000;
        bill=costPerDay*rentalDays;

        return bill;
    }
}
