package Day032P;

import javax.sound.sampled.Line;
import java.util.Scanner;

public class Day03205쇼핑몰관리자P {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*
         * # 쇼핑몰 [관리자]
         * 1. 카테고리와 아이템을 입력받아 아래의 예시와 같이 저장한다.
         * 2. 카테고리는 각 행의 첫번째 열에 저장한다.
         * 3. 아이템은 각 행의 두번째 열에 저장한다.
         *    단, 아이템은 여러개를 추가할 수 있도록 슬러시(/)를 구분자로 연결해준다.
         * 예)
         * {
         * 		{"과일", "사과/포도/"},
         * 		{"과자", "홈런볼/쪼리퐁/"},
         * 		{"음료", "콜라/"},
         * 		{"육류", "소고기/"}
         * 		...
         * }
         */
        String[][] items = new String[100][2];
        for (int i = 0; i < items.length; i++) {
            items[i][0] = "";
            items[i][1] = "";
        }

        int itemCount = 0;
        int categoryCount = 0;
        while (true) {

            System.out.println("[관리자 모드]");
            System.out.println("[1]카테고리 관리");
            System.out.println("[2]아 이 템  관리");
            System.out.println("[3]전체품목 출력");

            System.out.print(": ");
            int sel = scanner.nextInt();

            if (sel == 1) { // manage category only change items[i][0] -> this part
                System.out.println("카테고리 삭제(1) / 카테고리 추가(2)");
                int categoryChoice = scanner.nextInt();

                if (categoryChoice == 1) { // delete category
                    System.out.println("삭제 카테고리를 입력하세요 : ");
                    String myCategory = scanner.next();

                    for (int i = 0; i < categoryCount; i++) {
                        if (items[i][0].compareTo(myCategory) == 0) {
                            for (int j = i; j < categoryCount; j++) {
                                items[j][0] = items[j + 1][0]; // category is moving
                            }
                        }
                    }
                    items[categoryCount][0] = "";
                    categoryCount--;
                } else if (categoryChoice == 2) { // add category
                    System.out.println("추가 카테고리를 입력하세요 : ");
                    String myCategory = scanner.next();

                    items[categoryCount][0] = myCategory;
                    categoryCount++;
                } else {
                    System.out.println("Wrong Choice");
                }
            } else if (sel == 2) { // manage items
                System.out.println("물품을 정리하려는 카테고리를 입력하세요 : ");
                String myCategory = scanner.next();
                int check = -1;
                for (int i = 0; i < categoryCount; i++) {
                    if (myCategory.compareTo(items[i][0]) == 0) {
                        check = i; // check => find items category
                    }
                }
                if (check != -1) { // if insert right category
                    System.out.println("아이템 삭제(1) / 추가(2)");
                    int itemsChoice = scanner.nextInt();
                    int chooseItemIndex = items[check].length; // find out how long is the length of items[check] and insert to chooseItemIndex
                    if (itemsChoice == 1) { // delete items
                        System.out.println("삭제할 아이템을 작성하세요 : ");
                        String myItem = scanner.next();
                        for (int i = 1; i < items[check].length; i++) {
                            if (items[check][i].compareTo(myItem) == 0) {
                                chooseItemIndex--;
                            }
                        }
                        String[][] temp = new String[categoryCount][chooseItemIndex + 1];
                        for (int i = 0; i < categoryCount; i++) {
                            for (int j = 0; j < temp[i].length; j++) {
                                temp[i][j] = items[i][j];
                            }
                        }
                        items = new String[categoryCount][chooseItemIndex]; // new items array
                        for (int i = 0; i < items[check].length; i++) {
                            if (items[check][i].compareTo(myItem) == 0) {
                                for (int j = i; j < items[check].length; j++) {
                                    items[check][j] = temp[check][j + 1];
                                }
                            }
                        }

                    } else if (itemsChoice == 2) { // add items

                        int itemCheck = -1;
                        for (int i = 0; i < items[check].length; i++) {
                            if (items[check][i].compareTo("") != 0) {
                                itemCheck = 1;
                                itemCount++; // 0 1 2 3 4 5
                            }
                        }
                        if (itemCheck != -1) {
                            items[check][itemCount] = "";
                        }
                        items[check][itemCount] = "";
                        System.out.println("추가할 아이템을 작성하세요  : ");
                        String myItem = scanner.next();
                        for (int i = 0; i < items[check].length; i++) {
                            if (items[check][i].compareTo("") == 0) {
                                items[check][i] = myItem;
                            }
                        }
                    } else {
                        System.out.println("잘못입력하였습니다");
                    }
                } else { // no exist category
                    System.out.println("잘못된 카테고리입니다");
                }
            } else if (sel == 3) { // show whole items
                for (int i = 0; i < categoryCount; i++) {
                    System.out.println(items[i][0] + ": ");
                    for (int j = 1; j < items[i].length; j++) {
                        System.out.print(items[i][j] + "/ ");
                        if (j + 1 == items[i].length) {
                            System.out.print(items[i][j] + " ");
                        }
                    }
                    System.out.println();
                }
            } else if (sel == 0) { // off the program
                System.out.println("프로그램 종료");
                break;
            }

        }

    }
}
