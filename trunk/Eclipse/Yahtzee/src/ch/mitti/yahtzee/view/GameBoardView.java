package ch.mitti.yahtzee.view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JLabel;

import ch.mitti.yahtzee.controller.ButtonController;
import ch.mitti.yahtzee.controller.PlayerController;
import ch.mitti.yahtzee.main.MainFrameListener;

public class GameBoardView extends JFrame{
	
	private GridBagLayout gbl;
	private GridBagConstraints gbc;
	private ScoreBoardView scoreBoard;
	private ButtonController buttonBoard;
	private PlayerController playerController;
	private FillerView fillerView;
	private int inset;
	private DiceBoardView diceBoard;
	public static final int WINDOW_SIZE = 800;
	public static final int TOTAL_PLAYER_AMOUNT = 3;
	private int playerAmount;
	
	public GameBoardView(){
		playerAmount = 0;
		inset = 30;
		gbl = new GridBagLayout();
		gbc = new GridBagConstraints();
		playerController = new PlayerController(this);
		scoreBoard = new ScoreBoardView(playerController);
		diceBoard = new DiceBoardView();
		fillerView = new FillerView();
		buttonBoard = new ButtonController();
		
		this.init();
	}
	
	public void init(){
		this.setResizable(false);
		this.getContentPane().setBackground(Color.CYAN);
		ArrayList<PlayerView> playerViews = playerController.getPlayerView();
		
		Iterator<PlayerView> it = playerViews.iterator();
		PlayerView view = null;
		
		this.setLayout(gbl);
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.insets = new Insets(inset, inset, inset, 0);
		
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.gridheight = 8;
		
		gbl.setConstraints(scoreBoard, gbc);
		this.add(scoreBoard);
		
		//Player1
		gbc.gridx = 3;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 8;
		gbc.insets = new Insets(inset,0,inset,0);
		
		if(it.hasNext()) view = it.next();
		gbl.setConstraints(view, gbc);
		this.add(view);
		
		//Player2
		gbc.gridx = 4;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 8;
		
		if(it.hasNext()) view = it.next();
		gbl.setConstraints(view, gbc);
		this.add(view);
		
		//Player3
		gbc.gridx = 5;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 8;
		gbc.insets = new Insets(inset,0,inset,inset);
		
		if(it.hasNext()) view = it.next();
		gbl.setConstraints(view, gbc);
		this.add(view);
		
		//Dice
		gbc.gridx = 6;
		gbc.gridwidth = 1;
		gbc.gridheight = 5;
		gbc.weightx = 0.5;
		gbc.fill = GridBagConstraints.NONE;
		gbl.setConstraints(diceBoard, gbc);
		this.add(diceBoard);
		
		
		
		//Buttons
		gbc.gridy = 6;
		gbc.gridwidth = 2;
		gbc.gridheight = 3;
		gbc.weightx = 1.0;
		gbl.setConstraints(buttonBoard.getView(), gbc);
		this.add(buttonBoard.getView());
		
		//Filler
		/*
		gbc.gridx = 7;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 5;
		gbc.weightx = 1.0;
		
		gbl.setConstraints(fillerView, gbc);
		this.add(fillerView);*/
		
		
		
		this.setSize(WINDOW_SIZE,WINDOW_SIZE);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public int getPlayerAmount(){
		return playerAmount;
	}
	
	public void addPlayerAmount(){
		this.playerAmount++;
	}
}
