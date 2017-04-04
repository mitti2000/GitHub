package ch.mitti.yahtzee.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import ch.mitti.yahtzee.model.DiceModel;
import ch.mitti.yahtzee.view.DiceView;
import ch.mitti.yahtzee.view.GameBoardView;

public class DiceController extends MouseAdapter{
	private DiceModel diceModel;
	private DiceView diceView;
	
	public DiceController(){
		diceModel = new DiceModel();
		diceView = new DiceView(diceModel.getCount(), GameBoardView.WINDOW_SIZE/13);
		diceView.addMouseListener(this);
	}
	
	public DiceView getView(){
		return diceView;
	}
	
	public void roll(){
		int count = diceModel.roll();
		diceView.setValue(count);
	}
	
	public void resetColor(){
		this.diceView.resetBackgroundColor();
	}
	
	
	
	@Override
	public void mouseClicked(MouseEvent e){
		this.diceView.switchBackgroundColor();
		this.diceModel.setLockedStatus();
	}
	
}