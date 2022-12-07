package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Button_cell;
import model.Player;

import java.awt.GridLayout;
import java.awt.HeadlessException;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class GameRoom extends JFrame {
	private static final int M = 12;
	private Button_cell[][] BT = new Button_cell[M][M];
	private JPanel contentPane;
	private Socket client;
	private DataOutputStream os;
	private Player player;
	private boolean click;
	private JTextField sms;
	private JButton doithu;
	private JButton me;
	private JLabel luotdoithu;
	private JLabel denluotban;

	public GameRoom(Socket client, Player player) throws IOException {
		this.client = client;
		this.player = player;
		System.out.println(player.getValue());

		if (player.getValue().equals("X")) {
			click = true;
		} else if (player.getValue().equals("O")) {
			click = false;
		}
		os = new DataOutputStream(client.getOutputStream());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 500);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(275, 10, 430, 430);
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				int x = i, y = j;
				Button_cell bt = new Button_cell();
				bt.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						if (bt.cell.isVisited() == false && click == true) {
							bt.cell.setVisited(true);
							bt.cell.setValue(player.getValue());
							if (bt.cell.getValue().equals("X")) {
								bt.setIcon(new ImageIcon("C:\\DATA\\Client\\src\\view\\x1.png"));
							} else if (bt.cell.getValue().equals("O")) {
								bt.setIcon(new ImageIcon("C:\\DATA\\Client\\src\\view\\o1.png"));
							}
							setClick(false);
							setluotdanh();
							try {
								write("attack," + x + "," + y);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							checkWin5(x, y);
						}
						// TODO Auto-generated method stub

					}
				});
				BT[i][j] = bt;
				panel.add(bt);

			}
		}
		contentPane.add(panel);
		panel.setLayout(new GridLayout(M, M, 1, 1));

		me = new JButton("New button");
		me.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		me.setBounds(87, 35, 85, 68);
		contentPane.add(me);

		doithu = new JButton("New button");
		doithu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		doithu.setBounds(803, 37, 95, 65);
		contentPane.add(doithu);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(746, 260, 213, 180);
		contentPane.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);

		JTextArea allsms = new JTextArea();
		scrollPane.setViewportView(allsms);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 391, 245, 49);
		contentPane.add(panel_2);
		panel_2.setLayout(new BorderLayout(10, 10));

		sms = new JTextField();
		panel_2.add(sms);
		sms.setColumns(10);

		JButton sendsms = new JButton("SEND");
		panel_2.add(sendsms, BorderLayout.WEST);

		denluotban = new JLabel("New label");
		denluotban.setHorizontalAlignment(SwingConstants.CENTER);
		denluotban.setFont(new Font("Tahoma", Font.PLAIN, 15));
		denluotban.setBounds(66, 150, 128, 27);
		contentPane.add(denluotban);

		luotdoithu = new JLabel("New label");
		luotdoithu.setHorizontalAlignment(SwingConstants.CENTER);
		luotdoithu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		luotdoithu.setBounds(782, 154, 150, 19);
		contentPane.add(luotdoithu);
		setluotdanh();
		setVisible(true);
	}

	public void write(String message) throws IOException {
		os.writeUTF(message);
		os.flush();
	}

	public void setAttack(int x, int y) {
		if (BT[x][y].cell.isVisited() == false) {
			BT[x][y].cell.setVisited(true);
			if (player.getValue().equals("O")) {
				BT[x][y].cell.setValue("X");
				BT[x][y].setIcon(new ImageIcon("C:\\DATA\\Client\\src\\view\\x1.png"));
			} else if (player.getValue().equals("X")) {
				BT[x][y].cell.setValue("O");
				BT[x][y].setIcon(new ImageIcon("C:\\DATA\\Client\\src\\view\\o1.png"));
			}
		}
		setClick(true);
		setluotdanh();
	}

	public boolean isClick() {
		return click;
	}

	public void setClick(boolean click) {
		this.click = click;
	}

	public void checkWin5(int i, int j) {
		// Hang ngang
		int count = 0;
		for (int col = 0; col < M; col++) {
			Button_cell cell = BT[i][col];
			if (cell.cell.getValue().equals(player.getValue())) {
				count++;
				if (count == 5) {
					win();

				}
			} else {
				count = 0;
			}
		}

		// Chiều dọc
		count = 0;
		for (int row = 0; row < M; row++) {
			Button_cell cell = BT[row][j];
			if (cell.cell.getValue().equals(player.getValue())) {
				count++;
				if (count == 5) {
					win();
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
			Button_cell cell = BT[TopI][TopJ];
			if (cell.cell.getValue().equals(player.getValue())) {
				count++;
				if (count == 5) {
					win();
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
			Button_cell cell = BT[TopI][TopJ];
			if (cell.cell.getValue().equals(player.getValue())) {
				count++;
				if (count == 5) {
					win();
				}
			} else {
				count = 0;
			}
		}
	}

	public void win() {
		try {
			write("win");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "Người chơi " + player.getName() + " đã chiến thắng", "Thông báo",
				JOptionPane.INFORMATION_MESSAGE);

	}

	public void lose() {
		JOptionPane.showMessageDialog(null, "Bạn đã thua ", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
	}

	public void setplayer(String me, String doithu) {
		this.me.setText(me);
		this.doithu.setText(doithu);
	}
	public void setluotdanh() {
		if(click == true) {
			this.denluotban.setText("Đến lượt bạn");
			this.luotdoithu.setText("Đối thủ đang chờ");
		}
		if(click == false) {
			this.denluotban.setText("Đến lượt đối thủ");
			this.luotdoithu.setText("Đối thủ đang đánh");

		}
	}
}
