
public class Service implements Runnable{
	
	private int result;
	private boolean[] array;
	private int start;
	private int end;
	
	public Service(boolean[] array, int start, int end){
		this.array = array;
		this.start = start;
		this.end = end;
	}
	
	@Override
	public void run() {
	
		for(int i = start; i<end; i++){
			if(array[i]) result++;
			
			
			try{
				Thread.sleep(5);
			} catch (InterruptedException e){
				
			}
			
			
		}
		

	}
	
	public int getResult(){
		return result;
	}

}