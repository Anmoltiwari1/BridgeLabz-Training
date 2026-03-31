import java.util.*;
import java.util.stream.Collectors;

class Invoice{
    int transactionId;

    Invoice(int transactionId){
        this.transactionId=transactionId;
    }

    public String toString(){
        return "Invoice{transactionID="+transactionId+"}";
    }
}


public class InvoiceObjectCreation {
    public static void main(String[] args) {
        
        List<Integer> transaction=new ArrayList<>();

        transaction.add(1001);
        transaction.add(1002);
        transaction.add(1003);

        List<Invoice> invoices = transaction.stream().map(Invoice::new).collect(Collectors.toList());

        System.out.println(invoices);
    }
}
