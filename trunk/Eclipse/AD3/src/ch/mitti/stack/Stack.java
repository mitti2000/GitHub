package ch.mitti.stack;

public interface Stack {
	
	/**
	 * Legt ein Objekt auf dem Stack ab
	 */
	public boolean  push(Element obj);
	
	/**
	 * Gibt das oberste Element zur�ck und entfernt dieses
	 */
	public Element pop();
	
	/**
	 * Gibt das oberste Element zur�ck 
	 */
	public Element top();
	
	/**
	 * liefert true, falls der Stack leer ist
	 */
	public boolean empty();

}