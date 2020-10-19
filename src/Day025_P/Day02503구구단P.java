package Day025_P;

public class Day02503구구단P {
    public static void main(String[] args) {
        for (int i = 2; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                int answer = i * j;
                System.out.printf("%d X %d = %d \t", j, i, answer); // \t는 탭을 의미한다
            }
            System.out.println();
        }
    }
}
