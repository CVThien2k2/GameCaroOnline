package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLayeredPane;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.BorderLayout;
import java.awt.Toolkit;

public class Offline extends JFrame {

	private JPanel contentPane;
	private Image img_IconsXO1, img_Xing, img_Quaylai, img_Reset, img_Exit, img_Home, img_MotNguoiChoi, img_HaiNguoiChoi;

	public Offline() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Offline.class.getResource("/icon/tic-tac-toe.png")));
		
		try{
			img_Xing = ImageIO.read(getClass().getResource("icons8-xing-96.png"));
            img_IconsXO1 = ImageIO.read(getClass().getResource("IconsXO_200x200.png"));
            img_Quaylai = ImageIO.read(getClass().getResource("back_42x42.png"));
            img_Reset = ImageIO.read(getClass().getResource("reset_50x50.png"));
            img_Exit = ImageIO.read(getClass().getResource("exit_50x50.png"));
            img_Home = ImageIO.read(getClass().getResource("home_50x50.png"));
            img_MotNguoiChoi = ImageIO.read(getClass().getResource("button_1nguoichoi_264x45.png"));
            img_HaiNguoiChoi = ImageIO.read(getClass().getResource("button_2nguoichoi_264x44.png"));
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
		
		JLabel lblIconsXO_1 = new JLabel("");
		Image imgIconsXO1 = img_IconsXO1;
		lblIconsXO_1.setIcon(new ImageIcon(imgIconsXO1));
		lblIconsXO_1.setBounds(40, 26, 227, 177);
		panel_1.add(lblIconsXO_1);
		
		JButton btnQuaylai = new JButton("Quay lại");
		btnQuaylai.setHorizontalAlignment(SwingConstants.LEFT);
		btnQuaylai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playSoundButton();
				dispose();
				new MenuView();
			}
		});
		btnQuaylai.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 18));
		btnQuaylai.setBackground(new Color(71, 141, 141));
		btnQuaylai.setBounds(62, 482, 173, 44);
		Image imgQuaylai = img_Quaylai;
		btnQuaylai.setIcon(new ImageIcon(imgQuaylai));
		panel_1.add(btnQuaylai);
		
		JLabel lblGame = new JLabel("Game");
		lblGame.setForeground(new Color(191, 238, 255));
		lblGame.setHorizontalAlignment(SwingConstants.CENTER);
		lblGame.setFont(new Font("Segoe Print", Font.BOLD, 31));
		lblGame.setBounds(10, 200, 127, 64);
		panel_1.add(lblGame);
		
		JLabel lblOffline = new JLabel("Offline");
		lblOffline.setForeground(new Color(191, 238, 255));
		lblOffline.setBackground(new Color(191, 238, 255));
		lblOffline.setHorizontalAlignment(SwingConstants.CENTER);
		lblOffline.setFont(new Font("Segoe Print", Font.BOLD, 50));
		lblOffline.setBounds(96, 235, 195, 73);
		panel_1.add(lblOffline);
		
		JButton btnReset = new JButton("");
		btnReset.setFont(new Font("Space Mono", Font.BOLD, 18));
		btnReset.setBackground(new Color(71, 141, 141));
		btnReset.setBounds(222, 384, 54, 54);
		Image imgReset = img_Reset;
		btnReset.setIcon(new ImageIcon(imgReset));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playSoundButton();
				dispose();
				new Offline();
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
				playSoundButton();
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
				playSoundButton();
				dispose();
				new MenuView();
			}
		});
		panel_1.add(btnHome);
		
		JLabel lblGameCaro_1 = new JLabel("Game Caro");
		lblGameCaro_1.setForeground(Color.WHITE);
		lblGameCaro_1.setFont(new Font(".VnCooperH", Font.PLAIN, 50));
		lblGameCaro_1.setBounds(380, 58, 458, 107);
		Image imgXing = img_Xing;
		lblGameCaro_1.setIcon(new ImageIcon(imgXing));
		contentPane.add(lblGameCaro_1);
		
		JLabel lblChonCheDoChoi = new JLabel("Chọn chế độ chơi");
		lblChonCheDoChoi.setHorizontalAlignment(SwingConstants.CENTER);
		lblChonCheDoChoi.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 30));
		lblChonCheDoChoi.setForeground(new Color(255, 255, 181));
		lblChonCheDoChoi.setBounds(468, 195, 311, 58);
		contentPane.add(lblChonCheDoChoi);
		
		JButton btnMotNguoiChoi = new JButton("");
		btnMotNguoiChoi.setBorder(UIManager.getBorder("Button.border"));
		btnMotNguoiChoi.setFont(new Font("Space Mono", Font.BOLD | Font.ITALIC, 20));
		btnMotNguoiChoi.setBackground(new Color(83, 168, 168));
		btnMotNguoiChoi.setForeground(new Color(83, 168, 168));
		btnMotNguoiChoi.setBounds(490, 285, 265, 47);
		Image imgMotNguoiChoi = img_MotNguoiChoi;
		btnMotNguoiChoi.setIcon(new ImageIcon(imgMotNguoiChoi));
		btnMotNguoiChoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playSoundButton();
				dispose();
				new OfflineOnePlayerView();
			}
		});
		contentPane.add(btnMotNguoiChoi);
		
		JButton btnHaiNguoiChoi = new JButton("");
		btnHaiNguoiChoi.setForeground(Color.WHITE);
		btnHaiNguoiChoi.setFont(new Font("Space Mono", Font.BOLD | Font.ITALIC, 20));
		btnHaiNguoiChoi.setBackground(new Color(83, 168, 168));
		btnHaiNguoiChoi.setBounds(490, 375, 265, 47);
		Image imgHaiNguoiChoi = img_HaiNguoiChoi;
		btnHaiNguoiChoi.setIcon(new ImageIcon(imgHaiNguoiChoi));
		btnHaiNguoiChoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playSoundButton();
				dispose();
				new HainguoichoiView();
			}
		});
		contentPane.add(btnHaiNguoiChoi);
	}
	
	public void playSoundButton() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("image/click3.wav").getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
    }
}
