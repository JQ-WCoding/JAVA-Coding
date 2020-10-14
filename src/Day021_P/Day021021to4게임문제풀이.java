package Day021_P;

import java.util.Random;
import java.util.Scanner;

public class Day021021to4게임문제풀이 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rn = new Random();

        int[] arr = new int[4];
        int[] arrCheck = new int[4];
        int[] check = new int[4];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = rn.nextInt(4) + 1;
            arrCheck[i] = arr[i];
            for (int j = 0; j < i; j++) {
                if (arr[i] == arrCheck[j]) {
                    i--;
                }
            }
        }

        int gameNum = 1;
        while (true) {
            for (int j : arr) {
                System.out.print(j + " ");
            }
            System.out.println();

            if (gameNum == 5) {
                break;
            }
            System.out.println("번호 입력하기 : ");

            int myNum = sc.nextInt() - 1;
            if(arr[myNum] == gameNum){
                arr[myNum] = 9;
                gameNum++;
            }
        }
        System.out.println("게임종료");
        sc.close();
    }
}
