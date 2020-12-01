package Day054P;

import java.util.Scanner;

/**
 * # 학생 추가 삭제 컨트롤러
 * => 컨트롤러를 완성해 아래 3개의 정보를 추가하시오.
 * 김철수 : 과목3개 수학50 국어50 영어60
 * 이만수 : 과목2개 수학20 국어30
 * 이영희 : 과목1개 수학100
 */
public class Day05403클래스배열학생컨트롤러 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Student[] students = new Student[3];
        int count = 0; // 학생수

        while (true) {
            // [1] 이름 입력받아 이름만 추가
            System.out.println("[1] 학생 추가하기");
            // [2] 이름과 추가할 과목 수를 입력
            // 입력 받은 과목 수 만큼 과목명만 입력받아 추가
            System.out.println("[2] 과목 추가하기");
            // [3] 이름과 과목명을 입력받아 성적을 저장한다
            System.out.println("[3] 성적 추가하기");
            System.out.println("[4] 확인하기");
            System.out.println("[0] 종료");
            int choice = scanner.nextInt();
            if (choice == 1) {
                if (count < 3) {
                    students[count] = new Student();
                    System.out.print("이름을 입력하세요 : ");
                    students[count].name = scanner.next();
                    count++;
                } else {
                    System.out.println("Full");
                }
            } else if (choice == 2) {
                System.out.print("추가과목의 학생 이름을 입력하세요 : ");
                String studentName = scanner.next();
                int index = -1;
                for (int i = 0; i < count; i++) {
                    if (studentName.equals(students[i].name)) {
                        index = i;
                        break;
                    }
                }
                System.out.print("추가할 과목 수를 입력하세요 : ");
                int subjectCount = scanner.nextInt();
                students[index].subjects = new Subject[subjectCount];
                for (int i = 0; i < subjectCount; i++) {
                    students[index].subjects[i] = new Subject();
                }
                System.out.print("입력할 과목을 작성하세요(구분은 ,를 이용한다) : ");
                String mySubjects = scanner.next();

                String[] eachSubject = mySubjects.split(",");
                for (int i = 0; i < subjectCount; i++) {
                    eachSubject[i] = eachSubject[i].trim(); // 띄어쓰기 지우기
                    students[index].subjects[i].name = eachSubject[i];
                }
            } else if (choice == 3) {
                System.out.print("이름을 입력하세요 : ");
                String myName = scanner.next();
                int index = -1;
                for (int i = 0; i < count; i++) {
                    if (myName.equals(students[i].name)) {
                        index = i;
                        break;
                    }
                }
                System.out.print("추가할 성적의 과목명을 입력하세요 : ");
                String whichSubject = scanner.next();
                int index2 = -1;
                for (int i = 0; i < students[index].subjects.length; i++) {
                    if (whichSubject.equals(students[index].subjects[i].name)) {
                        index2 = i;
                        break;
                    }
                }
                System.out.print("성적을 입력하세요 : ");
                students[index].subjects[index2].score = scanner.nextInt();
            } else if (choice == 4) {
                System.out.print("이름을 입력하세요 : ");
                String myName = scanner.next();
                int index = -1;
                for (int i = 0; i < count; i++) {
                    if (myName.equals(students[i].name)) {
                        index = i;
                        break;
                    }
                }
                System.out.println(students[index].name + "학생의 성적 : ");
                for (int i = 0; i < students[index].subjects.length; i++) {
                    System.out.printf("%s : %d점 \t", students[index].subjects[i].name, students[index].subjects[i].score);
                }
                System.out.println();
            } else if (choice == 0) {
                System.out.println("종료");
                break;
            }
        }
    }
}
