package SelfWork;

public class ArrayRelplace_MutiDemension {
	public static void main(String[] args) {
		int[][] a = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		// b의 배열은 가로 a의 길이만큼, 세로 a[0]의 길이만큼이다.
		int[][] b = new int[a.length][a[0].length];

		// 이중 for문 활용
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				b[i][j] = a[i][j];
			}
		}
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(b[i][j] + " ");
			}
		}

		// System.arraycopy() 활용 이중 for문 필요없다!
		int[][] c = new int[a.length][a[0].length];
		for (int i = 0; i < a.length; i++) {
			System.arraycopy(a[i], 0, c[i], 0, a[0].length);
		}
	}
}
