package AeroVigil;
public class FlightUtil {
    
    public boolean validateFlightNumber(String flightNumber) throws InvalidFlightException {
        if (!flightNumber.matches("FL-\\d{4}")) {
            throw new InvalidFlightException("The flight number " + flightNumber + " is invalid");
        }
        
        int number = Integer.parseInt(flightNumber.substring(3));
        if (number < 1000 || number > 9999) {
            throw new InvalidFlightException("The flight number " + flightNumber + " is invalid");
        }
        
        return true;
    }
    
    public boolean validateFlightName(String flightName) throws InvalidFlightException {
        if (!flightName.equals("SpiceJet") && !flightName.equals("Vistara") && 
            !flightName.equals("IndiGo") && !flightName.equals("Air Arabia")) {
            throw new InvalidFlightException("The flight name " + flightName + " is invalid");
        }
        
        return true;
    }
    
    public boolean validatePassengerCount(int passengerCount, String flightName) throws InvalidFlightException {
        int maxCapacity = 0;
        
        switch (flightName) {
            case "SpiceJet":
                maxCapacity = 396;
                break;
            case "Vistara":
                maxCapacity = 615;
                break;
            case "IndiGo":
                maxCapacity = 230;
                break;
            case "Air Arabia":
                maxCapacity = 130;
                break;
        }
        
        if (passengerCount <= 0 || passengerCount > maxCapacity) {
            throw new InvalidFlightException("The passenger count " + passengerCount + " is invalid for " + flightName);
        }
        
        return true;
    }
    
    public double calculateFuelToFillTank(String flightName, double currentFuelLevel) throws InvalidFlightException {
        double maxCapacity = 0;
        
        switch (flightName) {
            case "SpiceJet":
                maxCapacity = 200000;
                break;
            case "Vistara":
                maxCapacity = 300000;
                break;
            case "IndiGo":
                maxCapacity = 250000;
                break;
            case "Air Arabia":
                maxCapacity = 150000;
                break;
        }
        
        if (currentFuelLevel < 0 || currentFuelLevel > maxCapacity) {
            throw new InvalidFlightException("Invalid fuel level for " + flightName);
        }
        
        return maxCapacity - currentFuelLevel;
    }
}