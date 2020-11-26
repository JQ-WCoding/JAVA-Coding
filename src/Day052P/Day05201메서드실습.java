package Day052P;

class Ex02 {
    void loop1() {
        for (int i = 0; i <= 10; i++) {
            if (i == 5) {
                System.out.println("종료");
                break;
            }
            System.out.println("loop1 [ i : " + i + " ]");
        }
        System.out.println("loop1의 실행이 끝났습니다. \n");
    }

    void loop2() {
        for (int i = 0; i <= 10; i++) {
            if (i == 5) {
                System.out.println("종료");
                return;
            }
            System.out.println("loop1 [ i : " + i + " ]");
        }
        // 실행 불가 (return 이후 종료)
        System.out.println("loop1의 실행이 끝났습니다. \n");
    }
}

public class Day05201메서드실습 {
    public static void main(String[] args) {
        Ex02 ex = new Ex02();
        ex.loop1();
        ex.loop2();
    }
}
