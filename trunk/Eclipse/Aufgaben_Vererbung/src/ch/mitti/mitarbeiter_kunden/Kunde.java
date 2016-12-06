package ch.mitti.mitarbeiter_kunden;

public class Kunde extends Person{
	private int kundennummer;
	private char kundentyp;
	public Kunde(String vorname, String nachname, int alter, int kundennummer, char kundentyp) {
		super(vorname, nachname, alter);
		this.kundennummer = kundennummer;
		if(kundentyp>60||kundentyp<70) this.kundentyp = kundentyp;
		else kundentyp = 48;
	}
	public Kunde(String vorname, String nachname, int kundennummer, char kundentyp) {
		super(vorname, nachname);
		this.kundennummer = kundennummer;
		this.kundentyp = kundentyp;
	}
	public int getKundennummer() {
		return kundennummer;
	}
	public void setKundennummer(int kundennummer) {
		this.kundennummer = kundennummer;
	}
	public char getKundentyp() {
		return kundentyp;
	}
	public void setKundentyp(char kundentyp) {
		if(kundentyp>60||kundentyp<70) this.kundentyp = kundentyp;
		else kundentyp = 48;
	}
	
	public String datenAusgeben(){
		return (super.datenAusgeben()+"\nKundennummer: "+kundennummer+"\nKundentyp: "+kundentyp);
		}
	
	
}
