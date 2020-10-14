package Day022_P;

import java.util.Scanner;

/*
1. gameNum의 값과 일치하는 인덱스를 입력받는다.
2. 일치하면 gameNum의 값은 1증가한다.
3. gameNum의 값이 16이 되면 프로그램은 종료한다.
 */
public class Day02202복습문제 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int gameNum = 11;
        int[] game = {15, 12, 11, 13, 14};

        while (true) {
            for (int j : game) {
                System.out.print(j + " ");
            }
            System.out.println();
            System.out.println(gameNum + "의 번호는 몇번째에 있습니까 ? :");
            int myPick = sc.nextInt() - 1;
            for (int i = 0; i < game.length; i++) {
                if (gameNum == game[i]) {
                    if (myPick == i) {
                        game[i] = 0;
                        gameNum++;
                    }
                    else {
                        System.out.println("기입오류");
                        break;
                    }
                }
            }
            if (gameNum > 15) {
                System.out.println("게임종료");
                break;
            }
        }
    }
}
