package Day013_P;

public class Day01304for응용2_P {
	public static void main(String[] args) {
		//Q1
		int i = 0;
		int count = 0;
		for (i = 1; i <= 1000; i++) {
			if (i >= 50 && i <= 100) {
				if (i % 9 == 0)
					count++;
			}
		}
		System.out.println(count + "개");
		//Q2
		int temp = 0;
		for (i = 1; i <= 1000; i++) {
			if (i % 28 == 0) {
				temp = i;
			}
		}
		System.out.println(temp);
		//Q3
		count = 0;
		for (i = 1; i <= 1000; i++) {
			if (i % 8 == 0) {
				count++;
				if (count <= 5) {
					System.out.print(i + " ");
				}
			}
		}
	}
}
