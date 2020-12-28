package Portfolio.shop;

public class User {
    int userNo;
    String id;
    String pw;
    String name;

    @Override
    public String toString() {
        return "유저 번호 : " + userNo + " / 유저 이름 : " + name;
    }
}
