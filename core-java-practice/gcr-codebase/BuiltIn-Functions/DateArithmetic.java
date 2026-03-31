import java.time.*;

public class DateArithmetic {
    public static void main(String[] args) {
        LocalDate inputDate = LocalDate.of(2023, 6, 24); // Example date

        LocalDate updatedDate = inputDate.plusDays(7)
                                         .plusMonths(1)
                                         .plusYears(2)
                                         .minusWeeks(3);

        System.out.println("Original Date: " + inputDate);
        System.out.println("After adding 7 days, 1 month, 2 years and subtracting 3 weeks: " + updatedDate);
    }
}
