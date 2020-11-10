package Day040P;

import java.io.FileReader;
import java.io.FileWriter;

/**
 * 각 배열을 data 문자열에 한번에 저장 할 수 있도록 하기
 */
public class Day04007파일저장문제2 {
    public static void main(String[] args) {
        String[] names = {"momk", "megait", "github"};
        String[] pws = {"1111", "2222", "3333"};
        int[] moneys = {20000, 30000, 40000};

        String fileName = "fileTest02.txt";

        String data = "";

        // 위데이터를 아래와같이 저장해보세요.

        // momk/1111/20000
        // megait/2222/30000
        // github/3333/40000

        FileWriter fileWriter = null;
        try {
            for (int i = 0; i < names.length; i++) {
                data += names[i] + "/" + pws[i] + "/" + moneys[i] + "\n";
            }
            fileWriter = new FileWriter(fileName);
            fileWriter.write(data);

            fileWriter.close();
        } catch (Exception e) {
            System.out.println("save file error");
            e.printStackTrace();
        }
    }
}
