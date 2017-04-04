package ch.mitti.yahtzee.view;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class DiceView extends Canvas {
	private int value;
	private int size;
	
	public DiceView(int value, int size){
		this.value = value;
		this.size = size;
		this.setSize(size, size);
		this.setBackground(Color.WHITE);
		
	}
	
	public void setValue(int value){
		this.value = value;
		repaint();
	}
	
	public void resetBackgroundColor(){
		this.setBackground(Color.WHITE);
	}
	
	public void switchBackgroundColor(){
		if(this.getBackground() == Color.WHITE) this.setBackground(Color.YELLOW);
		else if (this.getBackground() == Color.YELLOW) this.setBackground(Color.WHITE);
	}

	
	@Override
	public void paint(Graphics g){
		g.setColor(Color.BLACK);
		g.drawRoundRect(0, 0, this.getWidth()-1, this.getHeight()-1, 5, 5);
		int eyeSize = this.getHeight()/5;
		int topY = this.getHeight()/5;
		int bottomY = this.getHeight()-(eyeSize*2);
		int leftX = this.getWidth()/5;
		int rightX = this.getWidth()-(eyeSize*2);
		int center = this.getHeight()/2-(eyeSize/2);
		
		
		if(value<1||value>6) return;
		else{
			switch(value){
			case 1:
				g.fillOval(center, center, eyeSize, eyeSize);
				break;
			
			case 2:
				g.fillOval(leftX, topY, eyeSize, eyeSize);
				g.fillOval(rightX, bottomY, eyeSize, eyeSize);
				break;
			
			case 3:
				g.fillOval(leftX, topY, eyeSize, eyeSize);
				g.fillOval(center, center, eyeSize, eyeSize);
				g.fillOval(rightX, bottomY, eyeSize, eyeSize);
				break;
				
			case 4:
				g.fillOval(leftX, topY, eyeSize, eyeSize);
				g.fillOval(rightX, topY, eyeSize, eyeSize);
				g.fillOval(leftX, bottomY, eyeSize, eyeSize);
				g.fillOval(rightX, bottomY, eyeSize, eyeSize);
				break;
			
			case 5:
				g.fillOval(leftX, topY, eyeSize, eyeSize);
				g.fillOval(rightX, topY, eyeSize, eyeSize);
				g.fillOval(center, center, eyeSize, eyeSize);
				g.fillOval(leftX, bottomY, eyeSize, eyeSize);
				g.fillOval(rightX, bottomY, eyeSize, eyeSize);
				break;
				
			case 6:
				g.fillOval(leftX, topY, eyeSize, eyeSize);
				g.fillOval(rightX, topY, eyeSize, eyeSize);
				g.fillOval(rightX, center, eyeSize, eyeSize);
				g.fillOval(leftX, center, eyeSize, eyeSize);
				g.fillOval(leftX, bottomY, eyeSize, eyeSize);
				g.fillOval(rightX, bottomY, eyeSize, eyeSize);
				break;
			}
		}
		
	}
}
