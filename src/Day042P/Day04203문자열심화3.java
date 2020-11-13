package Day042P;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 문제) 각 회원별 구입한 총금액 출력하기
 * 아래 데이터는 회원이 물건을 구입할때마다 기록한 내용이다.
 * 데이터를 정리해 아래와 같이 출력해보자.
 * <p>
 * 10001 김철수 2670
 * 10002 이영희 1950
 * 10003 유재석 4080
 * 10004 박명수 7130
 */
public class Day04203문자열심화3 {
    public static void main(String[] args) {
        // data 배열의 번호 부분을 순번대로 정렬하기
        String data = "10001/김철수/600\n";
        data += "10002/이영희/800\n";
        data += "10001/김철수/1400\n";
        data += "10003/유재석/780\n";
        data += "10002/이영희/950\n";
        data += "10004/박명수/330\n";
        data += "10001/김철수/670\n";
        data += "10003/유재석/3300\n";
        data += "10002/이영희/200\n";
        data += "10004/박명수/6800\n";
        System.out.println(data);
        // 배열 재정렬
        String[] splitData = data.split("\n");
        Arrays.sort(splitData);
        System.out.println(Arrays.toString(splitData));

        String[] nameAndNumber = new String[splitData.length];
        for (int i = 0; i < splitData.length; i++) {
            nameAndNumber[i] = splitData[i].substring(0, 9); // 이름과 순번까지만
        }

        int total = 0;

        List<String> datalist = new ArrayList<>();
        for (int i = 0; i < splitData.length; i++) {
            // 포함관계(contains)가 아닐경우에만 add 메소드를 통해서 datalist 에 저장시킨다
            if (!datalist.contains(nameAndNumber[i])) {
                datalist.add(nameAndNumber[i]);
            }
        }
        Collections.sort(datalist);
        System.out.println(datalist);


        // 번호만 입력받은 곳
//        String[] numberData = new String[splitData.length];
//        String[] money = new String[splitData.length];
//        String[] temp = new String[4];
//        int count = 0;
//        for (int i = 0; i < numberData.length; i++) {
//            int total = 0;
//            for (int j = 0; j < numberData.length; j++) {
//                if (numberData[i].equals(numberData[j])) {
//                    numberData[j] = "";
//                    splitData[j] = "";
//                    total += Integer.parseInt(money[j]);
//                }
//            }
//            temp[count] = splitData[i].substring(0, 10) + "/" + total;
//            count++;
//        }
    }
}
