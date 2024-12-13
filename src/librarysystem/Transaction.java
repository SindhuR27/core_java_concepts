package librarysystem;

interface Transaction {

    void deposit(double amount);

    void withdraw(double amount);

    // Default method
    default void checkBalance() {
        System.out.println("Checking balance...");
    }
// Static method

    static void printTransaction(String transactionType, double amount) {
        System.out.println("Transaction Type: " + transactionType + ", Amount: " + amount);
    }

}
