package Day030P;

public class Day03004P1 {
    public static void main(String[] args) {
        int[][] arr = new int[3][3];

        int k = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = 10 * k;
                k += 1;
            }
        }

        // 문제 1) 인덱스 2개를 입력받아 값 출력
        // 예    1) 인덱스1 입력 : 1	인덱스2 입력 : 2
        //		   값 출력 : 60
        int index1 = 1, index2 = 2;
        System.out.println(arr[index1][index2]);
        // 문제 2) 값을 입력받아 인덱스 2개 출력
        // 예    2) 값 입력 : 60
        //		   인덱스1 출력 : 1	인덱스2 출력 : 2
        int value = 60;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == value) {
                    System.out.println(i + " " + j);
                }
            }
        }
        // 문제 3) 가장 큰 값의 인덱스 2개 출력
        // 정답 3) 2 2
        int maxNum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (maxNum < arr[i][j]) {
                    maxNum = arr[i][j];
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (maxNum == arr[i][j]) {
                    System.out.println(i + " " + j);
                    break;
                }
            }
        }
        // 문제 4) 값 2개를 입력받아 값 교체
        int value1 = 30;
        int value2 = 60;
        index1 = 0;
        index2 = 0;
        int index3 = 0, index4 = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (value1 == arr[i][j]) {
                    index1 = i;
                    index2 = j;
                }
                if (value2 == arr[i][j]) {
                    index3 = i;
                    index4 = j;
                }
            }
        }
//        int temp = arr[index1][index2];
//        arr[index1][index2] = arr[index3][index4];
//        arr[index3][index4] = temp;
        arr[index1][index2] = value2;
        arr[index3][index4] = value1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
