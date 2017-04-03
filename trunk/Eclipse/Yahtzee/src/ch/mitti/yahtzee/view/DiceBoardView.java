package ch.mitti.yahtzee.view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ch.mitti.yahtzee.controller.DiceBoardMouseListener;
import ch.mitti.yahtzee.controller.DiceController;

public class DiceBoardView extends JPanel {
	
	public DiceBoardView(){
		init();
	}
	
	private void init(){
		
		//Create Grid Layout
		this.setLayout(new GridLayout(5,1,20,20));
		this.setBackground(Color.CYAN);
		
		
		for(int j=0; j<5; j++){
				this.add(new DiceController().getView());
		}
	}
		
}

