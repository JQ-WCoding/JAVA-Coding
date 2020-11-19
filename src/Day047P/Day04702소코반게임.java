package Day047P;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;
import java.util.Scanner;

public class Day04702소코반게임 {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    final int SIZE = 9;
    int player = 2, wall = 3, ball = 4, goal = 5;
    int wallCount = 0;
    int ballCount = 1;
    int goalCount = 1;
    int pY = 0;
    int pX = 0;

    int[][] map = new int[SIZE][SIZE];
    int[][] maker = new int[SIZE][SIZE];

    String fileName = "maker.txt";

    public void mainActor() {
        maker[pY][pX] = player;
        while (true) {
            System.out.println("[1]게임 맵 생성하기");
            System.out.println("[2]게임 실행하기");
            System.out.println("[0]종료하기");

            int choice = scanner.nextInt();

            if (choice == 1) { // makeMap
                makeMap();
            } else if (choice == 2) { // gameStart
                loadFile();
                gameStart();
                // 자동 저장
                saveFile(map);
            } else if (choice == 0) {
                break;
            }
        }
    }

    /*
    게임 실행
     */
    public void gameStart() {
        while (true) {
            showMakerMap(map);
            // 게임 완료 조건
            int check = -1;
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    if (map[i][j] == goal) {
                        check = i;
                    }
                    if (map[i][j] == player){
                        pX = j;
                        pY = i;
                    }
                }
            }
            int tempPX = pX, tempPY = pY;
            if (check == -1) {
                System.out.println("골인!");
                break;
            }

            System.out.println("     ^(8)  ");
            System.out.println("<(4)  V(5)   >(6)");
            System.out.println("(0) 나가기 (자동으로 저장됩니다)");
            int move = scanner.nextInt();


