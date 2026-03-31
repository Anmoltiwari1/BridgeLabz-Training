public class ThrowAndThrows {
    public static void main(String[] args) {
        
        try {
            double i=calculateInterest(1000, 2, 5);
            System.out.println("Interest: "+i);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: "+e.getMessage());
        }
    }

    public static double calculateInterest(double amount,double rate,int year) throws IllegalArgumentException{

        if(amount<0 || rate<0 || year<0){
            throw new IllegalArgumentException("Invalid input: Amount and rate must be positive");
        }

        double interest=amount*rate*year/100;
        return interest;
    }
}
