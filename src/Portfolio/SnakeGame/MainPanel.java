package Portfolio.SnakeGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MainPanel extends JPanel implements ActionListener {
    final int SIZE = 10;
    JButton[][] map;
    JButton[] direction;
    // 맵 내에 숫자로 표현된
    int[][] data;
    int snakeSize;
    int[] x;
    int[] y;
    int[] snake;
    int itemCount = 0;
    int itemPlus = 31;
    int itemMinus = 32;


    public MainPanel() {
        setLayout(null);

        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        map = new JButton[SIZE][SIZE];
        // 상하좌우 4가지 방향버튼
        direction = new JButton[4];
        data = new int[SIZE][SIZE];
        // 기본 뱀 크기
        snakeSize = 4;

        x = new int[snakeSize];
        y = new int[snakeSize];
        snake = new int[snakeSize];

        setNumber();
        setMap();
        setSnake();
        setButton();
    }

    /**
     * 뱀 몸통 번호 입력
     */
    public void setNumber() {
        for (int i = 0; i < snakeSize; i++) {
            x[i] = i;
            snake[i] = i + 1;
            data[y[i]][x[i]] = snake[i];
        }
    }

    /**
     * 뱀 세팅
     */
    public void setSnake() {
        // 초기 화면 세팅
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (data[i][j] == itemPlus) {
                    map[i][j].setBackground(Color.YELLOW);
                } else if (data[i][j] == itemMinus) {
                    map[i][j].setBackground(Color.GREEN);
                } else {
                    map[i][j].setBackground(Color.WHITE);
                }
            }
        }
        // 뱀 세팅
        map[y[0]][x[0]].setBackground(Color.BLUE);
        for (int i = 1; i < snakeSize; i++) {
            map[y[i]][x[i]].setBackground(Color.RED);
        }
    }

    /**
     * 바향키 버튼 세팅
     */
    public void setButton() {
        // 이동 버튼 (방향키)
        Font font = new Font("맑은 고딕", Font.BOLD, 30);
        for (int i = 0; i < direction.length; i++) {
            direction[i] = new JButton();
            direction[i].setSize(100, 100);
            if (i < 3) {
                direction[i].setLocation(550 + 100 * (i + 1), 400);
            } else {
                direction[i].setLocation(550 + 100 * 2, 300);
            }
            direction[i].setFont(font);
            direction[i].setHorizontalAlignment(JButton.CENTER);
            direction[i].addActionListener(this);

            add(direction[i]);
        }
        direction[0].setText("<");
        direction[1].setText("V");
        direction[2].setText(">");
        direction[3].setText("^");
    }

    /**
     * 전체 맵
     */
    public void setMap() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = new JButton();
                map[i][j].setSize(50, 50);
                map[i][j].setLocation(50 * (j + 1), 50 * (i + 1));
                add(map[i][j]);
            }
        }
    }

    /**
     * 아이템 세팅
     */
    public void setItem() {
        Random random = new Random();
        // itemPlus or itemMinus 둘중 하나 구분 짓기
        int randomItem = random.nextInt(2);

        int locationY = random.nextInt(SIZE);
        int locationX = random.nextInt(SIZE);

        if (data[locationY][locationX] == 0) { // 맵이 빈칸이면
            if (randomItem == 0) {
                // 꼬리 증가 아이템
                data[locationY][locationX] = itemPlus;
                map[locationY][locationX].setBackground(Color.YELLOW);
            } else {
                // 꼬리 감소 아이템
                data[locationY][locationX] = itemMinus;
                map[locationY][locationX].setBackground(Color.GREEN);
            }
            itemCount++;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (itemCount < 4){
            while (itemCount < 4){
                setItem();
            }
        }

        int index = 0;
        for (int i = 0; i < direction.length; i++) {
            if (direction[i] == e.getSource()) {
                index = i;
            }
        }

        int moveY = 0;
        int moveX = 0;

        if (index == 0) { // 좌
            moveX = x[0] - 1;
            moveY = y[0];
        } else if (index == 1) { // 하
            moveX = x[0];
            moveY = y[0] + 1;
        } else if (index == 2) { // 우
            moveX = x[0] + 1;
            moveY = y[0];
        } else if (index == 3) { // 상
            moveX = x[0];
            moveY = y[0] - 1;
        }

        if (SIZE <= moveX || moveX < 0 || SIZE <= moveY || moveY < 0) return;

        if (data[moveY][moveX] != 0 && data[moveY][moveX] != itemMinus && data[moveY][moveX] != itemPlus) { // 자신의 꼬리를 물었을 경우
            gameOver();
        }
        // 꼬리부분 0으로 초기화
        data[y[snakeSize - 1]][x[snakeSize - 1]] = 0;

        int[] tempX = x;
        int[] tempY = y;
        int[] tempSnake = snake;
        if (data[moveY][moveX] == itemPlus) { // 꼬리 길어지는 아이템
            getItem(tempY, tempX, tempSnake, true);
        } else if (data[moveY][moveX] == itemMinus) { // 꼬리 짧아지는 아이템
            getItem(tempY, tempX, tempSnake, false);
        } else if (data[moveY][moveX] == 0) { // 빈공간을 지나갈때
            for (int i = snakeSize - 1; i > 0; i--) {
                y[i] = y[i - 1];
                x[i] = x[i - 1];
            }
        }

        y[0] = moveY;
        x[0] = moveX;

        // 뱀이 지나간 부분 제거
        for (int i = 0; i < tempX.length; i++) {
            data[tempY[i]][tempX[i]] = 0;
        }

        for (int i = 0; i < snakeSize; i++) {
            data[y[i]][x[i]] = snake[i];
        }
        setSnake();
    }

    public void getItem(int[] tempY, int[] tempX, int[] tempSnake, boolean check) {
        if (check) {
            snakeSize++;
        } else {
            snakeSize--;
        }
        itemCount--;
        x = new int[snakeSize];
        y = new int[snakeSize];
        snake = new int[snakeSize];
        for (int i = 1; i < snakeSize; i++) {
            x[i] = tempX[i - 1];
            y[i] = tempY[i - 1];
            snake[i] = tempSnake[i - 1] + 1;
        }
        snake[0] = 1;
    }

    public void gameOver() {
        JFrame frame = new JFrame("GameOver");
        frame.setBounds(200, 200, 200, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.revalidate();
    }
}
