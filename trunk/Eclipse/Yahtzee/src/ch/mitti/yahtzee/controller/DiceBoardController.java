package ch.mitti.yahtzee.controller;

import java.util.ArrayList;

import ch.mitti.yahtzee.view.DiceBoardView;
import ch.mitti.yahtzee.view.GameBoardView;

public class DiceBoardController {
	public DiceBoardView diceBoardView;
	public GameBoardView gameBoardView;
	
	public DiceBoardController(GameBoardView gameBoardView){
		this.gameBoardView = gameBoardView;
		diceBoardView = gameBoardView.getDiceBoardView();
	}
	
	public int getPoints(int index){
		int points = 0;
		ArrayList<DiceController> diceControllers = diceBoardView.getDiceBoardModel().getDiceControllers();
		
		switch(index){
		
		//Zahlen
		//1er - 6er
		case 2:
		case 3:
		case 4:
		case 5:
		case 6:
		case 7:
			System.out.println(index-1);
			break;
		
		//Pasche 3er und 4er
		case 13:
		case 14:
			System.out.println((index-10) + "er Pasch");
			break;
			
		//Full House
		case 15:
			System.out.println("FullHouse");
			break;
		
		//Strasse
		case 16:
		case 17:
			System.out.println("Strasse");
			break;
		
		//Yahtzee
		case 18:
			System.out.println("Yahtzee");
			break;
		
		//Chance
		case 19:
			System.out.println("Chance");
			break;
		
		default:
			System.out.println("Fehler");
			break;
		
		
		}
		
		
		return points;
	}
}