package Day005_P;

import java.util.Scanner;

public class Day00504최대값구하기_P {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("숫자 1 입력 : ");
		int x = scan.nextInt();
		System.out.println("숫자 2 입력 : ");
		int y = scan.nextInt();
		System.out.println("숫자 3 입력 : ");
		int z = scan.nextInt();
		
		int maxNum = x;
		if(maxNum < y) {
			maxNum = y;
		}
		if(maxNum < z) {
			maxNum = z;
		}
		System.out.println("최대값  : " + maxNum);
		scan.close();
	}
}
