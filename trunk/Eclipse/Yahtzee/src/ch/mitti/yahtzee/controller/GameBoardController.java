package ch.mitti.yahtzee.controller;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

import ch.mitti.yahtzee.model.PlayerModel;
import ch.mitti.yahtzee.view.DiceBoardView;
import ch.mitti.yahtzee.view.GameBoardView;
import ch.mitti.yahtzee.view.PlayerView;
import ch.mitti.yahtzee.view.ScoreBoardView;

public class GameBoardController {
	private PlayerController playerController;
	private ArrayList<PlayerModel> playerModels;
	private ArrayList<PlayerView> playerViews;
	private GameBoardView gameBoardView;
	private ButtonController buttonController;
	private DiceBoardView diceBoardView;
	private int rolls;
	private PlayerModel activePlayer;
	
	
	public GameBoardController(PlayerController playerController, GameBoardView gameBoardView){
		this.gameBoardView = gameBoardView;
		this.playerController = playerController;
		this.playerModels = new ArrayList<PlayerModel>();
		this.playerViews = playerController.getPlayerViews();
		this.buttonController = gameBoardView.getButtonController();
		this.diceBoardView = gameBoardView.getDiceBoardView();
		this.rolls = 3;
		activePlayer = null;
		
		Iterator<PlayerView> it = playerViews.iterator();
		while(it.hasNext()){
			PlayerView playerView = it.next();
			playerModels.add(playerView.getModel());
		}
	}
	
	public void nextPlayerStart(){
		PlayerModel player = null;
		Iterator<PlayerModel> it = playerModels.iterator();
		while(it.hasNext()){
			player = it.next();
			if(player.isActivePlayer()) {
				activePlayer = player;
				this.buttonController = gameBoardView.getButtonController();
				buttonController.getView().setActivePlayer(player);
				break;
			}
		}
		JOptionPane.showMessageDialog(gameBoardView, "Nächster Spieler: " + player.getName() );
	}
	
	public void nextPlayer(){
		PlayerModel player = null;
		
		for(int i=0; i<playerModels.size();i++){
			player = playerModels.get(i);
			if(player.isActivePlayer()){
				player.setActivePlayer(false);
				player.setPointsSet(false);
				if(i==playerModels.size()-1){
					playerModels.get(0).setActivePlayer(true);
					player = playerModels.get(0);
				}
				else {				
					playerModels.get(i+1).setActivePlayer(true);
					player = playerModels.get(i+1);
				}
				if(!player.isDone())
				break;
			}
		}
		
		if(player.isDone()){
			endGame();
			return;
		}
		
		diceBoardView.resetDice();
		activePlayer = player;
		buttonController.getView().setActivePlayer(player);
		resetRolls();
		JOptionPane.showMessageDialog(gameBoardView, "Nächster Spieler: " + player.getName() );
	}
	
	public boolean rollsLeft(){
		if(rolls>0) return true;
		else return false;
	}
	
	public void setRollsMinusOne(){
		rolls--;
	}
	
	public void resetRolls(){
		rolls = 3;
	}
	
	public void setRollsToZero(){
		rolls=0;
	}
	
	public int getRollCount(){
		return rolls;
	}
	
	public PlayerModel getActivePlayer(){
		return activePlayer;
	}
	
	public GameBoardView getGameBoardView(){
		return gameBoardView;
	}

	public DiceBoardView getDiceBoardView(){
		return diceBoardView;
	}
	
}
