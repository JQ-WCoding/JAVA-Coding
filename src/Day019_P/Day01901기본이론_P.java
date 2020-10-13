package Day019_P;

public class Day01901기본이론_P {
	public static void main(String[] args) {
		// 증감연산자
		int num = 10;

		++num; // 11
		num++; // 12

		System.out.println(num + 1);
		System.out.println(num);

		int x = 10;

		int result = ++x;
		System.out.println("x = " + x); // 11
		System.out.println("result = " + result); // 11

		x = 10;
		result = x++;
		System.out.println("x = " + x); // 11
		System.out.println("result = " + result); // 10

		int a = 10;
		int b = 20;
		//if문
		if (a > b) {
			System.out.println("크다");
		} else {
			System.out.println("작다");
		}
		//삼항연산자
		String rs = a > b ? "크다" : "작다";
		System.out.println(rs);

	}
}
