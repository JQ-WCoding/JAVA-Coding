package Day052P;

import java.util.Arrays;

class Ex05 {
    // Q1 4의 배수의 개수를 리턴해주는 메서드
    int countMultiple(int[] arr) {
        int count = 0;
        for (int i : arr) {
            if (i % 4 == 0) {
                count++;
            }
        }
        return count;
    }

    int[] countMultipleArray(int[] arr) {
        int count = countMultiple(arr);
        int[] temp = new int[count];

        count = 0;
        for (int i : arr) {
            if (i % 4 == 0) {
                temp[count] = i;
                count++;
            }
        }
        return temp;
    }

    void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}

public class Day05203메서드문제 {
    public static void main(String[] args) {
        Ex05 ex = new Ex05();
        int[] arr = {87, 12, 21, 56, 100};

        System.out.println(ex.countMultiple(arr) + "개");

//        int[] temp = ex.countMultipleArray(arr);
//        ex.print(temp);
        ex.print(ex.countMultipleArray(arr));
    }
}
