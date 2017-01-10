package ch.mitti.tierweltauto;

public abstract class Lebewesen implements Hoerbar{
	boolean lebt;
	
	public Lebewesen(){
		lebt = true;
	}
	
	public boolean gibLebt(){
		return lebt;
	}
	

}
