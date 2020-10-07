package Day001_P;

public class Ex00101연산자암기문제_P {
	public static void main(String[] args) {
		//Q1)
		int width = 3;
		int length = 6;
		int square_Area = width * length;
		System.out.println(square_Area);
		//Q2)
		int aScore = 30;
		int bScore = 5;
		int cScore = 2;
		double avg = aScore + bScore + cScore / 3.0;
		System.out.println(avg + "점");
		//Q3)
		int time = 100;
		int minutes = time / 60;
		int seconds = time % 60;
		System.out.println(minutes + "분 " + seconds + "초");
		//Q4)
		int salary = 117;
		int year = 12;
		double afterTaxSalary = salary - (salary / 10.0);
		double afterTaxAnnualSalary = afterTaxSalary * year;
		System.out.println(afterTaxAnnualSalary);
		
	}
}
