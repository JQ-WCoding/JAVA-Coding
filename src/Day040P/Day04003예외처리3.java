package Day040P;

public class Day04003예외처리3 {
    public static void main(String[] args) {
        // # try - catch - finally

        // # finally
        // 에러 유무와 상관없이 무조건 실행되는 구역이다.

        int x = 10;
        int y = 0;

        try {
            System.out.println(x / y);
        }catch (ArithmeticException ae){
            System.out.println("0으로 나눌 수 없다");
        }finally {
            System.out.println("무조건 실행되는 문장");
        }
    }
}
