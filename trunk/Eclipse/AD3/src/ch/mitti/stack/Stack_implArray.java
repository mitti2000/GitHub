package ch.mitti.stack;

public class Stack_implArray implements Stack {
	
	private final int MAX=10;
	private Element[] stack;
	private int stackptr;
	
	public Stack_implArray() {
		stack = new Element[MAX];
		stackptr = 0;
	}

	@Override
	public boolean push(Element obj) {
		if(obj!=null){
			stack[stackptr] = obj;
			if(stackptr<=MAX-1) stackptr++;
			return true;
		}
		return false;
	}

	@Override
	public Element pop() {
		if(stackptr>0){
			Element tmp = stack[stackptr-1];
			stack[stackptr-1] = null;
			stackptr--;
			return tmp;
		}
		return null;
	}

	@Override
	public Element top() {
		if(stackptr>0){
			return stack[stackptr-1];
		}
		return null;
	}

	@Override
	public boolean empty() {
		if(stackptr==0 && stack[stackptr]==null) return true;
		return false;
	}

}
