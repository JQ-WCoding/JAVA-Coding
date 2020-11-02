package Day034P;

import java.util.Random;
import java.util.Scanner;

/**
 * # 소코반
 * 1. 캐릭터가 공을 움직여 골대에 넣으면 종료되는 게임이다.
 * 2. 벽의 개수를 입력받아 벽을 설치한다.
 * 3. 공과 골대 그리고 캐릭터의 위치 값을 입력받아 설치한다.
 * 4. 벽(9), 공(3), 캐릭터(2) 그리고 골대(7)의 설치가 끝나면 본격적으로 게임이 시작된다.
 * 5. 캐릭터튼 상하좌우로 이동이 가능해 이동하면서 공을 밀어내어 골대에 넣어야 한다.
 * <p>
 * 0 0 0 0 0 0 0
 * 0 0 0 9 9 0 0
 * 0 0 0 0 0 0 9
 * 0 0 0 0 0 0 0
 * 0 0 2 3 7 9 0
 * 0 0 0 0 0 0 0
 * 9 0 0 0 0 0 0
 * <p>
 * 상(1)하(2)좌(3)우(4) 입력 : 4
 * <p>
 * 0 0 0 0 0 0 0
 * 0 0 0 9 9 0 0
 * 0 0 0 0 0 0 9
 * 0 0 0 0 0 0 0
 * 0 0 0 2 3 9 0
 * 0 0 0 0 0 0 0
 * 9 0 0 0 0 0 0
 * <p>
 * 게임종료
 */
public class Day03403소코반P {
    Random random = new Random();
    int[][] map = new int[7][7];

    public void mapSetting() {
        wallSetting();
        othersSetting(7);
        othersSetting(3);
        othersSetting(2);
    }

    public void wallSetting() {
        // 벽 설치
        int count = 0;
        while (count < 5) { // count 4까지 반복
            int index1 = random.nextInt(7);
            int index2 = random.nextInt(7);
            if (map[index1][index2] == 9) { // 이미 존재하다면 한번 카운트가 줄어 원점으로 돌아간다
                count--;
            }
            map[index1][index2] = 9; // 벽 생성
            count++; // 카운트 증가
        } //while
    }

    public void othersSetting(int x) {
        if (x != 2) { // 다른 외부 요소는 상하좌우 한칸씩은 안으로 들어와있어야 한다
            int count = 0;
            while (count < 1) {
                int index1 = random.nextInt(5) + 1;
                int index2 = random.nextInt(5) + 1;
                if (map[index1][index2] == 0) {
                    map[index1][index2] = x; // 벽, 공, 골대 생성
                    count++;
                }
            }
        } else { // 플레이어 생성
            int count = 0;
            while (count < 1) {
                int index1 = random.nextInt(7);
                int index2 = random.nextInt(7);
                if (map[index1][index2] == 0) {
                    map[index1][index2] = x; // 벽, 공, 골대 생성
                    count++;
                }
            }
        }
    }

