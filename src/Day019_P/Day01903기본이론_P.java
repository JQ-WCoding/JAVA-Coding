package Day019_P;

public class Day01903기본이론_P {
	public static void main(String[] args) {
		// 메서드 영역
		int x = 10; // 지역변수(local variable)
		System.out.println(x); // local 에서만 인식

		if (true) {
			int y = 20;
			System.out.println(y);
		}

		//  제어문
		// 1) 조건문 : if, switch - case
		// switch-case만 확인
		int month = 10;
		switch (month) {
		case 3:
		case 4:
		case 5:
			System.out.println("봄");
			break;
		case 6: case 7: case 8:
			System.out.println("여름");
			break;
		case 9:
		case 10:
		case 11:
			System.out.println("여름");
			break;
		case 12:
		case 1:
		case 2:
			System.out.println("여름");
			break;
		default:
			System.out.println("입력오류!");
			break;
		}
	}
}
