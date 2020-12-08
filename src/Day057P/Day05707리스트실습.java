package Day057P;

import java.util.ArrayList;

class Student {
    String id;
    String pw;

    public void setData(String id, String pw) {
        this.id = id;
        this.pw = pw;
    }

    public void printData() {
        System.out.println("ID : " + id + " / PW : " + pw);
    }
}

class Manager {
    ArrayList<Student> list = new ArrayList<>();

    public void addStudent(Student student) {
        list.add(student);
    }

    public Student removeStudent(int index) {
        Student delStudent = list.get(index);
        list.remove(index);
        return delStudent;
    }

    public int checkId(Student student) {
        int check = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).id.equals(student.id)) {
                check = i;
                break;
            }
        }
        return check;
    }

    public void printStudent() {
        for (int i = 0; i < list.size(); i++) {
            list.get(i).printData();
        }
    }

    public String outData() {
        String data = "";
        int count = list.size();
        if (count == 0) {
            return data;
        }
        data += count;
        data += "\n";

        for (int i = 0; i < count; i++) {
            data = data + list.get(i).id;
            data = data + ",";
            data = data + list.get(i).pw;
            if (count - 1 != i) {
                data = data + "\n";
            }
        }
        return data;
    }

    public void loadData(ArrayList<Student> list) {
        this.list = list;
    }

    int getSize(){
        return list.size();
    }

    // 배열 정렬
    void sortData(){

    }
}

public class Day05707리스트실습 {
}
