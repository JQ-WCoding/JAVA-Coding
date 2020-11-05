package Day036P;

import java.util.Arrays;

public class Day03603주민등록번호검사P {
    public static void main(String[] args) {
        String jumin = "890101-2012932"; // 총 13자리 수
        String[] data = jumin.split("-");

        System.out.println(Arrays.toString(data));
        // 문제 1) 나이 출력
        // 정답 1) 31세
        /*
         올해 2020년 / (올해 - 태어난 연도) + 1 = 나이
         가장 앞 두자리 수가 출생연도 19년도가 포함됨
         String base = "19";를 통해 19년도 기본으로 깔고 가기
         */
        String myBirth = jumin.substring(0, 2);
        int age = 2020 - Integer.parseInt("19" + myBirth) + 1;
        System.out.println("방법1 : "+ age + "살");

        int birth;
        int thisYear = 2020;
        if (data[0].charAt(0) == 0) { // 2000년대 생
            birth = Integer.parseInt("20" + data[0].charAt(0) + data[0].charAt(1));
            System.out.println(birth);
            System.out.println(thisYear - birth + 1 + "살");
        } else if (data[0].charAt(0) != 0) { // 1900년대 생
            birth = Integer.parseInt("19" + data[0].charAt(0) + data[0].charAt(1));
            System.out.println(birth);
            System.out.println(thisYear - birth + 1 + "살");
        }
        // 문제 2) 성별 출력
        // 정답 2) 여성
        char gender =  jumin.charAt(7);
        System.out.println(gender);
        if (gender == '1' || gender == '3'){
            System.out.println("man");
        }
        else if (gender == '2' || gender == '4'){
            System.out.println("woman");
        }
    }
}
