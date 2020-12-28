package Day071P.ButtonTicTacToe;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MyPanel extends JPanel implements ActionListener {
    JButton[][] buttons;
    int[][] nums;
    boolean turn;
    JButton resetButton;
    JButton showWinner;

    public MyPanel() {
        setLayout(null);

        basicSetting();
        resetButton();
        showWinner();
    }

    public void showWinner() {
        showWinner = new JButton("승자는?");
        showWinner.setSize(100, 50);
        showWinner.setLocation(50, 350);
        showWinner.addActionListener(this);

        add(showWinner);
    }

    public void resetButton() {
        resetButton = new JButton("다시 시작");
        resetButton.setSize(100, 50);
        resetButton.setLocation(250, 350);
        resetButton.addActionListener(this);

        add(resetButton);
    }

    public void basicSetting() {
        buttons = new JButton[3][3];
        nums = new int[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton("");

                buttons[i][j].setSize(100, 100);
                buttons[i][j].setLocation(50 + 100 * j, 50 + 100 * i);
                buttons[i][j].addActionListener(this);

                add(buttons[i][j]);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (buttons[i][j] == e.getSource()) {
                    if (turn) {
                        if (nums[i][j] == 0) {
                            buttons[i][j].setText("O");
                            nums[i][j] = 1;
                        }
                    } else {
                        if (nums[i][j] == 0) {
                            buttons[i][j].setText("X");
                            nums[i][j] = 2;
                        }
                    }
                }
            }
        }
        turn = !turn;

        if (resetButton == e.getSource()) {
            new MyPanel();
        }
    }
}

public class ButtonEx5 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Tic Tac Toe");

        frame.setBounds(100, 100, 450, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setContentPane(new MyPanel());
        frame.setVisible(true);
        frame.revalidate();
    }
}
