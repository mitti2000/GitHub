package ch.mitti.trees;


public class Node {

	/**
	 * 
	 * @author Marcel Egloff
	 * @version 1.0
	 *
	 * 
	 */
	
		
	private Element item = null;
	private Node left = null;
	private Node right = null;
		
	/**
	 * Default Konstruktor
	*/
	public Node()
	{
		item = null;
		left = null;
		right = null;
	
	}
		
	public Node getLeft()
	{
		return this.left;
	}
	
	public Node getRight()
	{
		return this.right;
	}
		
	public void setLeft(Node newLeft)
	{
		this.left = newLeft;
	}
	
	public void setRight(Node newRight)
	{
		this.right = newRight;
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

