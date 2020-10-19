package SelfWork;

import java.util.Arrays;

public class ArrayEx9 {
    public static void main(String[] args) {
        int[] arr = new int[5];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 5); // 임의 값 중복처리는 불가능
        }
        System.out.println(Arrays.toString(arr));
    }
}
