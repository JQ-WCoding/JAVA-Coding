package Day072P.MouseEx03;

import javax.swing.*;
import java.awt.*;
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
    protected void paintComponent(Graphics g) {
        g.drawRect(rect.x, rect.y, rect.width, rect.height);

        // paintComponent() 메서드를 다시 호출시킨다
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }
}

public class Mouse03 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("마우스 연습문제3");
        frame.setBounds(100, 100, 500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new MyPanel());
        frame.setVisible(true);
        frame.revalidate();
    }
}
