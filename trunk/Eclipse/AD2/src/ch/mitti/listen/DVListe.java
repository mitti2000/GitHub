package ch.mitti.listen;

public class DVListe implements Liste {
	
	private DVNode head = null;
	
	public DVListe(){
		head = null;
	}

	@Override
	public boolean insertFirst(Element x) {
		if(head==null) {
			head = new DVNode(x);
			return true;
		}
		else{
			DVNode temp = head.getNext();
			head = new DVNode(x);
			temp.setPrev(head);
			head.setNext(temp);
			return true;
		}
	}

	@Override
	public boolean insertLast(Element x) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean empty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Element getFirst() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Element getLast() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Element search(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean change(int id1, int id2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Liste sublist(int pos1, int pos2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Liste searchElements(int key1, int key2) {
		// TODO Auto-generated method stub
		return null;
	}

}
