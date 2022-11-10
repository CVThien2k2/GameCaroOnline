package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Button_cell;

import javax.swing.JTabbedPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JScrollBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JTextField;

public class PlayView4 extends JFrame {
	private int clicked = 0;

	private JPanel contentPane;
	private static final int M = 9;
	private Button_cell[][] BTXO = new Button_cell[M][M];
	private String currentplayer = "O";

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public PlayView4() {
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

		tictactoe.setLayout(new GridLayout(M, M));
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

		JLabel lblNewLabel_2 = new JLabel("Người chơi O");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(116, 107, 115, 19);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Số lượt đã đánh: ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(10, 175, 118, 22);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel(clicked+"");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(151, 175, 57, 20);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Tỉ số: ");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(10, 225, 69, 28);
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("0 - 0");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(151, 225, 64, 23);
		contentPane.add(lblNewLabel_6);

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
						// TODO Auto-generated method stub
						if (bt.cell.isVisited() == false) {
							if (currentplayer.equals("O")) {
								clicked++;
								bt.setIcon(new ImageIcon("C:\\DATA\\GM2\\src\\view\\o1.png"));
								bt.cell.setValue("O");
								bt.cell.setVisited(true);
								checkWin5(x, y);
								
								currentplayer = ("X");
								setClick();
								setCurrentPlay(currentplayer);

							} else if (currentplayer.equals("X")) {
								clicked++;
								bt.setIcon(new ImageIcon("C:\\DATA\\GM2\\src\\view\\x1.png"));
								bt.cell.setValue("X");
								bt.cell.setVisited(true);

								checkWin5(x, y);
								setClick();
								
								currentplayer = ("O");
								setCurrentPlay(currentplayer);

							}

						}
					}

					private void setClick() {
						// TODO Auto-generated method stub
						lblNewLabel_4.setText(clicked+"");
					}

					private void setCurrentPlay(String currentplayer) {
						// TODO Auto-generated method stub
						lblNewLabel_2.setText("Người chơi "+currentplayer);
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
			if (cell.cell.getValue().equals(currentplayer)) {
				count++;
				if (count == 4) {
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
			if (cell.cell.getValue().equals(currentplayer)) {
				count++;
				if (count == 4) {
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
			if (cell.cell.getValue().equals(currentplayer)) {
				count++;
				if (count == 4) {
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
			if (cell.cell.getValue().equals(currentplayer)) {
				count++;
				if (count == 4) {
					choose();
				}
			} else {
				count = 0;
			}
		}
	}
	public void choose() {
		JOptionPane.showMessageDialog(null, "Người chơi " + currentplayer + " đã chiến thắng", "Thông báo",
				JOptionPane.INFORMATION_MESSAGE);
		int res = JOptionPane.showConfirmDialog(this, "Bạn muốn chơi lại không?","Đã hết game ",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
		if(res == JOptionPane.YES_OPTION) {
			dispose();
			new PlayView4();
		}
		else if(res == JOptionPane.NO_OPTION) {
			String[] option = {"Trở về Menu chính","Thoát game"};
			int choose = JOptionPane.showOptionDialog(this,"Bạn muốn: ","Menu",0, JOptionPane.QUESTION_MESSAGE, null, option, option);
			if(choose  == 0 ) {
				dispose();
				new MenuView();
			}
			if(choose == 1 ) {
				System.exit(0);
			}
		}
	}

}
