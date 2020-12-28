package Day071P.ButtonEx3;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MyPanel extends JPanel implements ActionListener {

    JButton button;

    public MyPanel() {
        setLayout(null);

        button = new JButton();
        button.setText("버튼이름");
        button.setSize(100, 100);
        button.setLocation(100, 100);

        button.addActionListener(this);

        add(button);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (button == e.getSource()) {
            button.setText("이름 바뀜");
        }
    }
}

public class ButtonEx3 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("버튼 연습문제3");

        frame.setBounds(100, 100, 1000, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setContentPane(new MyPanel());

        frame.setVisible(true);
        frame.revalidate();
    }
}
