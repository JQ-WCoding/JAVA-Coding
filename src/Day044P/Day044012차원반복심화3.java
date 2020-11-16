package Day044P;

/**
 * # 달팽이
 * 아래와 같이 출력해보세요.
 * <p>
 * 1	2	3	4	5
 * 16	17	18	19	6
 * 15	24	25	20	7
 * 14	23	22	21	8
 * 13	12	11	10	9
 */

public class Day044012차원반복심화3 {
    public static void main(String[] args) {
        int[][] map = new int[5][5];
        /*
        count 는 대입 숫자
        move 는 내가 한칸씩 이동하면서 이동할 방법 -> 가로 세로 한번을 돌고나면 x, y 축이 모두 감소하기때문에 - 부호로 변경을 위해 필요한 변수
         */
        int count = 1, move = 1;
        int y = -1, x = 0;
        int edge = map.length;

        while (true) {
            for (int i = 0; i < edge; i++) {
                y += move;
                map[x][y] = count;
                count++;
            }
            edge--; // 점점 5 4 3 식으로 이동 거리가 줄어든다
            if (edge == 0) { // edge 가장자리가 0 이면 반복문 탈출 더이상 넣을 공간이 없다
                break;
            }
            for (int i = 0; i < edge; i++) {
                x += move;
                map[x][y] = count;
                count++;
            }
            // ㄱ자로 이동이 완료되면 ㄴ자로 이동하기 위해 - 부호가 필요함
            move = -move;
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
}
