import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public interface DateFormatter {
    static String formatToISO(LocalDate date) {
        return date.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }
    
    static String formatToUS(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
    }
    
    static String formatToEU(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
    
    static String formatToReadable(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("MMMM dd, yyyy"));
    }
}

class InvoiceGenerator {
    public static void main(String[] args) {
        LocalDate invoiceDate = LocalDate.now();
        
        System.out.println("ISO Format: " + DateFormatter.formatToISO(invoiceDate));
        System.out.println("US Format: " + DateFormatter.formatToUS(invoiceDate));
        System.out.println("EU Format: " + DateFormatter.formatToEU(invoiceDate));
        System.out.println("Readable Format: " + DateFormatter.formatToReadable(invoiceDate));
    }
}