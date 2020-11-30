package Day053P;

import java.util.Random;

class Horse {
    String name;
    int position;
    int rank;
    boolean win;
}

class Racing {
    Random random = new Random();

    int size = 4;
    int line = 20;

    Horse[] horses = new Horse[size];
    int[][] track = new int[size][line];

    public void run() {
        String name = "ABCD";
        for (int i = 0; i < size; i++) {
            horses[i] = new Horse();
            horses[i].name = name.charAt(i) + " ";
        }
        play();
        printHorse();
        showRank();
    }

    public void showRank() {
        for (int i = 0; i < size; i++) {
            System.out.print(horses[i].name + "말 등수 : " + horses[i].rank + "등 \t");
        }
        System.out.println();
    }

    public void printHorse() {
        System.out.println();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < line; j++) {
                if (horses[i].position == j) {
                    System.out.print("[" + horses[i].name + "]");
                } else {
                    System.out.print("[ ]");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public void play() {
        int count = 0;

        boolean loop = true;
        while (loop) {
            printHorse();

            for (int i = 0; i < size; i++) {
                if (horses[i].win == true) continue;

                int r = random.nextInt(4) + 1;
                horses[i].position += r;

                if (horses[i].position >= 19) {
                    horses[i].position = 19;
                    horses[i].rank = count + 1;
                    horses[i].win = true;
                    count++;
                    if (count >= size) {
                        loop = false;
                        break;
                    }
                }
            }
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

public class Day05307클래스경마게임 {
    public static void main(String[] args) {
        Racing racing = new Racing();
        racing.run();
    }
}
