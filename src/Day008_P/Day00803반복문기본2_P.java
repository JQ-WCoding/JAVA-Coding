package Day008_P;

public class Day00803반복문기본2_P {
	public static void main(String[] args) {
		// 문제1) 1 ~ 5까지의 합 출력
		// 정답1) 15
		int i = 1;
		int total = 0;
		
		while(i <= 5) {
			total = total + i;
			i++;
		}
		System.out.println(total);
		// 문제2) 1 ~ 10까지 반복해 3미만 7이상만 출력
		// 정답2) 1, 2, 7, 8, 9, 10
		i = 1;
		while(i <= 10) {
			if(i < 3 || i>= 7) {
				System.out.print(i + " ");
			}
			i++;
		}
		// 문제3) 문제2의 조건에 맞는 수들의 합 출력
		// 정답3) 37
		i = 1;
		total = 0;
		while(i <= 10) {
			if(i < 3 || i >= 7) {
				total = total + i;
			}
			i++;
		}
		System.out.println("\n"+ total);
		// 문제4) 문제2의 조건에 맞는 수들의 개수를 출력
		// 정답4) 6개
		i = 1;
		int count = 0;
		
		while(i <= 10) {
			if(i < 3 || i >= 7) {
				count = count + 1;
			}
			i++;
		}
		System.out.println(count + "개");
	}
}
