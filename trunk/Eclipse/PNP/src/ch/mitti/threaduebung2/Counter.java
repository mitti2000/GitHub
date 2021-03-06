package ch.mitti.threaduebung2;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JLabel;

public class Counter extends Thread{
	JLabel label;
	boolean status;
	SimpleDateFormat sdf;
	Calendar cal;
	long startTime;
	
	
	
	public Counter(JLabel label){
		cal = Calendar.getInstance();
		cal.setTimeInMillis(0);
		this.label = label;
		sdf = new SimpleDateFormat("HH:mm:ss:SSS");
		status = true;
		cal.set(0, 0, 0, 0, 0, 0);
		label.setText(sdf.format(cal.getTime()));
	}
	
	@Override
	public void run(){
		startTime = System.currentTimeMillis();
		while(!isInterrupted()){
			if(status) {
				cal.setTimeInMillis(System.currentTimeMillis() - startTime);
			}
			label.setText(sdf.format(cal.getTime()));
		}
	}
	
	public void toggleStatus(){
		if(status) status = false;
		else status = true;
	}
}
