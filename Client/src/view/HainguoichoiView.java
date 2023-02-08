package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Font;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.BorderLayout;
import java.awt.Color;

public class HainguoichoiView extends JFrame {

	private JPanel contentPane;
	private Image img_Xing, img_IconsXO, img_Quaylai, img_Reset, img_Exit, img_Home;

	public HainguoichoiView() {
		try{
			img_Xing = ImageIO.read(getClass().getResource("icons8-xing-96.png"));
            img_IconsXO = ImageIO.read(getClass().getResource("IconsXO_200x200.png"));
            img_Quaylai = ImageIO.read(getClass().getResource("back_42x42.png"));
            img_Reset = ImageIO.read(getClass().getResource("reset_50x50.png"));
            img_Exit = ImageIO.read(getClass().getResource("exit_50x50.png"));
            img_Home = ImageIO.read(getClass().getResource("home_50x50.png"));
    	}catch (Exception e){
            e.printStackTrace();
    	}
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(220, 50, 900, 600);
		this.setResizable(false);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(83, 168, 168));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		panel_1.setBackground(new Color(71, 141, 141));
		panel_1.setBounds(0, 0, 305, 563);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblIcons = new JLabel("");
		Image imgIconsXO = img_IconsXO;
		lblIcons.setIcon(new ImageIcon(imgIconsXO));
		lblIcons.setBounds(40, 26, 227, 177);
		panel_1.add(lblIcons);
		
		JButton btnQuaylai = new JButton("Quay lại");
		btnQuaylai.setHorizontalAlignment(SwingConstants.LEFT);
		btnQuaylai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Offline();
			}
		});
		btnQuaylai.setFont(new Font("Space Mono", Font.BOLD, 18));
		btnQuaylai.setBackground(new Color(71, 141, 141));
		btnQuaylai.setBounds(62, 482, 173, 44);
		Image imgQuaylai = img_Quaylai;
		btnQuaylai.setIcon(new ImageIcon(imgQuaylai));
		panel_1.add(btnQuaylai);
		
		JButton btnExit = new JButton("");
		btnExit.setFont(new Font("Space Mono", Font.BOLD, 18));
		btnExit.setBackground(new Color(71, 141, 141));
		btnExit.setBounds(26, 384, 54, 54);
		Image imgExit = img_Exit;
		btnExit.setIcon(new ImageIcon(imgExit));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		panel_1.add(btnExit);
		
		JButton btnHome = new JButton("");
		btnHome.setFont(new Font("Space Mono", Font.BOLD, 18));
		btnHome.setBackground(new Color(71, 141, 141));
		btnHome.setBounds(126, 384, 54, 54);
		Image imgHome = img_Home;
		btnHome.setIcon(new ImageIcon(imgHome));
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MenuView();
			}
		});
		panel_1.add(btnHome);
		
		JButton btnReset = new JButton("");
		btnReset.setFont(new Font("Space Mono", Font.BOLD, 18));
		btnReset.setBackground(new Color(71, 141, 141));
		btnReset.setBounds(222, 384, 54, 54);
		Image imgReset = img_Reset;
		btnReset.setIcon(new ImageIcon(imgReset));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new HainguoichoiView();
			}
		});
		panel_1.add(btnReset);
		
		JLabel lblHainguoichoi = new JLabel("Hai người chơi");
		lblHainguoichoi.setHorizontalAlignment(SwingConstants.CENTER);
		lblHainguoichoi.setForeground(new Color(255, 238, 240));
		lblHainguoichoi.setFont(new Font("Bungee", Font.BOLD, 26));
		lblHainguoichoi.setBackground(new Color(242, 252, 255));
		lblHainguoichoi.setBounds(17, 273, 269, 54);
		panel_1.add(lblHainguoichoi);
		
		JLabel lblGame = new JLabel("Game");
		lblGame.setHorizontalAlignment(SwingConstants.CENTER);
		lblGame.setForeground(new Color(191, 238, 255));
		lblGame.setFont(new Font("Segoe Print", Font.BOLD, 21));
		lblGame.setBounds(42, 199, 103, 34);
		panel_1.add(lblGame);
		
		JLabel lblOffline = new JLabel("Offline");
		lblOffline.setHorizontalAlignment(SwingConstants.CENTER);
		lblOffline.setForeground(new Color(191, 238, 255));
		lblOffline.setFont(new Font("Segoe Print", Font.BOLD, 35));
		lblOffline.setBackground(new Color(191, 238, 255));
		lblOffline.setBounds(110, 208, 151, 54);
		panel_1.add(lblOffline);
		
		JLabel lblGameCaro_1 = new JLabel("Game Caro");
		lblGameCaro_1.setForeground(Color.WHITE);
		lblGameCaro_1.setFont(new Font(".VnCooperH", Font.PLAIN, 50));
		lblGameCaro_1.setBounds(380, 58, 458, 107);
		Image imgXing = img_Xing;
		lblGameCaro_1.setIcon(new ImageIcon(imgXing));
		contentPane.add(lblGameCaro_1);
		
		JLabel lblNewLabel_2 = new JLabel("Chọn chế độ chơi");
		lblNewLabel_2.setFont(new Font("Space Mono", Font.BOLD, 30));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(475, 195, 311, 58);
		contentPane.add(lblNewLabel_2);
		
		JButton co3Button = new JButton("Cờ 3 ô");
		co3Button.setBorder(UIManager.getBorder("Button.border"));
		co3Button.setFont(new Font("Space Mono", Font.BOLD | Font.ITALIC, 20));
		co3Button.setBackground(new Color(138, 196, 196));
		co3Button.setForeground(new Color(255, 255, 255));
		co3Button.setBounds(366, 312, 214, 39);
		co3Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new PlayView3();
			}
		});
		contentPane.add(co3Button);
		
		JButton co6Button = new JButton("Cờ 6 ô");
		co6Button.setForeground(Color.WHITE);
		co6Button.setFont(new Font("Space Mono", Font.BOLD | Font.ITALIC, 20));
		co6Button.setBackground(new Color(138, 196, 196));
		co6Button.setBounds(624, 312, 214, 39);
		co6Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new PlayView6and3();
			}
		});
		contentPane.add(co6Button);
		
		JButton co9Button = new JButton("Cờ 9 ô");
		co9Button.setForeground(Color.WHITE);
		co9Button.setFont(new Font("Space Mono", Font.BOLD | Font.ITALIC, 20));
		co9Button.setBorder(UIManager.getBorder("Button.border"));
		co9Button.setBackground(new Color(138, 196, 196));
		co9Button.setBounds(366, 394, 214, 39);
		co9Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new PlayView4();
			}
		});
		contentPane.add(co9Button);
		
		JButton co12Button = new JButton("Cờ 12 ô");
		co12Button.setForeground(Color.WHITE);
		co12Button.setFont(new Font("Space Mono", Font.BOLD | Font.ITALIC, 20));
		co12Button.setBorder(UIManager.getBorder("Button.border"));
		co12Button.setBackground(new Color(138, 196, 196));
		co12Button.setBounds(624, 394, 214, 39);
		co12Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new PlayView5();
			}
		});
		contentPane.add(co12Button);

	}
}
