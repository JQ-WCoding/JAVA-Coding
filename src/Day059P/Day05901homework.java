package Day059P;

import java.util.Scanner;

class Student {
    String name;
    int age;

    public void print() {
        System.out.println(name + " : " + age);
    }
}

class StudentManager {
    Scanner scanner = new Scanner(System.in);
    Student[] students;
    int count = 0;

    public void main() {
        while (true) {
            showMenu();
            int choice = scanner.nextInt();
            if (choice == 1) { // 추가 기능
                addStudents();
            } else if (choice == 2) { // 삭제 기능
                deleteStudents();
            } else if (choice == 3) { // 나이 순으로 정렬
                sort();
            } else if (choice == 0) { // 프로그램 종료
                endProgram();
                break;
            }
        }
    }

    /**
     * 프로그램 종료
     */
    public void endProgram() {
        System.out.println("프로그램 종료");
    }

    /**
     * 나이 순 정렬하기
     */
    public void sort() {
        for (int i = 0; i < count; i++) {
            int min = students[i].age;
            int index = -1;
            for (int j = i; j < count; j++) {
                if (min > students[j].age) {
                    min = students[i].age;
                    index = j;
                }
            }
            if (index != -1) {
                Student temp = students[i];
                students[i] = students[index];
                students[index] = temp;
            }
        }
        for (int i = 0; i < count; i++) {
            students[i].print();
        }
    }

    /**
     * 삭제 기능
     */
    public void deleteStudents() {
        System.out.println("이름을 입력하세요 : ");
        String myName = scanner.next();

        int index = -1;
        for (int i = 0; i < count; i++) {
            if (myName.equals(students[i].name)) {
                index = i;
            }
        }
        if (index != -1) {
            Student[] temp = new Student[count - 1];
            int tempCount = 0;
            for (int i = 0; i < count; i++) {
                if (index != i) {
                    temp[tempCount] = students[i];
                    tempCount++;
                }
            }
            count--;
            students = temp;
        }
    }

    /**
     * 추가 기능
     */
    public void addStudents() {
        Student[] temp = students;
        students = new Student[count + 1];
        System.out.println("이름을 입력하세요 : ");
        String myName = scanner.next();
        System.out.println("나이를 입력하세요 : ");
        int myAge = scanner.nextInt();
        if (count > 0) {
            for (int i = 0; i < count; i++) {
                students[i] = temp[i];
            }
        }
        students[count] = new Student();

        students[count].name = myName;
        students[count].age = myAge;

        count++;
    }

    /**
     * 메뉴 출력
     */
    public void showMenu() {
        System.out.println("[1]추가");    // 이름, 나이 입력받아 학생 추가
        System.out.println("[2]삭제");    // 이름 입력받아 학생 삭제
        System.out.println("[3]정렬");    // 성적 순으로 정렬
        System.out.println("[0]종료");
    }
}

public class Day05901homework {
    public static void main(String[] args) {
        StudentManager studentManager = new StudentManager();
        studentManager.main();
    }
}
