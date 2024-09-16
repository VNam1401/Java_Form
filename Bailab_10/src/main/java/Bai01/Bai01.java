package Bai01;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Bai01 extends JFrame {
    private JLabel lblnum1, lblnum2, lblresult;
    private JTextField txtnum1, txtnum2, txtresult;
    private JButton btnAdd, btnSubtract, btnMultiply, btnDivide, btnExit;

    public Bai01(String title) {
        super(title);
        CreateGUI();
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void CreateGUI() {
        // Tạo JPanel chính
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(4, 5, 3, 5));

        // Tạo các thành phần nhập liệu
        lblnum1 = new JLabel("Số 1:");
        txtnum1 = new JTextField(10);
        lblnum2 = new JLabel("Số 2:");
        txtnum2 = new JTextField(10);
        lblresult = new JLabel("Kết quả:");
        txtresult = new JTextField(10);
        txtresult.setEditable(false);

        // Tạo các nút
        btnAdd = new JButton("Cộng");
        btnSubtract = new JButton("Trừ");
        btnMultiply = new JButton("Nhân");
        btnDivide = new JButton("Chia");
        btnExit = new JButton("Kết thúc");

        // Thêm các thành phần vào JPanel
        p.add(lblnum1);
        p.add(txtnum1);
        p.add(lblnum2);
        p.add(txtnum2);
        p.add(lblresult);
        p.add(txtresult);
        p.add(btnAdd);
        p.add(btnSubtract);
        p.add(btnMultiply);
        p.add(btnDivide);
        p.add(btnExit);

        // Thêm JPanel vào JFrame
        add(p);

        // Event handlers
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performCalculation('+');
            }
        });

        btnSubtract.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performCalculation('-');
            }
        });

        btnMultiply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performCalculation('*');
            }
        });

        btnDivide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performCalculation('/');
            }
        });

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn kết thúc?", "Xác nhận", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    dispose();
                }
            }
        });
    }

    private void performCalculation(char operation) {
        try {
            double s1 = Double.parseDouble(txtnum1.getText());
            double s2 = Double.parseDouble(txtnum2.getText());
            double result = 0;
            
            switch (operation) {
                case '+':
                    result = s1 + s2;
                    break;
                case '-':
                    result = s1 - s2;
                    break;
                case '*':
                    result = s1 * s2;
                    break;
                case '/':
                    if (s2 == 0) {
                        throw new ArithmeticException("Không chia cho 0!!!");
                    }
                    result = s1 / s2;
                    break;
            }
            txtresult.setText(String.valueOf(result));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Nhập số không hợp lệ!!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } catch (ArithmeticException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new Bai01("Bai01");
    }
}
