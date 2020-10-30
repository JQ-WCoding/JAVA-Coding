package Day032P;

import java.util.Arrays;
import java.util.Scanner;

public class Day03204장바구니P {
    static void needLoginMessage() { // already have main... so just use static
        System.out.println("로그인이 필요합니다");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*
         * # 쇼핑몰 [장바구니]
         * 1. 로그인 후 쇼핑 메뉴를 선택하면, 다음과 같이 상품목록을 보여준다.
         * 	1) 사과
         *  2) 바나나
         *  3) 딸기
         * 2. 번호를 선택해 상품을 장바구니에 담을 수 있다.
         * 3. 로그인 회원의 인덱스 번호는 각 행의 첫번째 열에 저장한다.
         * 4. 해당 회원이 구매한 상품의 인덱스 번호는 각 행의 두번째 열에 저장한다.
         * 예)
         * {
         * 		{1, 0},				qwer회원 			> 사과구매
         * 		{2, 1},				javaking회원 		> 바나나구매
         * 		{3, 0},				abcd회원			> 사과구매
         * 		{1, 2},				qwer회원			> 딸기구매
         * 		...
         * }
         */
        String[] ids = {"qwer", "javaking", "abcd"};
        String[] pws = {"1111", "2222", "3333"};

        int MAX_SIZE = 100;
        int[][] jang = new int[MAX_SIZE][2]; // 회원 인덱스, 상품 인덱스 번호

        int count = 0;

        String[] items = {"사과", "바나나", "딸기"};

        int log = -1;

        while (true) {

            System.out.println("[Green MART]");
            System.out.println("[1]로 그 인");
            System.out.println("[2]로그아웃");
            System.out.println("[3]쇼     핑");
            System.out.println("[4]장바구니");
            System.out.println("[0]종     료");

            System.out.print("메뉴 선택 : ");
            int sel = scanner.nextInt();

            if (sel == 1) { // login
                if (log == -1) {
                    System.out.println("ID를 입력하세요 : ");
                    String myId = scanner.next();
                    System.out.println("PW를 입력하세요 : ");
                    String myPw = scanner.next();
                    for (int i = 0; i < ids.length; i++) {
                        if (myId.compareTo(ids[i]) == 0 && myPw.compareTo(pws[i]) == 0) { // myId == ids && myPw == pws
                            log = i + 1; // log is ids & pws' index number 1 2 3
                            break; // for
                        }
                    }
                } else { // log != -1
                    System.out.println(ids[log - 1] + "님이 로그인 중입니다");
                }
            } else if (sel == 2) {  // log out
                if (log != -1) { // when still login
                    System.out.println("로그아웃 완료");
                    log = -1;
                } else { // no one is login
                    needLoginMessage();
                }
            } else if (sel == 3) { // shopping
                if (log != -1) {
                    System.out.println(Arrays.toString(items)); // show the menu
                    System.out.println("원하는 물품을 작성해주세요 : ");
                    String myItemsChoice = scanner.next(); //insert String
                    for (int i = 0; i < items.length; i++) {
                        if (myItemsChoice.compareTo(items[i]) == 0) {
                            jang[count][0] = log; // member index
                            jang[count][1] = i; // items index
                        }
                    }
                    count++;
                } else {
                    needLoginMessage();
                }
            } else if (sel == 4) { // cart
                if (log != -1) {
                    System.out.print(ids[log - 1] + "님의 장바구니 :  ");
                    for (int i = 0; i < count; i++) {
                        if (log == jang[i][0]) {
                            System.out.print(items[jang[i][1]] + " "); // show items
                        }
                    }
                    System.out.println(); // change line
                } else {
                    needLoginMessage();
                }
            } else if (sel == 0) {
                System.out.println("프로그램 종료");
                break;
            }

        }
    }
}
