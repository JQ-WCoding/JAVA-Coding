package Day036P;

import java.util.Arrays;

public class Day036배열테스트2P {
    public static void main(String[] args) {
        int arr[][] = {
                {10, 20, 30},
                {40, 50, 60},
                {70, 80, 90},
        };
        int temp[] = {10, 2, 54, 90, 50};
        // temp 에 arr의 값이 있으면 0으로 변경

        //예) temp ==> {0,2,54,0,0}

        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                for (int z = 0; z < arr[j].length; z++) {
                    if (temp[i] == arr[j][z]) {
                        temp[i] = 0;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(temp));

    }
}
