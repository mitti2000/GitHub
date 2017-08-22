package ch.mitti.MathLight;

public class MathOperations {
	
	public int addiere(int a, int b){
		return (a+b);
	}
	
	public int subtrahiere(int a, int b){
		return (a-b);
	}
	
	public int multipliziere(int a, int b){
		return (a*b);
	}
	
	public double dividiere(int a, int b){
		int result = 0;
		if(b == 0) throw new IllegalArgumentException();
		else result = (a / b);
		return result;
	}
	
}
