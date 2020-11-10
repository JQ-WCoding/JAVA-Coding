package Day040P;
/**
 * # try - catch
 * . 자바는 일반적으로 에러가 발생하면 프로그램이 즉시 종료한다.
 * . try - catch는 에러가 발생해도 프로그램이 종료되지 않고,
 *   에러가 발생한 부분만 동작하지 않고 프로그램이 계속 진행하도록 만들어 준다.(매우 좋음)
 *
 * # 사용법
 * . try {}					: 중괄호 안에 코드를 작성하면 에러가 발생하면
                                  바로 catch 중괄호로 이동한다.
 * . catch(Exception e) {}	: 에러가 발생하면 한번 작동된다.
 */
public class Day04001예외처리1 {
    public static void main(String[] args) {
        int num = 0;
        System.out.println("Start Program");
//        System.out.println(10 / 0); // 오류 발생 시 프로그램이 강제 종료
        try {
            System.out.println(10 / num);
        }catch (ArithmeticException ae){
            System.out.println(10 / 2); // try 영역에서 오류가 발생하면 실행할 코드
            ae.printStackTrace();
        }finally {
            System.out.println("무조건 실행");
        }
        System.out.println("End Program");
    }
}
