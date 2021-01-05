package Day074P.ChangePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ThirdPanel extends JPanel implements ActionListener{
    JButton backButton;

    public ThirdPanel(){

        setLayout(null);

        setBackground(Color.YELLOW);

        backButton = new JButton("Back");
        backButton.setBounds(100,200,100,30);
        backButton.addActionListener(this);
        add(backButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(backButton == e.getSource()){
            Ex01.frame.setContentPane(new SecondPanel());
            Ex01.frame.revalidate();
        }
    }
}

class SecondPanel extends JPanel implements ActionListener{
    JButton nextButton;
    JButton backButton;

    public SecondPanel(){
        setLayout(null);
        setBackground(Color.ORANGE);

        backButton = new JButton("Back");
        backButton.setBounds(50,200,100,30);
        backButton.addActionListener(this);
        add(backButton);

        nextButton = new JButton("Next");
        nextButton.setBounds(155,200,100,30);
        nextButton.addActionListener(this);
        add(nextButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (backButton == e.getSource()){
            Ex01.frame.setContentPane(new FirstPanel());
        }else if(nextButton == e.getSource()){
            Ex01.frame.setContentPane(new ThirdPanel());
        }
        Ex01.frame.revalidate();
    }
}

class FirstPanel extends JPanel implements ActionListener{
    JButton nextButton;

    public FirstPanel(){
        setLayout(null);
        setBackground(Color.RED);

        nextButton = new JButton("Next");
        nextButton.setBounds(100,200,100,30);
        nextButton.addActionListener(this);
        add(nextButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (nextButton == e.getSource()){
            Ex01.frame.setContentPane(new SecondPanel());
            Ex01.frame.revalidate();
        }
    }
}
public class Ex01 {
    static JFrame frame = new JFrame("화면전환");

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        }catch (Exception e){}

        frame.setSize(300,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 화면 중앙 정렬
        frame.setLocationRelativeTo(null);
        frame.setContentPane(new FirstPanel());

        frame.setVisible(true);
        frame.revalidate();
    }
}
