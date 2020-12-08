package Day057P;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class Node {
    int front;
    int back;
}

class MemoryGame {
    ArrayList<Node> nodeList;
    int[] data;
    final int SIZE = 10;
    Scanner scanner = new Scanner(System.in);

    /**
     * shuffle number
     */
    public void shuffle() {
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            int r = random.nextInt(data.length);
            int temp = data[r];
            data[r] = data[0];
            data[0] = temp;
        }
    }

    /**
     * init(초기화)
     */
    public void dataInit() {
        data = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            data[i] = (i + 1) / 2;
        }
    }

    /**
     * nodeInit
     */
    public void nodeInit() {
        nodeList = new ArrayList<>();
        for (int i = 0; i < SIZE; i++) {
            Node node = new Node();
            node.front = data[i];
            nodeList.add(node);
        }
    }
}

public class Day05708기억력게임 {
    public static void main(String[] args) {

    }
}
