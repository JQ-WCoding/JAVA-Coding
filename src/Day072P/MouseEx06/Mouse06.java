package Day072P.MouseEx06;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class Rect {
    int y, x, size, num;
}

class MyPanel extends JPanel implements MouseListener {
    final int SIZE = 5;
    Rect[] rect;

    int mY, mX;

    public MyPanel() {
        setLayout(null);
        addMouseListener(this);
        basicSetting();
    }

    public void basicSetting() {
        rect = new Rect[SIZE * SIZE];

        int i = 0;
        for (int y = 0; y < SIZE; y++) {
            for (int x = 0; x < SIZE; x++) {
                rect[i] = new Rect();

                rect[i].num = i + 1;
                rect[i].size = 50;
                rect[i].y = rect[i].size + rect[i].size + y;
                rect[i].x = rect[i].size + rect[i].size + x;
                i++;
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        // 기본 셋팅 코딩
        super.paintComponent(g);
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
        }
        repaint();

        for (int i = 0; i < rect.length; i++) {
            g.drawRect(rect[i].x, rect[i].y, rect[i].size, rect[i].size);
            g.drawString(rect[i].num + "", rect[i].x + rect[i].size / 2, rect[i].y + rect[i].size / 2);
        }

        g.drawString("마우스 y = " + mY, 350, 70);
        g.drawString("마우스 x = " + mX, 350, 90);

    }

    public Rect getClickedRect(int mX, int mY) {
        Rect temp = null;
        for (int i = 0; i < rect.length; i++) {
            if (rect[i].y < mY && mY < rect[i].y + rect[i].size) {
                if (rect[i].x < mX && mX < rect[i].x + rect[i].size) {
                    temp = rect[i];
                }
            }
        }
        return temp;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        mY = e.getY();
        mX = e.getX();

        if (getClickedRect(mX, mY) != null) {
            getClickedRect(mX, mY).num = 100;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }
}

public class Mouse06 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("마우스 연습문제6");
        frame.setBounds(100, 100, 450, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setContentPane(new MyPanel());
        frame.setVisible(true);
        frame.revalidate();
    }
}
