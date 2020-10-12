package Day020_P;

import java.util.Random;

public class Day02007미니빙고 {
    public static void main(String[] args) {
        Random rn = new Random();

//        int[] arr = {
//                0, 0, 0,
//                0, 0, 0,
//                3, 3, 3
//        };

        int[][] temp = new int[3][3];

        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                temp[i][j] = rn.nextInt(3) + 1;
            }
        }
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                System.out.print(temp[i][j] + " ");
            }
            System.out.println();
        }
        int count = 0;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i][0] == 3 && temp[i][1] == 3 && temp[i][2] == 3){
                count++;
            }
        }
        if(count == 1){
            System.out.println("1빙고!");
        }
        else if(count == 2){
            System.out.println("2빙고!");
        }
        else if(count == 3){
            System.out.println("3빙고!");
        }
        else{
            System.out.println("꽝!");
        }
    }
}
