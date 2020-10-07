package Day018_P;

import java.util.Scanner;

public class Day01802배열응용4_P {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] c = { 1001, 40, 1002, 65, 1003, 70 };
		int[] d = { 0, 0, 0, 0, 0, 0 };

		int index = 0;
		int size = c.length;
		System.out.println("학번을 입력하세요 : ");
		int myNum = sc.nextInt();
		for (int i = 0; i < size; i += 2) {
			if (myNum != c[i]) {
				d[index] = c[i];
				d[index + 1] = c[i + 1];
				index += 2;
			}
		}
		for(int i = 0 ;i<size;i++) {
			System.out.print(d[i] + " ");
		}
		sc.close();
	}
}
