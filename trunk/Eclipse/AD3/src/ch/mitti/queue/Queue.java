package ch.mitti.queue;


public interface Queue {
	/**
	 * Legt ein Objekt in der Queue ab
	 */
	public boolean enq(Element obj);
	
	
	/**
	 * Holt das n�chste Element aus der Queue ab 
	 */
	public Element deq();
	
	/**
	 * liefert true, falls die Queue leer ist
	 */
	public boolean empty();

}
