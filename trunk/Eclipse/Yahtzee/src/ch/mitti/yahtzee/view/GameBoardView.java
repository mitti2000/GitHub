package ch.mitti.yahtzee.view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;

import ch.mitti.yahtzee.controller.ButtonController;
import ch.mitti.yahtzee.controller.DiceBoardController;
import ch.mitti.yahtzee.controller.GameBoardController;
import ch.mitti.yahtzee.controller.PlayerController;
import ch.mitti.yahtzee.main.GameMenu;
import ch.mitti.yahtzee.main.MainFrameListener;

public class GameBoardView extends JFrame{
	
	private GridBagLayout gbl;
	private GridBagConstraints gbc;
	private ScoreBoardView scoreBoardView;
	private ButtonController buttonController;
	private PlayerController playerController;
	private GameBoardController gameBoardController;
	private DiceBoardController diceBoardController;
	private FillerView fillerView;
	private int inset;
	private DiceBoardView diceBoardView;
	public static final int WINDOW_SIZE = 800;
	public static final int TOTAL_PLAYER_AMOUNT = 3;
	private int playerAmount;
	private GameMenu gameMenu;
	
	public GameBoardView(){
		playerAmount = 0;
		inset = 30;
		gbl = new GridBagLayout();
		gbc = new GridBagConstraints();
		
		playerController = new PlayerController(this);
		
		scoreBoardView = new ScoreBoardView(playerController);
		diceBoardView = new DiceBoardView(this);
		fillerView = new FillerView();
		diceBoardController = new DiceBoardController(this);
		gameBoardController = new GameBoardController(playerController, this);
		buttonController = new ButtonController(diceBoardView, gameBoardController);
		gameMenu = new GameMenu(this);
		
		
		
		this.init();
	}
	
	public void init(){
		this.setResizable(false);
		this.getContentPane().setBackground(Color.CYAN);
		ArrayList<PlayerView> playerViews = playerController.getPlayerViews();
		
		Iterator<PlayerView> it = playerViews.iterator();
		PlayerView view = null;
		
		this.setJMenuBar(gameMenu);
		
		this.setLayout(gbl);
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.insets = new Insets(inset, inset, inset, 0);
		
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.gridheight = 9;
		
		gbl.setConstraints(scoreBoardView, gbc);
		this.add(scoreBoardView);
		
		//Player1
		gbc.gridx = 3;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 9;
		gbc.insets = new Insets(inset,0,inset,0);
		
		if(it.hasNext()) view = it.next();
		gbl.setConstraints(view, gbc);
		this.add(view);
		
		//Player2
		gbc.gridx = 4;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 9;
		
		if(it.hasNext()) view = it.next();
		gbl.setConstraints(view, gbc);
		this.add(view);
		
		//Player3
		gbc.gridx = 5;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 9;
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
		gbl.setConstraints(diceBoardView, gbc);
		this.add(diceBoardView);
		
		
		
		//Buttons
		gbc.gridy = 6;
		gbc.gridwidth = 2;
		gbc.gridheight = 4;
		gbc.weightx = 1.0;
		gbl.setConstraints(buttonController.getView(), gbc);
		this.add(buttonController.getView());
				
		this.setName("Yahtzee!!!");
		this.setTitle("Yahtzee!!!");
		this.setSize(WINDOW_SIZE,WINDOW_SIZE);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
		gameBoardController.nextPlayerStart();
	}
	
	public int getPlayerAmount(){
		return playerAmount;
	}
	
	public void addPlayerAmount(){
		this.playerAmount++;
	}
	
	public ButtonController getButtonController(){
		return buttonController;
	}

	public ScoreBoardView getScoreBoardView(){
		return scoreBoardView;
	}

	public DiceBoardView getDiceBoardView(){
		return diceBoardView;
	}
	
	public DiceBoardController getDiceBoardController(){
		return diceBoardController;
	}
	
	public GameBoardController getGameBoardController(){
		return gameBoardController;
	}
	
	public void removeWindow(){
		this.dispose();
	}
}
