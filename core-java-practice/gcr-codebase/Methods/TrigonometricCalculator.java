public class TrigonometricCalculator {

    public static double[] calculateTrigonometricFunctions(double angleInDegrees) {

        double radians = Math.toRadians(angleInDegrees);

        double sin = Math.sin(radians);
        double cos = Math.cos(radians);
        double tan = Math.tan(radians);

        return new double[]{sin, cos, tan};
    }

    public static void main(String[] args) {
        double angle = 45;

        double[] result = calculateTrigonometricFunctions(angle);

        System.out.println("Sine: " + result[0]);
        System.out.println("Cosine: " + result[1]);
        System.out.println("Tangent: " + result[2]);
    }
}
