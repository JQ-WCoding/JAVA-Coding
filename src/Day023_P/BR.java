package Day023_P;

import java.util.Scanner;

public class BR {
    public static void main(String[] args) {
        /*
         * # 베스킨라빈스31
         * 1. p1과 p2가 번갈아가면서 1~3을 입력한다.
         * 2. br은 p1과 p2의 입력값을 누적해서 저장한다.
         * 3. br이 31을 넘으면 게임은 종료된다.(종료조건)
         * 4. 승리자를 출력한다.
         * 예)
         * 1턴 : p1(2)		br(2)
         * 2턴 : p2(3)		br(5)
         * 3턴 : p1(1)		br(6)
         * ...
         */
        Scanner scanner = new Scanner(System.in); // 스캐너 도구를 가져오겠다
        int p1 = 0; // 플레이어 1의 값
        int p2 = 0; // 플레이어 2의 값
        int br = 0; // 합계
        boolean turn = true; // true인 경우 p1이 입력 , false인 경우 p2가 입력
        boolean mainRun = true; // 메인 게임이 끝나는지 안끝나는지 확인시키는 조건
        while (mainRun) { // mainRun이 true인 상태이면 계속 반복 / false가되면 반복문을 종료하고 나올거에요
            // 1P
            if (turn == true) {//1P의 턴
                System.out.println("p1 차례 / (1 ~ 3)의 수를 입력하세요 : ");
                p1 = scanner.nextInt(); // p1 입력
                br = br + p1; // br은 현재 br의 값 + p1이 입력한 값
                System.out.println("총합 : " + br); // br 출력
                turn = false; // turn을 false를 통해 p2로 보내기
            }
            // 2P
            else if (turn == false) { // 2P의 턴
                System.out.println("p2 차례 / (1 ~ 3)의 수를 입력하세요 : ");
                p2 = scanner.nextInt(); // p1 입력
                br = br + p2; // br은 현재 br의 값 + p1이 입력한 값
                System.out.println("총합 : " + br); // br 출력
                turn = true; // turn을 true바꿔서 1p보내주기
            }
            //-----------------------------------------------------
            if (br > 31){ // 총합이 31 초과일때
                if (turn == true){
                    System.out.println("1P 승리");
                }
                else if (turn == false){
                    System.out.println("2P 승리");
                }
                mainRun = false;
                // mainRun 반복문을 이제 끝냅니다
            }
        }
        System.out.println("[프로그램 종료]");
    }
}
