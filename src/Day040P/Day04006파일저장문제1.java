package Day040P;

import java.io.FileWriter;

/**
 * 파일 값을 나눠서 입력 받을 수 있게끔 한다
 */
public class Day04006파일저장문제1 {
    public static void main(String[] args) {
        // 김철수/20,이만수/30,이영희/40

        String[] names = {"김철수", "이만수", "이영희"};
        int[] ages = {20, 30, 40};

        String fileName = "fileTest01.txt";

        String data = "";
        FileWriter fileWriter = null;
        try {
            for (int i = 0; i < names.length; i++) {
                data += (i > 0) ? "," + names[i] + "/" + ages[i] : "" + names[i] + "/" + ages[i];
            }
            fileWriter = new FileWriter(fileName);
            fileWriter.write(data);

            fileWriter.close();
        } catch (Exception e) {
            System.out.println("파일 오류");
            e.printStackTrace();
        }
    }
}
