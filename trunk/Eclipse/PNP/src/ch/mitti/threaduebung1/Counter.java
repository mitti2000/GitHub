package ch.mitti.threaduebung1;

import javax.swing.JLabel;

public class Counter extends Thread{
	int counter;
	JLabel label;
	boolean status;
	public Counter(JLabel label){
		this.label = label;
		counter = 0;
		label.setText(""+counter);
		status = true;
	}
	
	@Override
	public void run(){
		while(!isInterrupted()){
				if(status) counter++;
				label.setText(""+counter);
			try {
				sleep(100);
			} catch (InterruptedException e) {
				interrupt();
			}
		}
	}
	
	public void toggleStatus(){
		if(status) status = false;
		else status = true;
	}
}
