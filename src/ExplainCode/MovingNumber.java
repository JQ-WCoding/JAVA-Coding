package ExplainCode;

import java.util.Arrays;
import java.util.Scanner;

public class MovingNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*
         * # 숫자이동[1단계]
         * 1. 숫자2는 캐릭터이다.
         * 2. 숫자1을 입력하면, 캐릭터가 왼쪽으로
         * 	    숫자2를 입력하면, 캐릭터가 오른쪽으로 이동한다.
         * 3. 단, 좌우 끝에 도달했을 때, 예외처리를 해야한다.
         */

        int[] game = {0, 0, 0, 0, 2, 0, 0, 0}; // 8개 new int[8];

        while (true) {
            System.out.println(Arrays.toString(game));
//            for (int i =0; i< game.length;i++){
//                System.out.print(game[i] + " ");
//            }
            System.out.println("왼쪽(1) 오른쪽(2) 이동을 선택하세요");
            int move = scanner.nextInt(); // move라는 수에 값을 입력받기
            /*
            Move가 1일때는 왼쪽으로 계속 이동
            game[index] index -로 점점 이동
            move가 2일때는 오른쪽으로 계속 이동
            game[index] index +로 점점 이동
             */
            if (move == 1) { // index --
                int move1Index = 0;
                for (int i = 0; i < game.length; i++) {
                    if (game[i] == 2) { // 2를 찾았을때
                        move1Index = i; // move1index I 값을 넣는다 i = 4 = move1index
                        game[move1Index] = 0;
                        move1Index--; // move1index = 3
                        game[move1Index] = 2;
                    }
                }
                if (move1Index != 0){ // player

                }
                else if (move1Index == 0){ // else
                    System.out.println("더이상~");
                }
            } else if (move == 2) { // index ++
                int move2Index = 0;
                for (int i = 0; i < game.length; i++) {
                    if (game[i] == 2) {
                        move2Index = i;
                        game[move2Index] = 0;
                        move2Index++;
                        game[move2Index] = 2;
                    }
                }
                if (move2Index != 7){

                }
            } else {
                System.out.print("잘못입력하였습니다");
            }
        }
    }
}
