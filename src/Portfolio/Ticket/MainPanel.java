package Portfolio.Ticket;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel extends JPanel implements ActionListener {
    JLabel adminLabel; // 관리자 헤더
    JLabel userLabel; // 사용자 헤더

    int[] moneys = {50000, 10000, 5000, 1000, 500, 100}; // 지폐 단위
    int[] charges = {5, 4, 3, 2, 1, 0};
    int[] userCharges = {0, 0, 0, 0, 0, 0};

    ItemPanel[] adminItems; // 관리자 수량 확인
    ItemPanel[] userItems; // 사용자 수량 확인

    public MainPanel() {
        setLayout(null);
        // Mac Os
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        Font font = new Font("맑은 고딕", Font.BOLD, 50);
        setFont(font);

        // 관리자 기본 설정
        basicSettingOfAdmin();
        // 사용자 기본 설정
        basicSettingOfUser();

        add(new ItemPanel());
    }

    /**
     * 관리자 기본 설정
     */
    public void basicSettingOfAdmin() {
        adminLabel = new JLabel("관리자");
        adminLabel.setHorizontalAlignment(JLabel.CENTER);
        adminLabel.setBounds(100, 50, 250, 100);
        adminLabel.setFont(getFont());
        adminLabel.setForeground(Color.YELLOW);
        // Label은 배경색을 적용할 때 setOpaque(true)가 필요함
        // 단, Panel은 setOpaque(true)가 필요없음
        adminLabel.setOpaque(true);
        adminLabel.setBackground(Color.BLUE);
        add(adminLabel);

        adminItems = new ItemPanel[6]; // 6 항목 등록
        for (int i = 0; i < adminItems.length; i++) {
            adminItems[i] = new ItemPanel(); // 생성자 호출 필요

            // 금액 출력시 , 를 사용해 더 보기 쉽게 만듬
            StringBuilder convert = insertComma(moneys[i]);
            adminItems[i].moneyText.setBackground(Color.YELLOW);
            adminItems[i].countText.setBackground(Color.YELLOW);

            adminItems[i].moneyText.setText(convert + "원");
            adminItems[i].countText.setText(charges[i] + "");
            adminItems[i].setBounds(50, 200 + (i * 60), 345, 50); // 아래로 정렬시키기 위해

            // 액션 리스너를 기입해 버튼을 활성화 시켜주었다
            adminItems[i].plusButton.addActionListener(this);
            adminItems[i].minusButton.addActionListener(this);

            add(adminItems[i]);
        }
    }

    /**
     * 금액에 , 를 찍기 위한 메소드
     *
     * @param moneys
     * @return StringBuilder convert
     */
    public StringBuilder insertComma(int moneys) {
        StringBuilder convert = new StringBuilder(moneys + "");
        if (moneys >= 1000 && moneys < 10000) {
            convert.insert(1, ',');
        } else if (moneys >= 10000 && moneys < 100000) {
            convert.insert(2, ',');
        }
        return convert;
    }

    /**
     * 사용자 기본 설정
     */
    public void basicSettingOfUser() {
        userLabel = new JLabel("사용자");
        userLabel.setHorizontalAlignment(JLabel.CENTER);
        userLabel.setBounds(450, 50, 250, 100);
        userLabel.setFont(getFont()); // 베이스 폰트 가져오기 (따로 설정하지 않았음)
        userLabel.setForeground(Color.YELLOW); // JLabel 글 색상 변경
        userLabel.setOpaque(true);
        userLabel.setBackground(Color.GRAY);
        add(userLabel);

        userItems = new ItemPanel[6];
        for (int i = 0; i < userItems.length; i++) {
            userItems[i] = new ItemPanel();

            StringBuilder convert = insertComma(moneys[i]);
            userItems[i].countText.setBackground(Color.cyan);
            userItems[i].moneyText.setBackground(Color.cyan);

            userItems[i].moneyText.setText(convert + "원");
            userItems[i].countText.setText(userCharges[i] + "");
            userItems[i].setBounds(400, 200 + (i * 60), 345, 50); // 아래로 정렬시키기 위해

            // 액션 리스너를 기입해 버튼을 활성화 시켜주었다
            userItems[i].plusButton.addActionListener(this);
            userItems[i].minusButton.addActionListener(this);
            add(userItems[i]);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int size = adminItems.length;
        for (int i = 0; i < size; i++) {
            if (adminItems[i].plusButton == e.getSource()) {
                charges[i]++;
                adminItems[i].countText.setText(charges[i] + "");
            } else if (adminItems[i].minusButton == e.getSource()) {
                // 0 보다 작은 수로 내려갈 수 없도록 한다
                if (charges[i] == 0) {
                    break;
                }
                charges[i]--;
                adminItems[i].countText.setText(charges[i] + "");
            } else if (userItems[i].plusButton == e.getSource()) {
                userCharges[i]++;
                userItems[i].countText.setText(userCharges[i] + "");
            } else if (userItems[i].minusButton == e.getSource()) {
                if (userCharges[i] == 0){
                    break;
                }
                userCharges[i]--;
                userItems[i].countText.setText(userCharges[i] + "");
            }
        }
    }
}
