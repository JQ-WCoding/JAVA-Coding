package Day025_P;

public class Day02504삼각형그리기P1 {
    public static void main(String[] args) {
        /*
         * 문제 1)
         * #
         * ##
         * ###
         */
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("#");
            }
            System.out.println();
        }
        System.out.println();
        /*
         * 문제 2)
         * ###
         * ##
         * #
         */
        for (int i = 0; i < 3; i++) {
            for (int j = 3 - i; j > 0; j--) {
                System.out.print("#");
            }
            System.out.println();
        }
        System.out.println();
        /*
         * 문제 3)
         * @##
         * @@#
         * @@@
         */
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i < j) {
                    System.out.print("#");
                } else {
                    System.out.print("@");
                }
            }
            System.out.println();
        }
        System.out.println();
        /*
         * 문제 4)
         * @@#
         * @###
         * #####
         */
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3 + i; j++) {
                if (i + j < 2) {
                    System.out.print("@");
                } else {
                    System.out.print("#");
                }
            }
            System.out.println();
        }
    }
}
