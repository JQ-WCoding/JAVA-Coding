package Day051P;

class Ex02 {
    public void printSum() {
        int total = 0;
        for (int i = 0; i <= 5; i++) {
            total += i;
        }
        System.out.println("1부터 5까지의 합 = " + total);
    }
}

public class Day05101메서드기본 {
    public static void main(String[] args) {
        Ex02 ex = new Ex02();
        ex.printSum();
    }
}
