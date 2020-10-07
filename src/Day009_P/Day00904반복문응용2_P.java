package Day009_P;

public class Day00904반복문응용2_P {
	public static void main(String[] args) {
		//Q4
		int i = 50;
		int cnt = 0;
		while(i <= 100) {
			if(i % 9 == 0) {
				System.out.print(i + " ");
				cnt += 1;
			}
			i++;
		}
		System.out.println("\n(" + cnt + "개)");
		//Q5
		i = 1;
		int temp = 0;
		while(i < 1000) {
			if(i % 28 == 0 && i > 100 && i < 999) {
				temp = i;
			}
			i++;
		}
		System.out.println(temp);
		//Q6
		i = 1;
		cnt = 0;
		while(i < 1000) {
			if(i % 8 == 0) {
				cnt += 1;
				if(cnt < 6) {
				System.out.print(i + " ");
				}
			}
			i++;
		}
	}
}
