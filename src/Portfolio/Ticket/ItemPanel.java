package Portfolio.Ticket;

import Portfolio.rpg.Item;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ItemPanel extends JPanel implements ActionListener {
    JLabel moneyText;
    JLabel countText;

    JButton plusButton;
    JButton minusButton;

    public ItemPanel() {
        setLayout(null);

        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        setBackground(Color.YELLOW);
        basicSetting();
    }

    /**
     * 기본 세팅
     */
    public void basicSetting() {
        Font font = new Font("basicFont", Font.BOLD, 25); // basicFont로 편하게 사용하기

        // 금액 텍스트 등록
        moneyText = new JLabel();
        moneyText.setOpaque(true); // 투명도 설정 -> 불투명하게
//        moneyText.setBackground(Color.YELLOW);
        moneyText.setFont(font);
        moneyText.setBounds(0, 0, 190, 50);
        add(moneyText);

        // 갯수 텍스트 등록
        countText = new JLabel();
        countText.setOpaque(true);
//        countText.setBackground(Color.YELLOW);
        countText.setHorizontalAlignment(JLabel.CENTER); // JLabel 의 위치를 가운데로 정렬
        countText.setFont(font);
        countText.setBounds(190, 0, 50, 50);
        add(countText);

        // 추가 "+" 버튼 생성하기
        plusButton = new JButton("+");
        plusButton.setFont(font);
        plusButton.setBounds(240, 0, 55, 50);
        plusButton.setBackground(Color.WHITE);
        add(plusButton);

        // 빼기 "-" 버튼 생성하기
        minusButton = new JButton("-");
        minusButton.setFont(font);
        minusButton.setBounds(290, 0, 55, 50);
        minusButton.setBackground(Color.WHITE);
        add(minusButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
