package Day026P;

import java.util.Arrays;
import java.util.Random;

public class RandomNumberPrint {
    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = new int[5];
        int maxPrint = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(10) + 1;
            if (arr[i] > maxPrint) {
                maxPrint = arr[i];
            }
        }
        System.out.println(Arrays.toString(arr));
        int[][] newArr = new int[maxPrint][arr.length]; // [5][Random]
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < maxPrint - arr[i]; j++) {
                newArr[j][i] = 1;
            }
        }
//        for (int i = 0; i < maxPrint; i++) {
//            for (int j = 0; j < arr.length; j++) {
//                System.out.print(newArr[i][j]);
//            }
//            System.out.println();
//        }
        for (int i = 0; i < maxPrint; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (newArr[i][j] == 0){
                    System.out.print("*");
                }
                else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
