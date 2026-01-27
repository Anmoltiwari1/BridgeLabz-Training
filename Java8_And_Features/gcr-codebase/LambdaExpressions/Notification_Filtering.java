import java.util.*;
import java.util.function.Predicate;

class Alert{
    String type;

    Alert(String type){
        this.type=type;
    }
}

public class Notification_Filtering {
    public static void main(String[] args) {
        
        List<Alert> alerts=List.of(
            new Alert("Critical"),
            new Alert("Normal"),
            new Alert("Emergency")
        );

        Predicate<Alert> criticalOnly = a -> a.type.equals("Critical");

        alerts.stream().filter(criticalOnly).forEach(a -> System.out.println(a.type));
    }
}
