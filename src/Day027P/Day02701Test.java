package Day027P;

import java.util.Arrays;

public class Day02701Test {
    public static void main(String[] args) {


        int arr[] = {10, 20, 30, 40, 50};
        int temp1[] = new int[5];
        int temp2[] = new int[5];
        int temp3[] = new int[5];
        //문제1) arr 의 값을 temp1 에  복사후 출력
        // temp1 ==> {10, 20, 30, 40, 50}
        for (int i = 0; i < arr.length; i++) {
            temp1[i] = arr[i];
        }
//        System.arraycopy(arr, 0, temp1, 0, arr.length);
        System.out.println(Arrays.toString(temp1));
        //문제2) arr 의 값의 2배를 temp2에 복사후 출력
        // temp2 ==> {20, 40, 60, 80 , 100}
        for (int i = 0; i < arr.length; i++) {
            temp2[i] = arr[i] * 2;
        }
        System.out.println(Arrays.toString(temp2));

        //문제3) arr 의 값에 i를 더한값을 temp3 에 복사후 출력
        // temp3 ==> {10,21,32,43,54}
        for (int i = 0; i < arr.length; i++) {
            temp3[i] = arr[i] + i;
        }
        System.out.println(Arrays.toString(temp3));
        //문제4) arr의 값중 4의 배수만 b에 거꾸로저장
        // 예) b = {0,0,0,40,20};
        int[] b = new int[5];
        int tempIndex = arr.length - 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 4 == 0) {
                b[tempIndex] = arr[i];
                tempIndex--;
            }
        }
        System.out.println(Arrays.toString(b));
    }
}
