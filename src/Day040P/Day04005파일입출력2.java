package Day040P;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * # 파일 불러오기
 * 1. FileReader fr = new FileReader("파일명.txt");
 * 2. BufferedReader br = new BufferedReader(fr);
 * 3. String data = br.readLine();
 * 4. fr.close();
 *    br.close();
 *
        * # 파일 불러오기
        *1.저장되어 있는 파일을 읽어온다.
        *FileReader fr=new FileReader("파일 이름");
        *2.fr로 가져온 파일을 String 으로 데이터를 가져올 수 있는 BufferedReader 를 이용한다.
        *BufferedReader br=new BufferedReade(fr);
        **3.BufferedReader 클래스의 readLine()메서드를 이용해서 String 으로 데이터를 가져온다.
        *String data=br.readLine();
        *4.반드시 닫아야된다.
        *fr.close();
        *br.close();

 */
public class Day04005파일입출력2 {
    public static void main(String[] args) {
        String fileName = "JAVA_PRACTICE.txt";
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(fileName);
            bufferedReader = new BufferedReader(fileReader);
//            FileReader fileReader = new FileReader("FileWriterEx01.txt"); // 파일리더 생성
//            BufferedReader bufferedReader = new BufferedReader(fileReader); // 버퍼리더로 파일리더 불러오기
            String data = bufferedReader.readLine(); // 문자열로 전환
            System.out.println(data);

            fileReader.close();
            bufferedReader.close();
        }catch (Exception e){
            System.out.println("파일을 불러올 수 없습니다");
            e.printStackTrace();
        }
    }
}
