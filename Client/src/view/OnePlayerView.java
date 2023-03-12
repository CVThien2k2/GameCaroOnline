package view;

import java.awt.Color;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Button_cell;
import controller.Heuristic;
import controller.AlphaBeta;

import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.Stack;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;


public class OnePlayerView extends JFrame {

	private JPanel contentPane;
	private static final int N = 16;
	private Button_cell[][] buttonCellModel = new Button_cell[N][N];
	private int[][] markPlayer = new int[N][N];

    private Timer timer = new Timer();
    private int ST = 0;
    private int sec = 0;
    private int countBack = 0;
    
    AlphaBeta alphaBeta = new AlphaBeta();
    public static final int winScore = 100000000;
	public static final int Machine_WIN = 1;
	public static final int Player_WIN = -1;
	public static final int ST_DRAW = 0;;
	public static final int ST_NORMAL = 2;
	public int count = 0;
	private int clicked = 0;
	private JLabel lblClick;
	private String tenNguoiChoi = "Nguoi choi";
	private JButton btnStart;
	private JLabel lblTime;
	
	private JButton bntQuaylai;
	Stack<Integer> stk = new Stack<>();
	
	public OnePlayerView(int depth) {
		Start();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(940, 685);
		setResizable(false);
		setLocationRelativeTo(null);
						
		contentPane = new JPanel();
		contentPane.setBackground(new Color(83, 168, 168));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel tictactoe = new JPanel();
		tictactoe.setBackground(new Color(83, 168, 168));

		tictactoe.setLayout(new GridLayout(N, N));
		tictactoe.setBounds(248, 15, 675, 616);
		contentPane.add(tictactoe);
		
		JLabel lblgameCaro = new JLabel("Game Caro");
		lblgameCaro.setForeground(Color.WHITE);
		lblgameCaro.setFont(new Font(".VnCooperH", Font.PLAIN, 20));
		lblgameCaro.setBounds(90, 31, 152, 44);
		contentPane.add(lblgameCaro);
		
		JLabel lblIconsXO = new JLabel("");
		lblIconsXO.setBounds(0, 11, 85, 82);
		lblIconsXO.setIcon(new ImageIcon(OnePlayerView.class.getResource("/view/IconsXO_100x100.png")));
		contentPane.add(lblIconsXO);
		
		JLabel lblChoivsMay = new JLabel("Chơi với máy");
		lblChoivsMay.setForeground(new Color(255, 255, 255));
		lblChoivsMay.setFont(new Font("Courier New", Font.BOLD, 19));
		lblChoivsMay.setBounds(92, 96, 137, 28);
		contentPane.add(lblChoivsMay);
		
		JLabel lblOffline = new JLabel("Offline");
		lblOffline.setForeground(Color.WHITE);
		lblOffline.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 18));
		lblOffline.setBounds(124, 69, 76, 28);
		contentPane.add(lblOffline);
		
		JLabel lblThongtinTrandau = new JLabel("Thông tin trận đấu");
		lblThongtinTrandau.setForeground(new Color(255, 255, 181));
		lblThongtinTrandau.setFont(new Font("Courier New", Font.BOLD, 21));
		lblThongtinTrandau.setHorizontalAlignment(SwingConstants.CENTER);
		lblThongtinTrandau.setBounds(2, 170, 245, 43);
		contentPane.add(lblThongtinTrandau);

		JLabel lblNguoichoi1 = new JLabel(tenNguoiChoi);
		lblNguoichoi1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNguoichoi1.setForeground(new Color(255, 255, 255));
		lblNguoichoi1.setFont(new Font("Comforter", Font.BOLD, 26));
		lblNguoichoi1.setBounds(0, 450, 102, 40);
		contentPane.add(lblNguoichoi1);
		
		if(depth==1) {
			JLabel lblNewLabel_7 = new JLabel("Mức độ: Dễ");
			lblNewLabel_7.setForeground(new Color(255, 255, 255));
			lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_7.setFont(new Font("Courier New", Font.BOLD, 16));
			lblNewLabel_7.setBounds(40, 207, 155, 37);
			contentPane.add(lblNewLabel_7);

		} else if(depth == 2) {
			JLabel lblNewLabel_7 = new JLabel("Mức độ: Trung bình");
			lblNewLabel_7.setForeground(new Color(255, 255, 255));
			lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_7.setFont(new Font("Courier New", Font.BOLD, 16));
			lblNewLabel_7.setBounds(30, 207, 185, 37);
			contentPane.add(lblNewLabel_7);
		} else {
			JLabel lblNewLabel_7 = new JLabel("Mức độ: Khó");
			lblNewLabel_7.setForeground(new Color(255, 255, 255));
			lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_7.setFont(new Font("Courier New", Font.BOLD, 16));
			lblNewLabel_7.setBounds(42, 207, 155, 37);
			contentPane.add(lblNewLabel_7);
		}

		JLabel lblSoluotdadanh = new JLabel("Số lượt bạn đã đánh: ");
		lblSoluotdadanh.setForeground(new Color(255, 255, 255));
		lblSoluotdadanh.setFont(new Font("Courier New", Font.BOLD, 16));
		lblSoluotdadanh.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoluotdadanh.setBounds(9, 265, 200, 22);
		contentPane.add(lblSoluotdadanh);
		
		
		lblClick = new JLabel("0");
		lblClick.setHorizontalAlignment(SwingConstants.CENTER);
		lblClick.setForeground(Color.WHITE);
		lblClick.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblClick.setBounds(205, 265, 43, 22);
		contentPane.add(lblClick);
				
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++) {
				int x = i; int y = j;
				Button_cell btCell = new Button_cell();
				buttonCellModel[i][j] = btCell;
				buttonCellModel[x][y].setIcon(new ImageIcon("image/border.jpg"));
				tictactoe.add(buttonCellModel[i][j]);
				buttonCellModel[x][y].addMouseListener(new MouseAdapter() {

					@Override
					public void mouseExited(MouseEvent e) {
						if (markPlayer[x][y]==0&&ST==0) buttonCellModel[x][y].setIcon(new ImageIcon("image/border.jpg"));
						if (markPlayer[x][y]==0&&ST==1) buttonCellModel[x][y].setIcon(new ImageIcon("image/border.jpg"));
					}

					@Override
					public void mouseEntered(MouseEvent e) {
						if (markPlayer[x][y]==0&&ST==0) buttonCellModel[x][y].setIcon(new ImageIcon("image/border2.jpg"));
						if (markPlayer[x][y]==0&&ST==1) buttonCellModel[x][y].setIcon(new ImageIcon(OnePlayerView.class.getResource("/icon/x2_pre.jpg")));
					}

					@Override
					public void mousePressed(MouseEvent e) {
						if (markPlayer[x][y]==0&&ST==1) {
							
							//Hàm đánh cờ 
							changePos("X", buttonCellModel[x][y],x,y);	
							
							if(checkWin(x,y,count,-1)== Player_WIN) { //Hàm kiểm kết thúc trận. nếu dúng thì kết thúc luôn
								choose(Player_WIN, depth);
								return;	
							}
							
							//CalculateNextMove: Hàm tìm nước đánh tốt nhất cho Máy 
							int[] nextMove = AlphaBeta.calculateNextMove(markPlayer, depth);
							
							if(nextMove[0]!=-1 && nextMove[1]!=-1) {
								changePos("O", buttonCellModel[nextMove[0]][nextMove[1]],nextMove[0],nextMove[1]);
							} 
							if(checkWin(nextMove[0],nextMove[1],count,1)== Machine_WIN) { //Hàm kiểm kết thúc trận. nếu dúng thì kết thúc luôn
								choose(Machine_WIN, depth);
								return;	
							}	
							
						}
					}
				});
			}
		
		
		bntQuaylai = new JButton("Quay lại nước đi");
		bntQuaylai.setForeground(new Color(255, 255, 255));
		bntQuaylai.setBackground(new Color(125, 191, 191));
		bntQuaylai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playSoundButton();
				if(!stk.empty()) {
					if(countBack<3) {
						deletePos();
						deletePos();
						if(clicked>0) {
							clicked--;
							lblClick.setText(clicked + "");}
						countBack++;
						if(countBack==3) JOptionPane.showMessageDialog(null, "Bạn vừa quay lại nước đi: Bạn còn không còn lượt quay lại nào nữa", "Thông báo quay lại nước đi", JOptionPane.INFORMATION_MESSAGE);
						else JOptionPane.showMessageDialog(null, "Bạn vừa quay lại nước đi: Bạn còn "+(3-countBack) +" lượt quay lại", "Thông báo quay lại nước đi", JOptionPane.INFORMATION_MESSAGE);
					}
					else JOptionPane.showMessageDialog(null, "Bạn đã hết lượt quay lại", "Thông báo quay lại nước đi", JOptionPane.INFORMATION_MESSAGE);

				}
				else JOptionPane.showMessageDialog(null, "Bạn chưa đánh nước đi nào", "Thông báo quay lại nước đi", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		bntQuaylai.setFont(new Font("Courier New", Font.BOLD, 15));
		bntQuaylai.setBounds(17, 365, 215, 34);
		bntQuaylai.setIcon(new ImageIcon(OnePlayerView.class.getResource("/view/rotate_28x28.png")));
		contentPane.add(bntQuaylai);
		
		JLabel lblTrandaugiua = new JLabel("Trận đấu giữa:");
		lblTrandaugiua.setFont(new Font("Courier New", Font.BOLD, 20));
		lblTrandaugiua.setHorizontalAlignment(SwingConstants.CENTER);
		lblTrandaugiua.setForeground(new Color(255, 255, 255));
		lblTrandaugiua.setBounds(32, 420, 199, 28);
		contentPane.add(lblTrandaugiua);
		
		JLabel lblIconsVs = new JLabel("");
		lblIconsVs.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconsVs.setBounds(100, 442, 67, 54);
		lblIconsVs.setIcon(new ImageIcon(OnePlayerView.class.getResource("/view/vs_85x85.png")));
		contentPane.add(lblIconsVs);
		
		JLabel lblMay = new JLabel("Máy");
		lblMay.setHorizontalAlignment(SwingConstants.CENTER);
		lblMay.setForeground(new Color(255, 255, 255));
		lblMay.setFont(new Font("Comforter", Font.BOLD, 26));
		lblMay.setBounds(165, 450, 54, 40);
		contentPane.add(lblMay);
		
		JLabel lblTgThidau = new JLabel("Thời gian thi đấu: ");
		lblTgThidau.setHorizontalAlignment(SwingConstants.CENTER);
		lblTgThidau.setForeground(Color.WHITE);
		lblTgThidau.setFont(new Font("Courier New", Font.BOLD, 16));
		lblTgThidau.setBounds(18, 298, 208, 22);
		contentPane.add(lblTgThidau);
		
		lblTime = new JLabel("00:00");
		lblTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblTime.setForeground(Color.WHITE);
		lblTime.setFont(new Font("Courier New", Font.BOLD, 16));
		lblTime.setBounds(86, 327, 61, 22);
		contentPane.add(lblTime);
		
		
		btnStart = new JButton("0");
		btnStart.setForeground(new Color(83, 168, 168));
		btnStart.setFont(new Font("Tahoma", Font.PLAIN, 5));
		btnStart.setBackground(new Color(83, 168, 168));
		btnStart.setBounds(62, 500, 126, 40);
		btnStart.setIcon(new ImageIcon(OnePlayerView.class.getResource("/view/buttonBatdau_114x38.png")));
		
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
							lblTime.setText(((sec / 60) / 10) + "" + (sec / 60) % 10 + ":" + ((sec % 60) / 10) + (sec % 60 % 10));
						}
					}, 1000, 1000); // trễ ban đầu 1000ms ,vòng lặp lại sau 1000ms
					btnStart.setIcon(new ImageIcon(OnePlayerView.class.getResource("/view/buttonTamdung_114x38.png")));
					btnStart.setText("1");

				} else if (cl.equals("2")) {
					ST = 1;
					timer.cancel();
					timer = new Timer();
					btnStart.setIcon(new ImageIcon(OnePlayerView.class.getResource("/view/buttonTamdung_114x38.png")));
					timer.scheduleAtFixedRate(new TimerTask() {
						@Override
						public void run() {
							sec++;
							lblTime.setText(((sec / 60) / 10) + "" + (sec / 60) % 10 + ":" + ((sec % 60) / 10) + (sec % 60 % 10));
						}
					}, 1000, 1000);
					btnStart.setText("1");
					
					for (int i = 0; i < N; i++) {
						for (int j = 0; j < N; j++) {
							if (markPlayer[i][j]==0) buttonCellModel[i][j].setIcon(new ImageIcon("image/border.jpg"));
							if (markPlayer[i][j]==1) buttonCellModel[i][j].setIcon(new ImageIcon(GameRoom.class.getResource("/icon/o2.jpg")));
							if (markPlayer[i][j]==-1) buttonCellModel[i][j].setIcon(new ImageIcon(GameRoom.class.getResource("/icon/x2.jpg")));
						}
					}
					
				} else if (cl.equals("1")) {
					ST = 2;
					timer.cancel();
					btnStart.setIcon(new ImageIcon(OnePlayerView.class.getResource("/view/buttonTieptuc_114x38.png")));
					btnStart.setText("2");
					
					for (int i = 0; i < N; i++) {
						for (int j = 0; j < N; j++) {
							buttonCellModel[i][j].setIcon(new ImageIcon("image/border2.jpg"));
						}
					}
				}

			}
		});
		
		contentPane.add(btnStart);
		
		JButton btnExit = new JButton("");
		btnExit.setFont(new Font("Space Mono", Font.BOLD, 18));
		btnExit.setBackground(new Color(83, 168, 168));
		btnExit.setBounds(10, 562, 54, 54);
		btnExit.setIcon(new ImageIcon(OnePlayerView.class.getResource("/view/exit_50x50.png")));
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
		btnHome.setBounds(93, 562, 54, 54);
		btnHome.setIcon(new ImageIcon(OnePlayerView.class.getResource("/view/home_50x50.png")));
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
		btnReset.setBounds(175, 562, 54, 54);
		btnReset.setIcon(new ImageIcon(OnePlayerView.class.getResource("/view/reset_50x50.png")));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playSoundButton();
				Reset();
			}
		});
		contentPane.add(btnReset);

	}
	
	public void BackHome() {
		int res = JOptionPane.showConfirmDialog(this, "Bạn có muốn quay về trang chủ không?", "Thông báo",
			JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		
		if (res == JOptionPane.YES_OPTION) {
			dispose();
			new MenuView();
		}
	}
	
	public void Reset() {
		int res = JOptionPane.showConfirmDialog(this, "Bạn có muốn chơi lại không?", "Thông báo",
			JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		
		if (res == JOptionPane.YES_OPTION) ResetEnd();
	}
	
	public void ResetEnd() {
		btnStart.setText("0");
		btnStart.setIcon(new ImageIcon(PlayView4.class.getResource("/view/buttonBatdau_114x38.png")));
		lblClick.setText(0 + "");
		lblTime.setText("00:00");
		timer.cancel();
		sec = 0;
		timer = new Timer();
		ST = 0;
		count = 0;
		countBack=0;
		stk.clear();
			
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++) {
				buttonCellModel[i][j].setIcon(new ImageIcon("image/border.jpg"));
				buttonCellModel[i][j].cell.setValue("no");
				buttonCellModel[i][j].cell.setVisited(false);
				markPlayer[i][j] = 0;
				clicked = 0;
			}
	}
	

	//Hàm đánh cờ (vẽ O hoặc X) vào ô cờ, rồi đánh dấu xem đã được thăm chưa
	public void changePos(String turn, Button_cell bt,int x, int y) {
		int k=x*10000+y;
		if(turn=="O") {
			bt.setIcon(new ImageIcon(GameRoom.class.getResource("/icon/o2.jpg")));
			markPlayer[x][y] = 1;
			count++;
			stk.push(k);
			playSound();
		}else if(turn=="X") {
			bt.setIcon(new ImageIcon(GameRoom.class.getResource("/icon/x2.jpg")));
			markPlayer[x][y] = -1;
			count++;
			clicked++;
			lblClick.setText(clicked + "");
			stk.push(k);
			playSound();
		}
	}
	
	//Hàm xóa nước vừa đánh
	public void deletePos() {
		if(!stk.empty()) {
			int k=stk.peek(); stk.pop();
			int yk=k%10000; int xk=(k-yk)/10000;			
			buttonCellModel[xk][yk].setIcon(new ImageIcon("image/border.jpg"));
			markPlayer[xk][yk] = 0;
			count--;
			
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
	
		public int checkWin(int i, int j, int countXo, int xo) {
			// Hang ngang
			int count = 0;
			for (int col = 0; col < N; col++) {
				if (markPlayer[i][col]==xo) {
					count++;
					if (count == 5) {
						for (int k = col; k > col - 5; k--) {
							if (xo==1) buttonCellModel[i][k].setIcon(new ImageIcon(OnePlayerView.class.getResource("/icon/owin.jpg")));
							if (xo==-1)buttonCellModel[i][k].setIcon(new ImageIcon(OnePlayerView.class.getResource("/icon/xwin.jpg")));
						}
						if(xo==1) return Machine_WIN;
						if(xo==-1)	return Player_WIN;
					}
				} else {
					count = 0;
				}
			}

			// Chiều dọc
			count = 0;
			for (int row = 0; row < N; row++) {
				if (markPlayer[row][j]==xo) {
					count++;
					if (count == 5) {
						for (int k = row; k > row - 5; k--) {
							if (xo==1) buttonCellModel[k][j].setIcon(new ImageIcon(OnePlayerView.class.getResource("/icon/owin.jpg")));
							if (xo==-1)buttonCellModel[k][j].setIcon(new ImageIcon(OnePlayerView.class.getResource("/icon/xwin.jpg")));
						}
						if(xo==1) return Machine_WIN;
						if(xo==-1)	return Player_WIN;
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
				if (markPlayer[TopI][TopJ]==xo) {
					count++;
					if (count == 5) {
						int x = TopI, y = TopJ;
						for (; x > TopI - 5 && TopJ - 5 < y; x--, y--) {
							if (xo==1) buttonCellModel[x][y].setIcon(new ImageIcon(OnePlayerView.class.getResource("/icon/owin.jpg")));
							if (xo==-1)buttonCellModel[x][y].setIcon(new ImageIcon(OnePlayerView.class.getResource("/icon/xwin.jpg")));
						}
						if(xo==1) return Machine_WIN;
						if(xo==-1)	return Player_WIN;
					}
				} else {
					count = 0;
				}
			}
			// cheophai
			min = i;
			TopI = i - min;
			TopJ = j + min;
			count = 0;

			if (TopJ >= N) {
				int du = TopJ - (N - 1);
				TopI = TopI + du;
				TopJ = N - 1;
			}

			for (; TopI < N && TopJ >= 0; TopI++, TopJ--) {
				if (markPlayer[TopI][TopJ]==xo) {
					count++;
					if (count == 5) {
						int x = TopI, y = TopJ;
						for (; x > TopI - 5 && TopJ + 5 > y; x--, y++) {
							if (xo==1) buttonCellModel[x][y].setIcon(new ImageIcon(OnePlayerView.class.getResource("/icon/owin.jpg")));
							if (xo==-1)buttonCellModel[x][y].setIcon(new ImageIcon(OnePlayerView.class.getResource("/icon/xwin.jpg")));
						}
						if(xo==1) return Machine_WIN;
						if(xo==-1)	return Player_WIN;
					}
				} else {
					count = 0;
				}
			}
			if (countXo==N*N) return ST_DRAW;
			return ST_NORMAL;
		}
		
	
	//Hàm lựa chọn sau khi kết thúc trò chơi
	public void choose(int winner, int depth) {
		playSoundwin();
		if(winner== ST_DRAW) JOptionPane.showMessageDialog(null, "Draw!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
		
		if(winner== Machine_WIN) JOptionPane.showMessageDialog(null, "You lose!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);

		if(winner== Player_WIN) JOptionPane.showMessageDialog(null, "You win!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
		
		int res = JOptionPane.showConfirmDialog(this, "Bạn muốn chơi lại không?","Đã hết game ",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
		
		if(res == JOptionPane.YES_OPTION) {
			ResetEnd();
		}
		if(res == JOptionPane.NO_OPTION) {
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
	
	public void Start() {
		int res = JOptionPane.showConfirmDialog(this, "Bạn có muốn đặt tên cho người chơi không?", "Bắt đầu game ",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (res == JOptionPane.YES_OPTION) {
			String NAME = JOptionPane.showInputDialog("Nhập tên người chơi O");
			if (NAME != null)
				tenNguoiChoi = NAME;
			else tenNguoiChoi = "Nguoi choi";
		}
	}
}


