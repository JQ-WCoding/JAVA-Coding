package Day020_P;

import java.util.Scanner;

public class Day02005숫자이동 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 캐릭터 '8'
        //좌(1) 우(2)
        int[] game = {0, 0, 0, 4, 0, 0, 0};
        boolean run = true;
        while (run) {
            int temp = 0;
            for (int j : game) {
                System.out.print(j + " ");
            }
            System.out.println();
            System.out.println("좌(1)이동 / 우(2)이동을 선택하세요 : ");
            int move = sc.nextInt();
            if (game[0] == 4) {
                System.out.println("반대방향으로 이동해주세요");
                if (move == 1) {
                    System.out.println("잘못입력하였습니다");
                    continue;
                }
            } else if (game[game.length - 1] == 4) {
                System.out.println("반대방향으로 이동해주세요");
                if (move == 2) {
                    System.out.println("잘못입력하였습니다");
                    continue;
                }

            }
            int empty = 0;
            if (move == 1) {
                for (int i = 0; i < game.length; i++) {
                    if (game[i] == 4) {
                        game[i - 1] = game[i];
                        game[i] = empty;
                        if (game[0] == 4) {
                            System.out.println("벽에 부딪혔습니다.");
                            i = game.length;
                        }
                    }
                }
            } else if (move == 2) {
                for (int i = game.length - 1; i >= 0; i--) {
                    if (game[game.length - 1] == 4) {
                        System.out.println("벽에 부딛혔습니다.");
                        i = -1;
                    }
                    else if (game[i] == 4) {
                        game[i + 1] = game[i];
                        game[i] = empty;
                    }
                }
            }
            System.out.println("이동을 멈추시겠습니까 ? ");
            System.out.println("No(0) / Yes(1)");
            int choice = sc.nextInt();

            if (choice == 1) {
                run = false;
            }
        }
        System.out.println("[최종 이동현황]");
        for (int j : game) {
            System.out.print(j + " ");
        }
        sc.close();
    }
}
