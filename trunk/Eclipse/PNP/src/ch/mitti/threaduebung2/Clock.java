package ch.mitti.threaduebung2;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JLabel;

public class Clock extends Thread {
	
	JLabel label;
	Calendar cal;
	SimpleDateFormat sdf ;
	
	public Clock(JLabel label){
		this.label = label;
		cal = Calendar.getInstance();
        sdf = new SimpleDateFormat("HH:mm:ss");
	}
	
	@Override
	public void run(){
		while(!isInterrupted()){
			cal = Calendar.getInstance();
	        label.setText(sdf.format(cal.getTime()) );
			try {
				sleep(100);
			} catch (InterruptedException e) {
				interrupt();
			}
		}
	}
}
