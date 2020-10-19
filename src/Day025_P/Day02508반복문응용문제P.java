package Day025_P;

import java.util.Scanner;

public class Day02508반복문응용문제P {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*
        [반복문 응용문제]
        1. -1이 나올때까지 일련의 수를 입력받는다.
        2. 위의 수 중 key값이 몇번째 포함되어 있는가를 출력한다.
        3. 단, key가 여러개 포함되어 있을 경우 앞에 나타난 것의 위치를 출력한다(*)
        4. key가 일련의 수 안에 없는 경우 "not fount"를 출력한다.
        예) key 값 입력 : 93
        입력 : 10
        입력 : 93
        입력 : 20
        입력 : 93
        입력 : 93
        입력 : 93
        입력 : -1 // 정답 : 2
         */

        System.out.println("key값을 입력하세요 : ");
        int myKey = scanner.nextInt();
        int place = 1;
        int firstPlace = 0;
        int numCount = 0;
        while (true){
            System.out.println("입력 : ");
            int anyKey = scanner.nextInt();
            if(anyKey == myKey){
                numCount++;
                if (numCount == 1){
                    firstPlace = place;
                }
            }
           else if (anyKey == -1){
               if (numCount == 0){
                   System.out.println("Not Found");
               }
               else {
                   System.out.printf("정답 : %d", firstPlace);
               }
               break;
            }
            place++;
        }
    }
}
