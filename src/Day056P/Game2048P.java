package Day056P;

import java.util.Arrays;

public class Game2048P {
    public static void main(String[] args) {

    }
}

class GameMain {
    int[][] gameBoard = {
            {2, 0, 2, 2},
            {0, 0, 0, 2},
            {0, 0, 0, 0},
            {0, 2, 0, 0}
    };

    /**
     * 게임 화면 출력
     */
    public void printBoard() {
        for (int i = 0; i < 4; i++) {
            System.out.println(Arrays.toString(gameBoard[i]));
        }
        System.out.println();
    }
    /**
     * 인게임
     */
    public void inGame(){

    }
}