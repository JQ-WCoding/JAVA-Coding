package Day071P.ButtonEx2;

import javax.swing.*;

class MyPanel extends JPanel {
    JButton button;

    public MyPanel() {
        setLayout(null);

        button = new JButton();
        button.setText("버튼 이름");
        button.setSize(100, 100);
        button.setLocation(100, 100);

        add(button);
    }
}

public class ButtonEx2 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("버튼 연습문제2");

        frame.setBounds(100, 100, 1000, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setContentPane(new MyPanel());

        frame.setVisible(true);
        frame.revalidate();
    }
}
