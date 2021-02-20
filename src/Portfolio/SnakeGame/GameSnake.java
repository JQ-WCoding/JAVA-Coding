package Portfolio.SnakeGame;

import javax.swing.*;

public class GameSnake {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Game Snake");
        frame.setBounds(100, 100, 1000, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(new MainPanel());
        frame.revalidate();
    }
}
