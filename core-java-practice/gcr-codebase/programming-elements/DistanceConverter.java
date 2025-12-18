import java.util.Scanner;

public class DistanceConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter distance in feet: ");
        double distanceInFeet = sc.nextDouble();

        double distanceInYards = distanceInFeet / 3;
        double distanceInMiles = distanceInYards / 1760;

        System.out.println(
            "Distance in feet is " + distanceInFeet +
            " while in yards is " + distanceInYards +
            " and in miles is " + distanceInMiles
        );

        sc.close();
    }
}
