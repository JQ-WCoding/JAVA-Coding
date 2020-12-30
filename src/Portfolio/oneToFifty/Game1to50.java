package Portfolio.oneToFifty;

import javax.swing.*;

public class Game1to50 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Game 1to50");
        frame.setSize(800,800);
        frame.setLocationRelativeTo(null);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new MainPanel());
        frame.setVisible(true);
        frame.revalidate();
    }
}
