package Day046P;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;
import java.util.Scanner;

/**
 * # 크레이지 아케이드
 * => 정답 파일을 먼저 실행한 후, 코드를 작성할 것!
 * 1. 맵의 크기는 7 x 7 이다.
 * 2. 캐릭터(2), 벽(3), 아이템(1), 폭탄(9)을 설정한다.
 * 3. 상(8)하(5)좌(4)우(6)로 이동이 가능하며,
 * 4. 폭탄설치(0)와 폭파(1)를 할 수 있다.
 * 5. 단, 폭탄은 설치한 순서대로 터져야 하며,
 * 폭파 시 십자가 형태로 터진다.
 * 6. 폭파를 통해 주변 벽이 파괴가 되면 그 자리에서
 * 아이템이 랜덤하게 생성된다.
 * 아이템은 -> 폭탄갯수 증가
 * 7. 해당 아이템을 먹으면 설치할 수 있는 폭탄의 개수도 증가한다.
 * 8. 폭탄 설치는 캐릭터가 위치한 그 자리에 바로 생성된다.
 */
public class Day04601크레이지아케이드 {
    Random random = new Random();
    Scanner scanner = new Scanner(System.in);

    final int SIZE = 7;
    int[][] map = new int[SIZE][SIZE];
    int[][] bombMap = new int[SIZE][SIZE];

    // 불러오고 저장할 파일명
    String fileName = "CrazyArcade.txt";

    int player = 2, wall = 3, item = 1, bomb = 9;

    // 초기 폭탄은 1개만 설치 가능
    int maxBombCount = 3;
    int bombCount = 0;