            if (move == 8) {
                tempPY--;
            } else if (move == 4) {
                tempPX--;
            } else if (move == 5) {
                tempPY++;
            } else if (move == 6) {
                tempPX++;
            } else {
                System.out.println("입력 오류");
                continue;
            }
            if (tempPX < 0 || tempPY < 0 || tempPY > map.length - 1 || tempPX > map.length - 1 || map[tempPY][tempPX] == wall || map[tempPY][tempPX] == goal)
                continue;
            if (map[tempPY][tempPX] == ball) {
                int tempBY = tempPY;
                int tempBX = tempPX;

                if (move == 8) {
                    tempBY--;
                } else if (move == 4) {
                    tempBX--;
                } else if (move == 5) {
                    tempBY++;
                } else if (move == 6) {
                    tempBX++;
                }
                if (tempBY < 0 || tempBX < 0 || tempBX > map.length - 1 || tempBY > map.length - 1 || map[tempBY][tempPX] == wall)
                    continue;
                if (map[tempBY][tempBX] == goal) {
                    map[tempBY][tempPX] = 10;
                }
                map[tempBY][tempBX] = ball;
            }
            map[pY][pX] = 0;
            map[tempPY][tempPX] = player;
        }
    }

    /*
    메이커 맵 보여주기
     */
    public void showMakerMap(int[][] gameMap) {
        for (int i = 0; i < gameMap.length; i++) {
            for (int j = 0; j < gameMap[i].length; j++) {
                if (gameMap[i][j] == player) {
                    System.out.print("🧍\t");
                } else if (gameMap[i][j] == wall) {
                    System.out.print("🧱\t");
                } else if (gameMap[i][j] == goal) {
                    System.out.print("🥅\t");
                } else if (gameMap[i][j] == ball) {
                    System.out.print("⚽️\t");
                } else if (gameMap[i][j] == 0) {
                    System.out.print("ㅁ\t");
                } else if (gameMap[i][j] == 10) {
                    System.out.println("👍\t");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    /*
    맵 만들기
     */
    public void makeMap() {
        while (true) {
            // 메이커 맵 보여주기
            showMakerMap(maker);
            // 이동키
            System.out.println("[이동] ▶  상(1)하(2)좌(3)우(4)");
            System.out.println("[설치] ▶ 벽(5)공(6)골(7) ");
            System.out.println("[종료] ▶ 0");
            int tempPX = pX, tempPY = pY;
            int move = scanner.nextInt();
            if (move == 1) {
                tempPY--;
            } else if (move == 2) {
                tempPY++;
            } else if (move == 3) {
                tempPX--;
            } else if (move == 4) {
                tempPX++;
            } else if (move == 5) { // 벽 설치
                makeWall();
            } else if (move == 6) { // 공 설치
                // 가장 끝 부분을을 제외한 내부에서 공 설치 가능
                if (tempPX > 0 && tempPX < maker.length - 1 && tempPY > 0 && tempPY < maker.length - 1) {
                    makeBall();
                } else { // 가장 끝 부분은 설치 불가능
                    System.out.println("공을 설치할 수 없는 위치 입니다");
                    continue;
                }
            } else if (move == 7) { // 골 설치
                makeGoal();
            } else if (move == 0) {
                System.out.println("설치 종료");
                // 저장 필요
                saveFile(maker);
                break;
            } else {
                System.out.println("입력 오류");
                continue;
            }
            // 외부로 나갈 수 없게 하기
            if (tempPX < 0 || tempPY < 0 || tempPY > maker.length - 1 || tempPX > maker.length - 1) continue;
            if (maker[tempPY][tempPX] == wall || maker[tempPY][tempPX] == ball || maker[tempPY][tempPX] == goal) {
                continue;
            }
            // 자리 이동
            if (maker[pY][pX] != wall && maker[pY][pX] != ball && maker[pY][pX] != goal) {
                maker[pY][pX] = 0;
                pY = tempPY;
                pX = tempPX;
                maker[pY][pX] = player;
            }else if (maker[pY][pX] == wall || maker[pY][pX] == ball || maker[pY][pX] == goal){
                pY = tempPY;
                pX = tempPX;
                maker[pY][pX] = player;
            }
        }
    }

    /*
    벽 설치
     */
    public void makeWall() {
        if (wallCount == 0) {
            System.out.print("설치할 벽의 개수 : ");
            wallCount = scanner.nextInt();
        }
        if (wallCount > 0) {
            maker[pY][pX] = wall;
            wallCount--;
        }
    }

    /*
    공 설치하기
     */
    public void makeBall() {
        if (ballCount == 1) {
            maker[pY][pX] = ball;
            ballCount--;
        } else {
            System.out.println("공이 부족합니다");
        }
    }

    public void makeGoal() {
        if (goalCount == 1) {
            maker[pY][pX] = goal;
            goalCount--;
        } else {
            System.out.println("골대가 부족합니다");
        }
    }

    public void saveFile(int[][] save) {
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(fileName);
            String data = "";
            for (int i = 0; i < save.length; i++) {
                for (int j = 0; j < save[i].length; j++) {
                    data += (j > 0) ? "," + save[i][j] : "" + save[i][j];
                }
                data += "\n";
            }
            fileWriter.write(data);
            fileWriter.close();
        } catch (Exception e) {
            System.out.println("저장 실패");
        }
    }

    public void loadFile() {
        FileReader fileReader;
        BufferedReader bufferedReader;
        try {
            fileReader = new FileReader(fileName);
            bufferedReader = new BufferedReader(fileReader);
            String data = "";
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                data += line + "\n";
            }
            String[] tempLine = data.split("\n");
            for (int i = 0; i < map.length; i++) {
                String[] temp = tempLine[i].split(",");
                for (int j = 0; j < temp.length; j++) {
                    map[i][j] = Integer.parseInt(temp[j]);
                }
            }
            fileReader.close();
            bufferedReader.close();
        } catch (Exception e) {
            System.out.println("불러오기 실패");
        }
    }
}
