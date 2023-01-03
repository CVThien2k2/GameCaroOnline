package view;

import controller.Client;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Client;
import model.Player;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;

public class InRoom extends JFrame {

	private JPanel contentPane;
	private Socket client;
	private DataOutputStream os;
	private Player player;
	private JButton doithu;
	private JButton btnNewButton;
	private JLabel lblNewLabel;
	private JButton btnNewButton_1;
	private boolean first;

	public InRoom(Socket client, Player player) {
		this.client = client;
		this.player = player;
		try {
			this.os = new DataOutputStream(client.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(450, 300);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JButton toi = new JButton("");
		toi.setBounds(0, 0, 108, 108);
		toi.setText(player.getName());
		toi.setBackground(Color.red);
		panel.add(toi);

		doithu = new JButton("<Trống>");
		doithu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		doithu.setBounds(318, 0, 108, 108);
		panel.add(doithu);

		lblNewLabel = new JLabel("ID ROOM: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(150, 10, 132, 13);
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setHgap(120);
		contentPane.add(panel_1, BorderLayout.SOUTH);

		btnNewButton = new JButton("Bắt đầu");
		btnNewButton.setEnabled(false);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					write("start");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_1.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					write("exit");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panel_1.add(btnNewButton_1);
		setVisible(true);
	}

	public void write(String message) throws IOException {
		os.writeUTF(message);
		os.flush();
	}

	public void setplayer1(String user) {
		doithu.setText(user);
		doithu.setBackground(Color.BLUE);
		
		btnNewButton.setEnabled(true);
		

	}
	public void SetIDRoom(String id) {
		lblNewLabel.setText("ID ROOM: "+id);
	}
	public void setplayer2(String user) {
		doithu.setText(user);
		doithu.setBackground(Color.BLUE);
		btnNewButton.setVisible(false);
	}
	public void exitroom() {
		doithu.setBackground(Color.gray);
		doithu.setText("");
		btnNewButton.setVisible(true);
		btnNewButton.setEnabled(false);
	}
}
