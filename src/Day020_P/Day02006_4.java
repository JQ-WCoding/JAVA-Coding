package Day020_P;

public class Day02006_4 {
    public static void main(String[] args) {


        int[] arr = {44, 11, 29, 24, 76};
        int[] temp = null;
        int index = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 4 == 0) {
                count++;
            }
        }
        temp = new int[count];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] % 4 == 0){
                temp[index] = arr[i];
                index++;
            }
        }
        for (int j : temp) {
            System.out.print(j + " ");
        }
    }
}
