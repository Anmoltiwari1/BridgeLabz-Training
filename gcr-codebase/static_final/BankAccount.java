public class BankAccount{
    
    private static String bankName="Union Bank of India";
    private static int totalAccount=0;
    private final String AccountNumber;
    private String accountholderName;
    private double balance;


    public BankAccount(String AccountNumber,String accountholderName,double balance){
        this.AccountNumber=AccountNumber;
        this.accountholderName=accountholderName;
        this.balance=balance;
        totalAccount++;
    }

    public static void gettotalAccount(){
        System.out.println("Total Accounts in the banks are : "+totalAccount);
    }

    public void AccountDetails(){
        System.out.println("Account Holder Name is : "+accountholderName);
        System.out.println("Account Number : "+ AccountNumber);
        System.out.println("Balance is :"+balance);

    }

    public String getAccountHolderName(){
        return accountholderName;
    }

    public void setAccountHolderName(String AccountHolderName){
        this.accountholderName=accountholderName;
    }

    public double getBalance(){
        return balance;
    }

    public void deposit(double amount) {
       if (amount > 0) {
           balance += amount;
           System.out.println("Deposited: $" + amount);
       } else {
           System.out.println("Invalid deposit amount.");
       }
   }
   public void withdraw(double amount) {
       if (amount > 0 && amount <= balance) {
           balance -= amount;
           System.out.println("Withdrawn: $" + amount);
       } else {
           System.err.println("Insufficient balance or invalid amount.");
       }
   }


   public static void main(String[] args) {
    
    BankAccount acc1=new BankAccount("ABCD@123", "Hritik",1000);
    BankAccount acc2=new BankAccount("ABCD@321", "Ansh",2000);

    System.out.println("Account deatils are as follows :");
    acc1.AccountDetails();

    System.out.println("Account details are as follows");
    acc2.AccountDetails();

    BankAccount.gettotalAccount();


    acc1.deposit(200);
    acc2.withdraw(122);
    System.out.println(acc1.getBalance());
   }
}
