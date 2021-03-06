package ch.mitti.dice;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Dice extends Canvas implements MouseListener {
	
	private int count;
	
	public Dice(int count, int size){
		this.count = count;
		this.setSize(size, size);
		this.setBackground(Color.BLUE);
		this.addMouseListener(this);
	}
	
	public int getCount(){
		return count;
	}
	
	public void setCount(int count){
		this.count = count;
	}
	
	@Override
	public void paint(Graphics g){
		g.setColor(Color.WHITE);
		int eyeSize = this.getHeight()/5;
		int topY = this.getHeight()/5;
		int bottomY = this.getHeight()-(eyeSize*2);
		int leftX = this.getWidth()/5;
		int rightX = this.getWidth()-(eyeSize*2);
		int center = this.getHeight()/2-(eyeSize/2);
		
		
		if(count<1||count>6) return;
		else{
			switch(count){
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

	@Override
	public void mouseClicked(MouseEvent e) {
		setCount((int)(Math.random()*6)+1);
		this.repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
