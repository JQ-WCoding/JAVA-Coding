package Day055P;

class Ex02 {
    // 접근제어자 : public, private
    // 클래스 멤버변수(클래스 영역에 선언된 변수)에 public 이나 private 을 붙일 수 있다.
    private int a;
    private int b;
    int c;
}

public class Day05504캡슐화1 {
    public static void main(String[] args) {
        Ex02 ex02 = new Ex02();

//        ex02.a = 10;  error!
        ex02.c = 10;
    }
}