    /*
    파일 로드
     */
    public void fileLoad() {
        FileReader fileReader;
        BufferedReader bufferedReader;
        try {
            fileReader = new FileReader(fileName);
            bufferedReader = new BufferedReader(fileReader);
            String data = "";
            // 파일 읽어들이기
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                data += line + "\n";
            }
            String[] temp = data.split("\n");
            for (int i = 0; i < map.length; i++) {
                String[] tempNum = temp[i].split(",");
                for (int j = 0; j < map[i].length; j++) {
                    map[i][j] = Integer.parseInt(tempNum[j]);
                }
            }

            bufferedReader.close();
            fileReader.close();
        } catch (Exception e) {
            System.out.println("파일을 불러오지 못했습니다");
            // 불러오지 못했을 경우 맵을 새로 만들어준다
            setMap();
        }
    }

    /*
    맵 세팅
     */
    public void setMap() {
        // 플레이어 생성
        map = new int[SIZE][SIZE];
        while (true) {
            int x = random.nextInt(SIZE);
            int y = random.nextInt(SIZE);
            if (map[y][x] == 0) {
                map[y][x] = player;
                break;
            }
        }
        // 벽 생성
        int wallCount = 0;
        while (wallCount < 10) {
            int x = random.nextInt(SIZE);
            int y = random.nextInt(SIZE);
            if (map[y][x] == 0) {
                map[y][x] = wall;
                wallCount++;
            }
        }
    }

    /*
    파일 자동 저장
     */
    public void autoSaveFile() {
        FileWriter fileWriter;
        try {
            String data = "";
            fileWriter = new FileWriter(fileName);
            // 파일 저장
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    data += (j > 0) ? "," + map[i][j] : "" + map[i][j];
                }
                data += "\n";
            }

            fileWriter.write(data);
            fileWriter.close();
        } catch (Exception e) {
            System.out.println("자동 저장 오류");
        }
    }

    /*
    맵 초기화 안내문
     */
    public void resetMessage() {
        System.out.println("저장된 파일이 없거나 새로 맵을 초기화가 필요합니까 ? : (1) Yes (AnyKey) No");
        int myChoice = scanner.nextInt();
        if (myChoice == 1) {
            setMap();
        }
    }

    /*
    메인 게임 출력
     */
    public void gameActor() {
        // 저장된 맵 가져오기
        fileLoad();
        resetMessage();
        do {
            // 매 게임 턴 시작전 자동 저장
            autoSaveFile();
            showMap();
            showKey();
            inGamePlay();
        } while (endGame() != -1);
        System.out.println("게임 종료");
    }

    /*
    조작키 보여주기
     */
    public void showKey() {
        System.out.println("      ^(8)");
        System.out.println("<(4)  V(5)   >(6)");
        System.out.println("(0) 폭탄설치  (1) 폭탄폭파");
    }

    /*
    맵 보여주기
     */
    public void showMap() {
        for (int[] ints : map) {
            for (int j = 0; j < ints.length; j++) {
                if (ints[j] == player) {
                    System.out.print("옷\t");
                } else if (ints[j] == wall) {
                    System.out.print("벽\t");
                } else if (ints[j] == bomb) {
                    System.out.print("😈\t");
                } else if (ints[j] == item) {
                    System.out.print("❤️\t");
                } else {
                    System.out.print(ints[j] + "\t");
                }
            }
            System.out.println();
        }
    }

    /*
    폭탄 설치하기
     */
    public void inGamePlay() {
        // 플레이어 찾기
        int playerY = -1, playerX = -1;
        first:
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == player) {
                    playerY = i;
                    playerX = j;
                    break first;
                }
            }
        }
        int tempPlayerY = playerY, tempPlayerX = playerX;
        // 움직임을 선택한다
        while (true) {
            int move = scanner.nextInt();
            // 이동 과정
            if (move == 4) { // left
                tempPlayerX--;
            } else if (move == 5) { // down move
                tempPlayerY++;
            } else if (move == 6) { // right move
                tempPlayerX++;
            } else if (move == 8) { // up move
                tempPlayerY--;
            } else if (move == 0) { // putting bomb
                if (bombCount < maxBombCount) {
                    // 폭탄 맵에 폭탄 설치
                    bombMap[playerY][playerX] = bomb;
                    bombCount++;
                } else {
                    System.out.println("폭탄이 부족합니다");
                }
            } else if (move == 1) { // bang bomb
                bangBomb();
                // 폭탄맵 초기화
                bombMap = new int[SIZE][SIZE];

                bombCount = 0;
            }

            if (tempPlayerX < 0 || map[tempPlayerY][tempPlayerX] == wall || map[tempPlayerY][tempPlayerX] == bomb || tempPlayerY < 0 || tempPlayerX > map.length - 1 || tempPlayerY > map.length - 1)
                continue;

            if (move != 1) {
                map[playerY][playerX] = 0;
                // 아이템을 먹는 경우
                if (map[tempPlayerY][tempPlayerX] == item) {
                    maxBombCount++;
                }
                map[tempPlayerY][tempPlayerX] = player;
            }
            if (map[playerY][playerX] != player) {
                // 폭탄 표시
                map[playerY][playerX] = bombMap[playerY][playerX];
            }
            break;
        }
    }

    /*
    폭탄 폭파하기
     */
    public void bangBomb() {
        // 가장자리를 제외한 폭탄 폭파의 경우
        for (int i = 1; i < SIZE - 1; i++) {
            for (int j = 1; j < SIZE - 1; j++) {
                if (map[i][j] == bomb || bombMap[i][j] == bomb) {
                    for (int z = -1; z < 2; z++) {
                        int num = random.nextInt(5);
                        if (map[i + z][j] == wall) {
                            if (num == 1) {
                                map[i + z][j] = item;
                            } else {
                                map[i + z][j] = 0;
                            }
                        }
                        if (map[i][j + z] == wall) {
                            if (num == 1) {
                                map[i][j + z] = item;
                            } else {
                                map[i][j + z] = 0;
                            }
                        }
                    }
                    map[i][j] = 0;
                }
            }
        }
        // 가장자리에 폭탄 폭파의 경우
        for (int i = 1; i < map.length - 1; i++) {
            for (int z = -1; z < 2; z++) {
                int num = random.nextInt(3);
                if (map[i][0] == bomb || bombMap[i][0] == bomb) { // 좌측 세로
                    if (map[i + z][0] == wall) {
                        if (num == 1) {
                            map[i + z][0] = item;
                        } else {
                            map[i + z][0] = 0;
                        }
                        map[i][1] = 0;
                    }
                    map[i][0] = 0;
                }
                if (map[0][i] == bomb || bombMap[0][i] == bomb) { // 상단 가로
                    if (map[0][i + z] == wall) {
                        if (num == 2) {
                            map[0][i + z] = item;
                        } else {
                            map[0][i + z] = 0;
                        }
                        map[1][i] = 0;
                    }
                    map[0][i] = 0;
                }
                if (map[i][map.length - 1] == bomb || bombMap[i][map.length - 1] == bomb) { // 우측 세로
                    if (map[i][map.length - 1 + z] == wall) {
                        if (num == 0) {
                            map[i + z][map.length - 1] = item;
                        } else {
                            map[i + z][map.length - 1] = 0;
                        }
                        map[i][map.length - 1] = 0;
                    }
                    map[i][map.length - 1] = 0;
                }
                if (map[map.length - 1][i] == bomb || bombMap[map.length - 1][i] == bomb) { // 하단 가로
                    if (map[map.length - 1][i + z] == wall) {
                        if (num == 1) {
                            map[map.length - 1][i + z] = item;
                        } else {
                            map[map.length - 1][i + z] = 0;
                        }
                        map[map.length - 2][i] = 0;
                    }
                    map[map.length - 1][i] = 0;
                }
            }
        }
        // 가장자리 4곳에 대한 확인
        int num = random.nextInt(3);
        // 0,1 1,0
        if (map[0][0] == bomb || bombMap[0][0] == bomb) {
            if (num == 1) {
                int randomNumber = random.nextInt(2);
                if (randomNumber == 1) {
                    map[0][1] = item;
                } else {
                    map[1][0] = item;
                }
            } else {
                map[1][0] = 0;
                map[0][1] = 0;
            }
            map[0][0] = 0;
        }
        // 0,6 6,0
        if (map[0][map.length - 1] == bomb || bombMap[0][map.length - 1] == bomb) {
            if (num == 1) {
                int randomNumber = random.nextInt(2);
                if (randomNumber == 1) {
                    map[0][map.length - 2] = item;
                } else {
                    map[1][map.length - 1] = item;
                }
            } else {
                map[0][map.length - 2] = 0;
                map[1][map.length - 1] = 0;
            }
            map[0][map.length - 1] = 0;
        }
        if (map[map.length - 1][0] == bomb || bombMap[map.length - 1][0] == bomb) {
            if (num == 1) {
                int randomNumber = random.nextInt(2);
                if (randomNumber == 1) {
                    map[map.length - 2][0] = item;
                } else {
                    map[map.length - 1][1] = item;
                }
            } else {
                map[map.length - 2][0] = 0;
                map[map.length - 1][1] = 0;
            }
            map[map.length - 1][0] = 0;
        }
        if (map[map.length - 1][map.length - 1] == bomb || bombMap[map.length - 1][map.length - 1] == bomb) {
            if (num == 1) {
                int randomNumber = random.nextInt(2);
                if (randomNumber == 1) {
                    map[map.length - 1][map.length - 2] = item;
                } else {
                    map[map.length - 2][map.length - 1] = item;
                }
            } else {
                map[map.length - 1][map.length - 2] = 0;
                map[map.length - 2][map.length - 1] = 0;
            }
            map[map.length - 1][map.length - 1] = 0;
        }
//        for (int i = 0; i < map.length; i++) {
//            for (int j = 0; j < map[i].length; j++) {
//                if (map[i][j] == bomb) {
//                    if (i > 0 && j > 0 || i < SIZE && j < SIZE) {
//                        map[i][j] = 0;
//                        map[i + 1][j] = 0;
//                        map[i - 1][j] = 0;
//                        map[i][j + 1] = 0;
//                        map[i][j - 1] = 0;
//                    }
//                }
//            }
//        }
    }

    /*
    종료 조건 확인
     */
    public int endGame() {
        /*
        플레이어가 죽어서 없어진 경우
        벽이 하나도 남지 않은 경우
         */
        int check = -1;
        int wallCount = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == player) {
                    check = i;
                }
                if (map[i][j] == wall) {
                    wallCount++;
                }
            }
        }
        // 벽이 아직 남아있는 경우 , 플레이어가 존재하는 경우
        if (wallCount > 0 && check != -1) {
            check = 1;
        }
        // 벽이 하나도 없고 플레이어가 살아있는 경우도 게임 종료
        if (wallCount == 0 && check != -1) {
            check = -1;
        }
        return check;
    }
}
