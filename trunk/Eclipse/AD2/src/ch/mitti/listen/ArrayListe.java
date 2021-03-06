package ch.mitti.listen;

public class ArrayListe implements Liste{
	
	private Element liste[];
	private int anzEl = 0;
	private final int MAXEL = 20;
	
	public ArrayListe(){
		liste = new Element[MAXEL];
		anzEl = 0;
	}
	
	public ArrayListe(Element[] tempListe){
		liste = tempListe;
		anzEl = tempListe.length;
	}

	@Override
	public boolean insertFirst(Element x) {
		if(anzEl==0){
			liste[0]=x;
			anzEl++;
			return true;
		}
		
		else if(anzEl<MAXEL){
			for(int i=anzEl; i>0; i--){
				liste[i] = liste[i-1];
			}
			liste[0] = x;
			anzEl++;
			return true;
		}
		return false;
	}

	@Override
	public boolean insertLast(Element x) {
		if(anzEl<MAXEL){
			liste[anzEl] = x;
			anzEl++;
			return true;
		}
		return false;
	}

	@Override
	public boolean empty() {
		if(anzEl==0) return true;
		return false;
	}

	@Override
	public Element getFirst() {
		return liste[0];
	}

	@Override
	public Element getLast() {
		if(anzEl==0) return null;
		return liste[anzEl-1];
	}

	@Override
	public Element search(int id) {
		for(int i=0; i<anzEl; i++){
			if(liste[i].getId()==id) return liste[i];
		}
		return null;
	}

	@Override
	public boolean delete(int id) {
		for(int i=0; i<anzEl; i++){
			if(liste[i].getId()==id){
				for(int j=i;j<anzEl-1;j++){
					liste[j]=liste[j+1];
				}
				liste[anzEl-1] = null;
				anzEl--;
				return true;
			}
		}
		return false;
	}

	@Override
	public void show() {
		for(int i=0; i<anzEl;i++){
			System.out.println(i + ": " + liste[i].getId() + "/" + liste[i].getName());
		}
	}

	@Override
	public boolean change(int id1, int id2) {
		Element temp = null;
		Element temp2 = null;
		int tempIndex = 0;
		
		for(int i=0; i<anzEl; i++){
			if(liste[i].getId()==id1){
				tempIndex = i;
				temp = liste[i];
				break;
			}
			else temp = null;
		}
		
		if(temp == null) return false;
		
		for(int i=0; i<anzEl; i++){
			if(liste[i].getId()==id2){
				temp2 = liste[i];
				liste[i] = temp;
				liste[tempIndex] = temp2;				
				break;
			}
		}
		return false;
	}

	@Override
	public ArrayListe sublist(int pos1, int pos2) {
		if(pos1>=anzEl || pos2>=anzEl) return null;
		
		if(pos1>pos2){
			int temp = pos1;
			pos2=pos1;
			pos2=temp;
		}
		
		Element[] tempListe = new Element[pos2-pos1+1];
		int counter = 0;
		for(int i=pos1; i<=pos2; i++){
			tempListe[counter] = liste[i];
			counter++;
		}
		return new ArrayListe(tempListe);
	}

	@Override
	public Liste searchElements(int key1, int key2) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void output(String message){
		for(int i=0; i<liste.length;i++){
			System.out.print(message + ":" + liste[i].getId() + "/" + liste[i].getName());
			System.out.println("");
		}
		System.out.println("******************");
	}

}
