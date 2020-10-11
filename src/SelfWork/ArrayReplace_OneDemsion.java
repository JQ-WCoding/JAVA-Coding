package SelfWork;

import java.util.Arrays;

public class ArrayReplace_OneDemsion {
	public static void main(String[] args) {

		// clone을 이용한 배열 복사
		int[] a = { 1, 2, 3, 4 };
		int[] b = a.clone();
		int a_Size = a.length;

		for (int i = 0; i < a_Size; i++) {
			System.out.print(b[i] + " ");
		}
		System.out.println();

		// 원하는 길이 만큼 복사 처음 시작부터 원하는 끝부분까지 Arrays.copyOf()을 사용
		int[] c = Arrays.copyOf(a, a_Size);
		for (int i = 0; i < a_Size; i++) {
			System.out.print(c[i] + " ");
		}
		System.out.println();

		// Arrays.copyOfRange()는 시작과 끝늘 모두 정할 수 있다.
		int[] d = Arrays.copyOfRange(a, 0, a_Size);
		for (int i = 0; i < a_Size; i++) {
			System.out.print(d[i] + " ");
		}
		System.out.println();

		// System.arraycopy()는 메서드에 지정된 배열만큼 배정한 배열에 저장
		int[] e = new int[a_Size];
		System.arraycopy(a, 0, e, 0, a_Size);
		for (int i = 0; i < a_Size; i++) {
			System.out.print(e[i] + " ");
		}

	}
}
