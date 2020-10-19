package Day025_P;

import java.util.Arrays;
import java.util.Random;

public class Day02507중복숫자금지1P {
    public static void main(String[] args) {
        Random random = new Random();
        // 0 ~ 4의 랜덤숫자 5개를 중복없이 arr 배열에 저장

        int[] arr = new int[5];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(5) + 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] == arr[j]) {
                    i--;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
