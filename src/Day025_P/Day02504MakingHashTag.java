package Day025_P;

public class Day02504MakingHashTag {
    public static void main(String[] args) {
        // 2차원
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print("#");
            }
            System.out.println();
        }
        System.out.println();
        // 1차원
        for (int i = 0; i < 16; i++) {
            System.out.print("#");
            if (i % 4 == 3) {
                System.out.println();
            }
        }
        System.out.println();

        // Q2)
        for (int i = 0; i < 3; i++) {
            for (int j = i; j < 3; j++) {
                System.out.print("#");
            }
            System.out.println();
        }
        System.out.println();

        // Q3)
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (j > i) {
                    System.out.print("#");
                } else {
                    System.out.print("@");
                }
            }
            // j > i #
            System.out.println();
        }
        System.out.println();
        // Q4)
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                if (i + j < 2) {
                    System.out.print("@");
                } else if (i + j > 1) {
                    if (j - i == 3) {
                        break;
                    }
                    System.out.print("#");
                }
            }
            System.out.println();
        }


    }
}