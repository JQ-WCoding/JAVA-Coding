package Day070P.SudentSpring;

public class StudentInsert {
    private StudentDAO studentDAO;

    public StudentInsert(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    public void insert(Student student) {
        String id = student.getId();
        if (checkId(id)) {
            studentDAO.insert(student);
        } else {
            System.out.println("중복아이디 입니다.");
        }
    }

    public boolean checkId(String id) {
        Student student = studentDAO.select(id);
        return student == null;
    }
}
