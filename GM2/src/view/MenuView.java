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


import javax.swing.SpringLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

		

		JButton btnNewButton = new JButton("Chơi Ngay");
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				new MenuPlayNowView();
				
			}
		});
		btnNewButton.setBounds(10, 85, 617, 65);
		contentPane.setLayout(null);
		btnNewButton.setBackground(new Color(128, 128, 0));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Thoát");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_1.setBounds(10, 203, 617, 57);
		btnNewButton_1.setBackground(new Color(128, 128, 0));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setToolTipText("Thoát");
		contentPane.add(btnNewButton_1);
	}
}
