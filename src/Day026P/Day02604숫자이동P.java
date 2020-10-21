package Day026P;

import java.util.Arrays;
import java.util.Scanner;

public class Day02604숫자이동P {
    static void outMeant(){
        System.out.println("이동이 불가능합니다");
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*
         * # 숫자이동[2단계]
         * 1. 숫자 2는 캐릭터이다.
         * 2. 숫자 1을 입력하면, 캐릭터가 왼쪽으로
         *    숫자 2을 입력하면, 캐릭터가 오른쪽으로 이동한다.
         * 3. 단, 좌우 끝에 도달했을 때, 예외처리를 해야한다.
         * 4. 숫자 1은 벽이다. 벽을 만나면 이동할 수 없다.
         * 5. 단, 숫자 3을 입력하면, 벽을 격파할 수 있다.
         */

        int[] game = {0, 0, 1, 0, 2, 0, 0, 1, 0};
        int where = 0; // 나의 위치
        for (int i = 0; i < game.length; i++) {
            if (game[i] == 2) {
                where = i; // 처음 나의 위치를 초기화한다
            }
        }
        while (true) { // 반복문 실행
            System.out.println(Arrays.toString(game));
            System.out.println("좌(1) 우(2)이동 : ");
            int move = scanner.nextInt();
            /*
            좌측이동은 선생님과 코드를 단축해서 수정한 코딩
             */
            if (move == 1) { // 좌로 이동
                if (where == 0) { // 나의 위치가 0이 아닐때 이동가능(좌측 이동 한에서)
                    outMeant();
                    continue;
                }
                if (game[where - 1] == 1) { // 바로 왼쪽 벽이 벽인 경우
                    System.out.println("3을 입력하여 벽을 부십니다");
                    int breakWall = scanner.nextInt();
                    if (breakWall != 3) { // 벽 부시기 3번을 입력한 경우
                        System.out.println("벽을 뚫어주세요");
                        continue;
                    }
                }
                // 위의 조건과 연관성이 없는 경우 (가장 일반적인 이동)
                game[where] = 0;
                where--;
                game[where] = 2;
                /*
                우측이동은 처음 스스로 풀었던 조금 불필요한 부분이 있는 코딩
                 */
            } else if (move == 2) { // 나의 코딩
                if (where != 8) {
                    if (game[where + 1] == 1) { // 바로 왼쪽 벽이 벽인 경우
                        System.out.println("3을 입력하여 벽을 부십니다");
                        int breakWall = scanner.nextInt();
                        if (breakWall == 3) {
                            game[where] = 0;
                            where++; // 우측 이동이기에 +화 시켜야한다
                            game[where] = 2;
                        } else {
                            System.out.println("벽을 뚫어주세요");
                        }
                    } else {
                        game[where] = 0;
                        where++;
                        game[where] = 2;
                    }
                } else {
                    outMeant();
                }
            } else {
                System.out.println("[입력 오류]");
            }
            System.out.println("종료? 1을 입력하면 종료됩니다");
            int end = scanner.nextInt();
            if (end == 1) {
                System.out.println("Game End");
                break;
            }
        }
    }
}
