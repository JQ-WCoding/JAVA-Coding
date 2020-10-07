package Day004_P;

import java.util.Scanner;

public class Day00409놀이기구이용제한Plus {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("본인의 키는?");
		int height = scan.nextInt();
		
		if(height <= 0) {
			System.out.println("오류");
		}
		if(height >= 120) {
			System.out.println("입장가능");
		}
		if(height < 120 && height > 0) {
			System.out.println("부모님과 함께 오셨나요? Yes : 1 / No : 0");
			int withParent = scan.nextInt();
			if(withParent == 1) {
				System.out.println("입장가능");
			}
			if(withParent == 0) {
				System.out.println("입장불가");
			}
			if(withParent != 1 && withParent != 0) {
				System.out.println("잘못입력하였습니다.");
			}
		}
	scan.close();
	}
}
