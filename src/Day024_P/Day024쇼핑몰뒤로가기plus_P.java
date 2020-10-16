package Day024_P;

import java.util.Scanner;

public class Day024쇼핑몰뒤로가기plus_P {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*
         * # 쇼핑몰 뒤로가기
         * 문제) 쇼핑몰 메인 메뉴에서 남성 의류를 선택해
         *      뒤로가기를 누르기 전까지 남성 의류 페이지를 유지하려고 한다.
         * 힌트) 개층 별로 반복문을 추가해주면 된다.
         * 1. 남성의류
         * 		1) 티셔츠
         * 		2) 바지
         * 		3) 뒤로가기
         * 2. 여성의류
         * 		1) 가디건
         * 		2) 치마
         * 		3) 뒤로가기
         * 3. 종료
         */
        // 초기선언
        int tShirt_BlackCount = 0;
        int tShirt_WhiteCount = 0;
        int tShirt_Black = 30_000; // 검은색 티셔츠의 값 선언
        int tShirt_White = 20_000; // 하얀색 티셔츠의 값 선언
        
        while (true) {
            System.out.println("===Shop===");
            System.out.println("[1] 남성의류");
            System.out.println("[2] 여성의류");
            System.out.println("[3] 주문확인");
            System.out.println("[0] 종료하기");
            int mainMenu = scanner.nextInt(); // mainMenu 선택에 대한 값 받기
            if (mainMenu == 1) { // mainMenu 1 입력시 남성의류
                while (true) {// mainMenu1_menu에 대한 반복
                    System.out.println("1) 티셔츠");
                    System.out.println("2) 바지");
                    System.out.println("0) 뒤로가기");
                    int mainMenu1_menu = scanner.nextInt(); // mainMenu1 내의 메뉴 선택지
                    if (mainMenu1_menu == 1) {
                        while (true) { // tShirtMenu 에대한 반복
                            // 값 출력
                            System.out.println("1. 검은색 티셔츠 : " + tShirt_Black + "원");
                            System.out.println("2. 하얀색 티셔츠 : " + tShirt_White + "원");
                            System.out.println("0. 뒤로가기");
                            System.out.println("어떤 셔츠를 고르시겠습니까?");
                            int tShirtMenu = scanner.nextInt();
                            if (tShirtMenu == 1) {
                                System.out.println("검은색 셔츠 개수 ? ");
                                int in_tShirt_BlackCount = scanner.nextInt();
                                tShirt_BlackCount += in_tShirt_BlackCount; // 메인반복문 밖의 카운트에 내가 입력한 티셔츠 수량 증가
                            } else if (tShirtMenu == 2) {
                                System.out.println("하얀색 셔츠 개수 ? ");
                                int in_tShirt_WhiteCount = scanner.nextInt();
                                tShirt_WhiteCount += in_tShirt_WhiteCount; // 메인반복문 밖의 카운트에 내가 입력한 티셔츠 수량 증가
                            } else if (tShirtMenu == 0) {
                                break;
                            }
                        }
                    } else if (mainMenu1_menu == 2) {

                    } else if (mainMenu1_menu == 0) {
                        break;
                    }
                }
            } else if (mainMenu == 2) { //mainMenu 2 입력시 여성의류
                System.out.println("1) 가디건");
                System.out.println("2) 치마");
                System.out.println("0) 뒤로가기");
                int mainMenu2_menu = scanner.nextInt(); // mainMenu2 내의 메뉴 선택지
                if (mainMenu2_menu == 1) {

                } else if (mainMenu2_menu == 2) {

                } else if (mainMenu2_menu == 0) {
                    break;
                }
            }
            else if(mainMenu == 3){ // 주문확인 총 금액 확인시키기
                int wholeTotal_Count = (tShirt_BlackCount + tShirt_WhiteCount);
                int wholeTotal_Money = (tShirt_BlackCount * tShirt_Black) + (tShirt_White * tShirt_WhiteCount);
                System.out.println("총 구매량 : " + wholeTotal_Count + "개");
                System.out.println("총 금액 : " + wholeTotal_Money + "원");
            }
            else if (mainMenu == 0) { // mainMenu 0 입력시 종료하기
                System.out.println("[메세지] 프로그램 종료");
                break; // 반복문 종료
            }
        }
    }
}
