package ch.mitti.sorting;
	/**
	* 
	* @author Marcel Egloff
	* @version 1.0
	* Sortieren mit Shellsort
	* 
	*/
public class ShellSortWork implements Isorter {
	
	public void sort(int[] z)
	{
		int[] schrittweite = new int[20];
		int s, q, tmp, sindex, ms;
		int[] temp = z;
	
		// Schrittweiten berechnen 
		schrittweite[0] = 1;
		for (int i = 1; i<20;i++)
			schrittweite[i] = 3 * schrittweite[i-1] + 1;
		
		// Bestimmen der grössten Schrittweite (mindestens 50 Elemente pro Teilarray)
		
		for(ms=9; (ms>=0) && schrittweite[ms] > (z.length/50); ms--)
			;
			
		
//		System.out.println("Schrittweite="+schrittweite[ms]);
		
		for (int n=ms; n >=0; n--)
		{
			s = schrittweite[n];
		
			
		
			
		}
	}
}
