package view;

import java.awt.Color;
import java.util.TimerTask;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Timer;
import java.util.TimerTask;

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
	private JTextArea allsms;
	private JLabel loading2;
	private JLabel loading1;
	private JLabel timebd;
	private JTextField textField;
	private Timer timer;
	private int sec;
	

	public GameRoom(Socket client, Player player) throws IOException {
		Timer timer = new Timer();
		this.client = client;
		this.player = player;
		System.out.println(player.getValue());
		loading2 = new JLabel("");
		loading2.setHorizontalAlignment(SwingConstants.CENTER);
		loading2.setBounds(815, 178, 70, 70);

		loading1 = new JLabel("");
		loading1.setBackground(Color.WHITE);
		loading1.setHorizontalAlignment(SwingConstants.CENTER);
		loading1.setBounds(98, 165, 70, 70);

		if (player.getValue().equals("X")) {
			click = true;
			loading1.setIcon(new ImageIcon(GameRoom.class.getResource("/view/Ellipsis-1s-70px.gif")));
		} else if (player.getValue().equals("O")) {
			click = false;
			loading2.setIcon(new ImageIcon(GameRoom.class.getResource("/view/Ellipsis-1s-70px.gif")));

		}
		os = new DataOutputStream(client.getOutputStream());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 500);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(278, 0, 430, 430);
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
							loading1.setIcon(null);
							loading2.setIcon(new ImageIcon(GameRoom.class.getResource("/view/Ellipsis-1s-70px.gif")));

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
		me.setBounds(93, 35, 85, 68);
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

		 allsms = new JTextArea("");
		 allsms.setEditable(false);
		scrollPane.setViewportView(allsms);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 391, 245, 49);
		contentPane.add(panel_2);
		panel_2.setLayout(new BorderLayout(10, 10));

		sms = new JTextField();
		panel_2.add(sms);
		sms.setColumns(10);

		JButton sendsms = new JButton("SEND");
		sendsms.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mess = sms.getText();
				System.out.println(mess);
				if(mess != null) {
					try {
						write("sms,"+mess);
						allsms.setText(allsms.getText()+"\nTôi: "+mess);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				sms.setText("");
			}
		});
		panel_2.add(sendsms, BorderLayout.WEST);

		denluotban = new JLabel("New label");
		denluotban.setHorizontalAlignment(SwingConstants.CENTER);
		denluotban.setFont(new Font("Tahoma", Font.PLAIN, 15));
		denluotban.setBounds(70, 128, 128, 27);
		contentPane.add(denluotban);

		luotdoithu = new JLabel("New label");
		luotdoithu.setHorizontalAlignment(SwingConstants.CENTER);
		luotdoithu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		luotdoithu.setBounds(779, 132, 150, 19);
		contentPane.add(luotdoithu);
		
		 
		contentPane.add(loading2);
		
		 
		contentPane.add(loading1);
		
		timebd = new JLabel("Thời gian thi đấu");
		timebd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		timebd.setHorizontalAlignment(SwingConstants.CENTER);
		timebd.setBounds(370, 440, 128, 19);
		contentPane.add(timebd);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setText("00:00");
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(509, 440, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Đầu hàng");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					write("dau-hang");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(87, 266, 111, 27);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Xin hòa");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					write("xin-hoa");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(87, 327, 111, 21);
		contentPane.add(btnNewButton_1);
		setluotdanh();
		timer.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				sec++;
				// TODO Auto-generated method stub
				textField.setText(((sec / 60) / 10) + "" + (sec / 60) % 10 + ":" + ((sec % 60) / 10)
						+ (sec % 60 % 10));
			}
		}, 1000, 1000);
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
		loading1.setIcon(new ImageIcon(GameRoom.class.getResource("/view/Ellipsis-1s-70px.gif")));
		loading2.setIcon(null);


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

	public void setsms(String string) {
		// TODO Auto-generated method stub
		allsms.setText(allsms.getText()+"\nĐối thủ: "+string);
	}
	public void end() {
		JOptionPane.showMessageDialog(null, "Đối thủ đã thoát trận, bạn đã thắng", "Thông báo",
				JOptionPane.INFORMATION_MESSAGE);
	}
}
