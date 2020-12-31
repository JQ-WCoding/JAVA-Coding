package Portfolio.oneToFifty;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MainPanel extends JPanel implements ActionListener {
    static boolean gameStart = false;
    final int SIZE = 5;
    int[][] frontBoard;
    int[][] backBoard;
    BoardPanel[][] boardButtons;
    JLabel countNumber;
    JButton restart;
    static JLabel time;
    int counting = 1;

    public MainPanel() {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        setLayout(null);
        Font font = new Font("맑은 고딕", Font.BOLD, 40);
        setFont(font);
        mainBasicSetting();
//        add(new BoardPanel());
    }

    public void mainBasicSetting() {
        frontBoard = new int[SIZE][SIZE];
        backBoard = new int[SIZE][SIZE];
        boardButtons = new BoardPanel[SIZE][SIZE];

        setFrontBoard();
        setBackBoard();

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                boardButtons[i][j] = new BoardPanel();
                boardButtons[i][j].boardButton = new JButton();
                boardButtons[i][j].boardButton.setBounds(150 + (100 * j), 200 + (100 * i), 100, 100);
                boardButtons[i][j].boardButton.setText(frontBoard[i][j] + "");
                boardButtons[i][j].boardButton.addActionListener(this);
                add(boardButtons[i][j].boardButton);
            }
        }

        countNumber = new JLabel();
        countNumber.setText(counting + "");
        countNumber.setBounds(500, 0, 300, 50);
        countNumber.setBackground(Color.BLACK);
        countNumber.setForeground(Color.WHITE);
        countNumber.setOpaque(true);
        countNumber.setHorizontalAlignment(JLabel.CENTER);
        countNumber.setFont(getFont());
        add(countNumber);

        time = new JLabel();
        time.setText("00 : 00 : 00");
        time.setBounds(0, 0, 500, 50);
        time.setBackground(Color.BLACK);
        time.setForeground(Color.WHITE);
        time.setOpaque(true);
        time.setHorizontalAlignment(JLabel.LEFT);
        time.setFont(getFont());
        add(time);

        restart = new JButton("다시하기");
        restart.setBounds(10, 50, 300, 50);
        restart.setBackground(Color.PINK);
        restart.setForeground(Color.WHITE);
        restart.setOpaque(true);
        restart.setHorizontalAlignment(JButton.CENTER);
        restart.setFont(getFont());
        restart.addActionListener(this);
        add(restart);
    }

    /**
     * 1 ~ 25 보드 세팅
     */
    public void setFrontBoard() {
        Random random = new Random();
        int count = 1;

        while (true) {
            int x = random.nextInt(frontBoard.length);
            int y = random.nextInt(frontBoard.length);
            if (frontBoard[y][x] != 0) {
                continue;
            }
            frontBoard[y][x] = count;
            count++;
            if (count > 25) {
                break;
            }
        }
    }

    /**
     * 26 ~ 50 보드 세팅
     */
    public void setBackBoard() {
        Random random = new Random();
        int count = 26;
        while (true) {
            int x = random.nextInt(frontBoard.length);
            int y = random.nextInt(frontBoard.length);
            if (backBoard[y][x] != 0) {
                continue;
            }
            backBoard[y][x] = count;
            count++;
            if (count > 50) {
                break;
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        clickRestart(e);
        numberClick(e);
    }

    public void numberClick(ActionEvent e) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (boardButtons[i][j].boardButton == e.getSource()) {
                    if (boardButtons[i][j].boardButton.getText().equals("1")) {
                        StopWatch.play = true;
                        StopWatch stopWatch = new StopWatch();
                        stopWatch.start();

                        gameStart = true;
                    }
                    if (boardButtons[i][j].boardButton.getText().equals("50")) {
                        StopWatch.play = false;
                    }
                    if ((countNumber.getText()).equals(boardButtons[i][j].boardButton.getText())) {
                        if (counting <= 25) {
                            boardButtons[i][j].boardButton.setText(backBoard[i][j] + "");
                            boardButtons[i][j].boardButton.setBackground(Color.ORANGE);
                        } else {
                            boardButtons[i][j].boardButton.setText("");
                            boardButtons[i][j].boardButton.setBackground(Color.WHITE);
                        }
                        counting++;
                        countNumber.setText(counting + "");
                        if (counting > 50){
                            countNumber.setText("완료");
                        }
                    }
                }
            }
        }
    }

    public void clickRestart(ActionEvent e) {
        if (restart == e.getSource()) {
            // 스톱워치와 게임 종료
            StopWatch.play = false;
            gameStart = false;
            // 보드 리셋
            boardReset();
        }
    }

    public void boardReset() {
        frontBoard = new int[SIZE][SIZE];
        backBoard = new int[SIZE][SIZE];
        setFrontBoard();
        setBackBoard();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                boardButtons[i][j].boardButton.setText(frontBoard[i][j] + "");
                boardButtons[i][j].boardButton.setBackground(Color.cyan);
            }
        }
        counting = 1;
        countNumber.setText(counting + "");
    }
}
