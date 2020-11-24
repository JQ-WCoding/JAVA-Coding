package Day050P;

class Ex03 {
    int[] arr = {87, 100, 11, 72, 92};
}

public class Day05003클래스문제1 {
    // 문제 1) 전체 합 출력
    // 정답 1) 362

    // 문제 2) 4의 배수의 합 출력
    // 정답 2) 264

    // 문제 3) 4의 배수의 개수 출력
    // 정답 3) 3

    // 문제 4) 짝수의 개수 출력
    // 정답 4) 3
    public static void main(String[] args) {
        Ex03 ex03 = new Ex03();
        // Q1
        int total = 0;
        for (int i = 0; i < ex03.arr.length; i++) {
            total += ex03.arr[i];
        }
        System.out.println(total);

        // Q2
        total = 0;
        for (int i = 0; i < ex03.arr.length; i++) {
            if (ex03.arr[i] % 4 == 0) {
                total += ex03.arr[i];
            }
        }
        System.out.println(total);

        // Q3
        int count = 0;
        for (int i = 0; i < ex03.arr.length; i++) {
            if (ex03.arr[i] % 4 == 0) {
                count++;
            }
        }
        System.out.println(count + "개");

        // Q4
        count = 0;
        for (int i = 0; i < ex03.arr.length; i++) {
            if (ex03.arr[i] % 2 == 0) {
                count++;
            }
        }
        System.out.println(count + "개");
    }
}
