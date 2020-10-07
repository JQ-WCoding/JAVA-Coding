package Day009_P;

public class Day00904반복문응용2_P1 {
	public static void main(String[] args) {
		
		int i = 50;
		int count = 0;
		while(i <= 100) {
			if(i % 9 == 0) {
				System.out.print(i + " ");
				count += 1;
			}
			i++;
		}
		System.out.println(count + "개");
		
		int temp = 0;
		i = 1;
		while(i < 1000) {
			if(i % 28 == 0 && i / 100 != 0) {
				temp = i;
			}
			i++;
		}
		System.out.println(temp);
		
		i = 1;
		count = 0;
		while(i < 1000) {
			if(i % 8 == 0) {
				count += 1;
				System.out.print(i + " ");
			}
			if(count == 5) {
				i = 1000;
			}
			i++;
		}
	}
}
