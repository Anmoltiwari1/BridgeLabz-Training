interface Vehicle {
    void displaySpeed();
    
    default void displayBatteryPercentage() {
        System.out.println("Battery feature not available for this vehicle");
    }
}

class RegularCar implements Vehicle {
    private int speed;
    
    public RegularCar(int speed) {
        this.speed = speed;
    }
    
    public void displaySpeed() {
        System.out.println("Current speed: " + speed + " km/h");
    }
}

class ElectricCar implements Vehicle {
    private int speed;
    private int batteryPercentage;
    
    public ElectricCar(int speed, int batteryPercentage) {
        this.speed = speed;
        this.batteryPercentage = batteryPercentage;
    }
    
    public void displaySpeed() {
        System.out.println("Electric car speed: " + speed + " km/h");
    }
    
    @Override
    public void displayBatteryPercentage() {
        System.out.println("Battery: " + batteryPercentage + "%");
    }
}

public class SmartVehicleDashboard {
    public static void main(String[] args) {
        Vehicle regularCar = new RegularCar(80);
        Vehicle electricCar = new ElectricCar(90, 75);
        
        System.out.println("Regular Car Dashboard:");
        regularCar.displaySpeed();
        regularCar.displayBatteryPercentage();
        
        System.out.println("\nElectric Car Dashboard:");
        electricCar.displaySpeed();
        electricCar.displayBatteryPercentage();
    }
}