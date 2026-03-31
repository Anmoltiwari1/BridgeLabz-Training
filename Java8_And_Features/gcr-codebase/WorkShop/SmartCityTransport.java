import java.util.*;
import java.util.stream.*;
import java.time.LocalDateTime;


@FunctionalInterface
interface FareCalculator {
    double calculateFare(double distance, String serviceType);
}


interface EmergencyService {
}


interface GeoUtils {
    static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        return Math.sqrt(Math.pow(lat2 - lat1, 2) + Math.pow(lon2 - lon1, 2)) * 111; 
    }
}

interface TransportService {
    void scheduleService();
    double getFare();
    String getServiceType();
    
    
    default void printServiceDetails() {
        System.out.println("Service: " + getServiceType() + ", Fare: $" + getFare());
    }
}


class BusService implements TransportService {
    private String route;
    private double fare;
    private LocalDateTime departureTime;
    
    public BusService(String route, double fare, LocalDateTime departureTime) {
        this.route = route;
        this.fare = fare;
        this.departureTime = departureTime;
    }
    
    @Override
    public void scheduleService() {
        System.out.println("Bus scheduled on route: " + route);
    }
    
    @Override
    public double getFare() { return fare; }
    
    @Override
    public String getServiceType() { return "Bus"; }
    
    public String getRoute() { return route; }
    public LocalDateTime getDepartureTime() { return departureTime; }
}

class MetroService implements TransportService {
    private String line;
    private double fare;
    private LocalDateTime departureTime;
    
    public MetroService(String line, double fare, LocalDateTime departureTime) {
        this.line = line;
        this.fare = fare;
        this.departureTime = departureTime;
    }
    
    @Override
    public void scheduleService() {
        System.out.println("Metro scheduled on line: " + line);
    }
    
    @Override
    public double getFare() { return fare; }
    
    @Override
    public String getServiceType() { return "Metro"; }
    
    public String getLine() { return line; }
    public LocalDateTime getDepartureTime() { return departureTime; }
}

class TaxiService implements TransportService {
    private String vehicleId;
    private double fare;
    
    public TaxiService(String vehicleId, double fare) {
        this.vehicleId = vehicleId;
        this.fare = fare;
    }
    
    @Override
    public void scheduleService() {
        System.out.println("Taxi available: " + vehicleId);
    }
    
    @Override
    public double getFare() { return fare; }
    
    @Override
    public String getServiceType() { return "Taxi"; }
}

class AmbulanceService implements TransportService, EmergencyService {
    private String vehicleId;
    
    public AmbulanceService(String vehicleId) {
        this.vehicleId = vehicleId;
    }
    
    @Override
    public void scheduleService() {
        System.out.println("Emergency Ambulance dispatched: " + vehicleId);
    }
    
    @Override
    public double getFare() { return 0.0; }
    
    @Override
    public String getServiceType() { return "Ambulance"; }
}


class Passenger {
    private String name;
    private String route;
    private double fare;
    private boolean isPeakTime;
    
    public Passenger(String name, String route, double fare, boolean isPeakTime) {
        this.name = name;
        this.route = route;
        this.fare = fare;
        this.isPeakTime = isPeakTime;
    }
    
   
    public String getName() { return name; }
    public String getRoute() { return route; }
    public double getFare() { return fare; }
    public boolean isPeakTime() { return isPeakTime; }
}

public class SmartCityTransport {
    private List<TransportService> services;
    private List<Passenger> passengers;
    private FareCalculator fareCalculator;
    
    public SmartCityTransport() {
        this.services = new ArrayList<>();
        this.passengers = new ArrayList<>();
        this.fareCalculator = (distance, serviceType) -> {
            double baseFare = serviceType.equals("Bus") ? 2.0 : serviceType.equals("Metro") ? 3.0 : 5.0;
            return baseFare + (distance * 0.5);
        };
        initializeServices();
        initializePassengers();
    }
    
