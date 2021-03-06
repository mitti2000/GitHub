package ch.mitti.listen;

public class DVNode {
	private Element item = null;
	private DVNode next = null;
	private DVNode prev = null;
	
	/**
	 * Default Konstruktor
	 */
	public DVNode()
	{
		item = null;
		next = null;
		prev = null;
	}
	
	public DVNode(Element x)
	{
		item = x;
		next = null;
	}
	
	public DVNode getNext()
	{
		return this.next;
	}
	
	public DVNode getPrev(){
		return this.prev;
	}
	
	public void setNext(DVNode newNext)
	{
		this.next = newNext;
	}
	
	public void setPrev(DVNode newPrev){
		this.prev = newPrev;
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
