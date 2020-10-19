package SelfWork;

import java.util.Arrays;
import java.util.Random;

public class Shuffle {
    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = new int[4];
        //shuffle
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(4) + 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] == arr[j]) {
                    i--;
                }
            }
        }
        System.out.println(Arrays.toString(arr));

        //New Shuffle
        int[] newArr = new int[10];
        for (int i = 0; i < newArr.length; i++) {
            int count = 0;
            newArr[i] = random.nextInt(5) + 1;
            for (int j = 0; j < i; j++) {
                if (newArr[i] == newArr[j]) {
                    count++;
                }
            }
            if (count == 2){
                i--;
            }
        }
        System.out.println(Arrays.toString(newArr));
    }
}
