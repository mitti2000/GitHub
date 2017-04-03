package ch.mitti.yahtzee.view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ch.mitti.yahtzee.controller.DiceController;

public class FillerView extends JPanel{
	
	public FillerView(){
		init();
	}
	
	public void init(){
		//Create Grid Layout
				this.setLayout(new GridLayout(5,1,20,20));
				
				
				for(int j=0; j<5; j++){
						JLabel label = new JLabel(" ");
						label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
						this.add(label);
				}
	}
}
