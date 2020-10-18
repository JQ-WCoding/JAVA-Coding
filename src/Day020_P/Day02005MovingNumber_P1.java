package Day020_P;

import java.util.Arrays;
import java.util.Scanner;

public class Day02005MovingNumber_P1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*
         * # 숫자이동[1단계]
         * 1. 숫자2는 캐릭터이다.
         * 2. 숫자1을 입력하면, 캐릭터가 왼쪽으로
         * 	    숫자2를 입력하면, 캐릭터가 오른쪽으로 이동한다.
         * 3. 단, 좌우 끝에 도달했을 때, 예외처리를 해야한다.
         */
        int[] game = {0, 0, 0, 0, 2, 0, 0, 0}; // game 배열

        while (true) { // 게임 시작
            System.out.println("현재 상황 : ");
            System.out.println(Arrays.toString(game));
            System.out.println("어떤 방향으로 이동? (1. 왼쪽 / 2. 오른쪽)");
            int move = scanner.nextInt(); // 캐릭터 이동 입력받기
            int player = 0;
            for (int i = 0; i < game.length; i++) {
                if (game[i] == 2) {
                    player = i;
                }
            }
            switch (move) {
                /*
                캐릭터의 왼쪽 이동 상황
                index를 찾아 그 전의 index 번호의 값과 변경해준다
                 */
                case 1:
                    if (player != 0) {
                        game[player] = 0;
                        player--;
                        game[player] = 2;
                    } else {
                        System.out.println("더이상 움직일 수 없습니다");
                    }
                    break;
                case 2:
                    if (player != game.length - 1) {
                        game[player] = 0;
                        player++;
                        game[player] = 2;
                    } else {
                        System.out.println("더이상 움직일 수 없습니다");
                    }
                    break;
                default:
                    System.out.println("잘못 입력하였습니다.");
                    break;
            }
            System.out.println("계속? 1) Go / 0) Out!");
            int check = scanner.nextInt();
            if (check == 0){
                break;
            }
        }

    }
}
