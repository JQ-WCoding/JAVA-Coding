package Day034P;

import java.util.Scanner;

/**
 * 가운데 숫자를 맞추는 게임
 */
public class Day03401가운데숫자찾기P2 {
    Scanner scanner = new Scanner(System.in);

    /*
    내가 선택한 숫자 입력받기
     */
    public int insertMyNum() {
        System.out.print("숫자를 입력하세요 : ");
        return scanner.nextInt();
    }

    public void mainGame() {
        int div = 1;
        int count = 0;
        int myNum = insertMyNum();
        // 몇자리 수인지 확인하기
        while (myNum / div != 0) {
            count++;
            div *= 10;
        }
        System.out.println(count);
        // 새 배열 선언
        int[] arr = new int[count];
        for (int i = 0; i < count; i++) {
            div /= 10;
            arr[i] = myNum / div;
            myNum %= div;
        }
        if (count % 2 == 0) {
            System.out.println("짝수의 자리");
        } else {
            System.out.println("가운데 자리 수 : " + arr[count / 2]);
        }
    }

    public static void main(String[] args) {
        Day03401가운데숫자찾기P2 middleNumber = new Day03401가운데숫자찾기P2();
        middleNumber.mainGame();
    }
}
