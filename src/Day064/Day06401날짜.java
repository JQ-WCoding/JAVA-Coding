package Day064;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Day06401날짜 {
    public static void main(String[] args) {

        // 현재 컴퓨터 시스템의 날짜와 시간을 얻어온다
        Date date = new Date();
        // 현재 시간
        System.out.println(date);
        /*
         * [1] 날짜 및 시간 출력 서식 저장 방법
         *  날짜 및 시간 서식에 사용되는 영문자를 제외한 나머지 문자는 입력하는 그대로 출력된다
         *  Date date = new Date();
         *  SimpleDateFormat sdf = new SimpleDateFormat("날짜 및 시간 서식");
         * [2] 날짜 및 시간 서식 적용 방법
         *  sdf.format(date);
         */

        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy년 MM월 dd일 E요일 a hh시 mm분 ss초");
        System.out.println(simpleDateFormat1.format(date));

        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy.MM.dd(E) HH:mm");
        System.out.println(simpleDateFormat2.format(date));

        /*
         * System.currentTimeMillis()
         * 1970년 1월 1일 자정 부터 이 메소드가 실행되는 순간까지 지나온 시단을 밀리초(1/1000초) 단위로 얻어온다.
         * 13자리의 숫자를 얻어오기 때문에 int 로 처리하면 에러가 발생되므로 long 으로 처리해야 한다.
         */

        long time = System.currentTimeMillis();
        System.out.println(time);

        System.out.println(simpleDateFormat2.format(time));
    }
}
