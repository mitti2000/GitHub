package ch.mitti.backtracking;

public class SpringerWegWork {

	/**
	 * @param args
	 */
	
	final static int deltaX[] = {2,1,-1,-2,-2,-1,1,2};
	final static int deltaY[] = {1,2,2,1,-1,-2,-2,-1};
	final static int N = 8;
	final static int MAXSPRINGERZUEGE = 8;
	
	public static void main(String[] args) {
		
		boolean gefunden = false;
		int brett[][];
		
		brett =new int[N][N];
		// initialisiere Brett
		for(int i=0; i<N;i++)
			for(int k=0;k<N;k++)
				brett[i][k]=0;
		
		int startX = 0;
		int startY = 0;
		brett[startX][startY] = 1;

		gefunden = findeLoesung(brett,2,startX,startY);
	
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
			System.out.println("Es gibt keinen Weg des Springers mit Startpunkt X="+ startX + " Y="+ startY);		
	}
	
	private static boolean findeLoesung(int brett[][],int schritt, int x, int y)
	{
		boolean ok = false;
		int newX;
		int newY;
		int zuege;
		zuege = -1;
		
		do{
			zuege++;
			newX = x + deltaX[zuege];
			newY = y + deltaY[zuege];
			
			if((newX>=0) && (newX<N) && (newY>=0) && (newY<N))
			{				//ist newPos auf Feld
				if(brett[newX][newY]==0)
				{									//ist newPos leer...
					brett[newX][newY]=schritt;									//dann den Schritt erh�hen
					if(schritt < N*N)
					{												//solange Schritt kleine max ist
						ok = findeLoesung(brett,schritt+1,newX, newY);				//den n�chsten Schritt probieren
						if(ok == false ) 
						{
							brett[newX][newY] = 0;								//wenn fehlschl�gt zur�ck
						}
					}
					else ok = true;
				}
			}
		} while((ok == false) && (zuege< MAXSPRINGERZUEGE-1));
		return ok;
	}
}
