package Day011_P;

import java.util.Scanner;

public class Day01101쇼핑몰뒤로가기_P {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		boolean run = true;
		while(run) {
			System.out.println("1. 남성의류");
			System.out.println("2. 여성의류");
			System.out.println("3. 종료");
			
			int choice = sc.nextInt();
			if(choice == 1) {
				boolean run1 = true;
				while(run1) {
					System.out.println("1) 티셔츠");
					System.out.println("2) 바지");
					System.out.println("3) 뒤로가기");
					
					int select1 = sc.nextInt();
					if(select1 == 1) {
						
					}
					else if(select1 == 2) {
						
					}
					else if(select1 == 3) {
						run1 = false;
					}
					else {
						System.out.println("다시 누르세요!");
					}
				}
			}
			else if(choice == 2) {
				boolean run2 = true;
				while(run2) {
					System.out.println("1) 가디건");
					System.out.println("2) 치마");
					System.out.println("3) 뒤로가기");
					
					int select2 = sc.nextInt();
					if(select2 == 1) {
						
					}
					else if(select2 == 2) {
						
					}
					else if(select2 == 3) {
						run2 = false;
					}
					else {
						System.out.println("다시 누르세요!");
					}
				}
			}
			else if(choice == 3) {
				run = false;
				System.out.println("프로그램 종료");
			}
			else {
				System.out.println("다시 입력하세요!");
			}
		}
		sc.close();
	}
}
