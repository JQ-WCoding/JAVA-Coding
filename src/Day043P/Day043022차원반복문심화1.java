package Day043P;

/**
 * # 2차원 반복문 : 아래와 같이 출력해보자.
 * 1   2  3  4  5
 * 10  9  8  7  6
 * 11 12 13 14 15
 * 20 19 18 17 16
 * 21 22 23 24 25
 */
public class Day043022차원반복문심화1 {
    public static void main(String[] args) {
        int[][] temp = new int[5][5];
        int count = 1;
        for (int i = 0; i < temp.length; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < temp[i].length; j++) {
                    temp[i][j]++;
                    count++;
                }
            } else {
                for (int j = temp[i].length - 1; j >= 0; j--) {
                    temp[i][j] = count;
                    count++;
                }
            }
        }

        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                System.out.print(temp[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
