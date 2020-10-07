package Day013_P;

public class Day01302for기본1_P {
	public static void main(String[] args) {
		//Q1
		int i = 0;
		for (i = 1; i <= 5; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		//Q2
		for (i = 1; i <= 10; i++) {
			if (i >= 5 && i <= 9) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
		
		//Q3
		for (i = 10; i >= 1; i--) {
			if (i <= 6 && i >= 3) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
		
		//Q4
		for (i = 1; i <= 10; i++) {
			if (i < 3 || i >= 7) {
				System.out.print(i + " ");
			}
		}
	}
}
