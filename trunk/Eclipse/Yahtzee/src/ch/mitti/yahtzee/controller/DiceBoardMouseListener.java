package ch.mitti.yahtzee.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import ch.mitti.yahtzee.view.DiceBoardView;

public class DiceBoardMouseListener extends MouseAdapter {
	
	private DiceBoardView board;
	
	public DiceBoardMouseListener(DiceBoardView board) {
		this.board = board;
	}
	
	@Override
	public void mouseClicked(MouseEvent e){
		JPanel panel = (JPanel)e.getComponent();
		board.move(panel.getY(), panel.getX());
	}
}
