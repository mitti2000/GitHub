package aufgabenserie1.mitti.ch;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WinListener implements WindowListener{

	@Override
	public void windowOpened(WindowEvent e) {
		System.out.println("windowOpened");
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("windowClosing");
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		System.out.println("windowClosed");
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		System.out.println("windowIconofied");
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		System.out.println("windowDeiconofied");
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		System.out.println("windowActivated");
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		System.out.println("windowDeactivated");
		
	}
	
}
