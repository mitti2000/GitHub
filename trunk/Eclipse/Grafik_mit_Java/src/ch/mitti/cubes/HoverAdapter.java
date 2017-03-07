package ch.mitti.cubes;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class HoverAdapter extends MouseAdapter {
	private Square square;

	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource() instanceof Square) square = (Square) e.getSource();
		else square = null;
		
		if(!square.equals(null)) square.setBackground(Color.YELLOW);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource() instanceof Square) square = (Square) e.getSource();
		else square = null;
		
		if(!square.equals(null)) square.setBackground(Color.BLUE);
	}
	

	
}
