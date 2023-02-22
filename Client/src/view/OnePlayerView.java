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
import java.util.Stack;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;


public class OnePlayerView extends JFrame {

	private JPanel contentPane;
	private static final int N = 20;
	private Button_cell[][] buttonCellModel = new Button_cell[N][N];
	private int[][] markPlayer = new int[N][N];
	
	private Image imgX, imgO, img_IconsXO, img_Rotate, imgVs, img_Start, img_Stop, img_Continue, img_Reset, img_Exit, img_Home;

    private Timer timer = new Timer();
    private boolean ST = false;
    private int sec = 0;
    
    AlphaBeta alphaBeta = new AlphaBeta();
    public static final int winScore = 100000000;
	public static final int Machine_WIN = 1;
	public static final int Player_WIN = -1;
	public static final int ST_DRAW = 0;;
	public static final int ST_NORMAL = 2;
	public int count = 0;
	private int clicked = 0;
	private JLabel lblClick;
	
	private JButton bntQuaylai;
	Stack<Integer> stk = new Stack<>();
	
	public OnePlayerView(int depth) {
		
		try{
            imgO = ImageIO.read(getClass().getResource("o1.png"));
            imgX = ImageIO.read(getClass().getResource("x1.png"));
            img_IconsXO = ImageIO.read(getClass().getResource("IconsXO_100x100.png"));
            img_Rotate = ImageIO.read(getClass().getResource("rotate_28x28.png"));
            imgVs = ImageIO.read(getClass().getResource("vs_85x85.png"));
            img_Start = ImageIO.read(getClass().getResource("buttonBatdau_114x38.png"));
            img_Stop = ImageIO.read(getClass().getResource("buttonTamdung_114x38.png"));
            img_Continue = ImageIO.read(getClass().getResource("buttonTieptuc_114x38.png"));
            img_Reset = ImageIO.read(getClass().getResource("reset_50x50.png"));
            img_Exit = ImageIO.read(getClass().getResource("exit_50x50.png"));
            img_Home = ImageIO.read(getClass().getResource("home_50x50.png"));
    	}catch (Exception e){
            e.printStackTrace();
    	}
		
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
		tictactoe.setBounds(237, 22, 675, 616);
		contentPane.add(tictactoe);
		
		JLabel lblgameCaro = new JLabel("Game Caro");
		lblgameCaro.setForeground(Color.WHITE);
		lblgameCaro.setFont(new Font(".VnCooperH", Font.PLAIN, 20));
		lblgameCaro.setBounds(90, 31, 152, 44);
		contentPane.add(lblgameCaro);
		
		JLabel lblIconsXO = new JLabel("");
		lblIconsXO.setBounds(0, 11, 85, 82);
		Image imgIconsXO = img_IconsXO;
		lblIconsXO.setIcon(new ImageIcon(imgIconsXO));
		contentPane.add(lblIconsXO);
		
		JLabel lblChoivsMay = new JLabel("Chơi với máy");
		lblChoivsMay.setForeground(new Color(255, 255, 255));
		lblChoivsMay.setFont(new Font("Space Mono", Font.BOLD, 16));
		lblChoivsMay.setBounds(96, 96, 131, 28);
		contentPane.add(lblChoivsMay);
		
		JLabel lblOffline = new JLabel("Offline");
		lblOffline.setForeground(Color.WHITE);
		lblOffline.setFont(new Font("Space Mono", Font.BOLD, 16));
		lblOffline.setBounds(124, 69, 76, 28);
		contentPane.add(lblOffline);
		
		JLabel lblThongtinTrandau = new JLabel("Thông tin trận đấu");
		lblThongtinTrandau.setForeground(new Color(255, 255, 255));
		lblThongtinTrandau.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblThongtinTrandau.setHorizontalAlignment(SwingConstants.CENTER);
		lblThongtinTrandau.setBounds(12, 170, 219, 43);
		contentPane.add(lblThongtinTrandau);

		JLabel lblNguoichoi1 = new JLabel("Peter");
		lblNguoichoi1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNguoichoi1.setForeground(new Color(255, 255, 255));
		lblNguoichoi1.setFont(new Font("Comforter", Font.BOLD, 26));
		lblNguoichoi1.setBounds(0, 450, 96, 40);
		contentPane.add(lblNguoichoi1);
		
		if(depth==1) {
			JLabel lblNewLabel_7 = new JLabel("Mức độ: Dễ");
			lblNewLabel_7.setForeground(new Color(255, 255, 255));
			lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNewLabel_7.setBounds(40, 207, 155, 37);
			contentPane.add(lblNewLabel_7);

		} else if(depth == 2) {
			JLabel lblNewLabel_7 = new JLabel("Mức độ: Trung bình");
			lblNewLabel_7.setForeground(new Color(255, 255, 255));
			lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNewLabel_7.setBounds(48, 207, 155, 37);
			contentPane.add(lblNewLabel_7);
		} else {
			JLabel lblNewLabel_7 = new JLabel("Mức độ: Khó");
			lblNewLabel_7.setForeground(new Color(255, 255, 255));
			lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNewLabel_7.setBounds(42, 207, 155, 37);
			contentPane.add(lblNewLabel_7);
		}

		JLabel lblSoluotdadanh = new JLabel("Số lượt bạn đã đánh: ");
		lblSoluotdadanh.setForeground(new Color(255, 255, 255));
		lblSoluotdadanh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSoluotdadanh.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoluotdadanh.setBounds(13, 267, 149, 22);
		contentPane.add(lblSoluotdadanh);
		
		
		lblClick = new JLabel("0");
		lblClick.setHorizontalAlignment(SwingConstants.CENTER);
		lblClick.setForeground(Color.WHITE);
		lblClick.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblClick.setBounds(149, 267, 51, 22);
		contentPane.add(lblClick);
				
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++) {
				int x = i; int y = j;
				Button_cell btCell = new Button_cell();
				buttonCellModel[i][j] = btCell;
				tictactoe.add(buttonCellModel[i][j]);
				buttonCellModel[x][y].addMouseListener(new MouseAdapter() {

					@Override
					public void mouseExited(MouseEvent e) {
						buttonCellModel[x][y].setBackground(Color.white);
					}

					@Override
					public void mouseEntered(MouseEvent e) {
						buttonCellModel[x][y].setBackground(null);
					}

					@Override
					public void mousePressed(MouseEvent e) {
						if (markPlayer[x][y]==0&&ST==true) {
							
							//Hàm đánh cờ 
							changePos("X", buttonCellModel[x][y],x,y);	
							
							if(checkWin(markPlayer,count)!=ST_NORMAL) { //Hàm kiểm kết thúc trận. nếu dúng thì kết thúc luôn
								choose(checkWin(markPlayer,count), depth);
								return;	
							}
							
							
							//CalculateNextMove: Hàm tìm nước đánh tốt nhất cho Máy 
							int[] nextMove = AlphaBeta.calculateNextMove(markPlayer, depth);
							
							if(nextMove[0]!=-1 && nextMove[1]!=-1) {
								changePos("O", buttonCellModel[nextMove[0]][nextMove[1]],nextMove[0],nextMove[1]);
							} 
							if(checkWin(markPlayer,count)!=ST_NORMAL) { //Hàm kiểm kết thúc trận. nếu dúng thì kết thúc luôn
								choose(checkWin(markPlayer,count), depth);
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
				deletePos();
				deletePos();
				if(clicked>0) {
					clicked--;
					lblClick.setText(clicked + "");}
			}
		});
		bntQuaylai.setFont(new Font("Tahoma", Font.PLAIN, 15));
		bntQuaylai.setBounds(31, 349, 188, 34);
		Image imgRotate = img_Rotate;
		contentPane.add(bntQuaylai);
		
		JLabel lblTrandaugiua = new JLabel("Trận đấu giữa:");
		lblTrandaugiua.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTrandaugiua.setHorizontalAlignment(SwingConstants.CENTER);
		lblTrandaugiua.setForeground(new Color(255, 255, 255));
		lblTrandaugiua.setBounds(57, 420, 131, 28);
		contentPane.add(lblTrandaugiua);
		
		JLabel lblIconsVs = new JLabel("");
		lblIconsVs.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconsVs.setBounds(95, 442, 67, 54);
		Image img3 = imgVs;
		lblIconsVs.setIcon(new ImageIcon(img3));
		contentPane.add(lblIconsVs);
		
		JLabel lblMay = new JLabel("Máy");
		lblMay.setHorizontalAlignment(SwingConstants.CENTER);
		lblMay.setForeground(new Color(255, 255, 255));
		lblMay.setFont(new Font("Comforter", Font.BOLD, 26));
		lblMay.setBounds(160, 450, 54, 40);
		contentPane.add(lblMay);
		
		JLabel lblTgThidau = new JLabel("Thời gian thi đấu: ");
		lblTgThidau.setHorizontalAlignment(SwingConstants.CENTER);
		lblTgThidau.setForeground(Color.WHITE);
		lblTgThidau.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTgThidau.setBounds(10, 303, 131, 22);
		contentPane.add(lblTgThidau);
		
		JLabel lblTime = new JLabel("00:00");
		lblTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblTime.setForeground(Color.WHITE);
		lblTime.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTime.setBounds(139, 303, 61, 22);
		contentPane.add(lblTime);
		
		
		JButton btnStart = new JButton("0");
		btnStart.setForeground(new Color(83, 168, 168));
		btnStart.setFont(new Font("Tahoma", Font.PLAIN, 5));
		btnStart.setBackground(new Color(83, 168, 168));
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
							lblTime.setText(((sec / 60) / 10) + "" + (sec / 60) % 10 + ":" + ((sec % 60) / 10) + (sec % 60 % 10));
						}
					}, 1000, 1000); // trễ ban đầu 1000ms ,vòng lặp lại sau 1000ms
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
							lblTime.setText(((sec / 60) / 10) + "" + (sec / 60) % 10 + ":" + ((sec % 60) / 10) + (sec % 60 % 10));
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
		
