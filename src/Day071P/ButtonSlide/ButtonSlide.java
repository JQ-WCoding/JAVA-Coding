package Day071P.ButtonSlide;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

class MyPanel extends JPanel implements ActionListener {
    final int SIZE = 5;

    JButton[][] buttons;
    int[][] nums;

    public MyPanel() {
        setLayout(null);

        basicSetting();
        numShuffle();
        setTextOfButtons();
    }

    public void basicSetting() {
        buttons = new JButton[SIZE][SIZE];
        nums = new int[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setText("");
                buttons[i][j].setBounds(50 + 100 * j, 50 + 100 * i, 100, 100);
//                buttons[i][j].setBackground(Color.GREEN);
                buttons[i][j].addActionListener(this);

                add(buttons[i][j]);
            }
        }
        int k = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                nums[i][j] = k;
                k++;
            }
        }
    }

    public void numShuffle() {
        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            int rY = random.nextInt(SIZE);
            int rX = random.nextInt(SIZE);

            int temp = nums[0][0];
            nums[0][0] = nums[rY][rX];
            nums[rY][rX] = temp;
        }
    }

    public void setTextOfButtons() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (nums[i][j] == 0) {
                    buttons[i][j].setText("");
                } else {
                    buttons[i][j].setText(nums[i][j] + "");
                }
            }
        }
    }

    public JButton checkBlank(int y, int x) {
        JButton button = null;
        // 가로 검사
        for (int i = 0; i <= 1; i++) {
            if (i == 0) continue;

            int tempY = y + i;
            if (SIZE <= tempY || tempY < 0) continue;
            if (buttons[tempY][x].getText().equals("")) {
                button = buttons[tempY][x];
            }
        }
        // 세로검사
        for (int i = 0; i <= 1; i++) {
            if (i == 0) continue;

            int tempX = x + i;
            if (SIZE <= tempX || tempX < 0) continue;
            if (buttons[y][tempX].getText().equals("")) {
                button = buttons[y][tempX];
            }
        }
        return button;
    }

    public void changeTextOfButtons(JButton button, String text) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (buttons[i][j] == button) {
                    buttons[i][j].setText(text);
                    nums[i][j] = Integer.parseInt(text);
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (buttons[i][j] == e.getSource()) {
                    // 누른 숫자
                    String text = buttons[i][j].getText();

                    // 누른 버튼 상하좌우로 공백이 있는지 검사
                    JButton button = checkBlank(i, j);

                    // 누른 버튼 주변에 공백이 있으면
                    if (button != null) {
                        // 누른 버튼의 값은 초기화 해주고
                        buttons[i][j].setText("");
                        nums[i][j] = 0;

                        // 공백은 누른 버튼의 숫자로 변경
                        changeTextOfButtons(button, text);
                    }
                }
            }
        }
    }
}

public class ButtonSlide {
    public static void main(String[] args) {
        JFrame frame = new JFrame("숫자 슬라이드 게임");

        frame.setBounds(100,100,650,650);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new MyPanel());
        frame.setVisible(true);
        frame.revalidate();
    }
}
