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
	private boolean gameDone;
	
	
	public GameBoardController(PlayerController playerController, GameBoardView gameBoardView){
		this.gameBoardView = gameBoardView;
		this.playerController = playerController;
		this.playerModels = new ArrayList<PlayerModel>();
		this.playerViews = playerController.getPlayerViews();
		this.buttonController = gameBoardView.getButtonController();
		this.diceBoardView = gameBoardView.getDiceBoardView();
		this.rolls = 3;
		this.gameDone = false;
		activePlayer = null;
		
		Iterator<PlayerView> it = playerViews.iterator();
		while(it.hasNext()){
			PlayerView playerView = it.next();
			playerModels.add(playerView.getModel());
		}
	}
	
	public void nextPlayerStart(){
		diceBoardView.resetDice();
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
		JOptionPane.showMessageDialog(gameBoardView, "N�chster Spieler: " + player.getName() );
	}
	
	public void nextPlayer(){
		if(gameDone) endGame();
		PlayerModel player = null;
		int doneCount = 0;
		
		for(int i=0; i<playerModels.size();i++){
			player = playerModels.get(i);
			
			if(!player.isDone() || (player.isDone() || player.isActivePlayer())){
				if(player.isActivePlayer()){
					player = setNextPlayerActive(player, i);
					break;
				}
			}
		}
		
		for(int i=0; i<playerModels.size();i++){
			if(playerModels.get(i).isDone()) doneCount++;
		}
		
		if(doneCount>=playerModels.size()) {
			endGame();
			return;
		}
		
		
		
		diceBoardView.resetDice();
		activePlayer = player;
		buttonController.getView().setActivePlayer(player);
		resetRolls();
		JOptionPane.showMessageDialog(gameBoardView, "N�chster Spieler: " + player.getName() );
	}
	
	public PlayerModel setNextPlayerActive(PlayerModel player, int i){
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
		
		return player;
	}
	
	public void endGame(){
		gameDone = true;
		int maxScore = 0;
		String bestPlayer = "";
		
		for(int i=0; i<playerModels.size();i++){
			if(playerModels.get(i).getTotalScore()>maxScore){
				maxScore = playerModels.get(i).getTotalScore();
				bestPlayer = playerModels.get(i).getName();
			}
		}
		buttonController.setGameDone();
		JOptionPane.showMessageDialog(gameBoardView, "Spiel Beendet \n  "
				+ "Bester Spieler ist " + bestPlayer + " mit " + maxScore + " Punkten. \n\n"
						+ "Gratulation !!");
		
		
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
	
	public void setScores(){
		ArrayList<PlayerView> playerViews = playerController.getPlayerViews();
		for(PlayerView view : playerViews){
			if(view.getModel().isActivePlayer()){
				view.setSums();
			}
		}
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
