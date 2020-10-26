package Day029P;

import java.util.Scanner;

public class Day02908주소이론4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = null;
        int count = 0;
        while (true) {
            System.out.println("메뉴 입력");
            int choice = scanner.nextInt();
            if (choice == 1) {
                System.out.println("[추가] 값 입력");
                int addValue = scanner.nextInt();
                if (count == 0) { // add
                    arr = new int[count + 1];
//                    arr[0] = addValue;
//                    count++;
                } else if (count > 0) {
                    int[] temp = arr;
                    arr = new int[count + 1];
                    for (int i = 0; i < count; i++) {
                        arr[i] = temp[i];
                    }
                    temp = null;
//                    arr[count] = addValue;
//                    count++;
                }
                arr[count] = addValue;
                count++;
            } else if (choice == 2) { // delete
                System.out.println("삭제 인덱스");
                int deleteIndex = scanner.nextInt();

                if (deleteIndex < 0 || deleteIndex > count - 1) {
                    System.out.println("지울 수 없는 값입니다");
                    continue;
                }

                if (count == 1) {
                    arr = null;
                } else if (count > 0) {
                    int[] temp = arr;
                    arr = new int[count - 1];
                    for (int i = 0; i < deleteIndex; i++) {
                        arr[i] = temp[i];
                    }
                    for (int i = deleteIndex; i < count - 1; i++) {
                        arr[i] = temp[i + 1];
                    }
                    temp = null;
                }
                count--;
            } else if (choice == 3) { // value delete
                System.out.println("삭제할 값을 입력하세요");
                int deleteValue = scanner.nextInt();
                int deleteIndex = -1;
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i] == deleteValue) {
                        deleteIndex = i;
                    }
                }
                if (deleteIndex == -1) {
                    System.out.println("입력이 잘못되었습니다");
                    continue;
                } else {
                    if (count == 1) {
                        arr = null;
                    } else if (count > 1) {
                        int[] temp = arr;
                        arr = new int[count - 1];

                        int j = 0;
                        for (int i = 0; i < count; i++) {
                            if (i != deleteIndex) {
                                arr[j] = temp[i];
                                j++;
                            }
                        }
                        temp = null;
                    }
                    count--;
                }
            } else if (choice == 4) { // insert value to specific Index
                System.out.println("삽입 위치 값을 입력하세요");
                int addIndex = scanner.nextInt();
                if (addIndex < 0 || addIndex > count) {
                    System.out.println("위치 오류");
                    continue;
                }
                System.out.println("값을 입력하세요");
                int myValue = scanner.nextInt();
                if (count == 0) {
                    arr = new int[count + 1];
                } else if (count > 0) {
                    int[] temp = arr;
                    arr = new int[count + 1];

                    int j = 0;
                    for (int i = 0; i < arr.length; i++) {
                        if (i != addIndex) {
                            arr[i] = temp[j];
                            j++;
                        }
                    }
                    temp = null;
                }
                arr[addIndex] = myValue;
                count++;
            }
            if (choice == 0) {
                break;
            }
            for (int i = 0; i < count; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}
