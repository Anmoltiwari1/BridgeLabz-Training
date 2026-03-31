public class TemperatureConverterTest {
    public static void main(String[] args) {
        testCelsiusToFahrenheit();
        testFahrenheitToCelsius();
        System.out.println("All TemperatureConverter tests passed!");
    }
    
    static void testCelsiusToFahrenheit() {
        TemperatureConverter converter = new TemperatureConverter();
        double result = converter.celsiusToFahrenheit(0);
        
        if (Math.abs(result - 32.0) < 0.01) {
            System.out.println("✅ testCelsiusToFahrenheit passed");
        } else {
            System.out.println("❌ testCelsiusToFahrenheit failed");
        }
    }
    
    static void testFahrenheitToCelsius() {
        TemperatureConverter converter = new TemperatureConverter();
        double result = converter.fahrenheitToCelsius(32);
        
        if (Math.abs(result - 0.0) < 0.01) {
            System.out.println("✅ testFahrenheitToCelsius passed");
        } else {
            System.out.println("❌ testFahrenheitToCelsius failed");
        }
    }
}