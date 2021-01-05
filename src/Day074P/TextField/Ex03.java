package Day074P.TextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class TextPanel extends JPanel implements ActionListener {
    JLabel idLabel;
    JTextField idTextField;

    JLabel pwLabel;
    JTextField pwTextField;

    JButton confirmButton;

    public TextPanel() {
        setLayout(null);

        idLabel = new JLabel("ID");
        idLabel.setBounds(15, 50, 50, 50);
        idLabel.setFont(new Font("", Font.BOLD, 20));
        add(idLabel);

        idTextField = new JTextField();
        idTextField.setFocusable(true);
        idTextField.setBounds(50, 50, 200, 50);
        add(idTextField);

        pwLabel = new JLabel("PW");
        pwLabel.setBounds(15, 110, 50, 50);
        pwLabel.setFont(new Font("", Font.BOLD, 20));
        add(pwLabel);

        pwTextField = new JTextField();
        pwTextField.setBounds(50, 110, 200, 50);
        add(pwTextField);

        confirmButton = new JButton("확인");
        confirmButton.setBounds(100, 200, 100, 50);
        confirmButton.addActionListener(this);
        add(confirmButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String id = idTextField.getText();
        String pw = pwTextField.getText();

        if (confirmButton == e.getSource()) {
            if (id.equals("")) {
                JOptionPane.showMessageDialog(null, "ID를 입력해주세요");
                idTextField.requestFocus();
            } else if (pw.equals("")) {
                JOptionPane.showMessageDialog(null, "PW를 입력해주세요");
                pwTextField.requestFocus();
            } else if (id.equals("qwer") && pw.equals("1234")) {
                JOptionPane.showMessageDialog(null, "로그인 성공");
            } else {
                JOptionPane.showMessageDialog(null, "ID와 PW값이 유효하지 않습니다");

                idTextField.setText("");
                pwTextField.setText("");

                idTextField.requestFocus();
            }
        }
    }
}

public class Ex03 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("텍스트필드 연습");
        frame.setSize(300, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setContentPane(new TextPanel());
        frame.setVisible(true);
        frame.revalidate();
    }
}
