package Day042P;

import java.util.Arrays;

/**
 * 문제) nameData 와 moneyData 를 조합해서 아래와 같이 출력해보자.
 * <p>
 * 100001/이만수/600
 * 100003/유재석/7000
 * 100001/이만수/100
 * 100002/이영희/400
 * 100001/이만수/600
 * 100004/박명수/900
 * 100001/이만수/130
 * 100003/유재석/200
 * 100002/이영희/700
 * 100002/이영희/900
 * 100004/박명수/800
 */
public class Day04202문자열심화2 {
    public static void main(String[] args) {
        /*
        nameData 의 앞 자신의 고유번호와 moneyData 의 앞 고유번호 비교
        비교시 일치하는 번호에 moneyData 의 '/' 뒷부분 돈을 계속 더한다
         */
        String nameData = "";
        nameData += "100001/이만수";
        // nameDataArray[0] = "100001/이만수"
        nameData += "\n";
        nameData += "100002/이영희";
        nameData += "\n";
        nameData += "100003/유재석";
        nameData += "\n";
        nameData += "100004/박명수";
        nameData += "\n";
        nameData += "100005/최여정";
        nameData += "\n";
        nameData += "100006/박병욱";

        String moneyData = "";
        // moneyData 의 '/' 부분을 분리하여 nameData 의 번호와 일치하는 경우 뒤의 수만 추가한다
        moneyData += "100001/600";
        moneyData += "\n";
        moneyData += "100003/7000";
        moneyData += "\n";
        moneyData += "100001/100";
        moneyData += "\n";
        moneyData += "100002/400";
        moneyData += "\n";
        moneyData += "100001/600";
        moneyData += "\n";
        moneyData += "100004/900";
        moneyData += "\n";
        moneyData += "100001/130";
        moneyData += "\n";
        moneyData += "100003/200";
        moneyData += "\n";
        moneyData += "100002/700";
        moneyData += "\n";
        moneyData += "100002/900";
        moneyData += "\n";
        moneyData += "100004/800";

        String data = "";

        String[] nameDataArray = nameData.split("\n");
        String[] nameDataNumber = new String[nameDataArray.length];
        for (int i = 0; i < nameDataArray.length; i++) {
            nameDataNumber[i] = nameDataArray[i].substring(0, 6);
        }

        String[] moneyDataArray = moneyData.split("\n");
        String[] moneyDataNumber = new String[moneyDataArray.length];

        for (int i = 0; i < moneyDataArray.length; i++) {
            moneyDataNumber[i] = moneyDataArray[i].substring(0, 6);
        }

        for (int i = 0; i < moneyDataNumber.length; i++) {
            for (int j = 0; j < nameDataNumber.length; j++) {
                if (nameDataNumber[j].equals(moneyDataNumber[i])) {
                    String temp = nameDataArray[j].substring(7) + "/" + moneyDataArray[i];
                    data += temp + "\n";
                }
            }
        }
        System.out.println(data);
    }
}
