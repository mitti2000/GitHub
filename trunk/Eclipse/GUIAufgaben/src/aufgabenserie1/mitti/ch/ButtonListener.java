package aufgabenserie1.mitti.ch;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ButtonListener implements ActionListener {
	
	JButton button;
	
	public ButtonListener(JButton button){
		this.button = button;
		}
	
	public void actionPerformed(ActionEvent e){
		System.out.println("Es wurde '" + button.getText()  + " gedr�ckt.");
	}

}
