package ch.mitti.dice;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class DicePanel extends JPanel {
	
	public DicePanel(int size){
		this.add(new Dice((int)(Math.random()*6)+1, size));
	}

}
