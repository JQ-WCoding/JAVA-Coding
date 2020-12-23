package Day070P.SudentSpring;

import java.util.HashMap;
import java.util.Map;

public class StudentDAO {
    private Map<String, Student> stDB = new HashMap<>();

    public void insert(Student student) {
        stDB.put(student.getId(), student);
    }

    public Student select(String id) {
        return stDB.get(id);
    }

    public Map<String, Student> getStudentDB() {
        return stDB;
    }
}
