package Day018_P;

import java.util.Arrays;

public class CopyArray {
    public static void main(String[] args) {
        int[] a = {10, 30, 50};
        int[] b = {20, 40, 60};
        int[] c = new int[6];
        int temp = 0;
        for (int i = 0; i < a.length; i++) {
            c[temp] = a[i];
            c[temp + 1] = b[i];
            temp += 2;
        }
        // ':' 콜론은 해당 배열만큼을 가져올 수 있는 기능
        for (int j : c) {
            System.out.print(j + " ");
        }
        System.out.println();
        // 끝자리 값 100으로 바꾸기
        int[] d = {10, 20, 30, 40, 50, 60};
        int[] e;
        e = Arrays.copyOfRange(d, 0, d.length);
        e[d.length - 1] = 100;
        for (int j : e) {
            System.out.print(j + " ");
        }
        System.out.println();

//        // 뒷부분부터 정렬
//        int[] f = new int[6];
//        // 배열 역순은 안됨
//        f = Arrays.copyOfRange(d, d.length, 0);
//        for (int j : f) {
//            System.out.print(j + " ");
//        }
//        System.out.println();
    }
}
