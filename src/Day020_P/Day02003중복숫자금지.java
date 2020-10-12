package Day020_P;

import java.util.Random;

public class Day02003중복숫자금지 {
    public static void main(String[] args) {
        Random rn = new Random();

        int[] check = new int[5];
        int[] arr = new int[5];


        for (int i = 0; i < arr.length; i++) {
            arr[i] = rn.nextInt(5);
            check[i] = arr[i];
            for (int j = 0; j < i; j++) {
                if (arr[i] == check[j]){
                    i--;
                }
            }
        }
        for(int j : arr){
            System.out.print(j + " ");
        }
    }
}
