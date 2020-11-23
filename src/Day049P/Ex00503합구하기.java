package Day049P;


public class Ex00503합구하기 {
    public static void main(String[] args) {
        Add add = new Add();
        add.add();
    }
}

class Add {
    // 문제) 위 수의 합을 구하시오.
    String data = "123+46";

    public void add() {
        String[] number = data.split("\\+");

        int total = 0;
        for (int i = 0; i < number.length; i++) {
            total += Integer.parseInt(number[i]);
        }

        System.out.printf("합계 : %d %n", total);
    }
}
