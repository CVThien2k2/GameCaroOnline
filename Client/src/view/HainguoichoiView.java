package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;

public class HainguoichoiView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public HainguoichoiView() {
		setVisible(true);
		setTitle("Hai người chơi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setSize(450, 300);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(20, 10));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new GridLayout(2, 2, 30, 30));
				
						JButton btnNewButton = new JButton("Cờ 3 ô");
						btnNewButton.setBackground(new Color(64, 128, 128));
						panel.add(btnNewButton);
						btnNewButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								dispose();
								new PlayView3();
							}
						});
						btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
				
				JButton btnNewButton_3 = new JButton("Cờ 6 ô");
				btnNewButton_3.setBackground(new Color(64, 128, 128));
				panel.add(btnNewButton_3);
				btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
				btnNewButton_3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
						new PlayView6and3();
					}
				});
				
						JButton btnNewButton_1 = new JButton("Cờ 9 ô");
						btnNewButton_1.setBackground(new Color(64, 128, 128));
						panel.add(btnNewButton_1);
						btnNewButton_1.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								dispose();
								new PlayView4();
								
							}
						});
						btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
				
						JButton btnNewButton_2 = new JButton("Cờ 12 ô");
						btnNewButton_2.setBackground(new Color(64, 128, 128));
						panel.add(btnNewButton_2);
						btnNewButton_2.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								dispose();
								new PlayView5();
							}
						});
						btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
						
						JPanel panel_1 = new JPanel();
						contentPane.add(panel_1, BorderLayout.NORTH);
						
						JLabel lblNewLabel_1 = new JLabel("Chọn chế độ bạn muốn chơi");
						lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
						lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
						panel_1.add(lblNewLabel_1);
						
						JPanel panel_2 = new JPanel();
						contentPane.add(panel_2, BorderLayout.SOUTH);
						
						JButton btnNewButton_4 = new JButton("Exit");
						btnNewButton_4.setForeground(new Color(255, 255, 255));
						btnNewButton_4.setBackground(new Color(255, 0, 0));
						btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
						panel_2.add(btnNewButton_4);
						
						JPanel panel_3 = new JPanel();
						contentPane.add(panel_3, BorderLayout.WEST);
						
						JPanel panel_4 = new JPanel();
						contentPane.add(panel_4, BorderLayout.EAST);
	}
}
