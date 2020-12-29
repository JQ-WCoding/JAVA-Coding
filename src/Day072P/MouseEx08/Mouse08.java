package Day072P.MouseEx08;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Stone {
    int y, x; // 돌의 크기
    int size, type; // 0 (선택전), 1(백돌), 2(흑돌)
    boolean isMouseOver;
}

class MyPanel extends JPanel implements ActionListener, MouseListener, MouseMotionListener {
    final static int COUNT = 11; // 라인의 개수
    final static int SIZE = 50; // 라인의 간격
    final static int INTERVAL_SIZE = 150; // 상하좌우 간격

    JButton rectButton;
    Stone[][] stoneGrid;
    boolean isShow;

    boolean gameStatus; // true(벽돌 차례), false(흑돌 차례)

    public MyPanel() {
        setLayout(null);
        addMouseListener(this);
        addMouseMotionListener(this);

        basicSetting();
    }

    public void basicSetting() {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        gameStatus = true;

        rectButton = new JButton("사각형 보여주기");
        rectButton.setBounds(325, 700, 150, 35);
        rectButton.setBackground(Color.WHITE);
        rectButton.addActionListener(this);
        add(rectButton);

        stoneGrid = new Stone[COUNT][COUNT];
        for (int y = 0; y < COUNT; y++) {
            for (int x = 0; x < COUNT; x++) {
                Stone stone = new Stone();

                stone.size = 35;
                stone.y = INTERVAL_SIZE - stone.size / 2 + y + SIZE;
                stone.x = INTERVAL_SIZE - stone.size / 2 + x + SIZE;

                stoneGrid[y][x] = stone;
            }
        }
    }

    public void drawStone(Graphics g) {
        for (int y = 0; y < COUNT; y++) {
            for (int x = 0; x < COUNT; x++) {
                if (stoneGrid[y][x].type == 1) {
                    g.setColor(Color.WHITE);
                    g.fillOval(stoneGrid[y][x].x, stoneGrid[y][x].y, stoneGrid[y][x].size, stoneGrid[y][x].size);
                } else if (stoneGrid[y][x].type == 2) {
                    g.setColor(Color.BLACK);
                    g.fillOval(stoneGrid[y][x].x, stoneGrid[y][x].y, stoneGrid[y][x].size, stoneGrid[y][x].size);
                }
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

        // 텍스트 그리기
        setFont(new Font("", Font.BOLD, 30));
        g.drawString("[나만의 오목게임]", 50, 80);

        // 선으로 오목판 그리기
        for (int i = 0; i < COUNT; i++) {
            // 가로선 그리기
            g.drawLine(INTERVAL_SIZE, INTERVAL_SIZE + SIZE * i, INTERVAL_SIZE + (COUNT - 1) * SIZE, INTERVAL_SIZE + SIZE * i);
            // 세로선 그리기
            g.drawLine(INTERVAL_SIZE + SIZE * i, INTERVAL_SIZE, INTERVAL_SIZE + SIZE * i, INTERVAL_SIZE + (COUNT - 1) * SIZE);
        }

        // 오목 돌 가이드 선 그리기
        for (int y = 0; y < COUNT; y++) {
            for (int x = 0; x < COUNT; x++) {
                if (isShow) {
                    g.setColor(Color.RED);
                    g.drawRect(stoneGrid[y][x].x, stoneGrid[y][x].y, stoneGrid[y][x].size, stoneGrid[y][x].size);
                }
            }
        }

        // 오목 돌 가이드 돌 그리기
        for (int y = 0; y < COUNT; y++) {
            for (int x = 0; x < COUNT; x++) {
                // 127 : opacity 50%
                if (gameStatus) {
                    g.setColor(new Color(255, 255, 255, 127));
                } else {
                    g.setColor(new Color(0, 0, 0, 127));
                }
                g.fillOval(stoneGrid[y][x].x, stoneGrid[y][x].y, stoneGrid[y][x].size, stoneGrid[y][x].size);
            }
        }
        // 오목 돌 그리기
        drawStone(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (rectButton == e.getSource()) {
            isShow = !isShow;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int mY = e.getY();
        int mX = e.getX();

        for (int y = 0; y < SIZE; y++) {
            for (int x = 0; x < SIZE; x++) {
                if (stoneGrid[y][x].y <= mY && mY <= stoneGrid[y][x].y + stoneGrid[y][x].size && stoneGrid[y][x].x <= mX && mX <= stoneGrid[y][x].x + stoneGrid[y][x].size) {
                    if (stoneGrid[y][x].type == 0) {
                        if (gameStatus) {
                            stoneGrid[y][x].type = 1;
                        } else {
                            stoneGrid[y][x].type = 2;
                        }
                        gameStatus = !gameStatus;
                    }
                }
            }
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        int mY = e.getY();
        int mX = e.getX();

        for (int y = 0; y < COUNT; y++) {
            for (int x = 0; x < COUNT; x++) {
                if (stoneGrid[y][x].y <= mY && mY <= stoneGrid[y][x].y + stoneGrid[y][x].size && stoneGrid[y][x].x <= mX && mX <= stoneGrid[y][x].x + stoneGrid[y][x].size) {
                    stoneGrid[y][x].isMouseOver = true;
                } else {
                    stoneGrid[y][x].isMouseOver = false;
                }
            }
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {

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

public class Mouse08 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("오목 게임");
        frame.setSize(800, 800);

        // 프레임 중앙 배치하기
        frame.setLocationRelativeTo(null);

        frame.setContentPane(new MyPanel());
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
