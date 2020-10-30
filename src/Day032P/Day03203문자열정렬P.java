package Day032P;

public class Day03203문자열정렬P {
    public static void main(String[] args) {
        // a  97
        // b  98
        //a.compareTo(b) :: a- b 를 하는것과 같다
        String str1 = "가";
        String str2 = "나";
        String str3 = "다";
        System.out.println(str1.compareTo(str2) < 0); // - 비교 if에서 사용하려면 비교같은것이 필요함
        System.out.println(str2.compareTo(str1));
        System.out.println(str3.compareTo(str3) == 0);
        System.out.println(str3.equals(str3));
        String[] name = {"강아지", "고양이", "호랑이", "사자", "강아지"};
        for (int i = 0; i < name.length; i++) {
            for (int j = 0; j < name.length; j++) {
                if (name[i].compareTo(name[j]) == 0) {
                    System.out.println(name[i] + " and " + name[j]);
                    System.out.println("same");
                }
            }
        }
    }
}
