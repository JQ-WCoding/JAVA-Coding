package Day041P;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

/**
 * ATM 기능 + 텍스트 파일에 저장하여 정보를 저장하고 로드하도록 변경하기
 */
public class Day04101파일ATM {
    Scanner scanner = new Scanner(System.in);

    int size = 5;
    int count = 0;
    // 로그인 안된 경우 확인을 위한 변수
    int noOneLogIn = -1;
    int log = noOneLogIn;
    String[] accs = new String[size];
    String[] pws = new String[size];
    int[] moneys = new int[size];
    // 메뉴 선택 변수
    int menuSelect = -1;

    String fileName = "atm.txt";

    /*
     * atm.txt
     * abcd/1234/300
     * qwer/1111/1800
     * javaking/3333/1000
     */

    public void showMainMenu() {
        System.out.println("[MEGA ATM]");
        System.out.println("[1]회원가입");
        System.out.println("[2]회원탈퇴");
        System.out.println("[3]로그인");
        System.out.println("[4]로그아웃");
        System.out.println("[5]입금");
        System.out.println("[6]출금");
        System.out.println("[7]이체");
        System.out.println("[8]잔액조회");
        System.out.println("[9]저장");
        System.out.println("[10]로드");
        System.out.println("[0]종료");

        System.out.print("메뉴 선택 : ");
    }

    /*
    메뉴 선택
     */
    public void menuChoice() {
        menuSelect = scanner.nextInt();
    }

    public void ATMActor() {
        while (true) {
            showMainMenu();
            menuChoice(); // 메뉴에 대한 결정 입력받기
            if (menuSelect == 1) { // 회원가입
                signIn();
            } else if (menuSelect == 2) { // 회원탈퇴
                signOut();
            } else if (menuSelect == 3) { // 로그인
                logIn();
            } else if (menuSelect == 4) { // 로그아웃
                logOut();
            } else if (menuSelect == 5) { // 입금
                depositMoney();
            } else if (menuSelect == 6) { // 출금
                drewMoney();
            } else if (menuSelect == 7) { // 이체
                transferMoney();
            } else if (menuSelect == 8) { // 잔액조회
                checkBalance();
            } else if (menuSelect == 9) { // 저장
                saveFile();
            } else if (menuSelect == 10) { // 로드
                loadFile();
            } else if (menuSelect == 0) { // 종료
                break;
            }
        }
    }

    /*
    menuSelect == 1
    회원가입
    아이디, 비밀번호, 기본 잔액 1,000원 입금시키기
     */
    public void signIn() {
        if (log == noOneLogIn) {
            if (count > size) {
                System.out.println("[메세지] 더이상 가입할 수 없습니다");
            } else {
                System.out.print("[회원가입] 아이디를 입력하세요 : ");
                String myId = scanner.next();
                System.out.print("[회원가입] 비밀번호를 입력하세요 : ");
                String myPw = scanner.next();
                int moneyForSignIn = 1000; // 기본 계좌 개설에 필요한 금액

                accs[count] = myId;
                pws[count] = myPw;
                moneys[count] = moneyForSignIn;
                count++;
            }
        } else {
            System.out.printf("[메세지] %s님 로그인중%n", accs[log]);
        }
    }

    /*
    로그인 상태에서 본인의 회원탈퇴만 가능하도록 한다
    log 가 -1 외의 값을 가지고 있어야한다
    log 는 로그인 메뉴에서 index 값을 초기화한다
     */
    public void signOut() {
        // 로그인이 안되어 있는 경우
        if (log == noOneLogIn) {
            System.out.println("로그인이 필요한 서비스 입니다");
        } else {
            // log 값을 토대로 삭제한다
            for (int i = log; i < count; i++) {
                accs[i] = accs[i + 1];
                pws[i] = pws[i + 1];
                moneys[i] = moneys[i + 1];
            }
            // 마지막 배열의 값은 다시 빈 공간으로 초기화
            accs[count] = null;
            pws[count] = null;
            moneys[count] = 0;
            count--;
            // 삭제가 완료된 후 log 는 다시 아무도 로그인 되지 않은 상태로 전환
            log = noOneLogIn;
            System.out.println("[메세지] 탈퇴완료");
        }
    }

    /*
    로그인 기능
    0 으로 초기화 되어있는 배열은 입력 받지 않도록 한다
    이미 로그인 상태인 경우 이용 불가
     */
    public void logIn() {
        // 로그아웃 상태
        if (log == noOneLogIn) {
            System.out.print("[로그인] 아이디를 입력하세요 : ");
            String myId = scanner.next();
            System.out.print("[로그인] 비밀번호를 입력하세요 : ");
            String myPw = scanner.next();

            for (int i = 0; i < count; i++) {
                if (myId.equals(accs[i]) && myPw.equals(pws[i])) { // String 문자열이기 때문에 equals 메소드 사용
                    log = i; // log 에 회원의 배열 인덱스 값 받기
                }
            }
            if (log != noOneLogIn) { // log 가 로그인에 성공하여 인덱스 값을 받아온 경우
                System.out.println("[메세지] 로그인 완료");
            }
            // 그대로 log 가 -1로 로그인 실패한 경우
            else {
                System.out.println("[메세지] 로그인 실패");
            }
        }
        // 로그인 상태
        else {
            System.out.printf("[메세지] %s님 로그인중%n", accs[log]);
        }
    }

