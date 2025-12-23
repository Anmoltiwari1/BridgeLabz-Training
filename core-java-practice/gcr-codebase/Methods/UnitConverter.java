import java.util.Scanner;

public class UnitConverter {
    public static double convertKmToMiles(double km) {
        double km2miles = 0.621371;
        return km * km2miles;
    }
    
    public static double convertMilesToKm(double miles) {
        double miles2km = 1.60934;
        return miles * miles2km;
    }
    
    public static double convertMetersToFeet(double meters) {
        double meters2feet = 3.28084;
        return meters * meters2feet;
    }
    
    public static double convertFeetToMeters(double feet) {
        double feet2meters = 0.3048;
        return feet * feet2meters;
    }
    
    public static double convertYardsToFeet(double yards) {
        double yards2feet = 3;
        return yards * yards2feet;
    }
    
    public static double convertFeetToYards(double feet) {
        double feet2yards = 0.333333;
        return feet * feet2yards;
    }
    
    public static double convertMetersToInches(double meters) {
        double meters2inches = 39.3701;
        return meters * meters2inches;
    }
    
    public static double convertInchesToMeters(double inches) {
        double inches2meters = 0.0254;
        return inches * inches2meters;
    }
    
    public static double convertInchesToCentimeters(double inches) {
        double inches2cm = 2.54;
        return inches * inches2cm;
    }
    
    public static double convertFahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
    
    public static double convertCelsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }
    
    public static double convertPoundsToKilograms(double pounds) {
        double pounds2kilograms = 0.453592;
        return pounds * pounds2kilograms;
    }
    
    public static double convertKilogramsToPounds(double kilograms) {
        double kilograms2pounds = 2.20462;
        return kilograms * kilograms2pounds;
    }
    
    public static double convertGallonsToLiters(double gallons) {
        double gallons2liters = 3.78541;
        return gallons * gallons2liters;
    }
    
    public static double convertLitersToGallons(double liters) {
        double liters2gallons = 0.264172;
        return liters * liters2gallons;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Unit Converter");
        System.out.println("1. Km to Miles");
        System.out.println("2. Miles to Km");
        System.out.println("3. Meters to Feet");
        System.out.println("4. Feet to Meters");
        System.out.println("5. Fahrenheit to Celsius");
        System.out.println("6. Celsius to Fahrenheit");
        System.out.print("Choose conversion (1-6): ");
        
        int choice = scanner.nextInt();
        System.out.print("Enter value: ");
        double value = scanner.nextDouble();
        
        switch (choice) {
            case 1:
                System.out.println(value + " km = " + convertKmToMiles(value) + " miles");
                break;
            case 2:
                System.out.println(value + " miles = " + convertMilesToKm(value) + " km");
                break;
            case 3:
                System.out.println(value + " meters = " + convertMetersToFeet(value) + " feet");
                break;
            case 4:
                System.out.println(value + " feet = " + convertFeetToMeters(value) + " meters");
                break;
            case 5:
                System.out.println(value + " F = " + convertFahrenheitToCelsius(value) + " C");
                break;
            case 6:
                System.out.println(value + " C = " + convertCelsiusToFahrenheit(value) + " F");
                break;
            default:
                System.out.println("Invalid choice");
        }
        
        scanner.close();
    }
}
