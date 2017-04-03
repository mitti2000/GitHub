package ch.mitti.yahtzee.model;

import java.util.ArrayList;

public class ScoreBoardModel {
	private String[] boardData;
	
	public ScoreBoardModel(){
		boardData = new String[23];
		this.fill();
	}

	private void fill() {
		boardData[0] = " ";		
		boardData[1] = "Oberer Teil";		
		boardData[2] = "1er";		
		boardData[3] = "2er";		
		boardData[4] = "3er";		
		boardData[5] = "4er";		
		boardData[6] = "5er";	
		boardData[7] = "6er";		
		boardData[8] = "Punkte";		
		boardData[9] = "Bonus";		
		boardData[10] = "Punkte Oberer Teil";		
		boardData[11] = " ";		
		boardData[12] = "Unterer Teil";		
		boardData[13] = "3er-Pasch";		
		boardData[14] = "4er-Pasch";		
		boardData[15] = "Full House";		
		boardData[16] = "Kleine Strasse";		
		boardData[17] = "Grosse Strasse";		
		boardData[18] = "Yahtzee";		
		boardData[19] = "Chance";		
		boardData[20] = "Punkte Unterer Teil";		
		boardData[21] = " ";
		boardData[22] = "Punkte Gesamt";
	}
	
	public String getValue(int value){
		if(value<0 || value>=boardData.length){
			return "";
		}
		
		return boardData[value];
	}
	
	public int modelLength(){
		return boardData.length;
	}
}
