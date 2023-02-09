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
import javax.swing.ImageIcon;

public class InRoom extends JFrame {

	private JPanel contentPane;
	private Socket client;
	private DataOutputStream os;
	private Player player;
	private JButton btnNewButton;
	private JLabel lblNewLabel;
	private JButton btnNewButton_1;
	private boolean first;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_4;
	private JButton btnNewButton_2;

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

		lblNewLabel = new JLabel("ID ROOM: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(150, 10, 132, 13);
		panel.add(lblNewLabel);
		
		lblNewLabel_2 = new JLabel("<name>\r\n");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(20, 144, 64, 13);
		lblNewLabel_2.setText(player.getName());
		panel.add(lblNewLabel_2);
		
		lblNewLabel_4 = new JLabel("<name>\r\n");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(333, 144, 64, 13);
		lblNewLabel_4.setText(null);
		panel.add(lblNewLabel_4);
		
		  btnNewButton_2 = new JButton("");
		btnNewButton_2.setBounds(312, 26, 85, 85);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("New button");
		btnNewButton_2_1.setBounds(20, 26, 85, 85);
		btnNewButton_2_1.setIcon(new ImageIcon("image/"+player.getAvatar()+".jpg"));
		panel.add(btnNewButton_2_1);
		

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

	public void setplayer1(String user,String avt) {
		btnNewButton_2.setIcon(new ImageIcon("image/"+avt+".jpg"));
		lblNewLabel_4.setText(user);
		btnNewButton.setEnabled(true);
		

	}
	public void SetIDRoom(String id) {
		lblNewLabel.setText("ID ROOM: "+id);
	}
	public void setplayer2(String user,String avt) {
		lblNewLabel_4.setText(user);
		btnNewButton_2.setIcon(new ImageIcon("image/"+avt+".jpg"));
		btnNewButton.setVisible(false);
	}
	public void exitroom() {
		btnNewButton_2.setIcon(null);
		lblNewLabel_4.setText(null);
		btnNewButton.setVisible(true);
		btnNewButton.setEnabled(false);
	}
}
