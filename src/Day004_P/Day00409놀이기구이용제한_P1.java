package Day004_P;

import java.util.Scanner;

public class Day00409놀이기구이용제한_P1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int height = 0;
		
		System.out.println("키가 몇인가요? : ");
		height = sc.nextInt();
		
		if(height >= 120) {
			System.out.println("입장 가능");
		}
		else {
			System.out.println("부모님과 함께 오셨나요? 	yes : 1 / no : 0");
			int answer = sc.nextInt();
			if(answer == 1) {
				System.out.println("입장 가능");
			}
			else if(answer == 0){
			System.out.println("놀이기구 이용 불가능");
			}
			else {
				System.out.println("기입 오류");
			}
		}
		sc.close();
	}
}
