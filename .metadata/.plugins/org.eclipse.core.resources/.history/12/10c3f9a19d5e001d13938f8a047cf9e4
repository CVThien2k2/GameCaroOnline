package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.BanCoView;
import View.MenuView;

public class MenuListener implements ActionListener {
	MenuView mv;
	public MenuListener(MenuView mv) {
		// TODO Auto-generated constructor stub
		this.mv = mv ;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String src = e.getActionCommand();
		if(src.equals("START")) {
			new BanCoView();
			mv.setVisible(false);
			
		}
	}

}
