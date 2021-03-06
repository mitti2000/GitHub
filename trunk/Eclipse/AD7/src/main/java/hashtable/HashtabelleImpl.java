package hashtable;


public class HashtabelleImpl  implements Hashtabelle{

	/**************************************************************************
	 * ATTRIBUTE
	 **************************************************************************/

	private final int MAX = 29;
	private HashTabElement tab[] = new HashTabElement[MAX];
	
	
	/**************************************************************************
	 * PRIVATE METHODEN
	 **************************************************************************/

	/**
	 * Hashfunktion: berechnet aus dem Schl�ssel den Prom�rindex
	 * @param S Schl�ssel
	 * @return Prim�rindex 
	 */
	private int hash(String s)
	{
		int value = (s.length()*(s.charAt(0) + s.charAt(s.length()-1))) % MAX; 
		return value;
	}
	
	/**
	 * Element anhand des Schl�ssel in der Hashtabelle suchen
	 * @param id Schl�ssel des ELementes
	 * @return Position des Elementes in der Hashtabelle; -1: Element nicht gefunden
	 */
	private int suchen(String id)
	{	
		int index = hash(id);
		if(tab[index].getZustand()==HashTabElement.FREI) return -1;
		if(tab[index].getElement().getId() == id) return index;
		if(index>tab.length-1) index ++;
		else index=0;
		while(tab[index].getElement().getId()!=id && index!=hash(id)){
			index++;
			if(tab[index].getZustand()==HashTabElement.FREI) return -1;
			if(tab[index].getElement().getId() == id) return index;
		}
		return -1;
	}

	
	/**************************************************************************
	 * PUBLIC METHODEN
	 **************************************************************************/	
	
	/**
	 * Defaultkonstruktor
	 */
	public HashtabelleImpl()
	{
		for(int i=0; i<tab.length; i++){
			tab[i] = new HashTabElement();
		}
	}
	
	/**
	 * Element in der Hashtabelle einf�gen
	 * @param e einzuf�gendes Element
	 * @return true: Element wurde eingef�gt; 
	 * 		   false: Hashtabelle voll; Element nicht eingef�gt
	 */
	public boolean put(Element e)
	{
		int index = hash(e.getId());
		if(tab[index].getZustand()!= HashTabElement.BESETZT) {
			tab[index] = new HashTabElement(e,HashTabElement.BESETZT);
			return true;
		}
		while(tab[index].getZustand()==HashTabElement.BESETZT && index!=hash(e.getId())){
			if(index>tab.length-1) index ++;
			else index=0;
			if(tab[index].getZustand()!= HashTabElement.BESETZT) {
				tab[index] = new HashTabElement(e,HashTabElement.BESETZT);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Element in der Hashtabelle suchen
	 * @param id Schl�ssel des zu suchenden Elementes
	 * @return gesuchtes Element; null-> Element nicht gefunden 
	 */
	public Element get(String id)
	{
		return tab[suchen(id)].getElement();
	}
	
	/**
	 * Element in der Hashtabelle l�schen
	 * @param id Schl�ssel des zu l�schenden Elementes
	 * @return true: Element wurde gel�scht; 
	 * 		   false: Element nicht gefunden
	 */
	public boolean delete(String id)
	{
		int index = hash(id);
		if(tab[index].getZustand()==HashTabElement.FREI) return false;
		if(tab[index].getElement().getId()==id){
			tab[index].setElement(null);
			tab[index].setZustand(HashTabElement.GELOESCHT);
			return true;
		}
		if(index>tab.length-1) index ++;
		else index=0;
		while(index!=hash(id)){
			if(tab[index].getZustand()==HashTabElement.FREI) return false;
			if(tab[index].getElement().getId()==id){
				tab[index].setElement(null);
				tab[index].setZustand(HashTabElement.GELOESCHT);
				return true;
			}
		}
		return false;
	}
}
	
