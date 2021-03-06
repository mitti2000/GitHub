package ch.mitti.yahtzee.model;

public class PlayerModel {
	private int[] scores;
	private int[] isSet;
	
	private int punkte;
	private int upperScore;
	private int lowerScore;
	private int totalScore;
	
	private boolean bonus;
	
	private String name;
	
	private boolean activePlayer;
	
	private boolean pointsSet;
	
	private boolean isAllSet;
	
	private boolean isDone;
	
	

	public PlayerModel(String name, boolean activePlayer){
		this.name = name;
		this.activePlayer = activePlayer;
		scores = new int[23];
		isSet = new int[23];
		punkte = 0;
		upperScore = 0;
		lowerScore = 0;
		totalScore = 0;
		bonus = false;
		pointsSet = false;
		isAllSet = false;
		isDone = false;
		
		init();
	}
	
	public void init(){
		for(int i=0; i<scores.length;i++){
				scores[i]=0;
				isSet[i]=0;
		}
	}
	
	public void setScore(int index, int score){
		scores[index] = score;
		isSet[index] = 1;
		setPunkte();
		setBonus();
		setUpperScore();
		setLowerScore();
		setTotalScore();
	}
	
	public int getScore(int index){
		return scores[index];
	}
	
	public int[] getScores() {
		return scores;
	}

	public void setScores(int[] scores) {
		this.scores = scores;
	}

	public int[] getIsSet() {
		return isSet;
	}

	public void setIsSet(int[] isSet) {
		this.isSet = isSet;
	}

	public boolean isAllSet() {
		int counter = 0;
		for(int i=0; i<isSet.length; i++){
			if(isSet[i]==1) counter++;
		}
		
		if(counter>13)return true;
		return false;
	}

	public void setAllSet(boolean isAllSet) {
		this.isAllSet = isAllSet;
	}

	private void setBonus(){
		if(punkte>=63) bonus = true;
	}
	
	private void setPunkte(){
		int tempScore =0;
		for(int i=0; i<8; i++){
			tempScore += scores[i];
		}
		this.punkte = tempScore;
	}
	
	private void setUpperScore() {
		if(bonus) upperScore = punkte + 35;
		else upperScore = punkte;
	}

	private void setLowerScore() {
		int tempScore =0;
		for(int i=12; i<20; i++){
			tempScore += scores[i];
		}
		this.lowerScore = tempScore;
	}

	public boolean isPointsSet() {
		return pointsSet;
	}

	public void setPointsSet(boolean pointsSet) {
		this.pointsSet = pointsSet;
	}

	public boolean isActivePlayer() {
		return activePlayer;
	}

	public void setActivePlayer(boolean activePlayer) {
		this.activePlayer = activePlayer;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getUpperScore() {
		return upperScore;
	}

	public int getLowerScore() {
		return lowerScore;
	}

	public int getTotalScore() {
		return totalScore;
	}

	private void setTotalScore() {
		this.totalScore = upperScore + lowerScore;
	}

	public boolean isBonus() {
		return bonus;
	}
	
	public boolean isDone(){
		return isDone;
	}
	
	public void setIsDone(boolean isDone){
		this.isDone = isDone;
	}
	
	public int getPoints(){
		return punkte;
	}
	
	public boolean getBonus(){
		return bonus;
	}
	
	
}
