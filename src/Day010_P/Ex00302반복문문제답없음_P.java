package Day010_P;

import java.util.Scanner;

public class Ex00302반복문문제답없음_P {
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	
	int count = 1;
	int num = 0;
	int total = 0;
	
	while(count <= 5) {
		System.out.println("("+ count + ") 정수를 입력하세요 : ");
		num = sc.nextInt();
		total = total + num;
		if(total < 100) {
			System.out.println(total);
			count += 1;
		}
		else if(total >= 100) {
			System.out.println(total + "종료!");
			count = 6;
		}
		}
	sc.close();
	}
}
