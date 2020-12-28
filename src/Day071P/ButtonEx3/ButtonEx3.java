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
        if (button == e.getSource()){
            button.setText("이름 바뀜");
        }
    }
}

public class ButtonEx3 {
    public static void main(String[] args) {

    }
}
