package Day033P;


import java.util.Scanner;

/**
 * # 소수 찾기[3단계]
 * 1. 숫자를 한 개 입력받는다.
 * 2. 입력받은 숫자보다 큰 첫 번째 소수를 출력한다.
 * <p>
 * 예) Enter Number ? 1000
 * 1000보다 큰 첫번재 소수는 1009
 * 예) Enter Number ? 500
 * 500보다 큰 첫번째 소수는 503
 */
public class Day03303소수찾기P {
    Scanner scanner = new Scanner(System.in);
    int number;

    public void start() {
        System.out.print("Enter Number ? ");
        this.number = scanner.nextInt();
    }

    public void findNumber() {
        while (true) {
            ++number;
            int count = 0;
            for (int i = 1; i <= number; i++) {
                if (number % i == 0) {
                    count++;
                }
                // for 반복문이 굳이 필요없이 뒤의 count 3이상 소수가 아닌경우를 연산할 필요가 없음을 인지하고 프로그램이 효율적으로 구동하게끔 생각하는 방법 기르기!
                if (count == 3) {
                    break;
                }
            }
            if (count == 2) {
                System.out.println(number);
                break;
            }
        }
    }

    public static void main(String[] args) {
        Day03303소수찾기P day03303 = new Day03303소수찾기P();

        day03303.start(); // 값 입력받기
        day03303.findNumber();
    }
}
