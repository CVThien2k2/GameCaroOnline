package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Player;

import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.SpringLayout;
import net.miginfocom.swing.MigLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.CardLayout;
import javax.swing.JScrollBar;

public class Home extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Socket client;
	private DataOutputStream os;
	private Player player;
	private Load ld;

	public Home(Socket client, Player player) {
		this.client = client;
		this.player = player;
		ld = new Load();
		try {
			this.os = new DataOutputStream(client.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(734, 530);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setResizable(false);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 192, 192));
		panel_1.setBounds(20, 10, 679, 217);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("avt");
		lblNewLabel_2.setBackground(new Color(64, 128, 128));
		lblNewLabel_2.setIcon(new ImageIcon("image/" + player.getAvatar() + ".jpg"));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(118, 75, 95, 83);
		panel_1.add(lblNewLabel_2);

		JLabel lblNewLabel = new JLabel("Tên người chơi: ");
		lblNewLabel.setBounds(291, 52, 111, 17);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel(" ID     : ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(326, 95, 55, 19);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1.add(lblNewLabel_1);

		JLabel lblNewLabel_3 = new JLabel("<Name>");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(398, 52, 95, 17);
		panel_1.add(lblNewLabel_3);
		lblNewLabel_3.setText(player.getName());

		JLabel lblNewLabel_1_1 = new JLabel("<id>");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(424, 95, 36, 19);
		panel_1.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setText(player.getID() + "");

		JLabel lblNewLabel_4 = new JLabel("Server :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(326, 145, 59, 13);
		panel_1.add(lblNewLabel_4);

		JLabel lblNewLabel_4_1 = new JLabel("Asia");
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4_1.setBounds(412, 145, 59, 13);
		panel_1.add(lblNewLabel_4_1);

		JLabel lblNewLabel_5 = new JLabel("Thông tin người chơi");
		lblNewLabel_5.setBackground(new Color(128, 128, 128));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(253, 10, 173, 23);
		panel_1.add(lblNewLabel_5);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(20, 369, 679, 114);
		contentPane.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 2, 15, 15));

		JButton btnNewButton_2 = new JButton("Chơi ngay");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					ld.setVisible(true);
					ld.setLocationRelativeTo(panel_2);

					ld.btnNewButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							try {
								write("khong-co-phong");
								ld.dispose();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					});
					write("go-room-now");

				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_2.add(btnNewButton_2);

		JButton btnNewButton_1 = new JButton("Tạo phòng");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					write("create-room");
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_2.add(btnNewButton_1);

		JButton btnNewButton = new JButton("Vào phòng");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idroom = JOptionPane.showInputDialog("Nhập id phòng");
				try {
					System.out.println("join-room,"+idroom);
					write("join-room,"+idroom);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_2.add(btnNewButton);

		JButton btnNewButton_3 = new JButton("Thoát");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_2.add(btnNewButton_3);

		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(20, 237, 679, 78);
		contentPane.add(textArea);

		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(20, 325, 609, 34);
		contentPane.add(textArea_1);

		JButton btnNewButton_4 = new JButton("Gửi");
		btnNewButton_4.setBounds(639, 325, 60, 34);
		contentPane.add(btnNewButton_4);
		setVisible(true);
	}

	public void write(String message) throws IOException {
		os.writeUTF(message);
		os.flush();
	}

	public void closeld() {
		ld.dispose();
	}
}