		contentPane.add(btnStart);
		
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
				if(depth==1) new OnePlayerView(1);
				else if(depth==2) new OnePlayerView(2);
				else new OnePlayerView(3);
			}
		});
		contentPane.add(btnReset);

	}

	public void Reset() {
		 
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++) {
				buttonCellModel[i][j].setIcon(null);
				buttonCellModel[i][j].cell.setValue("no");
				buttonCellModel[i][j].cell.setVisited(false);
				clicked = 0;
			}
	}

	//Hàm đánh cờ (vẽ O hoặc X) vào ô cờ, rồi đánh dấu xem đã được thăm chưa
	public void changePos(String turn, Button_cell bt,int x, int y) {
		int k=x*10000+y;
		if(turn=="O") {
			Image img = imgO;
			bt.setIcon(new ImageIcon(img));
			markPlayer[x][y] = 1;
			count++;
			stk.push(k);
		}else if(turn=="X") {
			Image img = imgX;
			bt.setIcon(new ImageIcon(img));
			markPlayer[x][y] = -1;
			count++;
			clicked++;
			lblClick.setText(clicked + "");
			stk.push(k);
		}
	}
	
	//Hàm xóa nước vừa đánh
	public void deletePos() {
		if(!stk.empty()) {
			int k=stk.peek(); stk.pop();
			int yk=k%10000; int xk=(k-yk)/10000;			
			buttonCellModel[xk][yk].setIcon(null);
			markPlayer[xk][yk] = 0;
			count--;
		}
	}
		 
		//Hàm kiểm tra xem hết trận đấu chưa, cụ thể là đã thắng hòa hay thua chưa. (True là đã hết || False là chưa hết)
		public int checkWin(int[][] arr, int count) {	
			
			if(Heuristic.getScore(arr,1,-1) >= winScore) return Machine_WIN;	

			else if (Heuristic.getScore(arr,-1,1) >= winScore) return Player_WIN;
			
			else if (count==N*N) return ST_DRAW;
			
			return ST_NORMAL;	
		}
	
	
	//Hàm lựa chọn sau khi kết thúc trò chơi
	public void choose(int winner, int depth) {
		if(winner== ST_DRAW) JOptionPane.showMessageDialog(null, "Draw!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
		
		if(winner== Machine_WIN) JOptionPane.showMessageDialog(null, "You lose!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);

		if(winner== Player_WIN) JOptionPane.showMessageDialog(null, "You win!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
		
		int res = JOptionPane.showConfirmDialog(this, "Bạn muốn chơi lại không?","Đã hết game ",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
		
		if(res == JOptionPane.YES_OPTION) {
			dispose();
			new OnePlayerView(depth);
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
}


