package Day036P;

import java.util.Arrays;
import java.util.Scanner;

public class Day036배열테스트4P {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int game[] = {0, 0, 0, 2, 8, 4, 0, 4, 0};

        // 1)left , 2)right

        //문제)번호를 입력받고 각방향으로 숫자를모으시요.
        //조건) 만약에 같은숫자2개가 붙었을경우는 서로 더해진다.
        // 아래 2단계출력
        //예) left
        //      1단계 :  {2,2,8,4,0,0,0,0,0};
        //      2단계 :  {4,8,4,0,0,0,0,0,0}; 2가 2개붙었으니 4가된다.

        //힌트)
        //우선 0이 아닌 숫자를 밀어낸다.		{2,2,8,4,0,0,0,0,0}
        //같은 숫자끼리 더한다.				{4,0,8,4,0,0,0,0,0}
        //다시 0이 아닌 숫자를 밀어낸다.		{4,8,4,0,0,0,0,0,0}

        while (true) {
            System.out.println("1) left  2) right  이동 / 0) 종료");
            int move = scanner.nextInt();
            /*
            좌측 이동
            0이 아닌경우 숫자를 확인하고 우측 자리 숫자와 동일 할 경우 두 합으로 입력 후 뒷 번호 0으로 초기화
             */
            if (move == 1) {
                int index = 0;
                // 자리 이동
                for (int i = 0; i < game.length; i++) {
                    if (game[i] != 0) {
                        game[index] = game[i];
                        if (index != i) { // 서로 수들이 붙어있는 경우 0으로 초기화 하면 안된당
                            game[i] = 0;
                        }
                        index++;
                    }
                }
                for (int i = 0; i < index; i++) {
                    if (game[i] == game[i + 1]) {
                        game[i] = game[i] + game[i + 1]; // 합
                        game[i + 1] = 0;
                    }
                }
                int secondIndex = 0;
                for (int i = 0; i < game.length; i++) {
                    if (game[i] != 0) {
                        game[secondIndex] = game[i];
                        if (secondIndex != i) { // 서로 수들이 붙어있는 경우 0으로 초기화 하면 안된당
                            game[i] = 0;
                        }
                        secondIndex++;
                    }
                }
                System.out.println(Arrays.toString(game));
            }
            /*
            우측 이동
             */
            else if (move == 2) {
                int index = game.length - 1;
                for (int i = game.length - 1; i >= 0; i--) {
                    if (game[i] != 0) {
                        game[index] = game[i];
                        if (index != i) {
                            game[i] = 0;
                        }
                        index--;
                    }
                }
                for (int i = game.length - 1; i >= index; i--) {
                    if (game[i] == game[i - 1]) {
                        game[i] = game[i] + game[i - 1]; // 합
                        game[i - 1] = 0;
                    }
                }
                int secondIndex = game.length - 1;
                for (int i = game.length - 1; i >= 0; i--) {
                    if (game[i] != 0) {
                        game[secondIndex] = game[i];
                        if (secondIndex != i) { // 서로 수들이 붙어있는 경우 0으로 초기화 하면 안된당
                            game[i] = 0;
                        }
                        secondIndex--;
                    }
                }
                System.out.println(Arrays.toString(game));
            }
            else if (move == 0){
                System.out.println("게임 종료");
                break;
            }
            else {
                System.out.println("입력 오류");
            }
        }
    }
}
