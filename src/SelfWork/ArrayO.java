package SelfWork;

import java.util.Arrays;

public class ArrayO {
    public static void main(String[] args) {
        int arr[] = {30, 20, 50, 40, 10};

        int minCheck = 100;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < minCheck){
                minCheck = arr[i];

            }
        }

        System.out.println(Arrays.toString(arr)); // [10,20,30,40,50]
    }
}
