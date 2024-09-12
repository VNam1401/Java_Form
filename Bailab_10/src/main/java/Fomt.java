
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fomt extends JFrame {

    // Các thành phần của giao diện
    private JTextField txtNumber1, txtNumber2, txtketqua;
    private JButton btncong, btntru, btnnhan, btnchia;

    public Fomt() {
        setTitle("Simple Calculator");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Tạo các JPanels với Layout khác nhau
        JPanel panelInput = new JPanel(new GridLayout(3, 2));
        JPanel panelButtons = new JPanel(new FlowLayout());
        JPanel panelketqua = new JPanel(new BorderLayout());

        // Tạo các thành phần nhập liệu
        JLabel lblNumber1 = new JLabel("Number 1:");
        JLabel lblNumber2 = new JLabel("Number 2:");
        JLabel lblResult = new JLabel("Kết Quả:");

        txtNumber1 = new JTextField(10);
        txtNumber2 = new JTextField(10);
        txtketqua = new JTextField(10);
        txtketqua.setEditable(false);  // Không cho phép chỉnh sửa kết quả

        // Thêm các thành phần vào panelInput
        panelInput.add(lblNumber1);
        panelInput.add(txtNumber1);
        panelInput.add(lblNumber2);
        panelInput.add(txtNumber2);
        panelInput.add(lblResult);
        panelInput.add(txtketqua);

        // Tạo các nút bấm
        btncong = new JButton("Cộng");
        btntru = new JButton("Trừ");
        btnnhan = new JButton("Nhân");
        btnchia = new JButton("Chia");

        // Thêm nút bấm vào panelButtons
        panelButtons.add(btncong);
        panelButtons.add(btntru);
        panelButtons.add(btnnhan);
        panelButtons.add(btnchia);

        // Thêm panelInput và panelButtons vào giao diện
        add(panelInput, BorderLayout.NORTH);
        add(panelButtons, BorderLayout.CENTER);

        // Xử lý sự kiện cho các nút
        btncong.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculate('+');
            }
        });

        btntru.addActionListener((ActionEvent e) -> {
            calculate('-');
        });

        btnnhan.addActionListener((ActionEvent e) -> {
            calculate('*');
        });

        btnchia.addActionListener((ActionEvent e) -> {
            calculate('/');
        });
    }

    // Phương thức tính toán
    private void calculate(char operator) {
        try {
            double num1 = Double.parseDouble(txtNumber1.getText());
            double num2 = Double.parseDouble(txtNumber2.getText());
            double result = 0;

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        JOptionPane.showMessageDialog(this, "Cannot divide by zero!");
                        return;
                    }
                    break;
            }

            // Hiển thị kết quả
            txtketqua.setText(String.valueOf(result));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers.");
        }
    }

    public static void main(String[] args) {
        // Chạy ứng dụng
        Fomt calculator = new Fomt();
        calculator.setVisible(true);
    }
}
