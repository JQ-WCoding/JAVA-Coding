package Day072P.New;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

class Rect {
    int y;
    int x;
    int size;

    int frontNum;
    int backNum;

    Color color;
}

class MyPanel extends JPanel implements MouseListener, MouseMotionListener {

    final int SIZE = 5;
    Rect[] rect;

    int mY;
    int mX;

    int gameNum;

    public MyPanel() {
        setLayout(null);
        addMouseListener(this);                // 마우스와 패널 연결
        addMouseMotionListener(this);        // 마우스 모션과 패널 연결

        basicSetting();
    }

    public void basicSetting() {
        gameNum = 1;

        rect = new Rect[SIZE * SIZE];

        int i = 0;
        for (int y = 0; y < SIZE; y++) {
            for (int x = 0; x < SIZE; x++) {
                rect[i] = new Rect();

                rect[i].color = Color.WHITE;

                rect[i].frontNum = i + 1;
                rect[i].backNum = i + 26;

                rect[i].size = 50;
                rect[i].y = rect[i].size + rect[i].size * y;
                rect[i].x = rect[i].size + rect[i].size * x;
                i++;
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        //================================================================
        // 기본 셋팅 코딩
        super.paintComponent(g);
        try {
            Thread.sleep(10);
        } catch (InterruptedException e1) {
        }
        repaint();
        //================================================================

        for (int i = 0; i < rect.length; i++) {
            // 배경색을 칠한 후
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

    Rect getClickedRect(int mX, int mY) {
        Rect temp = null;
        for (int i = 0; i < rect.length; i++) {
            if (rect[i].y < mY && mY < rect[i].y + rect[i].size
                    && rect[i].x < mX && mX < rect[i].x + rect[i].size) {
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
            if (rect[i].y < mY && mY < rect[i].y + rect[i].size
                    && rect[i].x < mX && mX < rect[i].x + rect[i].size) {
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

public class MouseEx07 {
    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setTitle("마우스 연습문제7");

        frame.setSize(450, 400);
        frame.setLocation(100, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MyPanel mp = new MyPanel();
        frame.setContentPane(mp);

        frame.setVisible(true);

        frame.revalidate();
    }
}