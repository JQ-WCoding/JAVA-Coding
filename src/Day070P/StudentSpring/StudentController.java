package Day070P.StudentSpring;

public class StudentController {
    private StudentDAO studentDAO;
    private StudentInsert insert;
    private StudentSelect select;
    private StudentSelectAll selectAll;

    public StudentController() {
        studentDAO = new StudentDAO();
        insert = new StudentInsert(studentDAO);
        select = new StudentSelect(studentDAO);
        selectAll = new StudentSelectAll(studentDAO);
    }

    public StudentDAO getStudentDAO() {
        return studentDAO;
    }

    public void setStudentDAO(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    public StudentInsert getInsert() {
        return insert;
    }

    public void setInsert(StudentInsert insert) {
        this.insert = insert;
    }

    public StudentSelect getSelect() {
        return select;
    }

    public void setSelect(StudentSelect select) {
        this.select = select;
    }

    public StudentSelectAll getSelectAll() {
        return selectAll;
    }

    public void setSelectAll(StudentSelectAll selectAll) {
        this.selectAll = selectAll;
    }
}
