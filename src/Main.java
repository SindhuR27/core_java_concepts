
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import librarysystem.BankTransaction;

public class Main {

    public static void main(String[] args) {
        // StudentMember student = new StudentMember("S001", "Alice", "Grade 10");
        // student.borrowBook();
        // student.attendClass();

        // BankAccount account = new BankAccount(1000);
        // SavingsAccount savings = new SavingsAccount(1000, 5);
        // account.deposit(500);
        // savings.deposit(500);
        // System.out.println("BankAccount balance: " + account.getBalance());
        // System.out.println("SavingsAccount balance: "
        //         + savings.getBalance());
        // FacultyMember faculty = new FacultyMember("F001", "Dr. Smith",
        //         "Computer Science");
        // faculty.borrowBook(); // Calls overridden borrowBook method in FacultyMember
        // SavingsAccount savings = new SavingsAccount(1000, 5);
        // CurrentAccount current = new CurrentAccount(500, 1000);
        // savings.deposit(500);
        // current.withdraw(700);
        // System.out.println("Savings Account Balance: " + savings.getBalance());
        // System.out.println("Current Account Balance: " + current.getBalance());

        // Map<String, String> books = new HashMap<>();
        // books.put("Effective Java", "Joshua Bloch");
        // books.put("Java Concurrency in Practice", "Brian Goetz");
        // books.put("Clean code", "Robert C. Martin");
        // System.out.println("Books in the library:");
        // for (Map.Entry<String, String> entry : books.entrySet()) {
        //     System.out.println("Title: " + entry.getKey() + ", Author: " + 
        //     entry.getValue());
        // };
        // String title = "Effective Java";
        // if(books.containsKey(title)) {
        //     System.out.println("The author of " + title + " is "+ books.get(title));
        // }
        // else {
        //     System.out.println(title + " is not in the library.");
        //     }
        
    //     String inputFile = "src/books.txt";
    //     String outputFile = "book_titles.txt";

    //     try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
    //         BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

    //         String line;
    //         while ((line = reader.readLine()) != null) {
    //             String[] bookdetails = line.split(",");
    //             String title = bookdetails[0];
    //             writer.write(title);
    //             writer.newLine();
    //             System.out.println("Book titles have been written to " + outputFile);
    //         }
    // } catch (IOException e) {
    //     System.out.println("An error occurred: " + e.getMessage());
    // }

    // String sourceFile = "bank_logo.jpg";
    // String destinationFile = "backup_bank_logo.jpg";

    // try (FileInputStream fis = new FileInputStream(sourceFile);
    // FileOutputStream fos = new FileOutputStream(destinationFile)) {
    //     byte[] buffer = new byte[1024];
    //     int bytesRead;
    //     while((bytesRead = fis.read(buffer)) != -1) {
    //         fos.write(buffer, 0, bytesRead);
    //     }
    //     System.out.println("File copied successfully to " + destinationFile);
    // }
    // catch (IOException e) {
    //     System.out.println("An error occurred: " + e.getMessage());
    //     }

    // BankAccount account = new BankAccount(1000);
    // Thread teller1 = new Thread(new BankTransaction(account, "Deposit", 500), "Teller 1");
    // Thread teller2 = new Thread(new BankTransaction(account, "Withdraw", 700), "Teller 2");

    // teller1.start();
    // teller2.start();

    // CountDownLatch latch = new CountDownLatch(3);

    // Thread returnBook1 = new Thread(new BookReturnTask(latch, "Effective Java"));
    // Thread returnBook2 = new Thread(new BookReturnTask(latch, "Clean Code"));
    // Thread returnBook3 = new Thread(new BookReturnTask(latch, "Java Concurrency in Practice"));

    // returnBook1.start();
    // returnBook2.start();
    // returnBook3.start();

    // try {
    //     latch.await();
    //     System.out.println("All books have been returned. Library is closing");
    // } catch (InterruptedException e) {
    //     System.out.println("Interrupted while waiting: " + e.getMessage());
    // }

    ExecutorService executor = Executors.newFixedThreadPool(3);
    executor.submit(new BankTransaction("Deposit", 1000));
    executor.submit(new BankTransaction("Withdraw", 500));
    executor.submit(new BankTransaction("Deposit", 2000));
    executor.submit(new BankTransaction("Withdraw", 1500));
    executor.submit(new BankTransaction("Deposit", 3000));

    executor.shutdown();
}
}
