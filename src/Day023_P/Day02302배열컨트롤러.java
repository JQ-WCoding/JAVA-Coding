package Day023_P;

import java.util.Scanner;

public class Day02302배열컨트롤러 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // ArrayList 뒷 길이에 상관없이 스스로 만들기
        int[] arr = {10, 20, 0, 0, 0};

        int count = 2; // 기본 arr배열내에 수 2개가 이미 입력 상태
        int choice; // 메뉴 선택 이동에 대한 변수 선언
        while (true) {
            // arr 배열 한번 나열하기
            for (int j : arr) {
                System.out.print(j + " ");
            }
            System.out.println();
            // 메뉴구성
            System.out.println("[1] 추가하기");
            System.out.println("[2] (값으로) 삭제하기");
            System.out.println("[3] (인덱스로) 삭제하기");
            System.out.println("[0] 종료하기");
            choice = scanner.nextInt(); // 메뉴 선택 입력받기 (1 ~ 3) 과 (0)만 입력가능
            if (choice == 1) { // 메뉴 1번
                System.out.println("[추가] 값 입력 : ");
                int value = scanner.nextInt(); // 값 입력받기
                arr[count] = value; // arr[count] 값 내에 value 값 설정 count는 임시 인덱스 번호
                count++; // 정확하게 입력하였을 경우 count는 1씩 증가
                if (count == 5) {
                    System.out.println("[초과] 수 입력 불가");
                    continue;
                }
            } else if (choice == 2) { // 메뉴 2번
                System.out.println("[삭제] 값 입력 : ");
                int value = scanner.nextInt(); // 삭제 값을 입력받기
                int index; // arr[i]에 대한 index값 차기
                for (int i = 0; i < arr.length; i++) { // 전체 반복을 통해 value와 같은 값을 찾는다
                    if (arr[i] == value) { // arr[i]의 배열에서 value를 찾을 경우
                        index = i; // index를 i로 초기화
                        for (int j = index; j < count - 1; j++) { // 받은 인덱스 번호부터 'count - 1'까지 값 이동시키기
                            arr[j] = arr[j + 1]; // ex) arr[1] = arr[2] / arr[2] = arr[3]으로 변화
                        }
                        arr[count - 1] = 0; // 가장 마지막 자리의 값 0으로 초기화
                        count--; // count 값은 하나 줄어든다
                    }
                    System.out.println("[오류] 해당 값이 없습니다");
                    break; // 메인 반복으로 바로 이동
                }
                System.out.println();
            } else if (choice == 3) {
                System.out.println("[삭제] 인덱스 입력 : "); // 메세지 출력
                int index = scanner.nextInt(); // 인덱스 번호 입력받기
                if (index < 0 || index >= count) { // 인덱스가 0보다 작거나 5이상이면 오류 : arr의 공간은 0 ~ 4까지
                    System.out.println("[메세지] 해당값을 입력 받을 수 없습니다."); // 경고 메세지
                    continue; // 반복문 while 최상단으로 이동
                }
                // else와 같은 상황
                for (int i = index; i < count - 1; i++) { // count - 1인 이유 : arr의 최대 인덱스 번호는 4이다
                    arr[i] = arr[i + 1]; // arr[i]의 값은 arr[i+1]로 뒤로 한칸 이동
                }
                arr[count - 1] = 0;
                count--; // 정상적으로 작동했을 경우, count는 하나 줄어야한다.

            } else if (choice == 0) {
                System.out.println("[종료] 프로그램 종료"); // 종료 메세지
                break; // 메인 반복문 종료 시키기
            } else {
                System.out.println("[오류] 다시 입력해주세요"); // 메뉴 버튼 선택의 오류시 출력되는 메세지
            }
        }
        for (int i = 0; i < count; i++) { // count만큼의 배열 값만 출력 후 나머지는 표시하지 않는다.
            System.out.print(arr[i] + " ");
        }
        System.out.println(); // 줄바꿈
    }
}
