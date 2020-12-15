package Day058P;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class Subject {
    String name;
    int score;
}

class SubjectManager {
    ArrayList<Subject> subjectList;
}

class Student {
    String name;
    int number;
    SubjectManager subjectManager;

    public void studentPrint() {
        System.out.println(number + " : " + name);
    }
}

class StudentManager {
    ArrayList<Student> studentList;
    int logInIndex = -1;

    public String setRandomName() {
        Random random = new Random();
        String name = "";
        String[] name1 = {"김", "이", "박", "최", "정"};
        String[] name2 = {"선", "재", "명", "지", "다"};
        String[] name3 = {"태", "민", "수", "연", "빈"};

        int r = random.nextInt(name1.length);
        name += name1[r];
        r = random.nextInt(name2.length);
        name += name2[r];
        r = random.nextInt(name3.length);
        name += name3[r];

        return name;
    }

    public void init() {
        studentList = new ArrayList<>();
        int num = 1001;
        for (int i = 0; i < 5; i++) {
            Student student = new Student();
            student.name = setRandomName();
            student.number += (num + i);
            studentList.add(student);
        }
    }

    public void printAllStudent() {
        for (int i = 0; i < studentList.size(); i++) {
            studentList.get(i).studentPrint();
        }
    }

    /*
    로그인
     */
    public void logIn() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("이름을 입력하세요 : ");
        String myName = scanner.next();

        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).name.equals(myName)) {
                logInIndex = i;
                System.out.println(myName + "님 환영합니다");
                break;
            }
        }
    }

    /*
    수강 과목 추가
     */
    public void addSubject() {
        if (logInIndex != -1) {

        }else {
            System.out.println("로그인이 필요합니다");
        }
    }

    /*
    과목 삭제
     */
    public void deleteSubject() {
        if (logInIndex != -1){

        }else {
            System.out.println("로그인이 필요합니다");
        }
    }

    /*
    과목 출력
     */
    public void printSubject() {
        if (logInIndex != -1){

        }else {
            System.out.println("로그인이 필요합니다");
        }
    }

    /*
    메인 메뉴
     */
    public void mainSection() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("[1] 로그인");
            System.out.println("[2] 수강과목 추가");
            System.out.println("[3] 수강과목 삭제");
            System.out.println("[4] 수강과목 출력");
            System.out.println("[0] 종료");

            int choice = scanner.nextInt();

            if (choice == 1) { // 로그인
                logIn();
            } else if (choice == 2) { // 과목 추가
                addSubject();
            } else if (choice == 3) { // 과목 삭제
                deleteSubject();
            } else if (choice == 4) { // 과목 출력
                printSubject();
            } else if (choice == 0) {
                System.out.println("프로그램 종료");
                break;
            }
        }
    }
}

public class Day05804수강신청프로그램 {
    public static void main(String[] args) {
        StudentManager studentManager = new StudentManager();
        studentManager.init();
        studentManager.printAllStudent();

        // 기능 추가
        // 1. 로그인( 그냥 이름으로 로그인)
        // 2. 수강과목 추가 삭제 전체출력 등 기능추가( 자바, 파이썬, 씨언어... 등등)
    }
}
