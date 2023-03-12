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
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JTextField;

public class PlayView6and3 extends JFrame {
	private int clicked = 0;

	private int sec = 0;

	private JPanel contentPane;
	private static final int N = 6;
	private Button_cell[][] BTXO = new Button_cell[N][N];
	private Player player1 = new Player("Player 1", "O"), player2 = new Player("Player 2", "X");
	private Player PlayerCR;
	private int ST = 0;
	Timer timer = new Timer();
	private JLabel lblNewLabel_2 = new JLabel("--");
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_8;
	private JButton btnStart;
	private JLabel lblNewLabel_4;
	
	public PlayView6and3() {

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

		tictactoe.setLayout(new GridLayout(N, N,9,6));
		tictactoe.setBounds(280, 30, 615, 590);
		contentPane.add(tictactoe);

		JLabel lblNewLabel_1 = new JLabel("Đến lượt: ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Courier New", Font.BOLD, 16));
		lblNewLabel_1.setBounds(10, 224, 109, 22);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_2.setForeground(new Color(255, 255, 255));

		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Courier New", Font.BOLD, 16));
		lblNewLabel_2.setBounds(140, 227, 115, 19);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Số lượt đã đánh: ");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Courier New", Font.BOLD, 16));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(10, 257, 163, 22);
		contentPane.add(lblNewLabel_3);

		lblNewLabel_4 = new JLabel(clicked + "");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Courier New", Font.BOLD, 16));
		lblNewLabel_4.setBounds(180, 258, 57, 20);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Trận đấu giữa: ");
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setFont(new Font("Courier New", Font.BOLD, 20));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(37, 420, 199, 28);
		contentPane.add(lblNewLabel_5);

		lblNewLabel_6 = new JLabel(player1.getName() + " VS " + player2.getName());
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setFont(new Font("Comforter", Font.BOLD, 26));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(7, 450, 242, 42);
		contentPane.add(lblNewLabel_6);

		btnStart = new JButton("0");
		btnStart.setForeground(new Color(83, 168, 168));
		btnStart.setBackground(new Color(83, 168, 168));
		btnStart.setFont(new Font("Tahoma", Font.PLAIN, 5));
		btnStart.setBounds(68, 500, 126, 40);
		btnStart.setIcon(new ImageIcon(PlayView3.class.getResource("/view/buttonBatdau_114x38.png")));

		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playSoundButton();
				String cl = e.getActionCommand();

				if (cl.equals("0")) {
					ST = 1;
					timer.scheduleAtFixedRate(new TimerTask() {

						@Override
						public void run() {
							sec++;
							// TODO Auto-generated method stub
							lblNewLabel_8.setText(((sec / 60) / 10) + "" + (sec / 60) % 10 + ":" + ((sec % 60) / 10)
									+ (sec % 60 % 10));
						}
					}, 1000, 1000);
					btnStart.setIcon(new ImageIcon(PlayView3.class.getResource("/view/buttonTamdung_114x38.png")));
					btnStart.setText("1");

				} else if (cl.equals("2")) {
					ST = 1;

					timer.cancel();
					timer = new Timer();
					btnStart.setIcon(new ImageIcon(PlayView3.class.getResource("/view/buttonTamdung_114x38.png")));
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
					
					for (int i = 0; i < N; i++) {
						for (int j = 0; j < N; j++) {
							if (BTXO[i][j].cell.getValue().equals("O")) BTXO[i][j].setIcon(new ImageIcon("image/o2_90x90.jpg"));
							else if (BTXO[i][j].cell.getValue().equals("X")) BTXO[i][j].setIcon(new ImageIcon("image/x2_90x90.jpg"));
							else BTXO[i][j].setIcon(new ImageIcon("image/border_90x90.jpg"));
						}
					}
					
				} else if (cl.equals("1")) {
					ST = 2;
					timer.cancel();
					btnStart.setIcon(new ImageIcon(PlayView3.class.getResource("/view/buttonTieptuc_114x38.png")));
					btnStart.setText("2");
					
					for (int i = 0; i < N; i++) {
						for (int j = 0; j < N; j++) {
							BTXO[i][j].setIcon(new ImageIcon("image/border2_90x90.jpg"));
						}
					}
					
				}

			}
		});
		contentPane.add(btnStart);

		JLabel lblNewLabel_7 = new JLabel("Thời gian thi đấu");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setForeground(new Color(255, 255, 255));
		lblNewLabel_7.setFont(new Font("Courier New", Font.BOLD, 16));
		lblNewLabel_7.setBounds(30, 290, 204, 22);
		contentPane.add(lblNewLabel_7);

		lblNewLabel_8 = new JLabel("00:00");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setForeground(new Color(255, 255, 255));
		lblNewLabel_8.setBackground(new Color(192, 192, 192));
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_8.setBounds(95, 323, 83, 13);
		contentPane.add(lblNewLabel_8);

		
		
		JLabel lblIconsXO = new JLabel("");
		lblIconsXO.setBounds(0, 11, 85, 82);
		lblIconsXO.setIcon(new ImageIcon(PlayView3.class.getResource("/view/IconsXO_100x100.png")));
		contentPane.add(lblIconsXO);
		
		JLabel lblgameCaro = new JLabel("Game Caro");
		lblgameCaro.setForeground(new Color(255, 238, 240));
		lblgameCaro.setFont(new Font(".VnCooperH", Font.PLAIN, 20));
		lblgameCaro.setBounds(90, 31, 152, 44);
		contentPane.add(lblgameCaro);
		
		JLabel lblOffline = new JLabel("Offline");
		lblOffline.setForeground(new Color(255, 238, 240));
		lblOffline.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 18));
		lblOffline.setBounds(124, 69, 76, 28);
		contentPane.add(lblOffline);
		
		JLabel lblChoivsMay = new JLabel("Hai người chơi");
		lblChoivsMay.setBackground(new Color(255, 238, 240));
		lblChoivsMay.setForeground(new Color(255, 238, 240));
		lblChoivsMay.setFont(new Font("Courier New", Font.BOLD, 19));
		lblChoivsMay.setBounds(85, 96, 165, 28);
		contentPane.add(lblChoivsMay);
		
		JLabel lblThongtinTrandau = new JLabel("Thông tin trận đấu");
		lblThongtinTrandau.setHorizontalAlignment(SwingConstants.CENTER);
		lblThongtinTrandau.setForeground(new Color(255, 255, 181));
		lblThongtinTrandau.setFont(new Font("Courier New", Font.BOLD, 22));
		lblThongtinTrandau.setBounds(12, 170, 250, 43);
		contentPane.add(lblThongtinTrandau);
		
		JButton btnExit = new JButton("");
		btnExit.setFont(new Font("Space Mono", Font.BOLD, 18));
		btnExit.setBackground(new Color(83, 168, 168));
		btnExit.setBounds(13, 562, 54, 54);
		btnExit.setIcon(new ImageIcon(PlayView3.class.getResource("/view/exit_50x50.png")));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playSoundButton();
				System.exit(0);
			}
		});
		contentPane.add(btnExit);
		
		JButton btnHome = new JButton("");
		btnHome.setFont(new Font("Space Mono", Font.BOLD, 18));
		btnHome.setBackground(new Color(83, 168, 168));
		btnHome.setBounds(96, 562, 54, 54);
		btnHome.setIcon(new ImageIcon(PlayView3.class.getResource("/view/home_50x50.png")));
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playSoundButton();
				BackHome();
			}
		});
		contentPane.add(btnHome);
		
		JButton btnReset = new JButton("");
		btnReset.setFont(new Font("Space Mono", Font.BOLD, 18));
		btnReset.setBackground(new Color(83, 168, 168));
		btnReset.setBounds(178, 562, 54, 54);
		btnReset.setIcon(new ImageIcon(PlayView3.class.getResource("/view/reset_50x50.png")));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playSoundButton();
				Reset();
			}
		});
		contentPane.add(btnReset);

		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++) {
				int x = i, y = j;
				Button_cell bt = new Button_cell();
				BTXO[i][j] = bt;
				BTXO[i][j].setIcon(new ImageIcon("image/border_90x90.jpg"));
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
						if (BTXO[x][y].cell.isVisited()==false && ST==0) BTXO[x][y].setIcon(new ImageIcon("image/border_90x90.jpg"));				
						if (BTXO[x][y].cell.isVisited()==false && ST==1) BTXO[x][y].setIcon(new ImageIcon("image/border_90x90.jpg"));		
					}

					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						if (BTXO[x][y].cell.isVisited()==false && ST==0) BTXO[x][y].setIcon(new ImageIcon("image/border2_90x90.jpg"));
						if (BTXO[x][y].cell.isVisited()==false && ST==1 && PlayerCR == player1) BTXO[x][y].setIcon(new ImageIcon("image/o2_pre_90x90.jpg"));
						if (BTXO[x][y].cell.isVisited()==false && ST==1 && PlayerCR == player2) BTXO[x][y].setIcon(new ImageIcon("image/x2_pre_90x90.jpg"));
					}

					@Override
					public void mousePressed(MouseEvent e) {
						if (ST == 1) {
							// TODO Auto-generated method stub
							if (bt.cell.isVisited() == false) {
								if (PlayerCR == player1) {
									playSound();
									clicked++;
									bt.setIcon(new ImageIcon("image/o2_90x90.jpg"));
									bt.cell.setValue("O");
									bt.cell.setVisited(true);
									checkWin5(x, y);
									if (clicked == N * N) {
										System.exit(0);
									}
									PlayerCR = player2;
									setClick();
									setCurrentPlay(PlayerCR.getName());

								} else if (PlayerCR == player2) {
									playSound();
									clicked++;
									bt.setIcon(new ImageIcon("image/x2_90x90.jpg"));
									bt.cell.setValue("X");
									bt.cell.setVisited(true);

									checkWin5(x, y);
									if (clicked == N * N) {
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
		for (int col = 0; col < N; col++) {
			Button_cell cell = BTXO[i][col];
			if (cell.cell.getValue().equals(PlayerCR.getValue())) {
				count++;
				if (count == 4) {
					for (int k = col; k > col - 4; k--) {
						if (PlayerCR.getValue().equals("X"))
							BTXO[i][k].setIcon(new ImageIcon("image/xwin_90x90.jpg"));
						if (PlayerCR.getValue().equals("O"))
							BTXO[i][k].setIcon(new ImageIcon("image/owin_90x90.jpg"));
					}
					choose();

				}
			} else {
				count = 0;
			}
		}

		// Chiều dọc
		count = 0;
		for (int row = 0; row < N; row++) {
			Button_cell cell = BTXO[row][j];
			if (cell.cell.getValue().equals(PlayerCR.getValue())) {
				count++;
				if (count == 4) {
					for (int k = row; k > row - 4; k--) {
						if (PlayerCR.getValue().equals("X"))
							BTXO[k][j].setIcon(new ImageIcon("image/xwin_90x90.jpg"));
						if (PlayerCR.getValue().equals("O"))
							BTXO[k][j].setIcon(new ImageIcon("image/owin_90x90.jpg"));
					}
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

		for (; TopI < N && TopJ < N; TopI++, TopJ++) {
			Button_cell cell = BTXO[TopI][TopJ];
			if (cell.cell.getValue().equals(PlayerCR.getValue())) {
				count++;
				if (count == 4) {
					int x = TopI, y = TopJ;
					for (; x > TopI - 4 && TopJ - 4 < y; x--, y--) {
						if (PlayerCR.getValue().equals("X"))
							BTXO[x][y].setIcon(new ImageIcon("image/xwin_90x90.jpg"));
						if (PlayerCR.getValue().equals("O"))
							BTXO[x][y].setIcon(new ImageIcon("image/owin_90x90.jpg"));
					}
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

			if (TopJ >= N) {
				int du = TopJ - (N - 1);
				TopI = TopI + du;
				TopJ = N - 1;
			}

		for (; TopI < N && TopJ >= 0; TopI++, TopJ--) {
			Button_cell cell = BTXO[TopI][TopJ];
			if (cell.cell.getValue().equals(PlayerCR.getValue())) {
				count++;
				if (count == 4) {
					int x = TopI, y = TopJ;
					for (; x > TopI - 4 && TopJ + 4 > y; x--, y++) {
						if (PlayerCR.getValue().equals("X"))
							BTXO[x][y].setIcon(new ImageIcon("image/xwin_90x90.jpg"));
						if (PlayerCR.getValue().equals("O"))
							BTXO[x][y].setIcon(new ImageIcon("image/owin_90x90.jpg"));
					}
					choose();
				}
			} else {
				count = 0;
			}
		}

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
	
	public void playSound() {
		try {
			AudioInputStream audioInputStream = AudioSystem
					.getAudioInputStream(new File("image/click.wav").getAbsoluteFile());
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
		} catch (Exception ex) {
			System.out.println("Error with playing sound.");
			ex.printStackTrace();
		}
	}
	
	public void playSoundwin() {
		try {
			AudioInputStream audioInputStream = AudioSystem
					.getAudioInputStream(new File("image/win.wav").getAbsoluteFile());
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
		} catch (Exception ex) {
			System.out.println("Error with playing sound.");
			ex.printStackTrace();
		}
	}
	
	public void Reset() {
		int res = JOptionPane.showConfirmDialog(this, "Bạn có muốn chơi lại không?", "Thông báo",
			JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		
		if (res == JOptionPane.YES_OPTION) ResetEnd();
	}
	
	public void ResetEnd() {
		btnStart.setText("2");
		btnStart.setIcon(new ImageIcon(PlayView4.class.getResource("/view/buttonBatdau_114x38.png")));
		lblNewLabel_4.setText(0 + "");
		lblNewLabel_8.setText("00:00");
		timer.cancel();
		sec = 0;
		timer = new Timer();
		ST = 0;
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++) {
				BTXO[i][j].setIcon(new ImageIcon("image/border_90x90.jpg"));
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
			btnStart.setText("2");
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
		playSoundwin();
		timer.cancel();

		sec = 0;
		JOptionPane.showMessageDialog(null, "Người chơi " + PlayerCR.getName() + " đã chiến thắng", "Thông báo",
				JOptionPane.INFORMATION_MESSAGE);
		int res = JOptionPane.showConfirmDialog(this, "Bạn muốn chơi lại không?", "Đã hết game ",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (res == JOptionPane.YES_OPTION) {
			btnStart.setText("2");
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
	
	public void BackHome() {
		int res = JOptionPane.showConfirmDialog(this, "Bạn có muốn quay về trang chủ không?", "Thông báo",
			JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		
		if (res == JOptionPane.YES_OPTION) {
			dispose();
			new MenuView();
		}
	}
}
