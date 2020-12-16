package Day065P;

class TestParent {
    private int a;
    protected int b;
    int c;
    public int d;
}

class TestChild extends TestParent {

}

/*
접근제어자 종류
public -> 1) 어디서든 사용가능
private -> 1) 자신클래스 안에서만 사용가능
protected -> 1) 패키지가 다르면 자신클래스와 자식클래스만 사용가능 2) 패키지가 같으면 public 과 같다
default -> 1) 아무것도 쓰지않으면 디폴트 2) 패키지가 다르면 private 패키지가 같으면 public 과 같다
 */
public class Day06505접근제어자 {
    public static void main(String[] args) {

    }
}
