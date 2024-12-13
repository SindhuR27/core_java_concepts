package librarysystem;

public class CurrentAccount implements Transaction {

    private double balance;
    private double overdraftLimit;

    public CurrentAccount(double balance, double overdraftLimit) {
        this.balance = balance;
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + ". New Balance: "
                + balance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= balance + overdraftLimit) {
            balance -= amount;
            System.out.println("Withdrew: " + amount + ". New Balance: "
                    + balance);
        } else {
            System.out.println("Overdraft limit exceeded.");
        }
    }
    // Getters

    public double getBalance() {
        return balance;
    }
}
