package Day040P;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Day04009파일컨트롤러 {
    Scanner scanner = new Scanner(System.in);
    public int[] vector = null;
    private int count = 0;
    private int sel;
    String fileName = "vector.txt";

    /*
    메뉴 종류 출력 화면 sel 변수 받기
     */
    public void showMenu() {
        System.out.println("[벡터 컨트롤러]");
        System.out.println("[1]추가하기");
        System.out.println("[2]삭제하기");
        System.out.println("[3]저장하기");
        System.out.println("[4]로드하기");
        System.out.println("[5]종료하기");

        System.out.print("메뉴 선택 : ");
        this.sel = scanner.nextInt();
    }

    /*
    메인 메뉴 구동
     */
    public void mainMenu() {
        while (true) {
            System.out.println(Arrays.toString(vector));
            showMenu();
            if (sel == 1) { // 값 추가
                addVector();
            } else if (sel == 2) { // 값 삭제
                deleteVector();
            } else if (sel == 3) { // 저장하기
                saveFile();
            } else if (sel == 4) {
                loadFile();
            } else if (sel == 5) {
                existProgram();
                break;
            }

        }
    }

    /*
    값 추가하기
     */
    public void addVector() {
        System.out.println("값을 입력하세요 : ");
        int myNum = scanner.nextInt();

        if (count == 0) {
            vector = new int[1];
            vector[0] = myNum;
        } else {
            int[] temp = vector;
            vector = new int[count + 1];
            for (int i = 0; i < count; i++) {
                vector[i] = temp[i];
            }
            vector[count] = myNum;
        }
        count++;
    }

    /*
    백터 삭제 메소드
     */
    public void deleteVector() {
        System.out.println("삭제할 값을 입력하세요 : ");
        int myNum = scanner.nextInt();

        if (count == 0) { // 삭제할 값이 없을 경우
            System.out.println("삭제할 값 없음");
        } else { // 배열 내에 값이 하나라도 있을 경우
            /*
            삭제할 값 인덱스 찾기
             */
            int index = -1;
            for (int i = 0; i < count; i++) {
                if (myNum == vector[i]) {
                    index = i;
                }
            }
            if (index != -1) {
                int[] temp = vector; // 4
                vector = new int[count - 1]; // 3
                int vectorCount = 0;
                for (int i = 0; i < count; i++) {
                    if (index != i) {
                        vector[vectorCount] = temp[i];
                        vectorCount++;
                    }
                }
                count--;
            }
            else { // index = -1 일 경우 같은 값을 찾지 못한거야
                System.out.println("삭제할 값이 없습니다");
            }
        }
    }

    /*
    파일 저장하기
     */
    public void saveFile() {
        String data = "";
        FileWriter fileWriter = null;
        // String data 에 vector 의 값을 모두 저장한다
        for (int i = 0; i < count; i++) {
            data += (i > 0) ? "/" + vector[i] : "" + vector[i];
        }
        try {
            fileWriter = new FileWriter(fileName);
            fileWriter.write(data);
            fileWriter.close();
        } catch (Exception e) {
            System.out.println("저장할 수 없습니다");
            e.printStackTrace();
        }
    }

    /*
    파일 불러오기
     */
    public void loadFile() {
        String data = "";

        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(fileName);
            bufferedReader = new BufferedReader(fileReader);
            while (true) {
                String line = bufferedReader.readLine();// data 내에 한줄씩 값 받아오기
                if (line == null) break;
                data += line;
                data += "/"; // 줄 구분자
            }
            data = data.substring(0, data.length() - 1);
            String[] temp = data.split("/"); // 줄 구분자를 기준으로 "/"삭제 후  temp[i] 에는 각각 한줄의 값이 모두 추가 들어가있음

            count = temp.length;
            vector = new int[count];

            for (int i = 0; i < count; i++) {
                vector[i] = Integer.parseInt(temp[i]);
            }

        } catch (Exception e) {
            System.out.println("파일불러오기 실패");
            e.printStackTrace();
        }
    }

    public void existProgram() {
        System.out.println("프로그램 종료");
    }

    public static void main(String[] args) {
        Day04009파일컨트롤러 day04009 = new Day04009파일컨트롤러();
        day04009.mainMenu();
    }
}
