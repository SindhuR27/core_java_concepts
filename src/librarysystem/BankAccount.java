package librarysystem;

public class BankAccount {
    protected double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    // public void deposit (double amount) {
    //     balance += amount;
    //     System.out.println("Deposited: " + amount);
    // }

    public synchronized void deposit(double amount) {
        balance +=amount;
        System.out.println(Thread.currentThread().getName() + " deposited " + amount + ". New balance: "+ balance);
    }

    // public void withdraw (double amount) {
    //     balance -= amount;
    //     System.out.println("Withdrew: " + amount);
    // }

    public synchronized void withdraw(double amount) {
        if (amount <= balance) {
        balance -= amount;
        System.out.println(Thread.currentThread().getName() + " withdrew " + amount + ". New balance: " + balance);
        } else {
        System.out.println(Thread.currentThread().getName() + " insufficient balance to withdraw " + amount);
        }
        }

    public double getBalance() {
        return balance;
    }
}
