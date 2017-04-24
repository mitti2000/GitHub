package ch.mitti.junit;

public class Bankkonto {
	private String besitzer;
	private double kontostand;
	
	//manipuliert
	//manipuliert 2
	//manipuliert 3


	
	public Bankkonto(String besitzer, double betrag){
		this.besitzer = besitzer;
		this.kontostand = betrag;
	}

	public String gibBesitzer() {
		return this.besitzer;
	}

	public double gibKontostand() {
		return this.kontostand;
	}
}
