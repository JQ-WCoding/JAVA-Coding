package Day040P;

public class Day04002예외처리2 {
    public static void main(String[] args) {
        int[] arr = new int[3];
        // 실습 1
        try {
            arr[100] = 100;
        }catch (ArrayIndexOutOfBoundsException be){
            be.printStackTrace();
        }
        // 실습 2
        int x = 10;
        try {
            int y = 10 / 0;
        }catch (ArithmeticException ae){
            ae.printStackTrace();
        }
        // 실습 3
        String str = "JAVA";
        try {
            int num = Integer.parseInt(str);
        }catch (NumberFormatException nfe){
            nfe.printStackTrace();
        }
        // # 결론)
        // 이처럼 에러의 종류는 너무 많기 때문에
        // 모든 에러를 처리해주는 Exception 을 보통 사용한다. (가장 상위 부모 클래스)
    }
}
