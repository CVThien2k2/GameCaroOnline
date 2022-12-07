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
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JTextField;

public class PlayView3 extends JFrame {
	private int clicked = 0;

	private int sec = 0;

	private JPanel contentPane;
	private static final int M = 3;
	private Button_cell[][] BTXO = new Button_cell[M][M];
	private Player player1 = new Player("Player 1", "O"), player2 = new Player("Player 2", "X");
	private Player PlayerCR;
	private boolean ST = false;
	Timer timer = new Timer();
	private JLabel lblNewLabel_2 = new JLabel("--");

	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_8;

	private JButton btnNewButton;

	private JLabel lblNewLabel_4;

	public PlayView3() {

		Start();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setSize(940, 685);
		setResizable(false);
		setLocationRelativeTo(null);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu_2 = new JMenu("Menu");
		menuBar.add(mnNewMenu_2);

		JMenuItem mntmNewMenuItem = new JMenuItem("Continue");
		mnNewMenu_2.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Restart");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reset();
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_1);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Exit");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_2);

		JMenu mnNewMenu = new JMenu("Setting");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Information");
		mnNewMenu.add(mntmNewMenuItem_3);

		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Help");
		mnNewMenu.add(mntmNewMenuItem_4);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel tictactoe = new JPanel();

		tictactoe.setLayout(new GridLayout(M, M,20,20));
		tictactoe.setBounds(241, 0, 675, 616);
		contentPane.add(tictactoe);

		JLabel lblNewLabel = new JLabel("Thông tin trận đấu");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(28, 35, 187, 28);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Đến lượt: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 105, 96, 22);
		contentPane.add(lblNewLabel_1);

		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(116, 107, 115, 19);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Số lượt đã đánh: ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(10, 175, 118, 22);
		contentPane.add(lblNewLabel_3);

		lblNewLabel_4 = new JLabel(clicked + "");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(151, 175, 57, 20);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Trận đấu giữa: ");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(67, 441, 106, 28);
		contentPane.add(lblNewLabel_5);

		lblNewLabel_6 = new JLabel(player1.getName() + " VS " + player2.getName());
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(41, 479, 166, 22);
		contentPane.add(lblNewLabel_6);

		btnNewButton = new JButton("Start");
		btnNewButton.setBackground(new Color(0, 255, 64));

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cl = e.getActionCommand();

				if (cl.equals("Start")) {
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
					btnNewButton.setText("Stop");

				} else if (cl.equals("Continue")) {
					ST = true;

					timer.cancel();
					timer = new Timer();
					btnNewButton.setSize(75, 35);
					btnNewButton.setBackground(Color.red);
					timer.scheduleAtFixedRate(new TimerTask() {

						@Override
						public void run() {
							sec++;
							// TODO Auto-generated method stub
							lblNewLabel_8.setText(((sec / 60) / 10) + "" + (sec / 60) % 10 + ":" + ((sec % 60) / 10)
									+ (sec % 60 % 10));
						}
					}, 1000, 1000);
					btnNewButton.setText("Stop");
				} else if (cl.equals("Stop")) {
					ST = false;
					timer.cancel();
					btnNewButton.setSize(100, 35);
					btnNewButton.setBackground(Color.blue);
					btnNewButton.setText("Continue");

				}

			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(77, 523, 73, 36);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel_7 = new JLabel("Thời gian thi đấu");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(67, 240, 118, 22);
		contentPane.add(lblNewLabel_7);

		lblNewLabel_8 = new JLabel("00:00");
		lblNewLabel_8.setBackground(new Color(192, 192, 192));
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_8.setBounds(96, 287, 65, 13);
		contentPane.add(lblNewLabel_8);

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
					public void mousePressed(MouseEvent e) {
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
					public void mouseClicked(MouseEvent e) {
						if (ST == true) {
							// TODO Auto-generated method stub
							if (bt.cell.isVisited() == false) {
								if (PlayerCR == player1) {
									clicked++;
									bt.setIcon(new ImageIcon("C:\\DATA\\Client\\src\\view\\o1.png"));
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
									bt.setIcon(new ImageIcon("C:\\DATA\\Client\\src\\view\\x1.png"));
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
				if (count == 3) {
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
				if (count == 3) {
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
				if (count == 3) {
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
				if (count == 3) {
					choose();
				}
			} else {
				count = 0;
			}
		}

	}

	public void Reset() {
		btnNewButton.setText("Start");
		btnNewButton.setBackground(Color.green);
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
			btnNewButton.setText("Start");
			btnNewButton.setBackground(Color.GREEN);
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
			btnNewButton.setText("Start");
			btnNewButton.setBackground(Color.GREEN);
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
