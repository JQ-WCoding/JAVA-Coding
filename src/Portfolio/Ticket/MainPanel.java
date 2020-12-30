package Portfolio.Ticket;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel extends JPanel implements ActionListener {
    JLabel adminLabel; // 관리자 헤더
    JLabel userLabel; // 사용자 헤더
    JButton buyButton; // 구매 버튼
    JLabel ticketPrice; // 티켓 가격 레이블

    int[] moneys = {50000, 10000, 5000, 1000, 500, 100}; // 지폐 단위
    int[] charges = {5, 4, 3, 2, 1, 0};
    int[] userCharges = {0, 0, 0, 0, 0, 0};
    int[] tickets = {0, 0}; // 티켓 수량 0 (관리자) / 1 (사용자)

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
        // 구매하기 버튼
        setBuyButton();
        // 티켓 가격 설정
        setTicketPrice();

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

        adminItems = new ItemPanel[7]; // 6 항목 등록
        for (int i = 0; i < adminItems.length; i++) {
            adminItems[i] = new ItemPanel(); // 생성자 호출 필요

            // 가장 하단은 식권 수량 표기
            if (i == adminItems.length - 1) {
                adminItems[i].moneyText.setBackground(Color.ORANGE);
                adminItems[i].countText.setBackground(Color.ORANGE);
                adminItems[i].countText.setText(tickets[0] + ""); // 식권 수량은 새 int 배열에서 가져온다
                adminItems[i].moneyText.setText("식권 수량");
            } else {
                adminItems[i].moneyText.setBackground(Color.YELLOW);
                adminItems[i].countText.setBackground(Color.YELLOW);
                // 금액 출력시 , 를 사용해 더 보기 쉽게 만듬
                StringBuilder convert = insertComma(moneys[i]);
                adminItems[i].moneyText.setText(convert + "원");
                adminItems[i].countText.setText(charges[i] + "");
            }
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
        userLabel.setBackground(Color.BLACK);
        add(userLabel);

        userItems = new ItemPanel[7];
        for (int i = 0; i < userItems.length; i++) {
            userItems[i] = new ItemPanel();

            if (i == userItems.length - 1) {
                userItems[i].countText.setBackground(Color.MAGENTA);
                userItems[i].moneyText.setBackground(Color.MAGENTA);
                userItems[i].moneyText.setText("구매 식권");
                userItems[i].countText.setText(tickets[1] + "");
            } else {
                userItems[i].countText.setBackground(Color.cyan);
                userItems[i].moneyText.setBackground(Color.cyan);
                StringBuilder convert = insertComma(moneys[i]);
                userItems[i].moneyText.setText(convert + "원");
                userItems[i].countText.setText(userCharges[i] + "");
            }
            userItems[i].setBounds(400, 200 + (i * 60), 345, 50); // 아래로 정렬시키기 위해

            // 액션 리스너를 기입해 버튼을 활성화 시켜주었다
            userItems[i].plusButton.addActionListener(this);
            userItems[i].minusButton.addActionListener(this);
            add(userItems[i]);
        }
    }

    /**
     * 구매 버튼 설정
     */
    public void setBuyButton() {
        buyButton = new JButton("구매하기");
        buyButton.setHorizontalAlignment(JButton.CENTER);
        buyButton.setBounds(400, 620, 245, 50);
        buyButton.setBackground(Color.WHITE);
        buyButton.addActionListener(this);
        add(buyButton);
    }

    public void setTicketPrice() {
        ticketPrice = new JLabel("티켓 가격 : 3,500원");
        Font font = new Font("new", Font.BOLD, 25);
        ticketPrice.setFont(font);
        ticketPrice.setHorizontalAlignment(JLabel.CENTER);
        ticketPrice.setBounds(50, 620, 245, 50);
        ticketPrice.setBackground(Color.LIGHT_GRAY);
        add(ticketPrice);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        clickButton(e);
        // 구매하기 버튼을 눌렀을 경우
        buyButton(e);
    }

    public void clickButton(ActionEvent e) {
        int size = adminItems.length;
        for (int i = 0; i < size; i++) {
            if (i != size - 1) {
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
                    if (userCharges[i] == 0) {
                        break;
                    }
                    userCharges[i]--;
                    userItems[i].countText.setText(userCharges[i] + "");
                }
            } else {
                if (adminItems[i].plusButton == e.getSource()) {
                    tickets[0]++;
                    adminItems[i].countText.setText(tickets[0] + "");
                } else if (adminItems[i].minusButton == e.getSource()) {
                    if (tickets[0] == 0) {
                        break;
                    }
                    tickets[0]--;
                    adminItems[i].countText.setText(tickets[0] + "");
                } else if (userItems[i].plusButton == e.getSource()) {
                    tickets[1]++;
                    userItems[i].countText.setText(tickets[1] + "");
                } else if (userItems[i].minusButton == e.getSource()) {
                    if (tickets[1] == 0) {
                        break;
                    }
                    tickets[1]--;
                    userItems[i].countText.setText(tickets[1] + "");
                }
            }
        }
    }

    public void buyButton(ActionEvent e) {
        if (buyButton == e.getSource()) {
            // 관리자의 티켓 수량이 더 많을 때
            if (tickets[0] >= tickets[1]) {
                int totalPrice = 3500 * tickets[1];
                int totalMyMoney = 0;
                for (int i = 0; i < userCharges.length; i++) {
                    totalMyMoney += userCharges[i] * moneys[i];
                }
                // 구매를 위해 지불할 돈이 더 많을 때
                if (totalMyMoney >= totalPrice) {
                    // 사용자의 지폐를 관리자로 옮겨오기
                    for (int i = 0; i < charges.length; i++) {
                        charges[i] += userCharges[i];
                        userCharges[i] = 0;
                    }
                    int change = totalMyMoney - totalPrice;

                    int totalCharges = totalCharges(change);

                    if (totalCharges < change) {
                        setAlarmFrame("잔돈 부족");
                    } else {
                        for (int i = 0; i < moneys.length; i++) {
                            if (charges[i] != 0 && change / moneys[i] != 0) {
                                charges[i] -= change / moneys[i];
                                change %= moneys[i];
                            }
                        }
                        for (int i = 0; i < moneys.length; i++) {
                            adminItems[i].countText.setText(charges[i] + "");
                            userItems[i].countText.setText(userCharges[i] + "");
                        }
                        tickets[0] -= tickets[1];
                        tickets[1] = 0;
                        adminItems[adminItems.length - 1].countText.setText(tickets[0] + "");
                        userItems[userItems.length - 1].countText.setText(tickets[1] + "");
                    }
                }
            } else {
                setAlarmFrame("수량 부족");
            }
        }
    }

    /**
     * 관리자 잔돈 확인
     *
     * @param change
     * @return totalCharges
     */
    public int totalCharges(int change) {
        int totalCharges = 0;
        int index = -1;
        for (int i = 0; i < moneys.length; i++) {
            if (moneys[i] <= change) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            for (int i = index; i < moneys.length; i++) {
                totalCharges += charges[i] * moneys[i];
            }
        }
        return totalCharges;
    }

    public void setAlarmFrame(String s) {
        JFrame frame = new JFrame("알림");
        frame.setBounds(500, 500, 100, 100);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        JLabel label = new JLabel(s);
        label.setBounds(0, 0, 100, 100);
        label.setHorizontalAlignment(JLabel.CENTER);
        panel.add(label);

        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setContentPane(panel);
        frame.setVisible(true);
        frame.revalidate();
    }
}
