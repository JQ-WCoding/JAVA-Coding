package Day036P;

public class Day03602형변환P {
    public static void main(String[] args) {
        char ch = 'a';
        int chNum = (int) ch;
        System.out.println(chNum);

        ch = (char) (chNum + 1);
        System.out.println(ch);

        String strNum = 10 + "";
        System.out.println(strNum + 1);

        int num = Integer.parseInt(strNum + 2) + 1; // String 입력되어있는 원리를 이해하기
        System.out.println(num);
    }
}
