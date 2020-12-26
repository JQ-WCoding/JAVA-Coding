package Day071P.ButtonEx1;

import javax.swing.*;

class MyPanel extends JPanel{
    public MyPanel(){}
}
public class ButtonEx1 {
    public static void main(String[] args) {

        JFrame jFrame = new JFrame();
        jFrame.setTitle("버튼 연습문제1");

        jFrame.setSize(1000,800);
        jFrame.setLocation(100,100);
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);

        MyPanel myPanel = new MyPanel();
        jFrame.setContentPane(myPanel);
        jFrame.setVisible(true);

        jFrame.revalidate();
    }
}
