package Day010_P;

import java.util.Scanner;

public class Day01002소수찾기1_P {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("정수를 입력하세요 : ");
		int num = sc.nextInt();
		// count는 while문 밖에!
		int count = 0;
		
		int i = 1;
		while(i <= num) {
			if(num % i == 0) {
				count += 1;
			}

			i++;
		}
		if(count == 2) {
			System.out.println("소수이다!");
		}
		else {
			System.out.println("소수가 아니다!");
		}
		sc.close();
	}
}	
