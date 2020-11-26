package Day052P;

class Test{
    int x;
    void check(){
        int x = 10;
        this.x = 100;
    }
}
public class This {
    public static void main(String[] args) {
        Test test = new Test();
        // 이걸 통해서 값을 초기화 시겼음
        test.check();

        // test.check() 메소드를 사용하지 않았다면 0 이다
        System.out.println(test.x);
    }
}
