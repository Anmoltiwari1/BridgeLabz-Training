import java.util.function.Function;


public class StringLenghtChecker {
    public static void main(String[] args) {
        
        int limit=20;

        Function<String ,Integer> lenghtCalculator = str -> str.length();

        String message="This is functional interface in java";

        if(lenghtCalculator.apply(message)> limit){
            System.out.println("Message exceeds the charater limit");
        }else{
            System.out.println("Message witihin limit");
        }
    }
}
