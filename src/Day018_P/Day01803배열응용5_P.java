package Day018_P;

public class Day01803배열응용5_P {
	public static void main(String[] args) {

		//Q1
		int[] a = { 10, 30, 50 };
		int[] b = { 20, 40, 60 };
		int[] c = { 0, 0, 0, 0, 0, 0 };

		int index = 0;
		int size = c.length;

		for (int i = 0; i < size / 2; i++) {
			c[index] = a[i];
			c[index + 1] = b[i];
			index += 2;
		}
		for (int i = 0; i < size; i++) {
			System.out.print(c[i] + " ");
		}
		System.out.println();
		//Q2
		int[] d = { 10, 20, 30, 40, 50 };
		int value = 100;
		int d_size = d.length;
		for (int i = 0; i < d_size - 1; i++) {
			d[i] = d[i + 1];
		}
		d[4] = value;

		for (int i = 0; i < d_size; i++) {
			System.out.print(d[i] + " ");
		}
		System.out.println();

		//Q3
		int[] e = { 10, 20, 30, 40, 50 };
		value = 100;
		int e_size = e.length;
		for (int i = e_size - 1; i > 0; i--) {
			e[i] = e[i - 1];
		}
		e[0] = value;
		for (int i = 0; i < e_size; i++) {
			System.out.print(e[i] + " ");
		}
	}
}
