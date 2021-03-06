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
			for(DiceController diceController : diceControllers){
				if(diceController.getDiceCount()==index-1) points += diceController.getDiceCount();
			}
			break;
		
		//Pasche 3er und 4er
		case 13:
		case 14:
			int comparePasch = index-10;
			int countPasch = 0;
			ArrayList<Integer> sortedPasch = sortArray(diceControllers);
			for(int j=1;j<7;j++){
				for(int number : sortedPasch){
					if(number==j) countPasch++;
				}
				if(countPasch>=comparePasch) {
					points = countPasch*j;
					break;
				}
				else countPasch = 0;
			}
			
			break;
			
		//Full House
		case 15:
			ArrayList<Integer> sortedFullHouse = sortArray(diceControllers);
			
			//TEST
			/*
			ArrayList<Integer> sortedFullHouse = new ArrayList<Integer>();
			sortedFullHouse.add(2);
			sortedFullHouse.add(2);
			sortedFullHouse.add(4);
			sortedFullHouse.add(5);
			sortedFullHouse.add(5);
			*/
			//End Test
			
			int compareFullHouse = 0;
			int compareMultiplier = 0;
			int countFullHouse = 0;
						
			for(int k=1;k<7;k++){
				for(int number : sortedFullHouse){
					if(number==k) countFullHouse++;
				}
				if((countFullHouse==2 || countFullHouse==3)){
					compareFullHouse = countFullHouse;
					compareMultiplier = k;
					countFullHouse = 0;
					break;
				}
			}
			
			System.out.println("Compare Mulitplier:" + compareMultiplier);
			System.out.println("Compare Full House" + compareFullHouse);
			
			for(int k=1;k<7;k++){
				for(int number : sortedFullHouse){
					if(number==k && compareMultiplier != k) countFullHouse++;
				}
				
				if((countFullHouse==2 || countFullHouse==3) && countFullHouse!=compareFullHouse){
					//points = (compareFullHouse * compareMultiplier) + (countFullHouse * k);
					points = 25;
				}
				countFullHouse = 0;
			}
			
			break;
		
		//Straight
		case 16:
		case 17:
			ArrayList<Integer> sortedStraight = sortArray(diceControllers);
			
			//TEST
			/*
			ArrayList<Integer> sortedStraight = new ArrayList<Integer>();
			sortedStraight.add(1);
			sortedStraight.add(2);
			sortedStraight.add(3);
			sortedStraight.add(4);
			sortedStraight.add(5);
			*/
			//End Test
			 
			
			boolean straight = false;
			int straightCount = 0;
			boolean isFirst = true;
			int first = 0;
			for(int i=sortedStraight.size()-1; i>0;i--){
				if(sortedStraight.get(i-1)+1==sortedStraight.get(i)){
					if(isFirst){
						first=sortedStraight.get(i);
						isFirst = false;
					}
					straight = true;
					straightCount++;
				}
				else straight = false;
			}
			if(index==16 && straightCount>2){
				points = 30;
			}
			else if(index==17 && straightCount >3){
				points = 40;
			}
			break;
		
		//Yahtzee
		case 18:
			ArrayList<Integer> sortedYahtzee = sortArray(diceControllers);
			
			//TEST
			/*
			ArrayList<Integer> sortedYahtzee = new ArrayList<Integer>();
			sortedYahtzee.add(5);
			sortedYahtzee.add(5);
			sortedYahtzee.add(5);
			sortedYahtzee.add(5);
			sortedYahtzee.add(5);
			*/
			//End Test
			
			int yahtzeeCount = 0;
			for(int i=1;i<7;i++){
				for(int j=0;j<sortedYahtzee.size();j++){
					if(sortedYahtzee.get(j)==i){
						yahtzeeCount++;
					}
				}
				if(yahtzeeCount==5) break;
				else yahtzeeCount = 0;
			}
			System.out.println(yahtzeeCount);
			if(yahtzeeCount==5){
				points = 50;
			}
			
			System.out.println(points);
			break;
		
		//Chance
		case 19:
			ArrayList<Integer> sortedChance = sortArray(diceControllers);
			int chanceCount = 0;
			for(int i : sortedChance){
				chanceCount+=i;
			}
			
			points = chanceCount;
			
			System.out.println(points);
			break;
		
		default:
			System.out.println("Fehler");
			break;
		
		
		}
		
		
		return points;
	}
	
	private ArrayList<Integer> sortArray(ArrayList<DiceController> unsorted){
		ArrayList<Integer> sorted = new ArrayList<Integer>();
		ArrayList<DiceController> diceControllers = unsorted;
		for(DiceController diceController : diceControllers){
			sorted.add(diceController.getDiceCount());
		}
		boolean isSorted = false;
		int temp =0;
		while(!isSorted){
			isSorted = true;
			for(int i=0; i<sorted.size()-1; i++){
				if(sorted.get(i)>sorted.get(i+1)){
					temp=sorted.get(i);
					sorted.set(i, sorted.get(i+1));
					sorted.set(i+1, temp);
					isSorted = false;
				}
			}
		}
		
		return sorted;
	}
}
