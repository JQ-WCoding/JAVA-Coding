package SelfWork;

public class StringtoInteger {
    public static void main(String[] args) {
        int num = Integer.parseInt("123");
        System.out.println(num);

        String a = "where";
        System.out.println(a);
        String b = new String("where");
        System.out.println(b);
        int c = 10; // -> heap stack c() - > heap 10의 값을 가져와서 c에서 읽어들이고 표현
        // a라는 객체변수 와 b라는 객체변수는 다른 주소에 존재하고 값이 우연히 내가 같게 입력했기에 같을 뿐인거잖아
        /*
        데이터를 주고받기 위해서만 사용하는 클래스
        특정 변수에 반드시 숫자가 올거야(이미 100% 예상되어있는 경우)
        숫자로 받지 않으면 에러가 나면 데이터 준 곳으로 데이터 (형 자체가 잘못되었다고) 에러를 반환하는 용도로
        발전해서 한줄 코드로 가능
         */
    }
}
