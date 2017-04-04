package ch.mitti.exceptions;

public class ArrayAccessException extends Exception{
	private static int counter = 0;
	
	public ArrayAccessException(String message){
		super(message);
		counter++;
	}
	
	public int getExceptionCount(){
		return counter;
	}
}