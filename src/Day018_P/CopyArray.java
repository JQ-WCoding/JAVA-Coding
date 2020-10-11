package Day018_P;

import java.util.Arrays;

public class CopyArray {
    public static void main(String[] args) {
        int[] a = {10, 30, 50};
        int[] b = {20, 40, 60};
        int[] c = new int[6];
        int temp = 0;
        for (int i = 0; i < a.length; i ++) {
            c[temp] = a[i];
            c[temp + 1] = b[i];
            temp += 2;
        }
        for (int j : c) {
            System.out.print(j + " ");
        }
    }
}
