package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.awt.event.ActionEvent;

public class ViewSetUser extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private Socket client;
	private DataOutputStream os;

 




	public ViewSetUser(Socket client) {
		this.client = client;
		try {
			os = new DataOutputStream(client.getOutputStream());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize( 534, 386);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JComboBox<ImageIcon> comboBox = new JComboBox();
		comboBox.setBounds(204, 194, 112, 69);

		comboBox.setMaximumRowCount(5);
		for (int i = 0; i <= 5; i++) {
			comboBox.addItem(new ImageIcon("image/" + i + ".jpg"));
		}
		contentPane.add(comboBox);

		JLabel lblNewLabel = new JLabel("Hãy nhập tên nhân vật của bạn");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(141, 42, 238, 34);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setBounds(190, 93, 140, 34);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Chọn ảnh đại diện");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(190, 148, 140, 30);
		contentPane.add(lblNewLabel_1);

		JButton btnNewButton = new JButton("Vào");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String username = textField.getText();
					if (username.isEmpty())
						throw new Exception("Vui lòng nhập tên của bạn");
					int avatar = comboBox.getSelectedIndex();
			            if(avatar==-1){
			                throw new Exception("Vui lòng chọn avatar");
			            }
			             write("set-player,"+username+","+avatar);
			             dispose();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(219, 292, 85, 34);
		contentPane.add(btnNewButton);
		setVisible(true);
	}
	public void write(String message) throws IOException {
		os.writeUTF(message);
		os.flush();
	}
}
