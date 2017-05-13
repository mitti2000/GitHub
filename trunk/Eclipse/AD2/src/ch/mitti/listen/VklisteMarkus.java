package ch.mitti.listen;

public class VklisteMarkus implements Liste {
	
	private Node head;
	
	public VklisteMarkus () {
		head = null;
	}

	@Override
	public boolean insertFirst(Element x) {
		if (x != null) {
			Node temp;
			temp = new Node(x);
			if (head == null) {
				head = temp;
				return true;
			} else {
				temp.setNext(head);
				head = temp;
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean insertLast(Element x) {
		if (x != null) {
			Node temp;
			temp = new Node(x);
			if (head == null) {
				head = temp;
				return true;
			} else {
				Node hilf = head;
				while(hilf.getNext() != null) {
					hilf = hilf.getNext();
				}
				hilf.setNext(temp);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean empty() {
		if(head==null) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public Element getFirst() {
		if(head!=null) {
			return head.getItem();
		}
		return null;
	}

	@Override
	public Element getLast() {
		if (head != null) {
			Node hilf = head;
			while(hilf.getNext() != null) {
				hilf = hilf.getNext();
			}
			return hilf.getItem();
		}
		return null;
	}

	@Override
	public Element search(int id) {
		Element temp = null;
		if(head!=null) {
			Node hilf = head;
			while(hilf.getNext() != null && hilf.getItem().getId() == id) {
					temp = hilf.getItem();
					}
		}
		return temp;
	}

	@Override	
	public boolean delete(int id) {
	if(head!=null) {
			Node vor = null; 
			Node hilf = head;
			while (hilf != null && hilf.getItem().getId() == id) {
				vor = hilf;
				hilf = hilf.getNext(); 
			}
			if (hilf != null) {
				if (vor != null) {
					vor.setNext(hilf.getNext());
					return true;
				}
				else {
					
				}
				head = hilf.getNext();
				return true;
			}
		}
		return false;
	}

	@Override
	public void show() {
		if(head !=null) {
			Node hilf = head;
			while(hilf.getNext() != null) {
				hilf.show();
			}
		}
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