package Day001_P;

public class Ex00102연산자암기문제_P2 {
	public static void main(String[] args) {
		//Q1
		int money = 800;
		int fiveCoin = money / 500;
		int oneCoin = money % 500 / 100;
		System.out.println("500원 개수 : " + fiveCoin + "개 / " + "100원 개수 : " + oneCoin + "개");

		//Q2
		int x = 10;
		int y = 20;
		int z = 0;

		x = y;
		y = z;
		System.out.println("x = " + x + " / y = " + y);
		
		//Q3
		int num = 24;
		System.out.println(num % 3 == 0 && num % 2 ==0);
		
		//Q4
		int kor = 100;
		int eng = 100;
		int math = 49;
		int total = kor + eng + math;
		double avg = total / 3.0;
		if(avg >= 60 && kor >= 50 && eng >= 50 && math >= 50) {
			System.out.println("합격");
		}
		else {
			System.out.println("불합격");
		}
	}
}
