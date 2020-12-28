package Day071P.Button1to50.AfterTimer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

class StopWatch extends Thread {
    static String timeText;

    long time = 0l, preTime = 0l;
    static boolean play;

    public void run() {
        preTime = System.currentTimeMillis();
        while (play) {
            try {
                sleep(10);
                time = System.currentTimeMillis() - preTime;
                int m = (int) (time / 1000.0 / 60.0);
                int s = (int) (time % (1000.0 * 60) / 1000.0);
                int ms = (int) (time % 1000 / 10.0);

                timeText = m + " : " + s + " : " + ms;
                System.out.println(timeText);

                if (MyPanel.gameStart) {
                    MyPanel.time.setText("버튼을 누르면 스톱워치가 시작됩니다");
                } else {
                    MyPanel.time.setText(StopWatch.timeText);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

class MyPanel extends JPanel implements ActionListener {
    static boolean gameStart = true;

    JButton mainPanel;
    JButton reStart;
    static JButton time;
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

        reStart = new JButton("게임 재시작");
        reStart.setBounds(450, 220, 100, 30);
        reStart.addActionListener(this);
        add(reStart);

        time = new JButton("버튼을 누르면 스톱워치가 시작됩니다");
        time.setBounds(300, 10, 250, 50);
        time.setBackground(Color.WHITE);
        add(time);

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
        if (gameStart) {
            StopWatch.play = true;

            StopWatch stopWatch = new StopWatch();
            stopWatch.start();

            gameStart = false;
        }

        if (reStart == e.getSource()) {
            StopWatch.play = false;
            gameStart = true;
            gameNum = 1;
            mainPanel.setText("Next Num = " + gameNum);

            numShuffle();
            setTextButtons();
        }

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
            StopWatch.play = false;
            mainPanel.setText("게임이 종료되었습니다");
        }
    }
}

public class AfterTimer {
    public static void main(String[] args) {
        JFrame frame = new JFrame("1 to 50");
        frame.setBounds(100, 100, 600, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new MyPanel());
        frame.setVisible(true);
        frame.revalidate();
    }
}
