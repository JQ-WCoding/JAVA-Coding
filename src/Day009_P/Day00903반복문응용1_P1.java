package Day009_P;

public class Day00903반복문응용1_P1 {
	public static void main(String[] args) {
		//Q1
		int i = 1;
		while(i < 1000) {
			if(i % 9 == 0 && i % 10 == 6) {
				System.out.println(i);
			i = 1000;
			}
			i++;
		}
		//Q2
		i = 1;
		while(i < 1000) {
			if(i % 9 == 0 && i / 10 == 6) {
				System.out.println(i);
				i = 1000;
			}
			i++;
		}
		//Q3
		int temp = 0;
		i = 1;
		while(i < 1000) {
			if(i % 8 == 0 && i < 150) {
				temp = i;
			}
			i++;
		}
		System.out.println(temp);
	}
}
