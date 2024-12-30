import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> getAvailableBooks() {
        List<Book> availableBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.isAvailable()) {
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }

    public synchronized boolean borrowBook(Member member, int bookId) {
        if (!member.canBorrow()) {
            System.out.println(member.getName() + " cannot borrow more than 2 books.");
            return false;
        }

        for (Book book : books) {
            if (book.getId() == bookId && book.isAvailable()) {
                book.setAvailable(false);
                member.borrowBook(book);
                System.out.println(member.getName() + " borrowed \"" + book.getTitle() + "\".");
                return true;
            }
        }
        System.out.println("Book not available or invalid ID.");
        return false;
    }

    public synchronized void returnBook(Member member, int bookId) {
        for (Book book : member.getBorrowedBooks()) {
            if (book.getId() == bookId) {
                book.setAvailable(true);
                member.returnBook(book);
                System.out.println(member.getName() + " returned \"" + book.getTitle() + "\".");
                return;
            }
        }
        System.out.println("Book not found in borrowed list.");
    }
}
