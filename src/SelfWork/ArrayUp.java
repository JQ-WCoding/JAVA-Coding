package SelfWork;

import java.util.Arrays;

public class ArrayUp {
    public static void main(String[] args) {
        int[] arr = {10, 30, 40, 20, 70, 60, 50};
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
