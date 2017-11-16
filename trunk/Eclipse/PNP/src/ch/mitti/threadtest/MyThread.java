package ch.mitti.threadtest;

public class MyThread extends Thread {
	
	public MyThread(String name){
		super(name);
	}
	
	@Override
	public void run(){
		for(int i=0; i<100;i++){
			System.out.print(this.getName()+" ");
		}
	}
	
}
