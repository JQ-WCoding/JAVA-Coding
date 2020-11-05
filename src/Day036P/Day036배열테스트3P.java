package Day036P;

import java.util.Arrays;
import java.util.Scanner;

public class Day036배열테스트3P {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int data[] = {5, 5, 6, 8, 2, 6};

        // 값을 입력받고 삭제
        // 조건) 만약에 같은값이 있으면 전부 삭제
        // 예) 2 ==> 5,5,6,8,6
        // 예) 5 ==> 6,8,2,6
        int dataSize = data.length;

        System.out.println("값을 입력하세요 : ");
        int myNum = scanner.nextInt();
        int check = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == myNum) {
                check++;
            }
        }
        int[] newData = new int[dataSize - check];
        int index = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] != myNum) {
                newData[index] = data[i];
                index++;
            }
        }
        System.out.println(Arrays.toString(newData));
    }
}
