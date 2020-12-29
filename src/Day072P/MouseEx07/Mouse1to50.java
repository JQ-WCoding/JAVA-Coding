package Day072P.MouseEx07;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

class Rect {
    int y, x, size;
    int frontNum, backNum;

    Color color;
}

class MyPanel extends JPanel implements MouseListener, MouseMotionListener {
    final int SIZE = 5;
    Rect[] rect;

    int mY, mX;

    int gameNum;

    public MyPanel() {
        setLayout(null);
        addMouseListener(this); // 마우스와 패널 연결
        addMouseMotionListener(this); // 마우스 모션과 패널 연결

        basicSetting();
    }

    public void basicSetting() {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        rect = new Rect[SIZE * SIZE];

        gameNum = 1;

        int i = 0;
        for (int y = 0; y < SIZE; y++) {
            for (int x = 0; x < SIZE; x++) {
                rect[i] = new Rect();

                rect[i].color = Color.white;

                rect[i].frontNum = i + 1;
                rect[i].backNum = i + 26;

                rect[i].size = 50;
                rect[i].y = rect[i].size + rect[i].size + y;
                rect[i].x = rect[i].size + rect[i].size + x;
                i++;
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
        }
        repaint();

        for (int i = 0; i < rect.length; i++) {
            // 배경 색칠
            g.setColor(rect[i].color);
            g.fillRect(rect[i].x, rect[i].y, rect[i].size, rect[i].size);

            // 선을 그림
            g.setColor(Color.BLACK);
            g.drawRect(rect[i].x, rect[i].y, rect[i].size, rect[i].size);

            String text = "";
            if (rect[i].frontNum != 0) {
                text = rect[i].frontNum + "";
            }
            g.drawString(text, rect[i].x + rect[i].size / 2, rect[i].y + rect[i].size / 2);
        }

        g.drawString("마우스 y = " + mY, 320, 70);
        g.drawString("마우스 x = " + mX, 320, 90);
        g.drawString("다음 숫자 = " + gameNum, 320, 150);
    }

    public Rect getClickedRect(int mX, int mY) {
        Rect temp = null;
        for (int i = 0; i < rect.length; i++) {
            if (rect[i].y < mY && mY < rect[i].y + rect[i].size && rect[i].x < mX && mX < rect[i].x + rect[i].size) {
                temp = rect[i];
            }
        }
        return temp;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        mY = e.getY();
        mX = e.getX();

        Rect rect = getClickedRect(mX, mY);
        if (rect != null && rect.frontNum == gameNum) {
            if (1 <= gameNum && gameNum <= 25) {
                rect.frontNum = rect.backNum;
            } else {
                rect.frontNum = 0;
            }
            gameNum++;
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mY = e.getY();
        mX = e.getX();

        for (int i = 0; i < rect.length; i++) {
            if (rect[i].y < mY && mY < rect[i].y + rect[i].size && rect[i].x < mX && mX < rect[i].x + rect[i].size) {
                rect[i].color = Color.RED;
            } else {
                rect[i].color = Color.WHITE;
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }
}

public class Mouse1to50 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("마우스 연습문제7");
        frame.setBounds(100, 100, 450, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setContentPane(new MyPanel());
        frame.setVisible(true);
        frame.revalidate();
    }
}
