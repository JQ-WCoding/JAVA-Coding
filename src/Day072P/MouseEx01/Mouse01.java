package Day072P.MouseEx01;

import javax.swing.*;
import java.awt.*;

class Rect {
    int y;
    int x;
    int width;
    int height;
}

class MyPanel extends JPanel {
    Rect rect = new Rect();

    public MyPanel() {
        rect.x = 50;
        rect.y = 50;

        rect.width = 100;
        rect.height = 100;
    }

    // JPanel의 그림 그리기 기능
    // JPanel 클래스의 생성자가 실행시 한번 paintComponent() 메서드를 호출한다

    @Override
    protected void paintComponent(Graphics g) {
        g.drawRect(rect.x, rect.y, rect.width, rect.height);
    }
}

public class Mouse01 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("마우스 연습문제1");

//        frame.setBounds(100, 100, 500, 500);
        frame.setSize(500,500);
        frame.setLocation(100,100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MyPanel myPanel = new MyPanel();
        frame.setContentPane(myPanel);
//        frame.setContentPane(new MyPanel());
        frame.setVisible(true);
        frame.revalidate();
    }
}
