package Day054P;

class Subject {
    String name;
    int score;
}

class Student {
    Subject[] subjects;
    String name;
}

public class Day05402클래스배열 {
    public static void main(String[] args) {
        Student[] students = new Student[3];

        students[0] = new Student();
        students[0].subjects = new Subject[3];
        for (int i = 0; i < 3; i++) {
            students[0].subjects[i] = new Subject();
        }
    }
}
