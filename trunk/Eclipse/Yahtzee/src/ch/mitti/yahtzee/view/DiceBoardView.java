package ch.mitti.yahtzee.view;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ch.mitti.yahtzee.controller.DiceBoardController;
import ch.mitti.yahtzee.controller.DiceBoardMouseListener;
import ch.mitti.yahtzee.controller.DiceController;
import ch.mitti.yahtzee.model.DiceBoardModel;

public class DiceBoardView extends JPanel {
	
	private DiceBoardModel diceBoardModel;
	ArrayList<DiceController> diceControllers;
	private DiceBoardController diceBoardController;
	private GameBoardView gameBoardView;
	
	public DiceBoardView(GameBoardView gameBoardView){
		this.gameBoardView = gameBoardView;
		diceBoardModel = new DiceBoardModel();
		diceControllers = diceBoardModel.getDiceControllers();
		diceBoardController = new DiceBoardController(gameBoardView);
		init();
	}
	
	private void init(){
		
		
		
		//Create Grid Layout
		this.setLayout(new GridLayout(5,1,20,20));
		this.setBackground(Color.CYAN);
		
		Iterator<DiceController> it = diceControllers.iterator();
		
		while(it.hasNext()){
			DiceController controller = it.next();
			this.add(controller.getView());
		}
	}
	
	public DiceBoardModel getDiceBoardModel(){
		return diceBoardModel;
	}
	
	public void resetDice(){
		Iterator<DiceController> it = diceControllers.iterator();
		
		while(it.hasNext()){
			DiceController controller = it.next();
			controller.resetColor();
			controller.resetLockedStatus();
			controller.resetDice();
		}
	}
}

