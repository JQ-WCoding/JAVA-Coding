package Day007_P;

import java.util.Scanner;

public class Day00704지하철요금계산_P {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("이용할 정거장 수를 입력하세요 : ");
		int nStation = scan.nextInt();
		
		int fee = 0;
		if(nStation >= 1 && nStation <= 5) {
			fee = 500;
		}
		else if(nStation >= 6 && nStation <= 10){
			fee = 600;
		}
		else {
			fee = 600 + (nStation - 10) / 2 * 50;
			if(nStation % 2 == 1) {
				fee = fee + 50;
			}
		}
		System.out.println("요금은 : " + fee + "원입니다.");
		scan.close();
	}
}
