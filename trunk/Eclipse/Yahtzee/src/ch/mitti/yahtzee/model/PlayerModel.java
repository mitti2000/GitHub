package ch.mitti.yahtzee.model;

public class PlayerModel {
	private int ones;
	private int twos;
	private int threes;
	private int fours;
	private int fives;
	private int sixes;
	private int threeCombo;
	private int fourCombo;
	private int fullHouse;
	private int smallStraight;
	private int bigStraight;
	private int yahtzee;
	private int chance;
	
	private int upperScore;
	private int lowerScore;
	private int totalScore;
	
	private boolean bonus;
	
	private String name;
	
	public PlayerModel(String name){
		this.name = name;
		ones = 0;
		twos = 0;
		threes = 0;
		fours = 0;
		fives = 0;
		sixes = 0;
		threeCombo = 0;
		fourCombo = 0;
		fullHouse = 0;
		smallStraight = 0;
		bigStraight = 0;
		yahtzee = 0;
		chance = 0;
		upperScore = 0;
		lowerScore = 0;
		totalScore = 0;
		bonus = false;
	}	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getOnes() {
		return ones;
	}

	public void setOnes(int ones) {
		this.ones = ones;
	}

	public int getTwos() {
		return twos;
	}

	public void setTwos(int twos) {
		this.twos = twos;
	}

	public int getThrees() {
		return threes;
	}

	public void setThrees(int threes) {
		this.threes = threes;
	}

	public int getFours() {
		return fours;
	}

	public void setFours(int fours) {
		this.fours = fours;
	}

	public int getFives() {
		return fives;
	}

	public void setFives(int fives) {
		this.fives = fives;
	}

	public int getSixes() {
		return sixes;
	}

	public void setSixes(int sixes) {
		this.sixes = sixes;
	}

	public int getThreeCombo() {
		return threeCombo;
	}

	public void setThreeCombo(int threeCombo) {
		this.threeCombo = threeCombo;
	}

	public int getFourCombo() {
		return fourCombo;
	}

	public void setFourCombo(int fourCombo) {
		this.fourCombo = fourCombo;
	}

	public int getFullHouse() {
		return fullHouse;
	}

	public void setFullHouse(int fullHouse) {
		this.fullHouse = fullHouse;
	}

	public int getSmallStraight() {
		return smallStraight;
	}

	public void setSmallStraight(int smallStraight) {
		this.smallStraight = smallStraight;
	}

	public int getBigStraight() {
		return bigStraight;
	}

	public void setBigStraight(int bigStraight) {
		this.bigStraight = bigStraight;
	}

	public int getYahtzee() {
		return yahtzee;
	}

	public void setYahtzee(int yahtzee) {
		this.yahtzee = yahtzee;
	}

	public int getChance() {
		return chance;
	}

	public void setChance(int chance) {
		this.chance = chance;
	}

	public int getUpperScore() {
		return upperScore;
	}

	public void setUpperScore(int upperScore) {
		this.upperScore = upperScore;
	}

	public int getLowerScore() {
		return lowerScore;
	}

	public void setLowerScore(int lowerScore) {
		this.lowerScore = lowerScore;
	}

	public int getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

	public boolean isBonus() {
		return bonus;
	}

	public void setBonus(boolean bonus) {
		this.bonus = bonus;
	}
	
	
}
