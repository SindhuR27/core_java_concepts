package librarysystem;

import java.util.concurrent.CountDownLatch;

public class BookReturnTask implements Runnable {
    private CountDownLatch latch;
    private String bookTitle;

    public BookReturnTask(CountDownLatch latch, String bookTitle) {
        this.latch = latch;
        this.bookTitle = bookTitle;
    }

    @Override
    public void run() {
        System.out.println(bookTitle + " is being returned");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Return interrupted: " + e.getMessage());
        }
        latch.countDown();
        System.out.println(bookTitle + " has been returned.");
    }
}