    public void showMap() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int checkGoal() { // 골 유무 체크하는 방법
        int check = -1;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (map[i][j] == 3) { // 공이 존재할 경우
                    check = 1;
                }
            }
        }
        return check;
    }

    public void moveCharacter() { // 캐릭터의 움직임 표현
        Scanner scanner = new Scanner(System.in);
        while (true) {
            showMap(); // 현재 위치 파익을 위한 매번 화면 보여주기
            int index1 = 0;
            int index2 = 0;
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map.length; j++) {
                    if (map[i][j] == 2) { // 현재 나의 인덱스 위치 파악하기
                        index1 = i;
                        index2 = j;
                    }
                }
            }
            checkGoal();
            if (checkGoal() != -1) {
                System.out.println("(1)상  (2)하  (3)좌  (4)우  이동 선택하세요 : ");
                // 상 이동 [i-1][j] , 하 이동[i +1][j] (수직이동) / 좌 이동[i][j - 1] , 우 이동[i][j +1] (평행이동)
                int myMove = scanner.nextInt();
                    /*
                    위로 이동
                     */
                if (myMove == 1) {
                    /*
                    map[0][i] 경우, 이동 불가
                    1] (공을 마주보고 있는 경우)
                        map[index1 - 1][index2] == 3인 경우

                        map[i - 2][j] == 9 이동 불가
                        map[i][j] 에서 i - 2가 0미만일 경우 이동 불가
                    2] (공이 없는 경우)
                        index - 1 < 0인 경우

                        map[i - 1][j] == 9 이동 불가
                        map[i][j] 에서 i - 1이 0미만일 경우 이동 불가
                     */
                    if (index1 == 0) { // 상단 끝 부분에 현 위치가 있을 경우
                        System.out.println("이동 불가");
                        continue;
                    } else if (map[index1 - 1][index2] == 3) { // 공이 인접한 경우
                        if (index1 - 2 < 0 || map[index1 - 2][index2] == 9) { // 공 다음이 벽인 경우
                            System.out.println("이동 불가");
                            continue;
                        } else if (map[index1 - 2][index2] == 7) { // 골대를 만났을때
                            map[index1 - 1][index2] = map[index1][index2]; // 캐릭터 이동
                            map[index1][index2] = 0;
                        } else {
                            map[index1 - 2][index2] = map[index1 - 1][index2]; // 아무 문제가 없다면 공을 이동시켜야한다
                        }
                    } else if (map[index1 - 1][index2] == 9) { // 자신 다음 벽이 존재하는 경우
                        System.out.println("이동 불가");
                        continue;
                    }
                    map[index1 - 1][index2] = 2;
                    map[index1][index2] = 0;
                    /*
                    아래 이동
                     */
                } else if (myMove == 2) { // map[map.length - 1][i] 경우, 이동 불가
                    if (index1 == map.length - 1) { // 하단 끝 부분
                        System.out.println("이동 불가");
                        continue;
                    } else if (map[index1 + 1][index2] == 3) { // 공이 인접한 경우
                        if (index1 + 2 > 4 || map[index1 + 2][index2] == 9) { // 공 바로 아래가 벽이거나 맵 밖인 경우
                            System.out.println("이동 불가");
                            continue;
                        } else if (map[index1 + 2][index2] == 7) { // 골대를 만났을때
                            map[index1 + 1][index2] = map[index1][index2]; // 캐릭터 이동
                            map[index1][index2] = 0;
                        } else {
                            map[index1 + 2][index2] = map[index1 + 1][index2]; // 문제가 없으면 값을 넘긴다
                        }
                    } else if (map[index1 + 1][index2] == 9) {
                        System.out.println("이동 불가");
                        continue;
                    }
                    map[index1 + 1][index2] = 2;
                    map[index1][index2] = 0;
                    /*
                    왼쪽 이동
                     */
                } else if (myMove == 3) { // map[i][0] 경우, 이동 불가
                    if (index2 == 0) {
                        System.out.println("이동 불가");
                        continue;
                    } else if (map[index1][index2 - 1] == 3) { // 공이 인접한 경우
                        if (index2 - 2 < 0 || map[index1][index2 - 2] == 9) { // 공 다음이 벽인 경우
                            System.out.println("이동 불가");
                            continue;
                        } else if (map[index1][index2 - 2] == 7) { // 골대를 만났을때
                            map[index1][index2 - 1] = map[index1][index2]; // 캐릭터 이동
                            map[index1][index2] = 0;
                        } else {
                            map[index1][index2 - 2] = map[index1][index2 - 1]; // 아무 문제가 없다면 공을 이동시켜야한다
                        }
                    } else if (map[index1][index2 - 1] == 9) { // 자신 다음 벽이 존재하는 경우
                        System.out.println("이동 불가");
                        continue;
                    }
                    map[index1][index2 - 1] = 2;
                    map[index1][index2] = 0;
                } else if (myMove == 4) { // map[i][map.length - 1] 경우, 이동 불가
                    if (index2 == map.length - 1) {
                        System.out.println("이동 불가");
                        continue;
                    } else if (map[index1][index2 + 1] == 3) { // 공이 인접한 경우
                        if (index2 + 2 > 4 || map[index1][index2 + 2] == 9) { // 공 바로 아래가 벽이거나 맵 밖인 경우
                            System.out.println("이동 불가");
                            continue;
                        } else if (map[index1][index2 + 2] == 7) { // 골대를 만났을때
                            map[index1][index2 + 1] = map[index1][index2]; // 캐릭터 이동
                            map[index1][index2] = 0;
                        } else {
                            map[index1][index2 + 2] = map[index1][index2 + 1]; // 문제가 없으면 값을 넘긴다
                        }
                    } else if (map[index1][index2 + 1] == 9) {
                        System.out.println("이동 불가");
                        continue;
                    }
                    map[index1][index2 + 1] = 2;
                    map[index1][index2] = 0;
                }
            } else {
                System.out.println("Goal!");
                break;
            }
        }

    }

    public static void main(String[] args) {
        Day03403소코반P day03403 = new Day03403소코반P();
        day03403.mapSetting();
        day03403.moveCharacter();
    }
}
