package Day019_P;

import java.util.Scanner;

public class Day01906기본이론_P {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("1. 햄버거");
			System.out.println("2. 피자");
			System.out.println("3. 샌드위치");
			
			System.out.println("메뉴 선택");
			int select = sc.nextInt();
			
			if(select != 1 && select != 2 && select != 3) {
				System.out.println("WrongChoice");
				continue; // 현재위치에서 처음으로 다시 돌아가는 방법
			}
			
			System.out.println("출력될까?");
			if(select == 1) {	
				System.out.println();
				break; // 현재 위치를 기점으로 끝나는 방법. 이후는 실행이 안되지만 이전것은 모두 실행됨
			}
			else if(select == 2) {	
			}
			else if(select == 3) {	
			}
		}
		sc.close();
	}
}
