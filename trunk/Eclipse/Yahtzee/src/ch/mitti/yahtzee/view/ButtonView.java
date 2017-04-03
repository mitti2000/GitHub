package ch.mitti.yahtzee.view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import ch.mitti.yahtzee.controller.ButtonController;

public class ButtonView extends JPanel {
	private JButton roll;
	private JButton newGame;
	private JButton highscore;
	private ButtonController controller;
	
	public ButtonView(ButtonController controller){
		roll = new JButton("Roll");
		newGame = new JButton("New Game");
		highscore = new JButton("Highscore");
		this.controller = controller;
		init();
	}

	private void init() {
		this.setBackground(Color.CYAN);
		roll.addActionListener(controller);
		newGame.addActionListener(controller);
		highscore.addActionListener(controller);
		this.setLayout(new GridLayout(3,1,30,30));
		this.add(roll);
		this.add(newGame);
		this.add(highscore);
	}
	
	
}
