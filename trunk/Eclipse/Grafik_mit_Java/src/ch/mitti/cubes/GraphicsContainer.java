package ch.mitti.cubes;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;

import ch.mitti.dice.DicePanel;

public class GraphicsContainer extends JFrame {
	
	private int size;
	private Square square;
	private Random r;
	private ArrayList<Square> squares;
	private int anzahl;
	
	public void initGUI(){
		size = 1000;
		anzahl = 7;
		this.setLayout(null);
		r= new Random();
		
		squares = new ArrayList<Square>();
		
		for(int i=0; i<anzahl; i++){
			Square square = new Square(size/10, size/10);
			square.setLocation(r.nextInt(size-50), r.nextInt(size-50));
			squares.add(square);
		}
		
		for(Square square : squares){
			this.add(square);
		}

		this.setSize(size,size);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public static void main(String[] args){
		GraphicsContainer container = new GraphicsContainer();
		container.initGUI();
	}
}
