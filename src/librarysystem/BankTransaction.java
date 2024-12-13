package librarysystem;

public class BankTransaction implements Runnable {

    private BankAccount account;
    private String transactionType;
    private double amount;

    // public BankTransaction(BankAccount account, String transactionType, double amount) {
    //    this.account = account;
    //    this.transactionType = transactionType;
    //    this.amount = amount; 
    // }
    public BankTransaction(String transactionType, double amount) {
        this.transactionType = transactionType;
        this.amount = amount;
    }

    @Override
    public void run() {
        // if(transactionType.equals("Deposit")) {
        //     account.deposit(amount);
        // } else if (transactionType.equals("Withdraw")) {
        //     account.withdraw(amount);
        // }
        System.out.println(Thread.currentThread().getName() + " processing " + transactionType + " of " + amount);
        // Simulate transaction processing time
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Transaction interrupted: " + e.getMessage());
        }
        System.out.println(Thread.currentThread().getName() + " completed " + transactionType);
    }
}
