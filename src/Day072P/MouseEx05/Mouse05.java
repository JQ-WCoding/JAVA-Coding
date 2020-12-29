package Day072P.MouseEx05;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class Rect {
    int x, y, width, height;
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
        super.paintComponent(g);

        try {
            Thread.sleep(10);
        } catch (Exception e) {
            e.printStackTrace();
        }

        g.drawRect(rect.x, rect.y, rect.width, rect.height);
        rect.x++;

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
        rect.x = 0;
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }
}

public class Mouse05 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("마우스 연습문제5");
        frame.setBounds(100, 100, 500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setContentPane(new MyPanel());
        frame.setVisible(true);
        frame.revalidate();
    }
}