    /*
    로그아웃 기능
     */
    public void logOut() {
        if (log == noOneLogIn) {
            System.out.println("[메세지] 로그인되어 있지 않습니다");
        } else {
            System.out.println("[메세지] 로그아웃 되었습니다");
            log = noOneLogIn;
        }
    }

    /*
    입급
    로그인 되어 있는 곳에만 값을 추가할 수 있도록
     */
    public void depositMoney() {
        // log 에 자신의 인덱스 값이 잘 입력되어 있을 경우
        if (log != noOneLogIn) {
            System.out.print("[입금] 입금할 금액을 입력하세요 : ");
            int myMoney = scanner.nextInt();
            // 정상적인 금액을 입력 받았을 경우
            if (myMoney > 0) {
                moneys[log] += myMoney; // 입금
                System.out.println("[메세지] 입금 완료");
                System.out.printf("[잔액] %d원 %n", moneys[log]);
            }
            // - 돈은 불가능
            else {
                System.out.println("[메세지] 금액 입력 오류");
            }
        }
        // 로그인이 필요
        else {
            System.out.println("[메세지] 로그인을 해주세요");
        }
    }

    /*
    인출
    자신이 가진 돈보다 많은 돈을 뽑을 수 없다
     */
    public void drewMoney() {
        if (log != noOneLogIn) {
            System.out.print("[출금] 출금할 금액을 입력하세요 : ");
            int drewMyMoney = scanner.nextInt();

            if (drewMyMoney <= moneys[log]) { // 전체금액까지 출금 가능
                moneys[log] -= drewMyMoney;
                System.out.println("[메세지] 출금완료");
                System.out.printf("[잔액] %d원 %n", moneys[log]);
            } else { // 잔고보다 많은 출금 불가능
                System.out.println("[메세지] 금액을 초과하였습니다");
            }
        } else {
            System.out.println("[메세지] 로그인을 해주세요");
        }
    }

    /*
    이체
    임시 변수를 선언 후 해당 이체 계좌에 확인 후 해당 계좌 인덱스 값 초기화
     */
    public void transferMoney() {
        if (log != noOneLogIn) {
            System.out.print("[이체] 보낼 계좌명을 작성하세요 : ");
            String transferId = scanner.next();
            int cannotFount = -1; // 계좌를 찾지 못한 상태
            int transferIndex = cannotFount; // 초기 인덱스 값으로 선언
            // 이체할 계좌의 인덱스 값을 찾는다
            for (int i = 0; i < count; i++) {
                if (accs[i].equals(transferId)) {
                    transferIndex = i;
                }
            }
            // 이체할 계좌의 인덱스를 찾은 경우
            if (transferIndex != cannotFount) {
                System.out.print("[이체] 보내실 금액을 입력하세요 : ");
                int transferMoney = scanner.nextInt();
                // 이체 과정
                if (transferMoney <= moneys[log]) {
                    moneys[log] -= transferMoney; // 나의 계좌에선 돈이 출금
                    moneys[transferIndex] += transferMoney; // 상대 계좌에선 돈이 입금
                    System.out.println("[메세지] 이체 완료");
                } else {
                    System.out.println("[메세지] 잔액이 부족합니다");
                }
            }
            // 찾지 못한 경우
            else {
                System.out.println("[메세지] 계좌를 찾을 수 없습니다");
            }
        } else {
            System.out.println("[메세지] 로그인을 해주세요");
        }
    }

    /*
    잔액조회
    log 로 받은 인덱스 값의 돈을 출력한다
     */
    public void checkBalance() {
        if (log != noOneLogIn) {
            System.out.printf("%s님의 현재 잔액 : %d원%n", accs[log], moneys[log]);
        } else {
            System.out.println("[메세지] 로그인을 해주세요");
        }
    }

    /*
    파일 저장
     */
    public void saveFile() {
        String data = "";

        FileWriter fileWriter = null;
        try {
            for (int i = 0; i < count; i++) {
                // 데이터 (값),(값),(값) 의 형식으로 저장 후 "/" 로 인덱스 구분
//                data += (i > 0) ? "/" + accs[i] + "," + pws[i] + "," + moneys[i] + "\n" : "" + accs[i] + "," + pws[i] + "," + moneys[i] + "\n";
                data += accs[i] + "," + pws[i] + "," + moneys[i] + "\n";
            }
            fileWriter = new FileWriter(fileName);
            fileWriter.write(data);

            fileWriter.close();
            System.out.println("저장 완료");
        } catch (Exception e) {
            System.out.println("저장 오류");
            e.printStackTrace();
        }
    }

    /*
    파일 로드
     */
    public void loadFile() {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        String data = "";

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
            accs = new String[size];
            pws = new String[size];
            moneys = new int[size];

            for (int i = 0; i < count; i++) {
                String[] info = temp[i].split(",");
                accs[i] = info[0];
                pws[i] = info[1];
                moneys[i] = Integer.parseInt(info[2]);
            }
            System.out.println("불러오기 완료");

            fileReader.close();
            bufferedReader.close();
        } catch (Exception e) {
            System.out.println("불러오기 실패");
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Day04101파일ATM atm = new Day04101파일ATM();
        atm.ATMActor();
    }
}
