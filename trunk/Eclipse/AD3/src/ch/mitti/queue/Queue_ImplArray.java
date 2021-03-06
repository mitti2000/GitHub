package ch.mitti.queue;

public class Queue_ImplArray implements Queue {
	
	private final static int MAX = 10;
	private int head;
	private int tail;
	private Element[] elements;
	
	public Queue_ImplArray() {
		elements = new Element[MAX];
		head=0;
		tail = head+1;
	}

	@Override
	public boolean enq(Element obj) {
		if(obj!=null && tail%(MAX)!= head%MAX){
			elements[tail-1] = obj;
			tail++;
			return true;
		}
		return false;
	}

	@Override
	public Element deq() {
		Element tmp = elements[head];
		elements[head] = null;
		if((head+1)%MAX != tail%MAX) head++;
		return tmp;
	}

	@Override
	public boolean empty() {
		if((head+1)%MAX == tail%MAX && elements[head]==null) return true;
		return false;
	}

}
