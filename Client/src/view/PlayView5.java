package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Button_cell;
import model.Player;

import javax.swing.JTabbedPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JScrollBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JTextField;

public class PlayView5 extends JFrame {
	private int clicked = 0;

	private int sec = 0;

	private JPanel contentPane;
	private static final int M = 12;
	private Button_cell[][] BTXO = new Button_cell[M][M];
	private Player player1 = new Player("Player 1", "O"), player2 = new Player("Player 2", "X");
	private Player PlayerCR;
	private boolean ST = false;
	Timer timer = new Timer();
	private JLabel lblNewLabel_2 = new JLabel("--");
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_8;
	private JButton btnStart;
	private JLabel lblNewLabel_4;
	private Image imgX, imgO, img_IconsXO, img_Start, img_Stop, img_Continue, img_Reset, img_Exit, img_Home;

	public PlayView5() {
		
		try{
            imgO = ImageIO.read(getClass().getResource("o1.png"));
            imgX = ImageIO.read(getClass().getResource("x1.png"));
            img_IconsXO = ImageIO.read(getClass().getResource("IconsXO_100x100.png"));
            img_Start = ImageIO.read(getClass().getResource("buttonBatdau_114x38.png"));
            img_Stop = ImageIO.read(getClass().getResource("buttonTamdung_114x38.png"));
            img_Continue = ImageIO.read(getClass().getResource("buttonTieptuc_114x38.png"));
            img_Reset = ImageIO.read(getClass().getResource("reset_50x50.png"));
            img_Exit = ImageIO.read(getClass().getResource("exit_50x50.png"));
            img_Home = ImageIO.read(getClass().getResource("home_50x50.png"));
    	}catch (Exception e){
            e.printStackTrace();
    	}

		Start();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setSize(940, 685);
		setResizable(false);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(83, 168, 168));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel tictactoe = new JPanel();
		tictactoe.setBackground(new Color(83, 168, 168));

		tictactoe.setLayout(new GridLayout(M, M));
		tictactoe.setBounds(241, 0, 675, 616);
		contentPane.add(tictactoe);

