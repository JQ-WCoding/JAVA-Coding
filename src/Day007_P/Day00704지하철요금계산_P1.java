package Day007_P;

import java.util.Scanner;

public class Day00704지하철요금계산_P1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("이용할 정거장 수를 입력하세요 :");
		int myNum = sc.nextInt();
		int charge = 0;
		if(myNum <= 5 && myNum > 0) {
			charge = 500;
			System.out.println(charge + "원");
		}
		else if(myNum <= 10 && myNum >= 6) {
			charge = 600;
			System.out.println(charge + "원");
		}
		else {
			charge = 600 + (myNum - 10) / 2 * 50;
			if(myNum %  2 == 1) {
				charge += 50;
			}
		}
		System.out.println("요금은" + charge + "원입니다.");
		sc.close();
	}
}
