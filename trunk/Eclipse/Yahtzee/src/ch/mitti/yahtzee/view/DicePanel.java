package ch.mitti.yahtzee.view;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import ch.mitti.yahtzee.controller.DiceBoardMouseListener;

public class DicePanel extends JPanel{
	private int posX;
	private int posY;
	
	public DicePanel(int y, int x, DiceBoardView board){
		super();
		this.setBackground(Color.BLUE);
		this.posX = x;
		this.posY = y;
		//this.setBorder(BorderFactory.createLineBorder(Color.black));
		//this.addMouseListener(new DiceBoardMouseListener(board));
	}
	
	public int getX(){
		return posX;
	}
	
	public int getY(){
		return posY;
	}
}