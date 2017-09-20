package ch.mitti.sorting;

public class ShellSort implements Isorter {

	@Override
	public void sort(int[] z)
	{
		int[] schrittweite = new int[20];
		int s; //Schrittweite
		int q; //
		int tmp; 
		int index; 
		int ms;
	
		// Schrittweiten berechnen 
		schrittweite[0] = 1;
		for (int i = 1; i<schrittweite.length;i++){
			schrittweite[i] = 3 * schrittweite[i-1] + 1;
		}
		
		// Bestimmen der grössten Schrittweite (mindestens 50 Elemente pro Teilarray)
		for(ms=9; (ms>=0) && schrittweite[ms] > (z.length/50); ms--);
		
		for (int n=ms; n >=0; n--)
		{
			s = schrittweite[n];
			
			for(int a=0;a<s; a++){ //schrittweite mal durchlaufen
				
				for(int b=a; b<z.length-s+1; b=b+s){ //jedes zwischenarray durchlaufen
					int hilf = z[b];
					int j;
					
					for(j=b; (j>=1) && (hilf < z[j-1]);j--){
						z[j] = z[j-1];
					}
					z[j] = hilf;
				}
			}
			
		}
	}
}
