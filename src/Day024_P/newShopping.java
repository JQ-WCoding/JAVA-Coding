package Day024_P;

import java.util.Scanner;

public class newShopping {
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
        // 1. 뒤로가기 2. 주문양 확인 / 금액 확인 -> keyPoint (제일 중요한거 두개)
//        boolean run = true;
        int tShirt_Count = 0;
        int tShirt_Price = 100;
        int pants_Count = 0;
        int pants_Price = 200;
        while (true){ // 큰틀잡기 (프로그램의 모든것)
            System.out.println("==MainMenu==");
            System.out.println("1. 남성의류");
            System.out.println("2. 여성의류");
            System.out.println("0. 종료");
            // -- 메뉴에대한 설명
            int mainMenuPick = scanner.nextInt(); // 메인메뉴에 번호를 기입했을때 입력받는 곳
            if (mainMenuPick == 1){ // 남성의류
                while (true) {
                    System.out.println("--남성의류--");
                    System.out.println("1) 티셔츠");
                    System.out.println("2) 바지");
                    System.out.println("0) 뒤로가기");
                    int mainMenuPick1_choice = scanner.nextInt(); // 메뉴 1번 남성의류에대한 메뉴선택 값
                    if (mainMenuPick1_choice == 1){ // 티셔츠
                        tShirt_Count++; // tShirt_Count의 값이 1씩 증가
                        System.out.println("티셔츠 현재 누적 수량 : " + tShirt_Count + "개");
                    }
                    else if(mainMenuPick1_choice == 2){ // 바지
                        pants_Count++;
                    }
                    else if (mainMenuPick1_choice == 0){
                        break; // 남성의류 메뉴 한에서 반복문 탈출하기
                    }
                }
            }
            else if (mainMenuPick == 2){ // 여성의류
                System.out.println("PASS");
            }
            else if(mainMenuPick == 0){ // 프로그램 종료
//                tShirt_Count - > 지금까지 우리가 프로그램을 실행하면 쌓여온 값
                System.out.println("구매한 총 개수 : " + (tShirt_Count + pants_Count) + "개");
                System.out.println("가격 " + ((tShirt_Count * tShirt_Price) + (pants_Count * pants_Price)) + "원 "); // 가격과 갯수를 통해 총 얼마인지 표시할 수 있다
                System.out.println("[프로그램 종료]");
                break; // while 문에 대한 탈출
                // run = false; 같은 의미
            }
        }
    }
}
