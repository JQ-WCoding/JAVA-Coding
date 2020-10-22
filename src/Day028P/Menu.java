package Day028P;

public class Menu {
    public static void fistMenu() {
        String menu = "=== 그린IT ATM ===\n";
        menu += "1.회원가입\n2.회원탈퇴\n3.로그인\n4.로그아웃\n";
        menu += "5.입금\n6.이체\n7.잔액조회\n0.종료";
        System.out.println(menu);
    }
}
