package librarysystem;

public class StudentMember extends LibraryMember {

    private String gradeLevel;

    public StudentMember(String memberId, String name, String gradeLevel) {
        super(memberId, name);
        this.gradeLevel = gradeLevel;
    }

    public void attendClass() {
        System.out.println(getName() + " is attending class.");
    }
    // Getters and Setters

    public String getGradeLevel() {
        return gradeLevel;
    }
}
