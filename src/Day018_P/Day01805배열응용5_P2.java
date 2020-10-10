package Day018_P;

public class Day01805배열응용5_P2 {
	public static void main(String[] args) {
		//Q1
		int[] a = { 10, 30, 50 };
		int[] b = { 20, 40, 60 };
		int[] c = { 0, 0, 0, 0, 0, 0 };
		int temp = 0;
		int size = a.length;

		for (int i = 0; i < size; i++) {
			c[temp] = a[i];
			c[temp + 1] = b[i];
			temp += 2;
		}
		for (int i = 0; i < 6; i++) {
			System.out.print(c[i] + " ");
		}
		System.out.println();

		//Q2
		int[] d = { 10, 20, 30, 40, 50 };
		int value = 100;
		int d_size = d.length;
		temp = 0;
		for (int i = d_size - 2; i >= 0; i--) {
			d[temp] = d[i];
			temp++;
		}
		d[d_size - 1] = value;
		for (int i = 0; i < d_size; i++) {
			System.out.print(d[i] + " ");
		}
		System.out.println();

		//Q3
		int[] e = { 10, 20, 30, 40, 50 };
		value = 100;
		int e_size = e.length;
		temp = 1;
		for (int i = 0; i < e_size - 1; i++) {
			e[temp] = e[i + 1];
			temp++;
		}
		e[0] = value;
		for (int i = 0; i < d_size; i++) {
			System.out.print(e[i] + " ");
		}
	}
}
