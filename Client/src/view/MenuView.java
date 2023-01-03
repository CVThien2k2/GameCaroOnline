package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import controller.Client;

import javax.swing.SpringLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import javax.swing.JLabel;

public class MenuView extends JFrame {

	private JPanel contentPane;

	public MenuView() {
		init();
		this.setVisible(true);
	}

	public void init() {
		setForeground(Color.RED);
		setSize(651, 480);
		setFont(new Font("Dialog", Font.BOLD, 15));
		setTitle("MENU");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(20, 20));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new GridLayout(2, 1, 60, 60));
				
						JButton btnNewButton_1 = new JButton("Online");
						panel.add(btnNewButton_1);
						btnNewButton_1.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								new Client();
								dispose();
							}
						});
						btnNewButton_1.setBackground(new Color(128, 128, 0));
						btnNewButton_1.setForeground(new Color(255, 255, 255));
						btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
						btnNewButton_1.setToolTipText("Thoát");
		
				
		
				JButton btnNewButton = new JButton("Chơi Ngay");
				panel.add(btnNewButton);
				btnNewButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						dispose();
						new MenuPlayNowView();
						
					}
				});
				btnNewButton.setBackground(new Color(128, 128, 0));
				btnNewButton.setForeground(new Color(255, 255, 255));
				btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
				
				JPanel panel_1 = new JPanel();
				contentPane.add(panel_1, BorderLayout.NORTH);
				
				JLabel lblNewLabel = new JLabel("Menu");
				lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
				panel_1.add(lblNewLabel);
				
				JPanel panel_2 = new JPanel();
				contentPane.add(panel_2, BorderLayout.SOUTH);
				
				JButton btnNewButton_2 = new JButton("Exit");
				btnNewButton_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.exit(0);
					}
				});
				btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
				panel_2.add(btnNewButton_2);
				
				JPanel panel_3 = new JPanel();
				contentPane.add(panel_3, BorderLayout.WEST);
				
				JPanel panel_4 = new JPanel();
				contentPane.add(panel_4, BorderLayout.EAST);
	}
}
