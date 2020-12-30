package Portfolio.oneToFifty;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoardPanel extends JPanel implements ActionListener {
    JButton boardButton;

    public BoardPanel(){
        setLayout(null);
        basicSetting();
    }

    public void basicSetting(){
        boardButton = new JButton();
        boardButton.setBackground(Color.cyan);
        boardButton.setOpaque(true);
        add(boardButton);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
