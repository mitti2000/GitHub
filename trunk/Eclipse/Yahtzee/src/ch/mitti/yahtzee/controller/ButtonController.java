package ch.mitti.yahtzee.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import ch.mitti.yahtzee.model.ButtonRollModel;
import ch.mitti.yahtzee.model.DiceBoardModel;
import ch.mitti.yahtzee.view.ButtonView;
import ch.mitti.yahtzee.view.DiceBoardView;

public class ButtonController implements ActionListener{
	private ButtonView buttonView;
	private DiceBoardView diceBoardView;
	private DiceBoardModel diceBoardModel;
	private GameBoardController gameBoardController;
	
	public ButtonController(DiceBoardView diceBoardView, GameBoardController gameBoardController){
		this.gameBoardController = gameBoardController;
		this.diceBoardView = diceBoardView;
		this.diceBoardModel = diceBoardView.getDiceBoardModel();
		this.buttonView = new ButtonView(this, diceBoardView);
	}
	
	public ButtonView getView(){
		return this.buttonView;
	}
	
	public void roll(){
		ArrayList<DiceController> diceControllers = diceBoardModel.getDiceControllers();
		Iterator<DiceController> it = diceControllers.iterator();
		while(it.hasNext()){
			DiceController dice = it.next();
			dice.addListeners();
			dice.roll();
		}
		gameBoardController.setRollsMinusOne();
	}
	
	public void setNextPlayer(){
		buttonView.setNextPlayer();
	}
	
	public void setGameDone(){
		buttonView.gameEnd();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof ButtonRollModel){
			if(gameBoardController.rollsLeft()) {
				roll();
				if(!gameBoardController.rollsLeft()){
					ButtonRollModel button = (ButtonRollModel)e.getSource();
					button.setText("N�chster Spieler");
				}
			}
			else{
				if(!gameBoardController.getActivePlayer().isPointsSet()){
					JOptionPane.showMessageDialog(gameBoardController.getGameBoardView(), "Punkte noch nicht gesetzt!");
				}
				else{
				gameBoardController.nextPlayer();
				ButtonRollModel button = (ButtonRollModel)e.getSource();
				button.setText("Roll");
				}
			}
		}
	}
	
	
}
