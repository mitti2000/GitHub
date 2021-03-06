package ch.mitti.cubes;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;

public class Square extends Canvas{
	
	public Square(int sizeX, int sizeY){
		HoverAdapter hover = new HoverAdapter();
		MoveListener move = new MoveListener();
		WheelListener wheel = new WheelListener();
		this.addMouseWheelListener(wheel);
		this.addMouseListener(hover);
		this.addMouseMotionListener(move);
		this.setBackground(Color.BLUE);
		this.setSize(sizeX,sizeY);
		
	}

}
