package ch.mitti.methoden_polymorphie;

public class Operation {
	protected double result;
	protected double term1;
	protected double term2;
	
	public Operation(){
		
	}
	
	public double getResult(){
		return result;
	}
	
	public void setTerm1(double term){
		this.term1 = term;
	}
	
	public void setTerm2(double term){
		this.term2 = term;
	}
	
	public void doOperation(){
		
	}
}