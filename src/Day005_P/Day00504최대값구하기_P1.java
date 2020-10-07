package Day005_P;

import java.util.Scanner;

public class Day00504최대값구하기_P1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("숫자1을 입력해주세요 : ");
		int x = scan.nextInt();
		System.out.println("숫자2를 입력해주세요 : ");
		int y = scan.nextInt();
		System.out.println("숫자3을 입력해주세요 : ");
		int z = scan.nextInt();
		
		int maxNum = x;
		if(maxNum < y) {
			maxNum = y;
		}
		if(maxNum < z) {
			maxNum = z;
		}
		System.out.println("최대값은 : " + maxNum);
		scan.close();
	}
}
