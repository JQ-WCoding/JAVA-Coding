package Day064P;

class MySingleTon {
    private MySingleTon() {
        // new 불가능
    }

    // 내부에서 new 를 한다
    static private MySingleTon instance = new MySingleTon();

    static public MySingleTon getInstance() {
        return instance;
    }
}

public class Day06402싱글톤패턴 {
    /*
    싱글톤 패턴이란
    클래스를 딱하나만 만들고 싶을때 사용한다
    (주로 배열을 가지고 있는 ManagerClass 들)

    1) 생성자를 private 으로 만든다. 그러면 new 불가능
    2) 내부에서 new 를 한다. static 필요
    3) public 을 get 함수에만 적용. static 필요
     */
    public static void main(String[] args) {
        MySingleTon mySingleTon = MySingleTon.getInstance();
    }
}
