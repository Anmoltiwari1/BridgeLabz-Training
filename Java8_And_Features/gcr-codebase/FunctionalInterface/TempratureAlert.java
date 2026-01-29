import java.util.function.Predicate;

public class TempratureAlert {
    public static void main(String[] args) {
        
        double threshold=40.0;

        Predicate<Double> isHighTemp = temp -> temp > threshold;

        double currentTemp=42.5;

        if(isHighTemp.test(currentTemp)){
            System.out.println("Alert ! High temp");
        }else{
            System.out.println("Temprature is normal");
        }
    }
}
