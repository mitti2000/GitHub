package aufgabenserie1.mitti.ch;

import javax.swing.JButton;

public class MyButton extends JButton {
	int counter;
	
	public MyButton(String name){
		super(name);
		counter = 0;
	}
	public void count(){
		counter++;
	}
	
	public int getCount(){
		return counter;
	}
}
