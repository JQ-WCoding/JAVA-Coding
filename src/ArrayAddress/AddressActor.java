package ArrayAddress;

import java.util.Scanner;

public class AddressActor {
    Scanner scanner = new Scanner(System.in);
    ArrayMessage arrayMessage = new ArrayMessage();

    private int choice; // 나의 선택에 관한 내용
    private int count;
    private ArrayDB[] arrayDBS;

    public AddressActor(int choice, int count, int[] arr) {
        this.choice = choice;
        this.count = count;
        arrayDBS = null;
    }

    public void mainActor() {
        while (true) {
            this.menuChoice(); // 메뉴 선택
            if (choice == 1) {
                this.addValue();
            } else if (choice == 2) {

            } else if (choice == 3) {

            } else if (choice == 4) {

            } else if (choice == 0) {
                menuExist();
                break;
            }
        }
    }

    public void menuChoice() {
        arrayMessage.choiceMenu();
        choice = scanner.nextInt();
    }

    public void menuExist() {
        arrayMessage.existMessage();
    }

    public void addValue() {
//        arrayMessage.addValue();
//        int addValue = scanner.nextInt();
//        if (count == 0) { // add
//            arr = new int[count + 1];
////                    arr[0] = addValue;
////                    count++;
//        } else if (count > 0) {
//            int[] temp = arr;
//            arr = new int[count + 1];
//            for (int i = 0; i < count; i++) {
//                arr[i] = temp[i];
//            }
//            temp = null;
////                    arr[count] = addValue;
////                    count++;
//        }
//        arr[count] = addValue;
//        count++;
    }

    public void deleteFromIndex(){

    }

}
