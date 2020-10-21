package Day026P;

import java.util.Arrays;
import java.util.Random;

public class Day02605중복숫자금지P {
    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = new int[5];

        for (int i = 0; i < arr.length; i++) {
            int check = 1;
            int r = random.nextInt(10) + 1;
            for (int j = 0; j < i; j++) {
                if (r == arr[j]) {
                    check = -1;
                }
            }
            if (check != -1) {
                arr[i] = r;
            } else {
                i--;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
