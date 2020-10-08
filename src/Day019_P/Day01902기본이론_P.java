package Day019_P;

public class Day01902기본이론_P {
	public static void main(String[] args) {

		// 선언과 초기화
		int x;
		x = 10;
		System.out.println(x);
		int y = 20;
		System.out.println(y);

		// 자료형
		/*
		 * byte short int long float double char boolean
		 */

		// 참조형
		int[] arr = new int[5];
		System.out.println(arr);

		// 알파벳 소문자 a부터 z까지 출력해보기
		// hint) 아스키코드
		char alhapet = 'a';
		//		System.out.println(a);
		//		System.out.println((char) (a + 1));
		//		System.out.println((char) (a + 2));
		for (int i = 0; i < 20; i++) {
			System.out.print((char) (alhapet + i) + " ");
		}
	}
}
