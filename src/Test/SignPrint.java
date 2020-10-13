package Test;

import java.util.Random;

public class SignPrint {
    public static void main(String[] args) {
        Random rn = new Random();
        int num = rn.nextInt(21) - 10;
        String check = (num == 0) ? "0" : (num > 0) ? "양수" : "음수";
        System.out.println(check);
    }
}
