import java.util.Scanner;

public class TemperatureConvertor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double celsius = sc.nextDouble();
        System.out.println("Temperature in Fahrenheit: " + fahrenheitToCelsius(celsius));
        double fahrenheit = sc.nextDouble();
        System.out.println("Temperature in Celsius: " + celsiusToFahrenheit(fahrenheit));
        sc.close();
    }

    private static double fahrenheitToCelsius(double f) {
        return (f - 32) * 5 / 9;
    }

    private static double celsiusToFahrenheit(double c) {
        return (c * 9 / 5) + 32;
    }
}