public class Book {
    private int id;
    private String title;
    private boolean isAvailable;

    public Book(int id, String title) {
        this.id = id;
        this.title = title;
        this.isAvailable = true;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
