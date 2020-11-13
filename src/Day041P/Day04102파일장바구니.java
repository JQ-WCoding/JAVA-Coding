package Day041P;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 장바구니 시스템 + txt 파일을 이용한 저장과 불러오기 기능 추가
 */
public class Day04102파일장바구니 {
    Scanner scanner = new Scanner(System.in);
    // 회원 정보
    String[] ids = {"qwer", "javaking", "abcd"};
    String[] pws = {"1111", "2222", "3333"};
    // 물품 목록
    String[] items = {"사과", "바나나", "딸기"};

    final int MAX_SIZE = 100;
    int[][] jang = new int[MAX_SIZE][2]; // 물품목록과 갯수인가?

    String fileName = "jang.txt";

    int count = 0;

    // 아무도 로그인하지 않았을 경우
    int noOneLogIn = -1;
    int log = noOneLogIn;
    int nothingChoice = -1;
    int menuChoice = nothingChoice;

    /*
     * jang.txt
     * 1/1
     * 1/2
     * 1/3
     * 2/2
     * 0/1
     */
    /*
    메뉴 메세지 출력
     */
    public void showMenu() {
        System.out.println("[MEGA SHOP]");
        System.out.println("[1]로그인");
        System.out.println("[2]로그아웃");
        System.out.println("[3]쇼핑");
        System.out.println("[4]장바구니");
        System.out.println("[5]저장");
        System.out.println("[6]로드");
        System.out.println("[0]종료");

        System.out.print("메뉴 선택 : ");
        menuChoice = scanner.nextInt();
    }

    public void basketActor() {
        while (true) {
            showMenu();
            if (menuChoice == 1) { // 로그인
                logIn();
            } else if (menuChoice == 2) { // 로그아웃
                logOut();
            } else if (menuChoice == 3) { // 쇼핑
                shopping();
            } else if (menuChoice == 4) { // 장바구니
                checkBasket();
            } else if (menuChoice == 5) { // 저장
                saveFile();
            } else if (menuChoice == 6) { // 로드
                loadFile();
            } else if (menuChoice == 0) { // 종료
                System.out.println("프로그램 종료");
                break;
            }
        }
    }

    /*
    로그인
    아이디와 비밀번호를 입력하고 둘다 맞으면 log 의 값을 i 를 통해 인덱스로 전환한다
     */
    public void logIn() {
        System.out.print("[로그인] 아이디를 입력하세요 : ");
        String myId = scanner.next();
        System.out.print("[로그인] 비밀번호를 입력하세요 : ");
        String myPw = scanner.next();

        for (int i = 0; i < ids.length; i++) {
            if (myId.equals(ids[i]) && myPw.equals(pws[i])) {
                log = i;
            }
        }
        if (log != noOneLogIn) {
            System.out.printf("%s님 환영합니다%n", ids[log]);
        } else {
            System.out.println("[메세지] 로그인 실패");
        }
    }

    /*
    로그아웃
     */
    public void logOut() {
        if (log != noOneLogIn) {
            System.out.println("[메세지] 로그아웃 되었습니다");
            log = noOneLogIn;
        } else {
            System.out.println("[메세지] 로그인 해주세요");
        }
    }

    /*
    쇼핑하기
     */
    public void shopping() {
        if (log != noOneLogIn) {
            // items 한번 전체 출력해서 보여주기
            System.out.println(Arrays.toString(items));

            System.out.print("[쇼핑] 품목을 선택해주세요 : ");
            String myItem = scanner.next();
            // 선택 확인을 위한 변수
            int nothingChoice = -1;
            int itemIndex = nothingChoice;
            // 선택한 품목이 item 배열 내에 존재하는지 확인하기
            for (int i = 0; i < items.length; i++) {
                if (myItem.equals(items[i])) {
                    itemIndex = i;
                }
            }
            // 존재할 경우
            if (itemIndex != nothingChoice) {
                // jang[x][0] = 해당 품목 구매자의 인덱스 , jang[x][1] =  해당 품목의 인덱스 (items 의 인덱스)
                jang[count][0] = log; // 현재 로그인 되어있는 유저의 인덱스 값 초기화
                jang[count][1] = itemIndex;
                count++;
            } else { // 존재하지 않을 경우
                System.out.println("[메세지] 해당 품목이 없습니다");
            }
        } else {
            System.out.println("[메세지] 로그인을 해주세요");
        }
    }

    /*
    장바구니 확인
     */
    public void checkBasket() {
        if (log != noOneLogIn) {
            System.out.print("현재 구매 상품 : ");
            for (int i = 0; i < count; i++) {
                // 현재 로그인 되어 있는 값을 이용해 출력
                if (jang[i][0] == log) { // 로그인되어 있는 유저의 인덱스 값만 확인하고 물품을 출력한다
                    System.out.print(items[jang[i][1]] + " ");
                }
            }
            System.out.println();
        } else {
            System.out.println("[메세지] 로그인을 해주세요");
        }
    }

    /*
    저장하기
     */
    public void saveFile() {
        String data = "";
        FileWriter fileWriter = null;
        try {
            for (int i = 0; i < count; i++) {
                data += jang[i][0] + "," + jang[i][1] + "\n";
//                for (int j = 0; j < jang[i].length; j++) {
//                    // data 내에 값이 jang 의 가로배열마다 입력 후 줄바꿈 되어 입력될 수 있도록 한다
//                    data += (i > 0) ? "," + jang[i][j] : "" + jang[i][j];
//                }
//                data += "\n";
            }
            fileWriter = new FileWriter(fileName);
            fileWriter.write(data);
            fileWriter.close();
        } catch (Exception e) {
            System.out.println("저장 오류");
            e.printStackTrace();
        }
    }

    /*
    불러오기
     */
    public void loadFile() {
        String data = "";

        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(fileName);
            bufferedReader = new BufferedReader(fileReader);

            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                data += line;
                data += "\n";
            }

            String[] temp = data.split("\n");
            count = temp.length;
            for (int i = 0; i < count; i++) {
                String[] info = temp[i].split(",");
                for (int j = 0; j < info.length; j++) {
                    jang[i][j] += Integer.parseInt(info[j]);
                }
            }
            System.out.println("불러오기 완료");

            fileReader.close();
            bufferedReader.close();

        } catch (Exception e) {
            System.out.println("불러오기 오류");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Day04102파일장바구니 basket = new Day04102파일장바구니();
        basket.basketActor();
    }
}
