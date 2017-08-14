package ch.mitti.trees;

public class TreeImplwork implements Tree{
	
	private Node root=null;
	
	private int hoehe=0;
	private int anzKnoten=0;
	private double pfadlaenge = 0;
	
//-------------------------- Oeffentliche Methoden -----------------------------------------
	
	/**
	 * Element einf�gen
	 * @param e einzuf�gendes Element
	 *  @return true: Element eingef�gt
	 */
	public boolean insert(Element e)
	{
		root = insertTree(root,e);
		return true;
		
	}
	
	/**
	 * Element suchen
	 * @param id Schl�ssel des zu suchenden Elementes
	 *  @return gesuchtes Element; null : Element nicht gefunden
	 */
	public Element search(int id)
	{
		Element e = search(root, id);
		return e;
		
	}
	
	/**
	 * Element suchen (nicht rekursive Variante)
	 * @param id Schl�ssel des zu suchenden Elementes
	 *  @return gesuchtes Element; null : Element nicht gefunden
	 */
	public Element search2(int id)
	{
		Element e = search2(root, id);
		return e;
		
	}
	
	/**
	 * Element l�schen 
	 * @param id Schl�ssel des zu l�schenden Elementes
	 */
	public void delete(int id)
	{
		root = delete(root,id);
	}
	
	/**
	 * Baum ausgeben (Inorder 
	 */
	public void show()
	{
		showInorder(root);
	}
	
	/**
	 * H�he des Baums bestimmen
	 * @return H�he des Baumes
	 */
	public int height()
	{
		hoehe = 0;
		height(root,0);
		return hoehe;
	}
	
	/**
	 * Durchschnittliche Pfadl�nge des Baums bestimmen
	 * @return Durchschnittliche Pfadl�nge
	 */
	public double length()
	{
		pfadlaenge = 0;
		anzKnoten = 0;
		length(root, 0);
		return (pfadlaenge/anzKnoten);
	}
	
	
//-------------------------- Private Methoden -----------------------------------------
	
	private void showInorder(Node r)
	{
		if(r==null) return;
		showInorder(r.getLeft());
		System.out.println(r.getItem().getId() + ": " + r.getItem().getName());
		showInorder(r.getRight());	
	}
	
	private Element search(Node r, int id)
	{
		if(r==null) return null;
		if(r.getItem().getId()==id) return r.getItem();
		if(id<r.getItem().getId()) return search(r.getLeft(),id);
		else return(search(r.getRight(),id));
	}
	
	/**
	 * nicht rekursive Variante von search
	*/
	private Element search2(Node root, int id)
	{
		if(root == null) return null;
		Node tempRoot = root;
		while(true){
			if(tempRoot==null) return null;
			if(tempRoot.getItem().getId()==id) return tempRoot.getItem();
			if(id<tempRoot.getItem().getId()){
				tempRoot=tempRoot.getLeft();
			}
			else tempRoot=tempRoot.getRight();
		}
	}
	
	private Node delete(Node root, int id)
	{
		if(root==null) return null;
		if(root.getItem().getId()==id){
			if(root.getLeft()!=null && root.getRight()!=null){
				Node tempRoot = root.getRight();
				while(tempRoot.getLeft()!=null){
					tempRoot=tempRoot.getLeft();
				}
				tempRoot.setRight(root.getRight());
				return tempRoot;
			}
			if(root.getLeft()==null) return root.getRight();
			else if(root.getRight()==null) return root.getLeft();
		}
		if(id<root.getItem().getId()){
			root.setLeft(delete(root.getLeft(),id));
		}
		else {
			root.setRight(delete(root.getRight(),id));
		}
		return root;
	}
	
	private Node insertTree(Node root, Element e)
	{
		Node neu;
		if(root==null){
			neu = new Node();
			neu.setItem(e);
			root=neu;
		}
		else{
			if(root.getItem().getId()>e.getId()) root.setLeft(insertTree(root.getLeft(),e));
			else if (root.getItem().getId()<e.getId()) root.setRight(insertTree(root.getRight(),e));
		}
		return root;
	}
	

	private void height(Node root, int h)
	{
		if(root==null) return;
		int locH = h+1;
		if(locH>hoehe) hoehe=locH;
		height(root.getLeft(),locH);
		height(root.getRight(),locH);		
	}
	
	private void length(Node root, int h)
	{
		
	}

}

