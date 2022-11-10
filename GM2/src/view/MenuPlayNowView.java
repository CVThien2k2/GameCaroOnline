package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLayeredPane;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuPlayNowView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public MenuPlayNowView() {
		this.setVisible(true);

		setTitle("Game Caro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(659, 423);
		setLocationRelativeTo(null);
		this.setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		JButton btnNewButton = new JButton("Một người chơi");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(10, 126, 625, 53);
		btnNewButton.setBackground(new Color(128, 128, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel = new JLabel("Hãy chọn chế độ chơi");
		lblNewLabel.setBounds(196, 21, 279, 28);
		lblNewLabel.setBackground(new Color(255, 255, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		contentPane.add(lblNewLabel);

		JButton btnNewButton_1 = new JButton("Hai người chơi");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				new HainguoichoiView();
			}
			
		});
		btnNewButton_1.setBounds(10, 214, 625, 53);
		btnNewButton_1.setBackground(new Color(128, 128, 0));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Quay lại");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MenuView();
			}
		});
		btnNewButton_2.setBounds(560, 355, 85, 21);
		contentPane.add(btnNewButton_2);
	}
}
