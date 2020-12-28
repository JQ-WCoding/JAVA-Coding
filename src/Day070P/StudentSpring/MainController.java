package Day070P.StudentSpring;

import java.util.Scanner;

public class MainController {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] nums = {1001, 1002, 1003, 1004};
        String[] ids = {"qwer", "green", "abcd", "hello"};
        String[] names = {"이만수", "김철수", "이영희", "유재석"};

        StudentController controller = new StudentController();
        StudentInsert insert = controller.getInsert();

        for (int i = 0; i < 4; i++) {
            Student student = new Student(nums[i], ids[i], names[i]);
            insert.insert(student);
        }

        while (true) {
            System.out.println("[1] 추가");
            System.out.println("[2] 삭제");
            System.out.println("[3] 출력");
            System.out.println("[4] 전체출력");

            int choice = scanner.nextInt();

            if (choice == 1) { // 추가
            } else if (choice == 2) { // 삭제
            } else if (choice == 3) { // 출력
                System.out.println("아이디를 입력하세요.");
                String id = scanner.next();

                StudentSelect select = controller.getSelect();
                Student student = select.select(id);
                if (student != null) System.out.println(student);
            } else if (choice == 4) { // 전체출력
                StudentSelectAll selectAll = controller.getSelectAll();
                selectAll.printAll();
            }
        }
    }
}
