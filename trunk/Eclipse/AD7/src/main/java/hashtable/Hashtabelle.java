package hashtable;

public interface Hashtabelle {
	
	/**
	 * Element in der Hashtabelle einf�gen
	 * @param e einzuf�gendes Element
	 * @return true: Element wurde eingef�gt; 
	 * 		   false: Hashtabelle voll; Element nicht eingef�gt
	 */
	public boolean put(Element e);
	
	
	/**
	 * Element in der Hashtabelle suchen
	 * @param id Schl�ssel des zu suchenden Elementes
	 * @return gesuchtes Element; null-> Element nicht gefunden 
	 */
	public Element get(String id);
	
	
	/**
	 * Element in der Hashtabelle l�schen
	 * @param id Schl�ssel des zu l�schenden Elementes
	 * @return true: Element wurde gel�scht; 
	 * 		   false: Element nicht gefunden
	 */
	public boolean delete(String id);

}
