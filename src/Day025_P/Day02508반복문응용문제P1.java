package Day025_P;

import java.util.Scanner;

public class Day02508반복문응용문제P1 {
    /**
     * # [반복문 응용문제]
     * 1. -1이 나올 때까지 일련의 수를 입력받는다.
     * 2. 위의 수 중 key값이 몇번째 포함되어 있는가를 출력한다.
     * 3. 단, key가 여러개 포함되어 있을 경우
     * 앞에 나타난 것의 위치를 출력한다.(*)
     * 4. key가 일련의 수 안에 없는 경우 "not found"를 출력한다.
     * 예) key값 입력 : 93
     * 입력 : 10
     * 입력 : 93
     * 입력 : 20
     * 입력 : 93
     * 입력 : 93
     * 입력 : -1				// 정답 : 2
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int breakNum = -1;
        System.out.println("Key 숫자를 입력하세요 : ");
        int keyNum = scanner.nextInt();
        int index = 0;
        int turn = 0;
        int count = 0;
        while (true) {
            System.out.print("입력 : ");
            int insertNum = scanner.nextInt();
            if (insertNum == keyNum && count == 0) {
                    index = turn;
                    count++;
            }
            if (insertNum == breakNum) {
                if (index != 0) {
                    System.out.println(index);
                } else {
                    System.out.println("not Found");
                }
                System.out.println("프로그램 종료");
                break;
            }
            turn++;
        }

    }
}
