package Day071P.ButtonEx4;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MyPanel extends JPanel implements ActionListener {
    JButton[] buttons;

    public MyPanel() {
        setLayout(null);

        buttons = new JButton[5];
        for (int i = 0; i < 5; i++) {
            buttons[i] = new JButton((i + 1) + "");

            buttons[i].setSize(100, 100);
            buttons[i].setLocation(100 + 100 * i, 100);
            buttons[i].addActionListener(this);

            add(buttons[i]);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 5; i++) {
            if (buttons[i] == e.getSource()) {
                buttons[i].setText("뿅");
            }
        }
    }
}

public class ButtonEx4 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("버튼 연습문제4");

        frame.setBounds(100, 100, 1000, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new MyPanel());
        frame.setVisible(true);
        frame.revalidate();
    }
}
