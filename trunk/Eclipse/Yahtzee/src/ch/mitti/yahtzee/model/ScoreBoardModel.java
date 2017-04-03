package ch.mitti.yahtzee.model;

import java.util.ArrayList;

public class ScoreBoardModel {
	private String[] boardData;
	
	public ScoreBoardModel(){
		boardData = new String[22];
		this.fill();
	}

	private void fill() {
		boardData[0] = "Oberer Teil";		
		boardData[1] = "1er";		
		boardData[2] = "2er";		
		boardData[3] = "3er";		
		boardData[4] = "4er";		
		boardData[5] = "5er";	
		boardData[6] = "6er";		
		boardData[7] = "Punkte";		
		boardData[8] = "Bonus";		
		boardData[9] = "Punkte Oberer Teil";		
		boardData[10] = "";		
		boardData[11] = "Unterer Teil";		
		boardData[12] = "3er-Pasch";		
		boardData[13] = "4er-Pasch";		
		boardData[14] = "Full House";		
		boardData[15] = "Kleine Strasse";		
		boardData[16] = "Grosse Strasse";		
		boardData[17] = "Yahtzee";		
		boardData[18] = "Chance";		
		boardData[19] = "Punkte Unterer Teil";		
		boardData[20] = "";
		boardData[21] = "Punkte Gesamt";
	}
	
	public String getValue(int value){
		if(value<0 || value>=boardData.length){
			return "";
		}
		
		return boardData[value];
	}
}
