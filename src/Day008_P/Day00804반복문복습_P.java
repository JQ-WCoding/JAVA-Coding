package Day008_P;
// 4m 05s
public class Day00804반복문복습_P {
	public static void main(String[] args) {
		// 문제1) 1 ~ 10 중에 홀수만 출력
		// 정답1) 1, 3, 5, 7, 9
		int i = 1;
		while(i <= 10) {
			if(i % 2 == 1 && i != 9) {
				System.out.print(i + ", ");
			}
			else if(i == 9) {
				System.out.print(i);
				}
			i++;
		}
		System.out.println();
		// 문제2) 0 ~ 20 중에 3의 배수이면서 4의 배수인 수만 출력
		// 정답2) 12
		i = 0;
		while(i <= 20) {
			if(i % 3 == 0 && i % 4 == 0 && i != 0) {
				System.out.println(i + " ");
			}
			i++;
		}
		// 문제3) 0 ~ 10 중에 2의 배수의 합 출력
		// 정답3) 30
		i = 0;
		int total = 0;
		while(i <= 10) {
			if(i % 2 == 0) {
				total += i;
			}
			i++;
		}
		System.out.println(total);
		// 문제4) 0 ~ 10 중에 3의 배수의 개수 출력
		// 정답4) 3
		i = 0;
		int count = 0;
		while(i <= 10) {
			if(i % 3 == 0 && i != 0) {
				count++;
			}
			i++;
		}
		System.out.println(count + "개");
	}
}
