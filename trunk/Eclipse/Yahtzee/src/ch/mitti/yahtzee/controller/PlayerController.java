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
	private GameBoardView gameBoard;
	private int playerAmount;
	private ArrayList<PlayerView> playerViews;
	
	public PlayerController(GameBoardView gameBoard){
		playerViews = new ArrayList<PlayerView>();
		playerAmount = 0;
		while(playerAmount<GameBoardView.TOTAL_PLAYER_AMOUNT) addPlayer();
		this.gameBoard = gameBoard;
		}
	
	private void addPlayer(){
		String name = (String)JOptionPane.showInputDialog(gameBoard, "Name");
		if(name.equals("")) name = "Player " + (playerAmount+1);
		playerViews.add(new PlayerView(name));
		playerAmount++;
	}
	
	public ArrayList<PlayerView> getPlayerView(){
		return playerViews;
	}
}
