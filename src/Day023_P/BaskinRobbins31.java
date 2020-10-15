package Day023_P;

import java.util.Random;
import java.util.Scanner;

public class BaskinRobbins31 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random random = new Random();
        int player = 1;// 플레이어 두명
        int total = 0; // ~ 31 까지 받을 변수
        while (true) { //반복문 실행
            if (player % 2 == 1) { // 1P
                System.out.println("1P] 숫자를 입력하세요(1 ~ 3) : ");
                int myNum = scan.nextInt(); // 내가 입력한 수
                // 조건 정수는 1 ~ 3까지 받아야한다
                if (myNum <= 3 && myNum > 0) { // 수는 1 ~ 3사이어야 입력받아진다.
                    total += myNum; // total에 myNum을 추가
                    System.out.println("현재 합 : " + total); // 현재 합계 출력
                    player = 2; // 플레이어2로 턴을 넘긴다.
                } else {
                    System.out.println("다시 입력하세요");
                }
            } else if (player % 2 == 0) {// 2P
                System.out.println("2P] 숫자를 입력중(1 ~ 3)");
                int comNum = random.nextInt(3) + 1; // 컴퓨터는 랜덤으로 1 ~ 3으로 입력
                player = 1; // 플레이어1로 턴을 넘긴다.
                total += comNum; // total 에 comNum을 추가로 저장
                System.out.println("현재 합 : " + total);
            }
            if (total >= 31) {
                if (player == 1) { // 마지막 플레이어2가 기입후 1로 턴넘김이 진행된 상태, 만약 31이상이 되면 1로 넘어가지 않고 종료
                    System.out.println("1P 승리");
                    break; // 전체 반복문 종료 (프로그램 종료)
                } else { // player != 1인경우 2밖에 없음
                    System.out.println("2P 승리");
                    break; // 전체 반복문 종료 (프로그램 종료)
                }
            }
        }
        System.out.println("[프로그램 종료]");
        scan.close(); // 메모리 누수 방지
    }
}



