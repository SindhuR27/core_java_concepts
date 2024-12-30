
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Library library = new Library();

        // Add some books to the library
        library.addBook(new Book(1, "The Great Gatsby"));
        library.addBook(new Book(2, "1984"));
        library.addBook(new Book(3, "To Kill a Mockingbird"));

        // Create members
        Member member1 = new Member(1, "Alice");
        Member member2 = new Member(2, "Bob");

        // Multi-threading for borrowing
        Thread t1 = new Thread(() -> {
            library.borrowBook(member1, 1);
            library.borrowBook(member1, 2);
        });

        Thread t2 = new Thread(() -> {
            library.borrowBook(member2, 1);
            library.borrowBook(member2, 3);
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try (Scanner scanner = new Scanner(System.in)) {
            boolean exit = false;
            
            while (!exit) {
                System.out.println("\nLibrary System Menu:");
                System.out.println("1. View Available Books");
                System.out.println("2. Borrow Book");
                System.out.println("3. Return Book");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                
                switch (choice) {
                    case 1 -> {
                        System.out.println("Available Books:");
                        for (Book book : library.getAvailableBooks()) {
                            System.out.println(book.getId() + ". " + book.getTitle());
                        }
                    }
                    case 2 -> {
                        System.out.print("Enter your Member ID: ");
                        int memberId = scanner.nextInt();
                        System.out.print("Enter Book ID to borrow: ");
                        int bookId = scanner.nextInt();
                        Member member = (memberId == 1) ? member1 : member2;
                        library.borrowBook(member, bookId);
                    }
                    case 3 -> {
                        System.out.print("Enter your Member ID: ");
                        int memberId = scanner.nextInt();
                        System.out.print("Enter Book ID to return: ");
                        int bookId = scanner.nextInt();
                        Member member = (memberId == 1) ? member1 : member2;
                        library.returnBook(member, bookId);
                    }
                    case 4 -> exit = true;
                    default -> System.out.println("Invalid choice. Try again.");
                }
            }
        }
    }
}
