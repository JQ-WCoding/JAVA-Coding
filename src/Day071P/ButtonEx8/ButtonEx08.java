package Day071P.ButtonEx8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Node {
    int y;
    int x;
    int num;
    int size;
}

class MyPanel extends JPanel implements ActionListener {
    final int SIZE = 10;

    JButton resetButton;

    Node[][] list;
    JButton[][] buttons;
    boolean turn;

    public MyPanel() {
        setLayout(null);
        basicSetting();
    }

    public void basicSetting() {
        // 맥에서 버튼 색상이 칠해지지 않는 오류 해결 방법 (플랫폼간 비슷하게 보이게끔 하는 방법)
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        resetButton = new JButton("처음부터");
        resetButton.setBounds(600, 50, 120, 50);
        resetButton.addActionListener(this);
        add(resetButton);

        list = new Node[SIZE][SIZE];
        buttons = new JButton[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                list[i][j] = new Node();

                list[i][j].num = 0;
                list[i][j].size = 50;

                list[i][j].y = 50 + list[i][j].size * i;
                list[i][j].x = 50 + list[i][j].size * j;
            }
        }
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                buttons[i][j] = new JButton();
//                UIManager.put(buttons[i][j],Color.LIGHT_GRAY);
                buttons[i][j].setBackground(Color.LIGHT_GRAY);
//                buttons[i][j].setOpaque(true);
//                buttons[i][j].setBorderPainted(false);
                buttons[i][j].setBounds(list[i][j].x, list[i][j].y, list[i][j].size, list[i][j].size);
                buttons[i][j].addActionListener(this);

                add(buttons[i][j]);
            }
        }
    }

    public void resetGame() {
        turn = false;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                list[i][j].num = 0;

                buttons[i][j].setBackground(Color.WHITE);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (resetButton == e.getSource()) {
            resetGame();
        }

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (buttons[i][j] == e.getSource()) {
                    if (list[i][j].num == 0) {
                        if (turn) {
                            list[i][j].num = 1;
                            buttons[i][j].setBackground(Color.RED);
                        } else {
                            list[i][j].num = 2;
                            buttons[i][j].setBackground(Color.BLUE);
                        }
                        buttons[i][j].setOpaque(true);
                        turn = !turn;
                    }
                }
            }
        }
    }
}

public class ButtonEx08 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("오목 게임");
        frame.setBounds(100, 100, 800, 650);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new MyPanel());
        frame.setVisible(true);
        frame.revalidate();
    }
}
