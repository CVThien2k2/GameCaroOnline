package view;

import java.awt.Color;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Button_cell;
import model.HeuristicModel;
import model.AlphaBetaModel;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Timer;
import java.awt.event.ActionEvent;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JTextField;

public class OnePlayerView extends JFrame {
	private int clicked = 0;

	private JPanel contentPane;
	private static final int N = 20;
	private Button_cell[][] buttonCellModel = new Button_cell[N][N];
	private int[][] markPlayer = new int[N][N];
	
	private Image imgX;
    private Image imgO;
    
    AlphaBetaModel alphaBetaModel = new AlphaBetaModel();
    public static final int winScore = 100000000;
	public static final int Machine_WIN = 1;
	public static final int Player_WIN = -1;
	public static final int ST_DRAW = 0;;
	public static final int ST_NORMAL = 2;
	public int count=0;
	
	public OnePlayerView() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setSize(940, 685);
		setResizable(false);
		setLocationRelativeTo(null);
		
		//Tạo menu
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu_2 = new JMenu("Menu");
		menuBar.add(mnNewMenu_2);

		JMenuItem mntmNewMenuItem_0 = new JMenuItem("Continue");
		mnNewMenu_2.add(mntmNewMenuItem_0);

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

		tictactoe.setLayout(new GridLayout(N, N));
		tictactoe.setBounds(241, 0, 675, 616);
		contentPane.add(tictactoe);

		JLabel lblNewLabel = new JLabel("Thông tin trận đấu");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(28, 35, 187, 28);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Người chơi: X ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 105, 96, 22);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Máy: O");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		lblNewLabel_2.setBounds(130, 107, 115, 19);
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
		
		try{
            imgO = ImageIO.read(getClass().getResource("o1.png"));
            imgX = ImageIO.read(getClass().getResource("x1.png"));
    	}catch (Exception e){
            e.printStackTrace();
    	}
		
		
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
						if (markPlayer[x][y]==0) {
							
							//Hàm đánh cờ 
							changePos("X", buttonCellModel[x][y],x,y);	
							
							if(checkWin(markPlayer,count)!=ST_NORMAL) { //Hàm kiểm kết thúc trận. nếu dúng thì kết thúc luôn
								choose(checkWin(markPlayer,count));
								return;	
							}
							
							//CalculateNextMove: Hàm tìm nước đánh tốt nhất cho Máy 
							int[] nextMove = AlphaBetaModel.calculateNextMove(markPlayer);
							
							if(nextMove[0]!=-1 && nextMove[1]!=-1) {
								changePos("O", buttonCellModel[nextMove[0]][nextMove[1]],nextMove[0],nextMove[1]);
							} 
							if(checkWin(markPlayer,count)!=ST_NORMAL) { //Hàm kiểm kết thúc trận. nếu dúng thì kết thúc luôn
								choose(checkWin(markPlayer,count));
								return;	
							}	
						}
					}
				});
			}
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
			if(turn=="O") {
				Image img = imgO;
				bt.setIcon(new ImageIcon(img));
				markPlayer[x][y] = 1;
				count++;
			}else if(turn=="X") {
				Image img = imgX;
				bt.setIcon(new ImageIcon(img));
				markPlayer[x][y] = -1;
				count++;
			}
		}
		 
		//Hàm kiểm tra xem hết trận đấu chưa, cụ thể là đã thắng hòa hay thua chưa. (True là đã hết || False là chưa hết)
		public int checkWin(int[][] arr, int count) {	
			
			if(HeuristicModel.getScore(arr,1,-1) >= winScore) return Machine_WIN;	

			else if (HeuristicModel.getScore(arr,-1,1) >= winScore) return Player_WIN;
			
			else if (count==N*N) return ST_DRAW;
			
			return ST_NORMAL;	
		}
	
	
	//Hàm lựa chọn sau khi kết thúc trò chơi
	public void choose(int winner) {
		if(winner== ST_DRAW) JOptionPane.showMessageDialog(null, "Draw!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
		
		if(winner== Machine_WIN) JOptionPane.showMessageDialog(null, "You lose!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);

		if(winner== Player_WIN) JOptionPane.showMessageDialog(null, "You win!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
		
		int res = JOptionPane.showConfirmDialog(this, "Bạn muốn chơi lại không?","Đã hết game ",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
		
		if(res == JOptionPane.YES_OPTION) {
			dispose();
			new OnePlayerView();
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


