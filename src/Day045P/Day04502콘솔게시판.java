package Day045P;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

/**
 * # 콘솔 게시판
 * 1. [이전] 또는 [이후] 버튼을 누르면 페이지 번호가 변경된다.
 * 2. 현재 페이지 번호에 해당되는 게시글만 볼 수 있다.
 * 3. 2차원 배열 board 에 0열에는 제목을 1열에는 게시글의 내용을 저장한다.
 * 4. 게시글을 추가하고 삭제할 때마다 파일입출력을 통해 데이터가 바로바로 저장된다.
 * 5. 실행시 저장되어 있는 파일이 존재한다면, 바로 파일을 불러오도록 설계한다.
 */
public class Day04502콘솔게시판 {
    Scanner scanner = new Scanner(System.in);

    String fileName = "board.txt";
    String[][] board = null;
    // board[y][x]  y 부분에는 페이지 제목을 입력 x 부분에는 내용을 입력할 수 있다.
    int count = 0;                // 전체 게시글 수
    int pageSize = 3;            // 한 페이지에 보여줄 게시글 수
    int curPageNum = 1;            // 현재 페이지 번호
    int pageCount = 0;            // 전체 페이지 개수
    int startRow = 0;            // 현재 페이지의 게시글 시작 번호
    int endRow = 0;                // 현재 페이지의 게시글 마지막 번호

    /*
    메뉴 메세지 출력
     */
    public void mainMessage() {
        System.out.println("[1]이전");
        System.out.println("[2]이후");
        System.out.println("[3]추가하기");
        System.out.println("[4]삭제하기");
        System.out.println("[5]내용확인");
        System.out.println("[0]종료하기");
    }

    /*
    메인 실행
     */
    public void mainActor() {
        // 메인문이 시작되자 마자 파일 로딩을 한번 시킨다
        fileLoad();
        // 메인 메뉴 시작
        while (true) {
            pageCheck();
            showPage();
            System.out.println();
            mainMessage();

            int choice = scanner.nextInt();
            if (choice == 1) { // 이전 이동
                prePage();
            } else if (choice == 2) { // 이후 이동
                nextPage();
            } else if (choice == 3) { // 추가하기
                addContents();
                fileSave();
            } else if (choice == 4) { // 삭제하기
                deleteContents();
                fileSave();
            } else if (choice == 5) { // 내용확인
                checkContents();
            } else if (choice == 0) { // 종료하기
                System.out.println("프로그램 종료");
                break;
            }
        }
    }

    /*
    현재 페이지의 게시글 출력
     */
    public void showPage() {
        System.out.println("총 게시글 수 : =" + count + "=");
        if (board == null) {
            System.out.println();
        } else {
            startRow = ((curPageNum - 1) * pageSize) + 1;
            endRow = startRow + 2;
            if (count < 3) {
                for (int i = 0; i < count; i++) {
                    System.out.println("[" + (i + 1) + "] " + board[i][0]);
                }
            } else {
                if (count > endRow) {
                    for (int i = startRow; i <= endRow; i++) {
                        System.out.println("[" + i + "] " + board[i - 1][0]);
                    }
                } else {
                    for (int i = startRow; i <= count; i++) {
                        System.out.println("[" + i + "] " + board[i - 1][0]);
                    }
                }
            }
        }
        if (count == 0) {
            System.out.println("0 / 0");
        } else {
            System.out.println(curPageNum + " / " + (pageCount));
        }
    }

    /*
    페이지 체크
     */
    public void pageCheck() {
        int pageValue = count / pageSize; // 전체 게시글 수 / 한페이지 최대 게시글 수 = 몫
        // 정확하게 떨어지는 경우에 대한 조건문 필요
        if (count % pageSize == 0) {
            pageCount = pageValue;
        } else {
            pageCount = pageValue + 1; // 몫 + 1 총 페이지
        }
    }

    /*
    이후 이동 (페이지 다음 페이지로 이동)
     */
    public void nextPage() {
        if (curPageNum == pageCount) {
            System.out.println("마지막 페이지입니다.");
        } else {
            System.out.println("페이지를 이동합니다");
            curPageNum++;
        }
    }

