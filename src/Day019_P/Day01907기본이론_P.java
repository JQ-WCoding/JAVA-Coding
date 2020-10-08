package Day019_P;

public class Day01907기본이론_P {
	public static void main(String[] args) {
		// do - while
		int i = 10;
		while (i <= 5) {
			System.out.println(i);
			i++;
		}
		System.out.println();
		 
		// 꼭 한번은 실행 후 조건 판별하여 반복유무 결정
		int j = 10;
		do {
			System.out.println(j);
			j++;
		} while (j <= 5);
	}
}
