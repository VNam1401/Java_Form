
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fomt extends JFrame {

    // Các thành phần của giao diện
    private JTextField txtso1, txtso2, txtketqua, txtpheptinh;
    private JButton btncong, btntru, btnnhan, btnchia;
    public Fomt() {
        setTitle("Simple Calculator");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Tạo các JPanels với Layout khác nhau
        JPanel panelInput = new JPanel(new GridLayout(4, 2));
        JPanel panelButtons = new JPanel(new FlowLayout());
        JPanel panelreJPanel = new JPanel(new BorderLayout());

        // Tạo các thành phần nhập liệu
        JLabel lblso1 = new JLabel("Số 1");
        txtso1 = new JTextField(10);
        JLabel lblso2 = new JLabel("Số 2");
        txtso2 = new JTextField(10);
        JLabel lblpheptinh = new JLabel("Phép tính");
        txtpheptinh = new JTextField();  // Chỉnh chiều rộng cho phép tính
        // Tạo các nút bấm
        btncong = new JButton("Cộng");
        btntru = new JButton("Trừ");
        btnnhan = new JButton("Nhân");
        btnchia = new JButton("Chia");

        // Thêm các thành phần vào panelInput
        panelInput.add(lblso1);
        panelInput.add(txtso1);
        panelInput.add(lblso2);
        panelInput.add(txtso2);
        panelInput.add(lblpheptinh);

        // Thêm nút bấm vào panelButtons
        panelButtons.add(lblpheptinh);
        panelButtons.add(txtpheptinh);
        panelButtons.add(btncong);
        panelButtons.add(btntru);
        panelButtons.add(btnnhan);
        panelButtons.add(btnchia);

        JLabel lblketqua = new JLabel("Kết Quả");
        txtketqua = new JTextField(10);
        txtketqua.setEditable(false);  // Không cho phép chỉnh sửa kết quả
        panelInput.add(lblketqua);
        panelInput.add(txtketqua);
        // Thêm panelInput và panelButtons vào giao diện
        add(panelInput, BorderLayout.NORTH);
        add(panelButtons, BorderLayout.CENTER);

        // Xử lý sự kiện cho các nút
        btncong.addActionListener((ActionEvent e) -> {
            calculate('+');
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
            double s1 = Double.parseDouble(txtso1.getText());
            double s2 = Double.parseDouble(txtso2.getText());
            double result = 0;

            switch (operator) {
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
                    if (s2 != 0) {
                        result = s1 / s2;
                    } else {
                        JOptionPane.showMessageDialog(this, "Không được nhập số 0 đầu tiên!");
                        return;
                    }
                    break;
            }

            // Hiển thị kết quả
            txtketqua.setText(String.valueOf(result));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Không hợp lệ.");
        }
    }

    public static void main(String[] args) {
        // Chạy ứng dụng
        Fomt calculator = new Fomt();
        calculator.setVisible(true);
    }
}
