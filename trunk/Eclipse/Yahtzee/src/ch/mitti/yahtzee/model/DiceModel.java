package ch.mitti.yahtzee.model;

public class DiceModel {
	private int count;
	private boolean isLocked;
	
	public DiceModel(){
		setCount();
		isLocked = false;
	}
	
	private int setCount(){
		count = ((int)(Math.random()*6)+1);
		return count;
	}
	
	public int getCount(){
		return count;
	}
	
	public boolean setLockedStatus(){
		if(!isLocked) isLocked=true;
		else isLocked = false;
		return isLocked;
	}
	
	public boolean getLockedStatus(){
		return isLocked;
	}
	
	public void resetLockedStatus(){
		isLocked = false;
	}
	
	public int roll(){
		if(!isLocked) setCount();
		return count;
	}
}
