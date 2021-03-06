package ch.mitti.tuerme;

public class Tuerme {
	
	public String anfang;
	public String hilf;
	public String ziel;
	int counter;
	
	public Tuerme(){
		counter = 0;
	}
	
	public void bewege(int hoehe, String ausgang, String hilf, String ziel){
		if(hoehe>0){
			bewege(hoehe-1,ausgang,ziel,hilf);
			transportiereScheibe(ausgang, ziel);
			bewege(hoehe-1, hilf,ausgang, ziel);
		}
	}
	
	public void transportiereScheibe(String ausgang, String ziel){
		counter++;
		System.out.println("Scheibe von "+ausgang+" zu "+ziel);
	}
	
	public int getCounter(){
		return counter;
	}
	
	
	public static void main(String[] args){
		int hoehe = 5;
		Tuerme tuerme = new Tuerme();
		tuerme.bewege(hoehe, "Anfang", "Hilf", "Ziel");
		System.out.println(tuerme.getCounter());
	}
}
