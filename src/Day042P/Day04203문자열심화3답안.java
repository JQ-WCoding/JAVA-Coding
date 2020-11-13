package Day042P;

import java.util.Arrays;

public class Day04203문자열심화3답안 {
    public static void main(String[] args) {
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
        // tempData[0] = {"10002/이영희/800"}
        String[] tempData = data.split("\n");

        int size = tempData.length;
        String[] numbers = new String[size];
        String[] names = new String[size];
        String[] moneys = new String[size];

        // 각 부분에 맞게 값을 분배해서 입력해준다
        for (int i = 0; i < tempData.length; i++) {
            String[] info = tempData[i].split("/");
            numbers[i] = info[0];
            names[i] = info[1];
            moneys[i] = info[2];
        }
        String[] tempNumbers = new String[size];
        String[] tempNames = new String[size];

        int count = 0;
        for (int i = 0; i < size; i++) {
            int good = 1;
            int check = good;
            int sameValue = -1;
            for (int j = 0; j < count; j++) {
                if (numbers[i].equals(tempNumbers[j])) {
                    check = sameValue;
                }
            }
            if (check == good) {
                tempNumbers[count] = numbers[i];
                tempNames[count] = names[i];

                count++;
            }
        }
        System.out.println("count = " + count);

        // 최종 결과 출력
        String[] temp = new String[count];

        for (int i = 0; i < count; i++) {
//            System.out.print(tempNumbers[i] + " " + tempNames[i] + " ");
            int total = 0;
            for (int j = 0; j < size; j++) {
                if (tempNumbers[i].equals(numbers[j])) {
                    total += Integer.parseInt(moneys[j]);
                }
            }
//            System.out.println(total);

            temp[i] = tempNumbers[i] + "/" + tempNames[i] + "/" + total;
        }
        System.out.println(Arrays.toString(temp));
    }
}
