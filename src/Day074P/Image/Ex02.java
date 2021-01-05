package Day074P.Image;

import javax.swing.*;
import java.awt.*;

class MyPanel extends JPanel {
    Image image1; // 원본
    Image image2; // 사이즈 변경

    public MyPanel() {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
        }
        setLayout(null);

        image1 = new ImageIcon("/Users/jun_q/Desktop/JAVA Edu/Workspace/Green_Practice/라이언.png").getImage();
        // Image.SCALE_SMOOTH(이미지 크기가 변경되어도 최대한 원본에 가깝게 이미지 유지)
        image2 = new ImageIcon("/Users/jun_q/Desktop/JAVA Edu/Workspace/Green_Practice/라이언.png").getImage().getScaledInstance(360,205,Image.SCALE_SMOOTH);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
            Thread.sleep(10);
        }catch (Exception e){}
        repaint();
        // 이미지 그리기
        g.drawImage(image1,0,0,null);
        g.drawImage(image2,0,500,null);
    }
}

public class Ex02 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("이미지 부착하기");
        frame.setSize(800,800);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setContentPane(new MyPanel());

        frame.setVisible(true);
        frame.revalidate();
    }
}
