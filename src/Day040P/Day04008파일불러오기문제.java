package Day040P;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.regex.Pattern;

public class Day04008파일불러오기문제 {
    public static void main(String[] args) {
        String[] ids = null;
        String[] pws = null;
        int[] moneys = null;

        String fileName = "fileTest02.txt";
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        String data = "";

        try {
            fileReader = new FileReader(fileName);
            bufferedReader = new BufferedReader(fileReader);
//            data = bufferedReader.readLine();
            // 한줄만 출력됨
//            System.out.println(data);
            /*
            모든 내용을 다 받아오기 위함
             */
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                data += line;
                data += "\n";
            }

//            data = data.substring(0, data.length() - 1);
            System.out.println(data);
            /*
            띄어쓰기를 구분해서 데이터 입력 받아두기
            1) monk/1111/20000  2) megait/2222/30000  3) github/3333/40000
             */
            String[] temp = data.split("\n");
            int size = temp.length; // temp 배열의 길이 확인
            /*
            사이즈에 맞게 배열 선언
             */
            ids = new String[size];
            pws = new String[size];
            moneys = new int[size];

            for (int i = 0; i < size; i++) {
                String[] info = temp[i].split("/");
                ids[i] = info[0];
                pws[i] = info[1];
                moneys[i] = Integer.parseInt(info[2]); // 정수형 형변환 필요
            }
            for (int i = 0; i < size; i++) {
                System.out.printf("%s : %s : %d원 \n", ids[i], pws[i], moneys[i]);
            }
            System.out.println("ID : " + Arrays.toString(ids));
            System.out.println("Pw : " + Arrays.toString(pws));
            System.out.println("Money : " + Arrays.toString(moneys));

            fileReader.close();
            bufferedReader.close();
        } catch (Exception e) {
            System.out.println("file load error");
            e.printStackTrace();
        }
    }
}
