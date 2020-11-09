package Day025_P;

public class Day02503구구단P1 {
    public static void main(String[] args) {
        /*
         * 2 x 1 = 2
         * 2 x 2 = 4
         * 2 x 3 = 6
         * ...
         * 3 x 1 = 3
         * 3 x 2 = 6
         * ...
         * 9 x 1 = 9
         * ...
         * 9 x 9 = 81
         */
        for (int i = 2; i < 9; i++) {
            for (int j = 1; j < 9; j++) {
                int total = i * j;
                System.out.printf("%d * %d = %d \t",i,j,total);
            }
            System.out.println();
        }
    }
}
