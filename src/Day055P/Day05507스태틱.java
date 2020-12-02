package Day055P;

/**
 * # static
 * 1. 메모리 static 영역에 만들 수 있다.
 * 2. 프로그램 시작 시 생성되며, 단 한개만 생성된다.
 * 3. new 를 했을 때 생성되지 않는다.
 */
class Ex03 {
    // 인스턴스 변수
    int x;
    int y;
    // static(=클래스 변수)
    static int z;

}

public class Day05507스태틱 {
    public static void main(String[] args) {
        // static 변수는 클래스명으로 접근 가능
        // 인스턴스화 불필요
        Ex03.z = 100;
    }
}
