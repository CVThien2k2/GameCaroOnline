package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import view.MenuPlayNowView;
import view.MenuView;
import view.TicTacToeView;

public class MenuController implements ActionListener {
	MenuView mnv;

	public MenuController(MenuView mnv) {
		// TODO Auto-generated constructor stub
		this.mnv = mnv;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String src = e.getActionCommand();
		if (src.equals("Thoát")) {
			System.exit(0);
		}
		if (src.equals("Chơi Ngay")) {
			this.mnv.setVisible(false);
			new MenuPlayNowView();
		}

	}

}
