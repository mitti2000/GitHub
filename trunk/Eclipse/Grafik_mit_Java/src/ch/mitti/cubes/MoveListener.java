package ch.mitti.cubes;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MoveListener implements MouseMotionListener{

	@Override
	public void mouseDragged(MouseEvent e) {
		Square square;
		if(e.getSource() instanceof Square) square = (Square) e.getSource();
		else square = null;
		
		if(!square.equals(null)) {	
			square.setLocation(e.getXOnScreen()-square.getHeight()/2, e.getYOnScreen()-square.getHeight()/2);
		}
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
