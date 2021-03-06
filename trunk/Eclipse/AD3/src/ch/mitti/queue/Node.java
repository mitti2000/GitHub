package ch.mitti.queue;


/**
 * 
 * @author Marcel Egloff
 * @version 1.0
 *
 * 
 */
public class Node {
	
	private Element item = null;
	private Node next = null;
	
	/**
	 * Default Konstruktor
	 */
	public Node()
	{
		item = null;
		next = null;
	}
	
	public Node getNext()
	{
		return this.next;
	}
	
	public void setNext(Node newNext)
	{
		this.next = newNext;
	}
	
	public Element getItem()
	{
		return this.item;
	}
	
	public void setItem(Element newItem)
	{
		this.item = newItem;
	}
	
	public void show()
	{
		item.show();
	}
}
