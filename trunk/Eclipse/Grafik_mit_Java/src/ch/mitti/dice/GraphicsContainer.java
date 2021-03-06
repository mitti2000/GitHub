package ch.mitti.dice;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicsContainer extends JFrame {
	
	private int anzahl;
	private int size;
	private int space;
	
	
	public void initGUI(){
		anzahl = 5;
		size = 100;
		space = 10;
		
		this.setLayout(new GridLayout(1,anzahl,space, space));

		
	
		for(int i=0; i<5; i++){
			this.add(new DicePanel(size));
		}
		
		this.setSize((size*(anzahl+1))+(space*(anzahl+1)),size+space*10);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	
	
	public static void main(String[] args){
		GraphicsContainer frame = new GraphicsContainer();
		frame.initGUI();
	}
}
