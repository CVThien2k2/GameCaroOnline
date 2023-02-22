package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.border.SoftBevelBorder;

import view.OnePlayerView;

import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

public class OfflineOnePlayerView extends JFrame {

	private JPanel contentPane;
	private Image img_0;
	private Image img_1;
	private Image img_Quaylai;
	private Image img_Reset;
	private Image img_Exit;
	private Image img_Home;
	

	public OfflineOnePlayerView() {
		
		try{
			img_0 = ImageIO.read(getClass().getResource("icons8-xing-96.png"));
            img_1 = ImageIO.read(getClass().getResource("IconsXO_200x200.png"));
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
		setLocationRelativeTo(null);
		
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
		
		JLabel lblIconsXO = new JLabel("");
		Image img1 = img_1;
		lblIconsXO.setIcon(new ImageIcon(img1));
		lblIconsXO.setBounds(40, 26, 227, 177);
		panel_1.add(lblIconsXO);
		
		JButton btnQuaylai = new JButton("Quay lại");
		btnQuaylai.setHorizontalAlignment(SwingConstants.LEFT);
		btnQuaylai.setFont(new Font("Space Mono", Font.BOLD, 18));
		btnQuaylai.setBackground(new Color(71, 141, 141));
		btnQuaylai.setBounds(62, 482, 173, 44);
		Image imgQuaylai = img_Quaylai;
		btnQuaylai.setIcon(new ImageIcon(imgQuaylai));
		btnQuaylai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Offline();
			}
		});
		panel_1.add(btnQuaylai);
		
		JButton btnReset = new JButton("");
		btnReset.setFont(new Font("Space Mono", Font.BOLD, 18));
		btnReset.setBackground(new Color(71, 141, 141));
		btnReset.setBounds(222, 384, 54, 54);
		Image imgReset = img_Reset;
		btnReset.setIcon(new ImageIcon(imgReset));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new OfflineOnePlayerView();
			}
		});
		panel_1.add(btnReset);
		
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
		
		JLabel lblMotnguoichoi = new JLabel("Một người chơi");
		lblMotnguoichoi.setHorizontalAlignment(SwingConstants.CENTER);
		lblMotnguoichoi.setForeground(new Color(242, 231, 252));
		lblMotnguoichoi.setFont(new Font("Bungee", Font.BOLD, 26));
		lblMotnguoichoi.setBackground(new Color(242, 252, 255));
		lblMotnguoichoi.setBounds(17, 273, 269, 54);
		panel_1.add(lblMotnguoichoi);
	
		
		JLabel lblGameCaro_1 = new JLabel("Game Caro");
		lblGameCaro_1.setForeground(Color.WHITE);
		lblGameCaro_1.setFont(new Font(".VnCooperH", Font.PLAIN, 50));
		lblGameCaro_1.setBounds(380, 58, 458, 107);
		Image img0 = img_0;
		lblGameCaro_1.setIcon(new ImageIcon(img0));
		contentPane.add(lblGameCaro_1);
		
		JLabel lblChonchedochoi = new JLabel("Chọn chế độ chơi");
		lblChonchedochoi.setFont(new Font("Space Mono", Font.BOLD, 30));
		lblChonchedochoi.setForeground(new Color(255, 255, 255));
		lblChonchedochoi.setBounds(475, 195, 311, 58);
		contentPane.add(lblChonchedochoi);
		
		JButton btnDe = new JButton("Dễ");
		btnDe.setBorder(UIManager.getBorder("Button.border"));
		btnDe.setFont(new Font("Space Mono", Font.BOLD | Font.ITALIC, 20));
		btnDe.setBackground(new Color(138, 196, 196));
		btnDe.setForeground(new Color(255, 255, 255));
		btnDe.setBounds(520, 295, 214, 39);
		btnDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new OnePlayerView(1);
			}
		});
		contentPane.add(btnDe);
		
		JButton btnTrungBinh = new JButton("Trung bình");
		btnTrungBinh.setForeground(Color.WHITE);
		btnTrungBinh.setFont(new Font("Space Mono", Font.BOLD | Font.ITALIC, 20));
		btnTrungBinh.setBackground(new Color(138, 196, 196));
		btnTrungBinh.setBounds(520, 366, 214, 39);
		btnTrungBinh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new OnePlayerView(2);
			}
		});
		contentPane.add(btnTrungBinh);
		
		JButton btnKho = new JButton("Khó");
		btnKho.setForeground(Color.WHITE);
		btnKho.setFont(new Font("Space Mono", Font.BOLD | Font.ITALIC, 20));
		btnKho.setBackground(new Color(138, 196, 196));
		btnKho.setBounds(520, 439, 214, 39);
		btnKho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new OnePlayerView(3);
			}
		});
		contentPane.add(btnKho);

	}
}
