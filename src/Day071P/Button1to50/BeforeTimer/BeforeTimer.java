package Day071P.Button1to50.BeforeTimer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

class MyPanel extends JPanel implements ActionListener {
    JButton mainPanel;

    int gameNum;

    JButton[] buttons;
    int[] front;
    int[] back;

    public MyPanel() {
        setLayout(null);

        basicSetting();
        numShuffle();
        setTextButtons();
    }

    public void basicSetting() {
        gameNum = 1;

        mainPanel = new JButton("Next Num = " + gameNum);
        mainPanel.setBounds(50, 10, 200, 50);
        mainPanel.setBackground(Color.WHITE);
        add(mainPanel);

        buttons = new JButton[5];
        front = new int[5];
        back = new int[5];

        for (int i = 0; i < 5; i++) {
            front[i] = i + 1;
            back[i] = i + 6;
        }

        for (int i = 0; i < 5; i++) {
            buttons[i] = new JButton("");
            buttons[i].setSize(100, 100);
            buttons[i].setLocation(50 + 100 * i, 100);
            buttons[i].addActionListener(this);

            add(buttons[i]);
        }
    }

    public void numShuffle() {
        Random random = new Random();

        for (int i = 0; i < 5; i++) {
            int r = random.nextInt(5);

            int temp = front[0];
            front[0] = front[r];
            front[r] = temp;
        }

        for (int i = 0; i < 5; i++) {
            int r = random.nextInt(5);

            int temp = back[0];
            back[0] = back[r];
            back[r] = temp;
        }
    }

    public void setTextButtons() {
        for (int i = 0; i < 5; i++) {
            buttons[i].setText(front[i] + "");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 5; i++) {
            if (buttons[i] == e.getSource()) {
                if (buttons[i].getText().equals(gameNum + "")) {

                    if (1 <= gameNum && gameNum <= 5) {
                        buttons[i].setText(back[i] + "");
                    } else {
                        buttons[i].setText("");
                    }

                    gameNum++;

                    mainPanel.setText("Next Num = " + gameNum);
                }
            }
        }
        if (gameNum > 10) {
            mainPanel.setText("Game Over");
        }
    }
}

public class BeforeTimer {
    public static void main(String[] args) {
        JFrame frame = new JFrame("1 to 50");

        frame.setBounds(100, 100, 600, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setContentPane(new MyPanel());

        frame.setVisible(true);
        frame.revalidate();
    }
}
