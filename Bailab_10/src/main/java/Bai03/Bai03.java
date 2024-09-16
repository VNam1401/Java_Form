package Bai03;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Bai03 extends JFrame {

    private JLabel lblnum1, lblnum2, lblresurf;
    private JTextField txtnum1, txtnum2, txtresurf;
    private JButton btntinh, btnnhaplai;
    private JComboBox<String> cbopheptinh;

    public Bai03(String title) {
        super(title);
        CreateGUI();
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2));
    }

    private void CreateGUI() {
 // Tạo các JPanels với Layout khác nhau
        JPanel p = new JPanel();
        p.setLayout(null);
        // Tạo các thành phần nhập liệu
        p.add(lblnum1 = new JLabel("Số 1"));
        p.add(txtnum1 = new JTextField(10));
        p.add(lblnum2 = new JLabel("Số 2"));
        p.add(txtnum2 = new JTextField(10));

        p.add(btntinh = new JButton("Tính"));
        cbopheptinh = new JComboBox<>(new String[]{"+", "-", "*", "/"});
        p.add(lblresurf = new JLabel("Kết quả "));
        p.add(txtresurf = new JTextField(10));
        txtresurf.setEditable(false);
        btntinh = new JButton("Phép tính");
        p.add(btnnhaplai = new JButton("Nhập lại"));
        // Thêm JPanel vào JFrame
        add(p);

        // Event handlers
        btntinh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });

        btnnhaplai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetFields();
            }
        });
    }

    private void actionPerformed() {
        try {
            double s1 = Double.parseDouble(txtnum1.getText());
            double s2 = Double.parseDouble(txtnum2.getText());
            double kq = 0;
            int selectedIndex = cbopheptinh.getSelectedIndex();
            switch (selectedIndex) {
                case 0: // '+'
                    kq = s1 + s2;
                    break;
                case 1: // '-'
                    kq = s1 - s2;
                    break;
                case 2: // '*'
                    kq = s1 * s2;
                    break;
                case 3: // '/'
                    if (s2 == 0) {
                        throw new ArithmeticException("Không chia cho 0!!!");
                    }
                    kq = s1 / s2;
                    break;
            }
            txtresurf.setText(String.valueOf(kq));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Nhập số không hợp lệ!!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } catch (ArithmeticException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void resetFields() {
        txtnum1.setText("");
        txtnum2.setText("");
        txtresurf.setText("");
        cbopheptinh.setSelectedIndex(0);
        txtnum1.requestFocus();
    }

    public static void main(String[] args) {
        new Bai03("Run");
    }
}
