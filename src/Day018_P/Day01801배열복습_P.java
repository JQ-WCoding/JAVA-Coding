package Day018_P;

public class Day01801배열복습_P {
	public static void main(String[] args) {
		int[] counts = { 10, 4, 5, 3, 1 };
		String[] fruits = { "사과", "딸기", "망고", "키위", "멜론" };
		//Q1
		for (int i = 0; i < 5; i++) {
			System.out.println(fruits[i] + " " + counts[i] + "개");
		}

		for (int i = 0; i < 5; i++) {
			if (i == 4) {
				System.out.print(fruits[i] + " " + counts[i] + "개");
			} else {
				System.out.print(fruits[i] + " " + counts[i] + "개, ");
			}
		}
		System.out.println();

		for (int i = 0; i < 5; i++) {
			System.out.print(fruits[i] + " " + counts[i] + "개");
			if (i != 4) {
				System.out.print(", ");
			}
		}
		System.out.println();
		//Q2
		int[] a = { 83, 100, 11, 49, 12 };
		int[] b = { 23, 98, 100, 5, 17 };
		int[] c = { 0, 0, 0, 0, 0 };

		int size = a.length;
		for (int i = 0; i < size; i++) {
			//			if (a[i] > b[i]) {
			//				c[i] = a[i];
			//			} else {
			//				c[i] = b[i];
			//			}
			// ** 효율성 고려!
			c[i] = a[i];
			if (a[i] < b[i]) {
				c[i] = b[i];
			}
		}
		for (int i = 0; i < size; i++) {
			System.out.print(c[i] + " ");
		}
		System.out.println();
		//Q3
		int[] hakbun = { 1001, 1002, 1003, 1004, 1005 };
		int[] kor = { 98, 11, 23, 87, 54 };
		int[] eng = { 11, 87, 58, 22, 81 };
		int[] math = { 97, 60, 92, 87, 43 };
		double[] avg = new double[5];

		int[] info = null;
		int count = 0;
		int temp = 0;

		size = hakbun.length;
		for (int i = 0; i < size; i++) {
			int total = kor[i] + eng[i] + math[i];
			avg[i] = total / 3.0;
			if (avg[i] >= 60) {
				count++;
			}
		}
		info = new int[count];
		for (int i = 0; i < size; i++) {
			if(avg[i] >= 60) {
				info[temp] = hakbun[i];
				temp++;
			}
		}
		size = info.length;
		for (int i = 0; i < size; i++) {
			System.out.print(info[i] + " ");
		}
	}
}
