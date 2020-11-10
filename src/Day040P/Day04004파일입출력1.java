package Day040P;

import java.io.FileWriter;
import java.io.IOException;

/**
 * # 입출력(Input Output => IO)
 * # 파일(메모장) 생성하기
 * 1. FileWriter / java.io.FileWriter 클래스 활용
 * 2. FileWriter fw = new FileWriter("파일명.txt")
 * 3. 위에서 생성된 파일에 문자 저장
 * fw.write("저장할 내용 작성")
 * 4. 파일 닫기
 * fw.close();
 */
public class Day04004파일입출력1 {
    public static void main(String[] args) {
        String fileName = "JAVA_PRACTICE.txt";
        try {
            FileWriter fileWriter = new FileWriter(fileName); // throws 를 통해 받거나 혹은 try - catch 를 사용한다
            fileWriter.write("Just for practice hello Java");
            fileWriter.close();
        }catch (Exception e){
            e.printStackTrace(); // Stack Trace 표시해주기
        }
    }
}
