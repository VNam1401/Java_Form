
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Combobox extends JFrame {

    // Các thành phần của giao diện
    private JTextField txtnum1, txtnum2, txtketqua;
    private JButton btnpheptinh, btnhaplai;
    private JComboBox<String> cboPhepTinh;
    private JLabel lblnum1, lblnum2, lblpheptinh, lblketqua;

    public Combobox() {
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Tạo các JPanels với Layout khác nhau
        JPanel p = new JPanel();
        // Tạo các thành phần nhập liệu
        p.add(lblnum1 = new JLabel("Số 1"));
        p.add(txtnum1 = new JTextField(10));
        p.add(lblnum2 = new JLabel("Số 2"));
        p.add(txtnum2 = new JTextField(10));
        p.add(lblpheptinh = new JLabel("Phép tính"));
        p.add(cboPhepTinh = new JComboBox<>());
        p.add(lblketqua = new JLabel("Kết quả"));
        p.add(txtketqua = new JTextField(10));
        p.add(btnpheptinh = new JButton("Tính"));
        p.add(btnhaplai = new JButton("Nhập lại"));

        //add p vào cửa sổ
        add(p);

        cboPhepTinh.addItem("Cộng");
        cboPhepTinh.addItem("Trừ");
        cboPhepTinh.addItem("Nhân");
        cboPhepTinh.addItem("Chia");
sta
    }
}
