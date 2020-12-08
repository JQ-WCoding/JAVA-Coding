package Day057P;

import java.util.ArrayList;
import java.util.Scanner;

public class Day05702리스트 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> list = new ArrayList<>();

        while (true) {
            System.out.println(list);

            System.out.println("1. 추가 2. 삭제 3. 삽입 4. 종료");
            int select = scanner.nextInt();

            if (select == 1) {
                System.out.println("[추가] 숫자 입력");
                int num = scanner.nextInt();

                list.add(num);
            } else if (select == 2) {
                System.out.println("[삭제] 인덱스 입력");
                int index = scanner.nextInt();

                if (list.size() <= 0) {
                    continue;
                }
                if (list.size() <= index || index < 0) {
                    continue;
                }

                list.remove(index);
            }else if (select == 3){
                System.out.println("[삽입] 위치 입력");
                int pos = scanner.nextInt();

                System.out.println("[삽입] 숫자 입력");
                int value = scanner.nextInt();

                list.add(pos,value);
            }else if (select == 4){
                System.out.println("종료");
                break;
            }
        }
    }
}
