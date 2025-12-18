public class DiscountedPrice {
    public static void main(String[] args) {
        int fee=125000;
        int discountedPercent=10;
        int discount=0;

        discount=fee * discountedPercent/100;

        System.out.println("The discount amount is INR "+ discount+" and the final discounted fee is INR "+ (fee-discount));
    }
}
