package ch.mitti.mystack;

public class MyStack {
	
	private Integer[] e;
	private int size;
	
	public MyStack(){
		size = 0;
		e = new Integer[size];
	}

	public Integer[] getE() {
		return e;
	}

	public boolean push(Integer e2) {
		if(e2==null)return false;
		size++;
		resize();		
		e[size-1] = e2;		
		if(e[size-1]==e2) return true;
		else return false;
	}


	public Object pop() {
		Integer temp = e[e.length-1];
		if(size==0) return null;
		size--;
		resize();
		if(e.length==size) return temp;
		else return null;
	}
	
	private void resize(){
		Integer[] temp = new Integer[size];
		
		if(e.length>=size){
			for(int i=0; i<size; i++){
				temp[i] = e[i];
			}
		}
		else if(e.length<size){
			for(int i=0; i<e.length; i++){
				temp[i] = e[i];
			}
		}
		
		e = temp;
	}

	
}
