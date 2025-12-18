public class ProfitAndLoss {
    public static void main(String[] args) {
        double CP=129;
        double SP=191;

        //Calculating profit
        double profit= SP-CP;

        //Calculating profit percentage
        double percentage=profit*100;

        System.out.println("The Cost Price is INR "+ CP + "and Selling Price is INR "+ SP);
        System.out.println("Profit is INR "+ profit + "Profit Percentage is "+percentage);

    }
}
