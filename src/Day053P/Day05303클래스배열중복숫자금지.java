package Day053P;

import java.util.Random;

class RanNum {
    int num;
    boolean check;
}

public class Day05303클래스배열중복숫자금지 {
    public static void main(String[] args) {
        Random random = new Random();
        // Q1) RanNum 클래스를 활용해서 중복숫자금지 출력
        // num 에 1 ~ 5 사이의 숫자를 랜덤으로 저장한다. (조건 중복숫자금지)
        RanNum[] ranNum = new RanNum[5];

        for (int i = 0; i < ranNum.length; i++) {
            ranNum[i] = new RanNum();
        }

        for (int i = 0; i < ranNum.length; i++) {
            ranNum[i].num = random.nextInt(5) + 1;
            for (int j = 0; j < i; j++) {
                if (ranNum[i].num== ranNum[j].num) {
                    i--;
                }
            }
//            if (!ranNum[i].check) {
//                ranNum[i].check = true;
//                ranNum[i].num = rNum + 1;
//            } else {
//                i--;
//            }
        }

        for (int i = 0; i < ranNum.length; i++) {
            System.out.print(ranNum[i].num + " ");
        }
    }
}
