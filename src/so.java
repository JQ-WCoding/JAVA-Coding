import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class so {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] user = new int[3];

        while (true) {
            System.out.print("숫자입력 : ");

            for (int i = 0; i < 3; i++) {
                user[i] = bufferedReader.read() - 48;
//                if(bufferedReader.read() == 10 || bufferedReader.read() == 13)continue;
            }
            bufferedReader.read();
            bufferedReader.read();

            for (int i = 0; i < 3; i++) {
                System.out.println(user[i]);
            }

        }
    }
}
