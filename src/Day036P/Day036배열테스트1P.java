package Day036P;

import java.util.Arrays;

public class Day036배열테스트1P {
    public static void main(String[] args) {
        int arr1[] = {10, 20, 30, 40, 50};
        int b[] = {10, 20, 3, 5};

        //문제) arr 안에 b의 값이 있으면 0으로 변경
        // 예) arr = {0,0,30,40,50};
        int size = arr1.length;
        int index = 0;

        int[] temp = new int[size];
        for (int i = 0; i < b.length; i++) {
            temp[index] = b[i];
            index++;
        }
        for (int i = 0; i < size; i++) {
            if (arr1[i] == temp[i]) {
                arr1[i] = 0;
            }
        }
        System.out.println(Arrays.toString(arr1));
    }
}