		JLabel lblNewLabel_1 = new JLabel("Đến lượt: ");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 224, 96, 22);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_2.setForeground(new Color(255, 255, 255));

		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(116, 227, 115, 19);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Số lượt đã đánh: ");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(10, 257, 118, 22);
		contentPane.add(lblNewLabel_3);

		lblNewLabel_4 = new JLabel(clicked + "");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(151, 258, 57, 20);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Trận đấu giữa: ");
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(57, 420, 131, 28);
		contentPane.add(lblNewLabel_5);

		lblNewLabel_6 = new JLabel(player1.getName() + " VS " + player2.getName());
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setBackground(new Color(240, 240, 240));
		lblNewLabel_6.setFont(new Font("Comforter", Font.BOLD, 26));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(0, 450, 242, 42);
		contentPane.add(lblNewLabel_6);

		btnStart = new JButton("0");
		btnStart.setForeground(new Color(83, 168, 168));
		btnStart.setBackground(new Color(83, 168, 168));
		btnStart.setFont(new Font("Tahoma", Font.PLAIN, 5));
		btnStart.setBounds(62, 500, 126, 40);
		Image imgStart = img_Start;
		btnStart.setIcon(new ImageIcon(imgStart));


		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cl = e.getActionCommand();

				if (cl.equals("0")) {
					ST = true;
					timer.scheduleAtFixedRate(new TimerTask() {

						@Override
						public void run() {
							sec++;
							// TODO Auto-generated method stub
							lblNewLabel_8.setText(((sec / 60) / 10) + "" + (sec / 60) % 10 + ":" + ((sec % 60) / 10)
									+ (sec % 60 % 10));
						}
					}, 1000, 1000);
					Image imgStop = img_Stop;
					btnStart.setIcon(new ImageIcon(imgStop));
					btnStart.setText("1");

				} else if (cl.equals("2")) {
					ST = true;

					timer.cancel();
					timer = new Timer();
					Image imgStop = img_Stop;
					btnStart.setIcon(new ImageIcon(imgStop));
					timer.scheduleAtFixedRate(new TimerTask() {

						@Override
						public void run() {
							sec++;
							// TODO Auto-generated method stub
							lblNewLabel_8.setText(((sec / 60) / 10) + "" + (sec / 60) % 10 + ":" + ((sec % 60) / 10)
									+ (sec % 60 % 10));
						}
					}, 1000, 1000);
					btnStart.setText("1");
				} else if (cl.equals("1")) {
					ST = false;
					timer.cancel();
					Image imgContinue = img_Continue;
					btnStart.setIcon(new ImageIcon(imgContinue));
					btnStart.setText("2");

				}

			}
		});
		btnStart.setFont(new Font("Tahoma", Font.PLAIN, 5));
		btnStart.setBounds(62, 500, 126, 40);
		contentPane.add(btnStart);

		JLabel lblNewLabel_7 = new JLabel("Thời gian thi đấu");
		lblNewLabel_7.setForeground(new Color(255, 255, 255));
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(55, 290, 118, 22);
		contentPane.add(lblNewLabel_7);

		lblNewLabel_8 = new JLabel("00:00");
		lblNewLabel_8.setForeground(new Color(255, 255, 255));
		lblNewLabel_8.setBackground(new Color(192, 192, 192));
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_8.setBounds(90, 323, 65, 13);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblIconsXO = new JLabel("");
		lblIconsXO.setBackground(new Color(83, 168, 168));
		lblIconsXO.setBounds(0, 11, 85, 82);
		Image imgIconsXO = img_IconsXO;
		lblIconsXO.setIcon(new ImageIcon(imgIconsXO));
		contentPane.add(lblIconsXO);
		
		JLabel lblgameCaro = new JLabel("Game Caro");
		lblgameCaro.setForeground(new Color(255, 238, 240));
		lblgameCaro.setFont(new Font(".VnCooperH", Font.PLAIN, 20));
		lblgameCaro.setBounds(90, 31, 152, 44);
		contentPane.add(lblgameCaro);
		
		JLabel lblOffline = new JLabel("Offline");
		lblOffline.setForeground(new Color(255, 238, 240));
		lblOffline.setFont(new Font("Space Mono", Font.BOLD, 16));
		lblOffline.setBounds(124, 69, 76, 28);
		contentPane.add(lblOffline);
		
		JLabel lblChoivsMay = new JLabel("Hai người chơi");
		lblChoivsMay.setForeground(new Color(255, 238, 240));
		lblChoivsMay.setFont(new Font("Space Mono", Font.BOLD, 16));
		lblChoivsMay.setBounds(88, 96, 150, 28);
		contentPane.add(lblChoivsMay);
		
		JLabel lblThongtinTrandau = new JLabel("Thông tin trận đấu");
		lblThongtinTrandau.setHorizontalAlignment(SwingConstants.CENTER);
		lblThongtinTrandau.setForeground(Color.WHITE);
		lblThongtinTrandau.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblThongtinTrandau.setBounds(12, 170, 219, 43);
		contentPane.add(lblThongtinTrandau);
		
		JButton btnExit = new JButton("");
		btnExit.setFont(new Font("Space Mono", Font.BOLD, 18));
		btnExit.setBackground(new Color(83, 168, 168));
		btnExit.setBounds(10, 562, 54, 54);
		Image imgExit = img_Exit;
		btnExit.setIcon(new ImageIcon(imgExit));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		contentPane.add(btnExit);
		
		JButton btnHome = new JButton("");
		btnHome.setFont(new Font("Space Mono", Font.BOLD, 18));
		btnHome.setBackground(new Color(83, 168, 168));
		btnHome.setBounds(93, 562, 54, 54);
		Image imgHome = img_Home;
		btnHome.setIcon(new ImageIcon(imgHome));
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MenuView();
			}
		});
		contentPane.add(btnHome);
		
		JButton btnReset = new JButton("");
		btnReset.setFont(new Font("Space Mono", Font.BOLD, 18));
		btnReset.setBackground(new Color(83, 168, 168));
		btnReset.setBounds(175, 562, 54, 54);
		Image imgReset = img_Reset;
		btnReset.setIcon(new ImageIcon(imgReset));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new PlayView5();
			}
		});
		contentPane.add(btnReset);

		for (int i = 0; i < M; i++)
			for (int j = 0; j < M; j++) {
				int x = i, y = j;
				Button_cell bt = new Button_cell();
				BTXO[i][j] = bt;
				BTXO[i][j].addMouseListener(new MouseListener() {

					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						bt.setBackground(Color.white);
					}

					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						bt.setBackground(null);
					}

					@Override
					public void mousePressed(MouseEvent e) {
						if (ST == true) {
							// TODO Auto-generated method stub
							if (bt.cell.isVisited() == false) {
								if (PlayerCR == player1) {
									clicked++;
									Image img = imgO;
									bt.setIcon(new ImageIcon(img));
									bt.cell.setValue("O");
									bt.cell.setVisited(true);
									checkWin5(x, y);
									if (clicked == M * M) {
										System.exit(0);
									}
									PlayerCR = player2;
									setClick();
									setCurrentPlay(PlayerCR.getName());

								} else if (PlayerCR == player2) {
									clicked++;
									Image img = imgX;
									bt.setIcon(new ImageIcon(img));
									bt.cell.setValue("X");
									bt.cell.setVisited(true);

									checkWin5(x, y);
									if (clicked == M * M) {
										full();
									}
									setClick();

									PlayerCR = player1;
									setCurrentPlay(PlayerCR.getName());

								}
							}

						}
					}

					private void setClick() {
						// TODO Auto-generated method stub
						lblNewLabel_4.setText(clicked + "");
					}

				});
				tictactoe.add(BTXO[i][j]);
			}
	}

	public void checkWin5(int i, int j) {
		// Hang ngang
		int count = 0;
		for (int col = 0; col < M; col++) {
			Button_cell cell = BTXO[i][col];
			if (cell.cell.getValue().equals(PlayerCR.getValue())) {
				count++;
				if (count == 5) {
					choose();

				}
			} else {
				count = 0;
			}
		}

		// Chiều dọc
		count = 0;
		for (int row = 0; row < M; row++) {
			Button_cell cell = BTXO[row][j];
			if (cell.cell.getValue().equals(PlayerCR.getValue())) {
				count++;
				if (count == 5) {
					choose();
				}
			} else {
				count = 0;
			}
		}

		// Chéo trái
		int min = Math.min(i, j);
		int TopI = i - min;
		int TopJ = j - min;
		count = 0;

		for (; TopI < M && TopJ < M; TopI++, TopJ++) {
			Button_cell cell = BTXO[TopI][TopJ];
			if (cell.cell.getValue().equals(PlayerCR.getValue())) {
				count++;
				if (count == 5) {
					choose();
				}
			} else {
				count = 0;
			}
		}

		// Chéo phải
		min = Math.min(i, j);
		TopI = i - min;
		TopJ = j + min;
		count = 0;

			if (TopJ >= M) {
				int du = TopJ - (M - 1);
				TopI = TopI + du;
				TopJ = M - 1;
			}

		for (; TopI < M && TopJ >= 0; TopI++, TopJ--) {
			Button_cell cell = BTXO[TopI][TopJ];
			if (cell.cell.getValue().equals(PlayerCR.getValue())) {
				count++;
				if (count == 5) {
					choose();
				}
			} else {
				count = 0;
			}
		}

	}

	public void Reset() {
		btnStart.setText("Start");
		btnStart.setBackground(Color.green);
		lblNewLabel_4.setText(0 + "");
		lblNewLabel_8.setText("00:00");
		timer.cancel();
		sec = 0;
		timer = new Timer();
		ST = false;
		for (int i = 0; i < M; i++)
			for (int j = 0; j < M; j++) {
				BTXO[i][j].setIcon(null);
				BTXO[i][j].cell.setValue("no");
				BTXO[i][j].cell.setVisited(false);
				clicked = 0;

			}
		String[] option = { player1.getName() + " đi trước", player2.getName() + " đi trước" };
		int choose = JOptionPane.showOptionDialog(this, "Bạn muốn: ", "Ai đi trước", 0, JOptionPane.QUESTION_MESSAGE,
				null, option, option);
		if (choose == 0) {
			PlayerCR = player1;
			setCurrentPlay(player1.getName());
		}
		if (choose == 1) {
			PlayerCR = player2;
			setCurrentPlay(player2.getName());
		}
	}
	public void full() {
		timer.cancel();

		sec = 0;
		JOptionPane.showMessageDialog(null, "Đã hết nước để đi", "Thông báo",
				JOptionPane.INFORMATION_MESSAGE);
		int res = JOptionPane.showConfirmDialog(this, "Bạn muốn chơi lại không?", "Ván này hòa ",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (res == JOptionPane.YES_OPTION) {
			btnStart.setText("Start");
			btnStart.setBackground(Color.GREEN);
			Reset();
		} else if (res == JOptionPane.NO_OPTION) {
			String[] option = { "Trở về Menu chính", "Thoát game" };
			int choose = JOptionPane.showOptionDialog(this, "Bạn muốn: ", "Menu", 0, JOptionPane.QUESTION_MESSAGE, null,
					option, option);
			if (choose == 0) {
				dispose();
				new MenuView();
			}
			if (choose == 1) {
				System.exit(0);
			}
		}
	}
	public void choose() {
		timer.cancel();

		sec = 0;
		JOptionPane.showMessageDialog(null, "Người chơi " + PlayerCR.getName() + " đã chiến thắng", "Thông báo",
				JOptionPane.INFORMATION_MESSAGE);
		int res = JOptionPane.showConfirmDialog(this, "Bạn muốn chơi lại không?", "Đã hết game ",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (res == JOptionPane.YES_OPTION) {
			btnStart.setText("Start");
			btnStart.setBackground(Color.GREEN);
			Reset();
		} else if (res == JOptionPane.NO_OPTION) {
			String[] option = { "Trở về Menu chính", "Thoát game" };
			int choose = JOptionPane.showOptionDialog(this, "Bạn muốn: ", "Menu", 0, JOptionPane.QUESTION_MESSAGE, null,
					option, option);
			if (choose == 0) {
				dispose();
				new MenuView();
			}
			if (choose == 1) {
				System.exit(0);
			}
		}
	}

	public void setCurrentPlay(String currentplayer) {
		// TODO Auto-generated method stub
		lblNewLabel_2.setText("" + currentplayer);
	}

	public void Start() {
		int res = JOptionPane.showConfirmDialog(this, "Bạn có muốn đặt tên cho người chơi không?", "Bắt đầu game ",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (res == JOptionPane.YES_OPTION) {
			String NAME1 = JOptionPane.showInputDialog("Nhập tên người chơi O");
			if (NAME1 != null)
				player1.setName(NAME1);
			String NAME2 = JOptionPane.showInputDialog("Nhập tên người chơi X");
			if (NAME2 != null)
				player2.setName(NAME2);
		}
		String[] option = { player1.getName() + " đi trước", player2.getName() + " đi trước" };
		int choose = JOptionPane.showOptionDialog(this, "Bạn muốn: ", "Ai đi trước", 0, JOptionPane.QUESTION_MESSAGE,
				null, option, option);
		if (choose == 0) {
			PlayerCR = player1;
			setCurrentPlay(player1.getName());
		}
		if (choose == 1) {
			PlayerCR = player2;
			setCurrentPlay(player2.getName());
		}
	}
}
