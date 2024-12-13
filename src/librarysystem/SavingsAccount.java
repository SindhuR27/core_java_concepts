package librarysystem;

public class SavingsAccount extends BankAccount implements Transaction {

    private double interestRate;
    private double balance;

    public SavingsAccount(double balance, double interestRate) {
        super(balance);
        this.interestRate = interestRate;
    }

    @Override
    public void deposit(double amount) {
        balance += amount + (amount * interestRate / 100);
        System.out.println("Deposited: " + amount + " with interest");
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: " + amount + ". New Balance: "
                    + balance);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public double getInterestRate() {
        return interestRate;
    }

    @Override
    public double getBalance() {
        return balance;
    }
}
