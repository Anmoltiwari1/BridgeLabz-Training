interface PaymentProcessor {
    void processPayment(double amount);
    
    default boolean refund(double amount) {
        System.out.println("Processing refund of $" + amount);
        return true;
    }
}

class PayPalProcessor implements PaymentProcessor {
    public void processPayment(double amount) {
        System.out.println("PayPal payment of $" + amount + " processed");
    }
}

class StripeProcessor implements PaymentProcessor {
    public void processPayment(double amount) {
        System.out.println("Stripe payment of $" + amount + " processed");
    }
    
    @Override
    public boolean refund(double amount) {
        System.out.println("Stripe custom refund of $" + amount);
        return true;
    }
}

public class PaymentGateway {
    public static void main(String[] args) {
        PaymentProcessor paypal = new PayPalProcessor();
        PaymentProcessor stripe = new StripeProcessor();
        
        paypal.processPayment(100.0);
        paypal.refund(50.0);
        
        stripe.processPayment(200.0);
        stripe.refund(75.0);
    }
}