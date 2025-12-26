package Ecapsulation_Plymorphism;

abstract class Transport {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;

    Transport(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getDriverName() {
        return driverName;
    }

    public double getRatePerKm() {
        return ratePerKm;
    }

    public String getTransportDetails() {
        return "Vehicle ID: " + vehicleId + " | Driver: " + driverName + " | Rate per Km: " + ratePerKm;
    }

    public abstract double calculateFare(double distance);
}

class Sedan extends Transport {
    public Sedan(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance;
    }
}

class Motorcycle extends Transport {
    public Motorcycle(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance;
    }
}

class Auto extends Transport {
    public Auto(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance;
    }
}

interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}

class GPSImpl implements GPS {
    private String currentLocation;

    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String newLocation) {
        currentLocation = newLocation;
    }
}

class RideManager {
    public static void calculateFareForRide(Transport transport, double distance) {
        System.out.println(transport.getTransportDetails());
        System.out.println("Fare for " + distance + " Km: " + transport.calculateFare(distance));
    }
}

public class RideHailingApplication {
    public static void main(String[] args) {
        Transport sedan = new Sedan("S123", "John", 10);
        Transport motorcycle = new Motorcycle("M456", "Mike", 5);
        Transport auto = new Auto("A789", "Alex", 7);

        System.out.println("Calculating fare for Sedan:");
        RideManager.calculateFareForRide(sedan, 15);

        System.out.println("\nCalculating fare for Motorcycle:");
        RideManager.calculateFareForRide(motorcycle, 10);

        System.out.println("\nCalculating fare for Auto:");
        RideManager.calculateFareForRide(auto, 20);

        GPSImpl gps = new GPSImpl();
        gps.updateLocation("Downtown");
        System.out.println("\nCurrent Location: " + gps.getCurrentLocation());
    }
}
