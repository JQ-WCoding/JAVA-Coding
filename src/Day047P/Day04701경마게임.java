package Day047P;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * # 경마 게임
 * 1. 5마리의 말이 랜덤으로 한번에 일정거리(1~4) 이동이 가능하다.
 * 2. 이동한 거리의 총 합이 20이상이면 도착하게 된다.
 * 3. 도착한 순서대로 등수를 출력한다.
 * 4. 조건) 단, 동시도착에 대한 예외처리를 해야한다.
 */
public class Day04701경마게임 {
    Random random = new Random();
    Scanner scanner = new Scanner(System.in);

    int horseCount = 5;
    int trackCount = 20;

    int[][] horse = new int[horseCount][trackCount];

    int[] rank = new int[horseCount];
    // total 은 각 말의 이동 누적 상태를 의미
    int[] total = new int[horseCount];
    int rankNumber = 1;
    int finishLine = 100;

    /*
    말 움직이는 방법
     */
    public void horseMove() {
        // 5말의 이동을 각각 total 배열에 저장
        for (int i = 0; i < horse.length; i++) {
            if (total[i] < 19) {
                horse[i][total[i]] = 0;
            }
            // 랜덤하게 이동하는 말의 거리
            int horseTurnMove = random.nextInt(4) + 1;
            total[i] += horseTurnMove;
//            if (total[i] > 19) {
//                total[i] = finishLine;
//            }
            // 1번 ~ 5번말 표시 숫자
            if (total[i] > 19) {
                horse[i][19] = (i + 1);
            } else {
                horse[i][total[i]] = (i + 1);
            }
        }
    }

    /*
    랭크 선정
     */
    public void rank() {
        int tempCheck = -1;
        int[] temp = new int[horseCount];
        for (int i = 0; i < total.length; i++) {
            if (total[i] >= 19 && total[i] < finishLine) {
                temp[i] = total[i];
                total[i] = finishLine;
                tempCheck = i;
            }
        }
        if (tempCheck != -1) {
            while (true) {
                int max = -1;
                for (int i = 0; i < temp.length; i++) {
                    if (max < temp[i]) {
                        max = temp[i];
                    }
                }
                for (int i = 0; i < temp.length; i++) {
                    if (max == temp[i]) {
                        rank[i] = rankNumber;
                        rankNumber++;
                        temp[i] = 0;
                    }
                }
                int check = -1;
                for (int i = 0; i < temp.length; i++) {
                    if (temp[i] != 0) {
                        check = i;
                    }
                }
                if (check == -1) {
                    break;
                }
            }
        }
    }

    /*
    플레이어 키 입력
     */
    public int nextMove() {
        System.out.print("계속 보기위해 (1)을 누르세요 : ");
        return scanner.nextInt();
    }

    /*
    메인 실행문
     */
    public void mainActor() {
        System.out.println("== 경마 게임 ==");
        while (true) {
            System.out.println(Arrays.toString(rank));
            if (nextMove() != 1) {
                continue;
            }
            gameScreen();
            horseMove();
            rank();
            if (endGame() == -1) {
                gameScreen();
                showRank();
                System.out.println("게임 종료");
                break;
            }
        }
    }

    /*
    게임 장면 보여주기
     */
    public void gameScreen() {
        for (int i = 0; i < horse.length; i++) {
            System.out.print("[" + (i + 1) + "말] : ");
            for (int j = 0; j < horse[i].length; j++) {
                if (horse[i][j] != 0) {
                    System.out.print("🦓\t");
                } else {
                    System.out.print(horse[i][j] + "\t");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    /*
    게임 종료 조건
     */
    public int endGame() {
        int check = -1;
        for (int i = 0; i < horse.length; i++) {
            // total 이 100이 아니면 check 가 -1이 아니다
            // 만약 total 이 100을 넘어가는게 전부 넘으면 check = - 1
            if (total[i] < finishLine) {
                check = i;
            }
        }
        return check;
    }

    /*
    랭크 보여주기
     */
    public void showRank() {
        int ranking = 1;
        while (ranking < 6) {
            for (int i = 0; i < horse.length; i++) {
                if (ranking == rank[i]) {
                    System.out.println(ranking + "등 : " + (i + 1) + "번 말");
                }
            }
            ranking++;
        }
    }
}
