package ch.mitti.yahtzee.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import ch.mitti.yahtzee.view.GameBoardView;

public class GameMenu extends JMenuBar implements ActionListener{
	JMenu mainMenu;
	JMenuItem newgame;
	JMenuItem highscores;
	JMenuItem endApplication;
	GameBoardView gameBoardView;
	
	public GameMenu(GameBoardView gameBoardView){
		this.gameBoardView = gameBoardView;
		init();
	}
	
	private void init(){
		mainMenu = new JMenu("Game");
		newgame = new JMenuItem("Neues Spiel");
		newgame.addActionListener(this);
		
		mainMenu.add(newgame);
		this.add(mainMenu);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JMenuItem clicked = (JMenuItem)e.getSource();
		if(clicked.getText() == "Neues Spiel"){
			gameBoardView.removeWindow();
			gameBoardView = null;
			gameBoardView = new GameBoardView();
		}
		
	}
}


