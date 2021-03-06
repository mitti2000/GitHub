package ch.mitti.exceptions;

import java.util.Random;
import java.util.Scanner;

public class ArrayException {
	private Integer[] data;
	private Random r;
	
	public ArrayException(){
		this.data = new Integer[20];
		this.r = new Random();
	}
	
	public void datenFuellen(){
		for(int c=0; c<data.length; c++){
			data[c] = r.nextInt(100);
		}
	}
	
	public Integer gibWertAnPosition(int position) throws ArrayAccessException{
		if(position<0 || position>= data.length){
			//Exception Handling 
			//ungepr�ft da erbt von RuntimeExceptions
			throw new ArrayAccessException("Zugriff auf "+position+" nicht erlaubt");
		}
		return data[position];
	}
	
	public static void main (String[] args){
		ArrayException ae = new ArrayException();
		ae.datenFuellen();
		Scanner sc = new Scanner(System.in);
		
		while(true){
			System.out.print("Position einngeben: ");
			int wert = sc.nextInt();
			try {
				System.out.println(ae.gibWertAnPosition(wert));
			} catch (ArrayAccessException e) {
				System.out.println(e.getMessage());
				System.out.println(e.getExceptionCount());
			}
		}
	}
}
