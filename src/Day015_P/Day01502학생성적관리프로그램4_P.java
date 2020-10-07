package Day015_P;

public class Day01502학생성적관리프로그램4_P {
	public static void main(String[] args) {
		int[] hakbuns = { 1001, 1002, 1003, 1004, 1005 };
		int[] scores = { 87, 11, 45, 98, 23 };

		int maxScore = 0;
		int index = 0;
		for (int i = 0; i < 5; i++) {
			if (scores[i] > maxScore) {
				maxScore = scores[i];
				index = i;
			}
		}
		System.out.println("1등 학생 : " + hakbuns[index] + " / " + scores[index]);
	}
}
