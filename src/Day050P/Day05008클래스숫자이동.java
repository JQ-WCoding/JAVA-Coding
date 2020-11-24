package Day050P;

import java.util.Arrays;
import java.util.Scanner;

/**
 * # 숫자이동[3단계] : 클래스 + 변수
 * 1. 숫자2는 캐릭터이다.
 * 2. 숫자1을 입력하면, 캐릭터가 왼쪽으로
 * 숫자2를 입력하면, 캐릭터가 오른쪽으로 이동한다.
 * 3. 숫자 1은 벽이다. 벽을 만나면 이동할 수 없다.
 * 4. 단, 숫자3을 입력하면, 벽을 격파할 수 있다.
 * 5. 좌우 끝에 도달해도 계속 반대편으로 이동이 가능하다.
 * 예)
 * 0 0 0 0 0 0 0 2
 * 왼쪽(1) 오른쪽(2) : 2
 * <p>
 * 2 0 0 0 0 0 0 0
 */
class Ex08 {
    int[] game = {0, 0, 1, 0, 2, 0, 0, 1, 0};
}

public class Day05008클래스숫자이동 {
    public static void main(String[] args) {
        Solution08 solution = new Solution08();
        solution.mainActor();
    }
}

class Solution08 {
    Ex08 ex = new Ex08();

    public void mainActor() {
        do {
            showBoard();
            moveChoice();
        } while (!endGame());
    }

    public boolean endGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("완료하시겠습니까 ? (1) yes No는 아무키");
        int number = scanner.nextInt();
        return number == 1;
    }

    public void moveChoice() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("(1) 왼쪽 이동  (2) 오른쪽 이동  (3) 벽 격파");
        int move = scanner.nextInt();
        if (move == 1) { // 왼쪽 이동
            move(-1);
        } else if (move == 2) {
            move(1);
        } else if (move == 3) {
            breakWall();
        } else {
            System.out.println("입력 오류");
        }
    }

    public void breakWall() {
        int myIndex = -1;
        for (int i = 0; i < ex.game.length; i++) {
            if (ex.game[i] == 2) {
                myIndex = i;
            }
        }
        if (ex.game[myIndex + 1] == 1 || ex.game[myIndex - 1] == 1) {
            ex.game[myIndex + 1] = 0;
            ex.game[myIndex - 1] = 0;
        } else {
            System.out.println("벽이 없습니다");
        }
    }

    public void move(int x) {
        int tempIndex = -1;
        for (int i = 0; i < ex.game.length; i++) {
            if (ex.game[i] == 2) {
                tempIndex = i;
            }
        }
        if (tempIndex < 0 || tempIndex > ex.game.length + x) {
            System.out.println("가장자리입니다");
        } else if (ex.game[tempIndex + x] == 1) {
            System.out.println("벽입니다");
        } else {
            int temp = ex.game[tempIndex];
            ex.game[tempIndex] = ex.game[tempIndex + x];
            ex.game[temp + x] = temp;
        }
    }

    public void showBoard() {
        System.out.println(Arrays.toString(ex.game));
    }
}