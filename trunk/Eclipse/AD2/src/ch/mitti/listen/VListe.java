package ch.mitti.listen;

public class VListe implements Liste{
	
	private Node head = null;
	
	public VListe(){
		head = null;
	}
	
	public VListe(Node head){
		this.head = head;
	}

	@Override
	public boolean insertFirst(Element x) {
		Node temp;
		temp = new Node(x);
		temp.setNext(head);
		head = temp;
		return true;
	}

	@Override
	public boolean insertLast(Element x) {
		if(head == null){
			head = new Node(x);
			return true;
		}
		Node tmp = head;
		boolean last = false;
		while(!last){
			if(tmp.getNext()==null) last = true;
			else tmp = tmp.getNext();
		}
		
		tmp.setNext(new Node(x));
		return true;
	}

	@Override
	public boolean empty() {
		if(head==null) return true;
		else return false;
	}

	@Override
	public Element getFirst() {
		if(head == null) return null;
		return head.getItem();
	}

	@Override
	public Element getLast() {
		if(head == null) return null;
		Node tmp = head;
		boolean last = false;
		while(!last){
			if(tmp.getNext()==null) last = true;
			else tmp = tmp.getNext();
		}
		
		return tmp.getItem();
	}

	@Override
	public Element search(int id) {
		Node tmp = head;
		while(tmp != null){
			if(tmp.getItem().getId() == id) return tmp.getItem();
			tmp = tmp.getNext();
		}
		return null;
	}

	@Override
	public boolean delete(int id) {
		if(head == null) return false;
		Node hilf = head;
		Node vor = hilf;
		
		while(hilf!=null && hilf.getItem().getId()!=id){
			vor = hilf;
			hilf = hilf.getNext();
		}
		if(hilf != null){
			if(hilf==head){
				head = head.getNext();
				return true;
			}
			
			else{
				vor.setNext(hilf.getNext());
				return true;
			}
		}
		
		return false;
	}

	@Override
	public void show() {
		Node tmp = head;
		while(tmp!=null){
			tmp.getItem().show();
			tmp = tmp.getNext();
		}
		
	}

	@Override
	public boolean change(int id1, int id2) {
		Node el1 = null;
		Node el2 = null;
		Node hilf = head;
		Node hilfEl1 = null;
		Node hilfEl2 = null;
		Node temp = null;
		
		if(head!=null){
			while(hilf!=null){
				if(hilf.getItem().getId()==id1) el1 = hilf;
				if(hilf.getItem().getId()==id2) el2 = hilf;
				hilf=hilf.getNext();
			}
			//wenn eines oder beide nicht vorhanden
			if(el1==null || el2 == null) return false;
			
			//...und nicht gleich head
			if(el1!=head && el2!=head){
				hilf=head;
				while(hilf!=null){
					if(hilf.getNext()==el1) hilfEl1 = hilf;
					if(hilf.getNext()==el2) hilfEl2 = hilf;
					hilf = hilf.getNext();
				}
				if(el1.getNext()!=el2 && el2.getNext()!=el1){
					//tauschen bei getrennten elementen
					hilfEl1.setNext(el2);
					hilfEl2.setNext(el1);
					temp = el2.getNext();
					el2.setNext(el1.getNext());
					el1.setNext(temp);
					return true;
				}
			}
			else if (el1==head||el2==head){
				if(el2==head) {
					temp = el2;
					el1 = el2;
					el2 = temp;
					temp = null;
				}
				hilf = head;
				while(hilf.getNext()!=el2){
					hilf = hilf.getNext();
				}
				//wenn el2 auf el1 folgt
				if(el1.getNext()==el2){
					temp = el2.getNext();
					head = el2;
					el2.setNext(el1);
					el1.setNext(temp);
					return true;
				}
				else{
					temp = el2.getNext();
					head=el2;
					el2.setNext(el1.getNext());
					hilf.setNext(el1);
					el1.setNext(temp);
					return true;
				}
			}
			}
		return false;
	}

	@Override
	public Liste sublist(int pos1, int pos2) {
		Node el1 = null;
		Node el2 = null;
		Node hilf = head;
		VListe tempListe;
		
		while(hilf!=null){
			if((hilf.getItem().getId()==pos1 || hilf.getItem().getId()==pos2) && el1==null) el1 = hilf;
			if(el1!=null && 
					hilf.getItem().getId()!=el1.getItem().getId() && 
					(hilf.getItem().getId()==pos1 || hilf.getItem().getId()==pos2)){
				el2=hilf;
			}
			if(el1!=null && el2!=null) break;
			hilf = hilf.getNext();
		}
		
		if(el1==null || el2==null) return null;
		
		Node tempHead = el1;
		Node help = tempHead;
		while(help!=el2){
			help = help.getNext();
		}
		help.setNext(null);
		tempListe = new VListe(tempHead);
		tempListe.show();
		
		return tempListe;
	}

	@Override
	public Liste searchElements(int key1, int key2) {
		// TODO Auto-generated method stub
		return null;
	}

}
