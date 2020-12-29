package Day072P.MouseEx02;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class Rect {
    int y;
    int x;
    int width;
    int height;
}

class MyPanel extends JPanel implements MouseListener {
    Rect rect = new Rect();

    public MyPanel() {
        addMouseListener(this);
        rect.y = 50;
        rect.x = 50;

        rect.width = 100;
        rect.height = 100;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("마우스 버튼을 눌렀다 땔 때");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("마우스가 패널 위에 올라갈 때");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("마우스가 패널에서 내려올 때");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("마우스 버튼이 눌러졌을 때");
        System.out.println(e.getY() + " " + e.getX());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("눌러진 버튼이 떼어질 때");
    }
}

public class Mouse02 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("마우스 연습문제2");
        frame.setBounds(100, 100, 500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setContentPane(new MyPanel());
        frame.setVisible(true);
        frame.revalidate();
    }
}
