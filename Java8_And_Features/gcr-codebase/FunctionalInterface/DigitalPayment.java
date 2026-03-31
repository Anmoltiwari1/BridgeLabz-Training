interface Payment{

    void pay();
}

class UPI implements Payment{

    public void pay(){
        System.out.println("UPI payment is done");
    }
}

class CreditCard implements Payment{

    public void pay(){
        System.out.println("UPI payment is done");
    }
}

class Wallet implements Payment{

    public void pay(){
        System.out.println("UPI payment is done");
    }
}

public class DigitalPayment {
    public static void main(String[] args) {
        
        Payment upi=new UPI();
        upi.pay();
    }
}
