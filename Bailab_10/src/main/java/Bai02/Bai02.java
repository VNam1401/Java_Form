package Bai02;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Bai02 extends JFrame {
    private JLabel lblnum1, lblnum2, lblresult;
    private JTextField txtnum1, txtnum2, txtresult;
    private JRadioButton rbtnAdd, rbtnSubtract, rbtnMultiply, rbtnDivide;
    private JButton btnCalculate, btnReset;
    private ButtonGroup operationGroup;

    public Bai02(String title) {
        super(title);
        CreateGUI();
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void CreateGUI() {
        // Tạo JPanel chính
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(6, 2, 5, 5));

        // Tạo các thành phần nhập liệu
        lblnum1 = new JLabel("Số 1:");
        txtnum1 = new JTextField(10);
        lblnum2 = new JLabel("Số 2:");
        txtnum2 = new JTextField(10);
        lblresult = new JLabel("Kết quả:");
        txtresult = new JTextField(10);
        txtresult.setEditable(false);

        // Tạo các RadioButton cho các phép tính
        rbtnAdd = new JRadioButton("Cộng", true);
        rbtnSubtract = new JRadioButton("Trừ");
        rbtnMultiply = new JRadioButton("Nhân");
        rbtnDivide = new JRadioButton("Chia");

        // Gom các RadioButton vào một ButtonGroup
        operationGroup = new ButtonGroup();
        operationGroup.add(rbtnAdd);
        operationGroup.add(rbtnSubtract);
        operationGroup.add(rbtnMultiply);
        operationGroup.add(rbtnDivide);

        // Tạo các nút
        btnCalculate = new JButton("Tính");
        btnReset = new JButton("Nhập lại");

        // Thêm các thành phần vào JPanel
        p.add(lblnum1);
        p.add(txtnum1);
        p.add(lblnum2);
        p.add(txtnum2);
        p.add(new JLabel("Phép tính:"));
        p.add(rbtnAdd);
        p.add(new JLabel(""));
        p.add(rbtnSubtract);
        p.add(new JLabel(""));
        p.add(rbtnMultiply);
        p.add(new JLabel(""));
        p.add(rbtnDivide);
        p.add(lblresult);
        p.add(txtresult);
        p.add(btnCalculate);
        p.add(btnReset);

        // Thêm JPanel vào JFrame
        add(p);

        // Event handlers
        btnCalculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performCalculation();
            }
        });

        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetFields();
            }
        });
    }

    private void performCalculation() {
        try {
            double s1 = Double.parseDouble(txtnum1.getText());
            double s2 = Double.parseDouble(txtnum2.getText());
            double result = 0;
            
            if (rbtnAdd.isSelected()) {
                result = s1 + s2;
            } else if (rbtnSubtract.isSelected()) {
                result = s1 - s2;
            } else if (rbtnMultiply.isSelected()) {
                result = s1 * s2;
            } else if (rbtnDivide.isSelected()) {
                if (s2 == 0) {
                    throw new ArithmeticException("Không chia cho 0!!!");
                }
                result = s1 / s2;
            }
            txtresult.setText(String.valueOf(result));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Nhập số không hợp lệ!!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } catch (ArithmeticException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void resetFields() {
        txtnum1.setText("");
        txtnum2.setText("");
        txtresult.setText("");
        rbtnAdd.setSelected(true); // Đặt phép tính cộng được chọn mặc định
        txtnum1.requestFocus();
    }

    public static void main(String[] args) {
        new Bai02("Bai02");
    }
}
