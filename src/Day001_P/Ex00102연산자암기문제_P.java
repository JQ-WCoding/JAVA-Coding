package Day001_P;

public class Ex00102연산자암기문제_P {
	public static void main(String[] args) {
		//Q1
		int money = 800;
		int fiveCoin = money / 500;
		int oneCoin = money % 500 / 100;
		System.out.println(fiveCoin + "개 (500원) / " + oneCoin + "개 (100원)");
		//Q2
		int x = 10;
		int y = 20;
		int z = x;
		
		x = y;
		y = z;
		System.out.println("x = " + x + " / y = " + y);
		//Q3
		int num = 24;
		System.out.println(num % 3 == 0 && num % 2 == 0);
		//Q4
		int kor = 100;
		int eng = 100;
		int math = 49;
		int total = kor + eng + math;
		double totalAvg = total / 3.0;
		System.out.println(totalAvg >= 60 && kor >= 50 && eng >= 50 && math >= 50);
	}
}
