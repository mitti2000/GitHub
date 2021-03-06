package ch.mitti.loesungen;

public class SpringerWeg {

	/**
	 * @param args
	 */
	
	final static int deltaX[] = {2,1,-1,-2,-2,-1,1,2};
	final static int deltaY[] = {1,2,2,1,-1,-2,-2,-1};
	final static int N = 8;
	final static int MAXSPRINGERZUEGE = 8;
	
	static int anz = 0;
	
	public static void main(String[] args) {
		
		boolean gefunden = false;
		int brett[][];
		
		brett =new int[N][N];
		// initialisiere Brett
		for(int i=0; i<N;i++)
			for(int k=0;k<N;k++)
				brett[i][k]=0;
		
		int startX = 0;
		int startY = 1;
		brett[startX][startY] = 1;
		
		System.out.println("Ein Weg des Springers mit Startpunkt X="+ startX + " Y="+ startY);
		System.out.println(brett[startX][startY]);


		gefunden = findeLoesung(brett,2,startX,startY);
	
		System.out.println("Es wurden " +anz+ " Aufrufe von findeLoesung ben�tigt");
		if (gefunden == true)
		{
			System.out.println("Ein Weg des Springers mit Startpunkt X="+ startX + " Y="+ startY);
		
			for(int i=N-1; i>=0;i--)
			{
				System.out.println();
				for(int k=0;k<N;k++)
				{
					if (brett[i][k] < 10)
						System.out.print(" ");
	
					System.out.print("  "+brett[i][k]);
				}
			}
		}
		else
			System.out.println("Es gibt keinen Weg des Springers mit Startpunkt X="+ startY + " Y="+ startY);		
	}
	
	private static boolean findeLoesung(int brett[][],int schritt, int x, int y)
	{
		int newx, newy, nr;
		boolean ok = false;
		nr = -1;
		anz++;
		do {
			nr++;
			newx = x + deltaX[nr];
			newy = y + deltaY[nr];
			// Teste, ob newx/newy auf dem Schachbrett liegt
			if ((newx>=0) && (newx < N) && (newy>=0) && (newy < N))
			{
				//Teste, ob newx/newy nicht besucht wurde
				if (brett[newx][newy] == 0)
				{
					brett[newx][newy] = schritt;
				//	System.out.println(schritt);
					// Test ob alle Felder besucht wurden
					if (schritt < N*N)
					{
						ok = findeLoesung(brett,schritt+1,newx,newy);
						if(ok == false)
						{
							// Mache Schritt r�ckg�ngig
							brett[newx][newy] = 0;
						}
					}
					else
						ok = true;
					
				}
			}
		} while ((ok == false)&& (nr < MAXSPRINGERZUEGE-1));
		return ok;
	}
}
