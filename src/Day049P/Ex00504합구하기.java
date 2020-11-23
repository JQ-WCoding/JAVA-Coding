package Day049P;


import java.util.Arrays;

public class Ex00504합구하기 {
    public static void main(String[] args) {
        AnotherAdd anotherAdd = new AnotherAdd();
        anotherAdd.mainActor();
    }
}

class AnotherAdd {
    // 문제) 아주 긴 수는 변수에 저장할 수 없다.
    //      int나 long을 사용하지 않고 아래 합을 구해보자.
    // 힌트) 배열에 저장해보자.

    String data1 = "123456789123456";
    String data2 = "88888888888888";

    String[] tempData1 = null;
    String[] tempData2 = null;

    public String[] splitString(String data) {
        return data.split("");
    }

    public void mainActor() {
        tempData1 = splitString(data1);
        tempData2 = splitString(data2);
        int[] total = new int[tempData1.length];

        add(total);
        convertToString(total);
    }

    public void add(int[] total) {
        for (int i = tempData2.length - 1; i >= 0; i--) {
            int tempX = Integer.parseInt(tempData1[i + 1]);
            int tempY = Integer.parseInt(tempData2[i]);
            // 첫번째 자리 수만
            total[0] = 1;

            total[i + 1] += ((tempX + tempY) % 10);
            if ((tempX + tempY) >= 10) {
                total[i] += 1;
            }
            if (total[i + 1] >= 10) {
                total[i + 1] %= 10;
                total[i] += 1;
            }
        }
    }

    public void convertToString(int[] total) {
        StringBuilder stringTotal = new StringBuilder();
        for (int j : total) {
            stringTotal.append(j);
        }
        System.out.println("총합 : " + stringTotal);
    }
}