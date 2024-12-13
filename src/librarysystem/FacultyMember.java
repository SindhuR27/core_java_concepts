package librarysystem;

public class FacultyMember extends LibraryMember {

    private String department;

    public FacultyMember(String memberId, String name, String department) {
        super(memberId, name); // Calls the superclass constructor
        this.department = department;
    }

    @Override
    public void borrowBook() {
        super.borrowBook(); // Calls the superclass method
        System.out.println(getName() + " from " + department + " department is borrowing a research paper.");
    }
    // Getters and Setters

    public String getDepartment() {
        return department;
    }
}
