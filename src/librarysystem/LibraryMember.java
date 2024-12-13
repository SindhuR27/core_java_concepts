package librarysystem;
public class LibraryMember {

    private String memberId;
    private String name;

    public LibraryMember(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }

    public void borrowBook() {
        System.out.println(name + " is borrowing a book.");
    }

    public String getMemberId() {
        return memberId;
        }
        public String getName() {
        return name;
        }
}
