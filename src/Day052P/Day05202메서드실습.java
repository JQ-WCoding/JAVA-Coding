package Day052P;

/**
 * getter setter 초기 연습
 */
class Ex04 {
    private int num;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}

public class Day05202메서드실습 {
    public static void main(String[] args) {
        Ex04 ex = new Ex04();

        ex.setNum(10);

        int result = ex.getNum();
        System.out.println(result);
    }
}
