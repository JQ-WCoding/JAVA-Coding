package Day001_P;

public class Ex00101연산자암기문제_P2 {
	public static void main(String[] args) {
		//Q1
		int width  = 3;
		int length = 6;
		int r_Area = width * length;
		System.out.println("사각형의 넓이 : " + r_Area);
		
		//Q2
		int test1 = 30;
		int test2 = 5;
		int test3 = 2;
		int testTotal = test1 + test2 + test3;
		double avgTotal = testTotal / 3.0;
		System.out.println("평균 : " + avgTotal);
		
		//Q3
		int time = 100;
		int minutes = time / 60;
		int seconds = time % 60;
		System.out.println(minutes + "분 " + seconds + "초");
		
		//Q4
		int salary = 117;
		int month = 12;
		double tax = 117 / 10;
		int preTaxSalary = salary * month;
		double afterTaxSalary = preTaxSalary - (tax * 12);
		System.out.println("세후 연봉 : " + afterTaxSalary + "원");
	}
}
