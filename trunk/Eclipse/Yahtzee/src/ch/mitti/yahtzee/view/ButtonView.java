package ch.mitti.yahtzee.view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ch.mitti.yahtzee.controller.ButtonController;
import ch.mitti.yahtzee.model.ButtonRollModel;
import ch.mitti.yahtzee.model.PlayerModel;

public class ButtonView extends JPanel {
	private ButtonRollModel roll;
	private JButton newGame;
	private JButton highscore;
	private ButtonController controller;
	private DiceBoardView diceBoardView;
	private JLabel activePlayer;

	
	public ButtonView(ButtonController controller, DiceBoardView diceBoardView){
		this.diceBoardView = diceBoardView;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		roll = new ButtonRollModel("Roll");
		newGame = new JButton("New Game");
		highscore = new JButton("Highscore");
		activePlayer = new JLabel("Test");
		this.controller = controller;
		init();
	}

	private void init() {
		this.setBackground(Color.CYAN);
		roll.addActionListener(controller);
		newGame.addActionListener(controller);
		highscore.addActionListener(controller);
		this.setLayout(new GridLayout(3,1,30,30));
		this.add(activePlayer);
		this.add(roll);
		this.add(newGame);
		this.add(highscore);
	}
	
	public void setActivePlayer(PlayerModel player){
		activePlayer.setText(player.getName());
	}
	
	public void setNextPlayer(){
		roll.setText("Nächster Spieler");
	}
	
	
}
