package Day013_P;

public class Day01303for응용1_P1 {
	public static void main(String[] args) {

		//Q1
		int count1 = 0;
		for (int i = 1; i <= 1000; i++) {
			if (i % 9 == 0 && i % 10 == 6) {
				count1++;
			}
			if (count1 == 1) {
				System.out.println(i);
				i = 1000;
			}
		}

		//Q2
		int count2 = 0;
		for (int i = 1; i <= 1000; i++) {
			if (i % 9 == 0 && i / 10 == 6) {
				count2++;
			}
			if(count2 == 1) {
				System.out.println(i);
				i = 1000;
			}
		}

		//Q3
		int temp = 0;
		for (int i = 1; i <= 1000; i++) {
			if (i % 8 == 0 && i < 150) {
				temp = i;
			}
		}
		System.out.println(temp);
	}
}