    /*
    이전 이동(페이지 전 페이지로 이동)
     */
    public void prePage() {
        if (curPageNum == 1) {
            System.out.println("첫번째 페이지 입니다");
        } else {
            System.out.println("페이지를 이동합니다");
            curPageNum--;
        }
    }

    /*
    파일 불러오기
     */
    public void fileLoad() {
        FileReader fileReader;
        BufferedReader bufferedReader;
        String data = "";
        try {
            fileReader = new FileReader(fileName);
            bufferedReader = new BufferedReader(fileReader);
            // board 의 배열 선언시 방 크기 설저을 위해 count 로 수를 확인한다
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                data += line + "\n";
                count++;
            }
            // board 배열 초기화
            board = new String[count][2];
            String[] temp = data.split("\n");
            for (int i = 0; i < count; i++) {
                String[] line = temp[i].split("/");
                board[i][0] = line[0];
                board[i][1] = line[1];
            }

            fileReader.close();
            bufferedReader.close();
        } catch (Exception e) {
            System.out.println("파일 로드 실패");
        }
    }

    /*
    파일 저장하기
     */
    public void fileSave() {
        FileWriter fileWriter;
        String data = "";
        try {
            fileWriter = new FileWriter(fileName);
            // contents 문자열 내에 board 의 모든 값을 입력해두기
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    data += (j == 0) ? "" + board[i][j] : "/" + board[i][j];
                }
                data += "\n";
            }

            fileWriter.write(data);
            fileWriter.close();
        } catch (Exception e) {
            System.out.println("저장 실패");
        }
    }

    /*
    게시글 추가하기
     */
    public void addContents() { // choice 3
        try {
            System.out.print("[메세지] 추가할 제목을 입력하세요 : ");
            String title = scanner.next();
            System.out.print("[메세지] 추가할 내용을 입력하세요 : ");
            String contents = scanner.next();
            if (count == 0) {
                board = new String[count + 1][2];
                board[count][0] = title;
                board[count][1] = contents;
                count++;
            } else {
                // 추가 배열 생성 후 복사
                String[][] temp = board;
                board = new String[count + 1][2];
                for (int i = 0; i < temp.length; i++) {
                    for (int j = 0; j < 2; j++) {
                        board[i][j] = temp[i][j];
                    }
                }
                board[count][0] = title;
                board[count][1] = contents;
                count++;
            }
        } catch (Exception e) {
            System.out.println("문자를 입력하세요");
        }
    }

    /*
    게시글 삭제하기
     */
    public void deleteContents() { // choice 4
        if (count == 0) {
            System.out.println("삭제할 내용이 없습니다");
        } else {
            System.out.print("[메세지] 삭제할 번호를 입력하세요 : ");
            int deleteNumber = scanner.nextInt();
            // 잘못입력한 경우
            if (deleteNumber < startRow || deleteNumber > endRow) {
                System.out.println("잘못입력했습니다");
            } else { // 잘입력할 경우
                String[][] temp = board;
                board = new String[count - 1][2];
                int indexCount = 0;
                // 삭제한 내용을 제외하고 다시 입력받기
                for (int i = 0; i < temp.length; i++) {
                    for (int j = 0; j < 2; j++) {
                        if (deleteNumber - 1 != i) {
                            board[indexCount][j] = temp[i][j];
                        }
                    }
                    if (deleteNumber - 1 != i) {
                        indexCount++;
                    }
                }
                count--;
            }
        }
    }

    /*
    내용 확인
     */
    public void checkContents() {
        System.out.print("확인할 제목 번호를 입력하세요 : ");
        int titleNumber = scanner.nextInt();
        if (titleNumber < startRow || titleNumber > endRow) {
            System.out.println("현제 페이지에서 사용 불가");
        } else {
            System.out.println(board[titleNumber - 1][1] + " ");
        }
    }

    public static void main(String[] args) {
        Day04502콘솔게시판 console = new Day04502콘솔게시판();
        console.mainActor();
    }
}