    private void initializeServices() {
        services.add(new BusService("Route-A", 2.5, LocalDateTime.now().plusMinutes(10)));
        services.add(new BusService("Route-B", 3.0, LocalDateTime.now().plusMinutes(5)));
        services.add(new MetroService("Blue Line", 4.0, LocalDateTime.now().plusMinutes(15)));
        services.add(new MetroService("Red Line", 3.5, LocalDateTime.now().plusMinutes(8)));
        services.add(new TaxiService("TX-011", 8.0));
        services.add(new AmbulanceService("TX-111"));
    }
    
    private void initializePassengers() {
        passengers.add(new Passenger("Amit", "Route-A", 2.5, true));
        passengers.add(new Passenger("Prakhar", "Route-A", 2.5, false));
        passengers.add(new Passenger("Shivani", "Red Line", 4.0, true));
        passengers.add(new Passenger("Sneha", "Route-B", 3.0, false));
        passengers.add(new Passenger("Shreyansh", "Red Line", 3.5, true));
    }
    

    public void filterServicesByFare(double maxFare) {
        System.out.println("Services under Rs" + maxFare + " ==");
        services.stream()
                .filter(service -> service.getFare() <= maxFare)
                .sorted((s1, s2) -> Double.compare(s1.getFare(), s2.getFare()))
                .forEach(TransportService::printServiceDetails);
    }
    
    
    public void displayAllServices() {
        System.out.println("All Available Services");
        services.forEach(TransportService::printServiceDetails);
    }
    

    public void generateRouteReport() {
        System.out.println("Passengers by Route ");
        Map<String, List<Passenger>> passengersByRoute = passengers.stream()
                .collect(Collectors.groupingBy(Passenger::getRoute));
        
        passengersByRoute.forEach((route, passengerList) -> {
            System.out.println(route + ": " + passengerList.size() + " passengers");
        });
    }
   
    public void generatePeakTimeReport() {
        System.out.println("Peak and Non-Peak Analysis");
        Map<Boolean, List<Passenger>> peakPartition = passengers.stream()
                .collect(Collectors.partitioningBy(Passenger::isPeakTime));
        
        System.out.println("Peak time passengers: " + peakPartition.get(true).size());
        System.out.println("Non-peak passengers: " + peakPartition.get(false).size());
    }
 
    public void generateRevenueReport() {
        System.out.println("Revenue Summary");
        DoubleSummaryStatistics fareStats = passengers.stream()
                .collect(Collectors.summarizingDouble(Passenger::getFare));
        
        System.out.println("Total Revenue: Rs" + fareStats.getSum());
        System.out.println("Average Fare: Rs" + String.format("%.2f", fareStats.getAverage()));
        System.out.println("Total Trips: " + fareStats.getCount());
    }
  
    public void updateLiveDashboard() {
        System.out.println("Live Dashboard Update");
        services.stream()
                .filter(service -> !(service instanceof EmergencyService))
                .forEach(service -> {
                    service.scheduleService();
                    service.printServiceDetails();
                });
    }
    
    public void handleEmergencyServices() {
        System.out.println("Emergency Services");
        services.stream()
                .filter(service -> service instanceof EmergencyService)
                .forEach(service -> {
                    System.out.println("PRIORITY: " + service.getServiceType());
                    service.scheduleService();
                });
    }
    
    public void calculateRouteDistance() {
        System.out.println("Route Distance Calculation");
        double distance = GeoUtils.calculateDistance(40.7128, -74.0060, 40.7589, -73.9851);
        System.out.println("Distance between points: " + String.format("%.2f", distance) + " km");
        
        double calculatedFare = fareCalculator.calculateFare(distance, "Bus");
        System.out.println("Calculated fare: $" + String.format("%.2f", calculatedFare));
    }
    
    public static void main(String[] args) {
        SmartCityTransport system = new SmartCityTransport();
        
        system.displayAllServices();
        system.filterServicesByFare(4.0);
        system.generateRouteReport();
        system.generatePeakTimeReport();
        system.generateRevenueReport();
        system.updateLiveDashboard();
        system.handleEmergencyServices();
        system.calculateRouteDistance();
        system.displayAllServices();
        system.filterServicesByFare(4.0);
        system.generateRouteReport();
        system.generatePeakTimeReport();
        system.generateRevenueReport();
        system.updateLiveDashboard();
        system.handleEmergencyServices();
        system.calculateRouteDistance();
    }
}
