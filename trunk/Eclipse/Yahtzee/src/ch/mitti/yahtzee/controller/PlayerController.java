package ch.mitti.yahtzee.controller;

import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import ch.mitti.yahtzee.model.PlayerModel;
import ch.mitti.yahtzee.view.GameBoardView;
import ch.mitti.yahtzee.view.PlayerView;

public class PlayerController {
	private GameBoardView gameBoardView;
	private int playerAmount;
	private ArrayList<PlayerView> playerViews;
	private DiceBoardController diceBoardController;
	
	public PlayerController(GameBoardView gameBoardView){
		playerViews = new ArrayList<PlayerView>();
		playerAmount = 0;
		this.gameBoardView = gameBoardView;	
				
		while(playerAmount<GameBoardView.TOTAL_PLAYER_AMOUNT) {
			addPlayer();
		}
		
		}
	
	private void addPlayer(){
		String name = (String)JOptionPane.showInputDialog(gameBoardView, "Name", "Player");
		if(name==null || name.equals("Player")){
			name = "Player " + (playerAmount+1);
		}
		if(playerAmount==0) playerViews.add(new PlayerView(name, true, this));
		else playerViews.add(new PlayerView(name, false, this));
		playerAmount++;
	}
	
	public ArrayList<PlayerView> getPlayerViews(){
		return playerViews;
	}
	
	public GameBoardView getGameBoardView(){
		return gameBoardView;
	}
}
