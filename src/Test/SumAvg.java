package Test;

public class SumAvg {
    public static void main(String[] args) {
        int total = 0;
        for (int i = 1; i <= 100; i++) {
            total += i;
        }
        double avg = (double) total / 100;
        System.out.println("1 ~ 100 합계: " + total);
        System.out.printf("평균: %.2f", avg);
    }
}
