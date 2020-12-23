package Day070P.SudentSpring;

import java.util.Iterator;
import java.util.Map;

public class StudentSelectAll {
    private StudentDAO studentDAO;

    public StudentSelectAll(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    public void printAll() {
        Map<String, Student> map = studentDAO.getStudentDB();

        /*
        for문으로 출력
        for(String key : map.keySet()){
        System.out.println(map.get(key));
        }
         */

        // while문으로 출력
        Iterator<String> keys = map.keySet().iterator();
        while (keys.hasNext()) {
            String key = keys.next();
            System.out.println(map.get(key));
        }
    }
}
