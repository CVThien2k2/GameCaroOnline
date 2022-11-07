package View;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controller.MenuListener;

public class MenuView extends JFrame{
	public MenuView() {
		// TODO Auto-generated constructor stub
		init();
		
		ActionListener ac = new MenuListener(this);
		
		Font font = new Font("Arial" , Font.BOLD ,30);
		
		this.setLayout(new BorderLayout());
		
		JPanel menu = new JPanel();
		JPanel set = new JPanel();
		JPanel meu = new JPanel();
		
		JLabel m = new JLabel("CARO",JLabel.CENTER);
		m.setFont(font);
		
		menu.setLayout(new GridLayout(3,1,80,80));
		
		JButton start = new JButton("START");
		start.addActionListener(ac);
		
		JButton login = new JButton("LOGIN");
		login.addActionListener(ac); 
		
		JButton exit = new JButton("EXIT");
		exit.addActionListener(ac);
		
		start.setFont(font);
		login.setFont(font);
		exit.setFont(font);
		
		menu.add(start);
		menu.add(login);
		menu.add(exit);
		
		meu.add(m);
		
		this.add(meu,BorderLayout.NORTH);
		this.add(menu,BorderLayout.CENTER);
		this.add(set,BorderLayout.SOUTH);
		this.setVisible(true);
		
	}
	public void init() {
		this.setTitle("GAME CARO");
		this.setSize(600,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}

}
