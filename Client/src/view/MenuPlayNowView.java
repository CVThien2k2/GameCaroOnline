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
import java.awt.GridLayout;
import java.awt.BorderLayout;

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
		contentPane.setLayout(new BorderLayout(30, 30));
		
		JButton btnNewButton_2 = new JButton("Quay lại");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MenuView();
			}
		});
		contentPane.add(btnNewButton_2);
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
				panel.setLayout(new GridLayout(2, 1, 20, 20));
		
				JButton btnNewButton = new JButton("Một người chơi");
				panel.add(btnNewButton);
				btnNewButton.setForeground(new Color(255, 255, 255));
				btnNewButton.setBackground(new Color(64, 128, 128));
				btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
				
						JButton btnNewButton_1 = new JButton("Hai người chơi");
						panel.add(btnNewButton_1);
						btnNewButton_1.setForeground(new Color(255, 255, 255));
						btnNewButton_1.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								dispose();
								new HainguoichoiView();
							}
							
						});
						btnNewButton_1.setBackground(new Color(64, 128, 128));
						btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
						
						JPanel panel_1 = new JPanel();
						contentPane.add(panel_1, BorderLayout.NORTH);
						
						JLabel lblNewLabel_1 = new JLabel("Hãy chọn chế độ chơi");
						lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
						lblNewLabel_1.setBackground(Color.YELLOW);
						panel_1.add(lblNewLabel_1);
						
						JPanel panel_2 = new JPanel();
						contentPane.add(panel_2, BorderLayout.SOUTH);
						
						JButton btnNewButton_2_1 = new JButton("Quay lại");
						btnNewButton_2_1.setForeground(new Color(255, 255, 255));
						btnNewButton_2_1.setBackground(new Color(255, 0, 0));
						btnNewButton_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
						panel_2.add(btnNewButton_2_1);
						
						JPanel panel_3 = new JPanel();
						contentPane.add(panel_3, BorderLayout.WEST);
						
						JPanel panel_4 = new JPanel();
						contentPane.add(panel_4, BorderLayout.EAST);
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
						new OnePlayerView();
					}
				});
	}
}
