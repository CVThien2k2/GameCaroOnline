package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

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
import java.awt.Toolkit;

public class MenuView extends JFrame {

	private JPanel contentPane;
	private Image img_0, img_1, img_Reset, img_Exit, img_3, img_5, img_ChoiNgay, img_Online;

	public MenuView() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuView.class.getResource("/view/tic-tac-toe.png")));
		init();
		this.setVisible(true);
	}

	public void init() {
		
		try{
			img_0 = ImageIO.read(getClass().getResource("icons8-xing-96.png"));
            img_1 = ImageIO.read(getClass().getResource("IconsXO_200x200.png"));
            img_Reset = ImageIO.read(getClass().getResource("reset_50x50.png"));
            img_Exit = ImageIO.read(getClass().getResource("exit_50x50.png"));
            img_3 = ImageIO.read(getClass().getResource("iconsXO3_300x300.png"));
            img_5 = ImageIO.read(getClass().getResource("vs_2_80x80.png"));
            img_ChoiNgay = ImageIO.read(getClass().getResource("button_Choingay_182x50.png"));
            img_Online = ImageIO.read(getClass().getResource("button_Online_182x50.png"));
    	}catch (Exception e){
            e.printStackTrace();
    	}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(220, 50, 900, 600);
		//this.setResizable(false);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(83, 168, 168));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		panel_1.setBackground(new Color(71, 141, 141));
		panel_1.setBounds(0, 0, 305, 574);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblIconsXO_1 = new JLabel("");
		Image img1 = img_1;
		lblIconsXO_1.setIcon(new ImageIcon(img1));
		lblIconsXO_1.setBounds(40, 25, 227, 177);
		panel_1.add(lblIconsXO_1);
		
		JButton btnReset = new JButton("");
		btnReset.setFont(new Font("Space Mono", Font.BOLD, 18));
		btnReset.setBackground(new Color(71, 141, 141));
		btnReset.setBounds(175, 470, 54, 54);
		Image imgReset = img_Reset;
		btnReset.setIcon(new ImageIcon(imgReset));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MenuView();
			}
		});
		panel_1.add(btnReset);
		
		JLabel lblNewLabel_1 = new JLabel("Game Offline");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setBackground(new Color(240, 240, 240));
		lblNewLabel_1.setForeground(new Color(191, 238, 255));
		lblNewLabel_1.setFont(new Font(".Vn3DH", lblNewLabel_1.getFont().getStyle() | Font.BOLD, lblNewLabel_1.getFont().getSize() + 14));
		lblNewLabel_1.setBounds(18, 220, 253, 46);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Game Online");
		lblNewLabel_1_1.setBackground(new Color(240, 240, 240));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setForeground(new Color(6, 34, 70));
		lblNewLabel_1_1.setFont(new Font(".Vn3DH", lblNewLabel_1_1.getFont().getStyle() | Font.BOLD, 25));
		lblNewLabel_1_1.setBounds(66, 358, 245, 46);
		panel_1.add(lblNewLabel_1_1);
		
		JButton btnExit = new JButton("");
		btnExit.setFont(new Font("Space Mono", Font.BOLD, 18));
		btnExit.setBackground(new Color(71, 141, 141));
		btnExit.setBounds(70, 470, 54, 54);
		Image imgExit = img_Exit;
		btnExit.setIcon(new ImageIcon(imgExit));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		panel_1.add(btnExit);
		
		JLabel iconsLabel = new JLabel("");
		iconsLabel.setBounds(107, 263, 80, 84);
		Image img5 = img_5;
		iconsLabel.setIcon(new ImageIcon(img5));
		panel_1.add(iconsLabel);
		
		JLabel lblGameCaro = new JLabel("Game Caro");
		lblGameCaro.setForeground(Color.WHITE);
		lblGameCaro.setFont(new Font(".VnCooperH", Font.PLAIN, 50));
		lblGameCaro.setBounds(380, 58, 458, 107);
		Image img0 = img_0;
		lblGameCaro.setIcon(new ImageIcon(img0));
		contentPane.add(lblGameCaro);
		
		JButton btnOnline = new JButton("");
		btnOnline.setBorder(UIManager.getBorder("Button.border"));
		btnOnline.setFont(new Font("Space Mono", Font.BOLD | Font.ITALIC, 20));
		btnOnline.setBackground(new Color(83, 168, 168));
		btnOnline.setForeground(new Color(83, 168, 168));
		btnOnline.setBounds(660, 446, 185, 54);
		Image imgOnline = img_Online;
		btnOnline.setIcon(new ImageIcon(imgOnline));
		btnOnline.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Client();
			}
		});
		contentPane.add(btnOnline);
		
		JButton btnChoiNgay = new JButton("");
		btnChoiNgay.setForeground(new Color(83, 168, 168));
		btnChoiNgay.setFont(new Font("Space Mono", Font.BOLD | Font.ITALIC, 20));
		btnChoiNgay.setBackground(new Color(83, 168, 168));
		btnChoiNgay.setBounds(405, 446, 185, 54);
		Image imgChoiNgay = img_ChoiNgay;
		btnChoiNgay.setIcon(new ImageIcon(imgChoiNgay));
		btnChoiNgay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Offline();
			}
		});
		contentPane.add(btnChoiNgay);
		
		JLabel lblIconsXO_2 = new JLabel("");
		lblIconsXO_2.setForeground(new Color(189, 128, 213));
		lblIconsXO_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconsXO_2.setBounds(508, 182, 233, 220);
		Image img3 = img_3;
		lblIconsXO_2.setIcon(new ImageIcon(img3));
		contentPane.add(lblIconsXO_2);

	}
}
