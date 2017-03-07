package ch.mitti.cubes;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class WheelListener implements MouseWheelListener{

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		System.out.println(e.getWheelRotation());
		Square square;
		if(e.getSource() instanceof Square) square = (Square) e.getSource();
		else square = null;
		
		if(!square.equals(null)){
			square.setSize(square.getHeight()+e.getWheelRotation(), square.getHeight()+e.getWheelRotation());
		}
	}

}
