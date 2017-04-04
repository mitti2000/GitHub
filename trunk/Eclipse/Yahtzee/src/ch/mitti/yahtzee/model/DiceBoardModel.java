package ch.mitti.yahtzee.model;

import java.util.ArrayList;

import ch.mitti.yahtzee.controller.DiceController;

public class DiceBoardModel {
	private ArrayList<DiceController> dice;
	
	public DiceBoardModel(){
		dice = new ArrayList<DiceController>();
		init();
	}
	
	public void init(){
		for(int i=0; i<5;i++){
			dice.add(new DiceController());
		}
	}
	
	public int getPoints(){
		int points = 0;
		
		return points;
	}
	
	public ArrayList<DiceController> getDiceControllers(){
		return dice;
	}
}