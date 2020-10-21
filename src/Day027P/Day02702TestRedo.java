package Day027P;

import java.util.Arrays;

public class Day02702TestRedo {
    public static void main(String[] args) {
        int arr[] = {0, 2, 0, 3, 4, 0, 0, 5, 0};

//        int leftIndex = 0;
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] != 0) {
//                arr[leftIndex] = arr[i];
//                arr[i] = 0;
//                leftIndex++;
//            }
//        }
//        System.out.println(Arrays.toString(arr));
        int rightIndex = arr.length - 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] != 0) {
                arr[rightIndex] = arr[i];
                arr[i] = 0;
                rightIndex--;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
