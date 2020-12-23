package Day070P.SudentSpring;

public class StudentSelect {
    private StudentDAO studentDAO;

    public StudentSelect(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    public Student select(String id) {
        return studentDAO.select(id);
    }
}
