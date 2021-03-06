package ch.mitti.AchtDamen;

public class AchtDamen {
	/**
	 * @param args
	 */
	
	static int positionDamen[];
	static boolean zeilenbestetzt[];
	static boolean diagonalenObenUntenbestetzt[];
	static boolean diagonalenUntenObenbestetzt[];

	public static void main(String[] args) {
		
		boolean gefunden = false;
		int positionDamen[] = new int[8];							// Position der Damen in der i-ten Spalte
		boolean zeilenbestetzt[]= new boolean[8];					// j-te Zeile frei
		boolean diagonalenObenUntenbestetzt[] = new boolean[15];
		boolean diagonalenUntenObenbestetzt[]= new boolean[15];
		
		// initialisiere 
		for(int i=0; i<8;i++)
		{
			positionDamen[i]=-1;
			zeilenbestetzt[i] = false;
		}
		
		for(int i=0; i<15;i++)
		{
			diagonalenObenUntenbestetzt[i] = false;
			diagonalenUntenObenbestetzt[i] = false;
		}
		
		// Startbedingung festelgen
	//	positionDamen[0] = 0;
	//	zeilenbestetzt[0] = true;
	//	diagonalenObenUntenbestetzt[0]= true;
	//	diagonalenUntenObenbestetzt[0] = true;

		gefunden = findeLoesung(positionDamen,0,zeilenbestetzt,diagonalenObenUntenbestetzt,diagonalenUntenObenbestetzt);
	
		if (gefunden == true)
		{
			System.out.println("Die acht Damen k�nnen an folgenden Positionen gesetzt werden:");
			System.out.println();
			for (int k = 7; k>=0; k--)
			{
				for(int i=0; i<8;i++) {
					if (positionDamen[k] == i) System.out.print(" X ");
					else System.out.print(" - ");
				}
				System.out.println("");
			}
		}
		else System.out.println("Es gibt keinen Weg des Springers mit Startpunkt X=");		
	}
	
	private static boolean findeLoesung(
			int positionDamen[], 
			int aktuelleSpalte, 
			boolean zeilenbesetzt[],
			boolean diagonalenObenUntenbestetzt[], 
			boolean diagonalenUntenObenbestetzt[]) {
		
		
		int spaltennr, zeilennr;
		boolean ok = false;
		
		spaltennr = aktuelleSpalte;
		zeilennr = 0;
		do {
			// Teste, ob Dame an Position spaltennr / zeilenr gesetzt werden kann
			if (zeilenbesetzt[zeilennr] == false && 
					diagonalenObenUntenbestetzt[zeilennr + spaltennr] == false && 
					diagonalenUntenObenbestetzt[(zeilennr - spaltennr) + 7] == false) {
				
				positionDamen[spaltennr]=zeilennr;
				zeilenbesetzt[zeilennr] = true; 
				diagonalenObenUntenbestetzt[zeilennr + spaltennr] = true;
				diagonalenUntenObenbestetzt[(zeilennr - spaltennr) + 7] = true;
				
			//	System.out.println(spaltennr + " " + zeilennr);
				// Test ob alle Damen gesetzt
				if (spaltennr == 7)	ok = true; // L�sung gefunden
				else {
					ok = findeLoesung(positionDamen,spaltennr+1,zeilenbesetzt,diagonalenObenUntenbestetzt,diagonalenUntenObenbestetzt);
				
					if(ok == false) {
						// Mache Schritt r�ckg�ngig
						positionDamen[spaltennr]=-1;
						zeilenbesetzt[zeilennr] = false;
						diagonalenObenUntenbestetzt[zeilennr + spaltennr] = false;
						diagonalenUntenObenbestetzt[(zeilennr - spaltennr) + 7] = false;
						zeilennr++;
					}
				}
			}
			else zeilennr++;
			
		} while ((ok == false)&& (zeilennr < 8));

		return ok;
	}
}

