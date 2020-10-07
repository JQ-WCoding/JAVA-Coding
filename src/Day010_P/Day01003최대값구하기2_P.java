package Day010_P;

import java.util.Scanner;

public class Day01003최대값구하기2_P {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int i = 1;
		int maxNum = 0;
		int num = 0;
		
		while(i <= 3) {
		System.out.println("정수("+ i + ")를 입력하세요 : ");
		num = sc.nextInt();
		if(maxNum < num) {
			maxNum = num;
		}
		i++;
		}
		System.out.println("최대값 : " + maxNum);
		sc.close();
	}
}
