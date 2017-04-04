package ch.mitti.yahtzee.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import ch.mitti.yahtzee.model.PlayerModel;
import ch.mitti.yahtzee.view.GameBoardView;
import ch.mitti.yahtzee.view.PlayerView;

public class PlayerLabelListener implements MouseListener {
	private PlayerModel playerModel;
	private PlayerController playerController;
	private GameBoardView gameBoardView;
	private DiceBoardController diceBoardController;
	
	public PlayerLabelListener(PlayerModel playerModel, PlayerController playerController){
		this.playerController = playerController;
		this.playerModel = playerModel;
		this.gameBoardView = playerController.getGameBoardView();
	}

	
	@Override
	public void mouseClicked(MouseEvent e) {
		this.diceBoardController = gameBoardView.getDiceBoardController();
		JLabel label = (JLabel) e.getComponent();
		PlayerView view = (PlayerView) e.getComponent().getParent();
		if(view.getModel().isActivePlayer() && view.getModel().isPointsSet()==false){
			JLabel[] labels = view.getLabels();
			for(int i=0; i<labels.length; i++){
				if(labels[i].equals(label))
					if(label.getText() != " "){
						JOptionPane.showMessageDialog(view, "Feld schon Voll");
					}
					else{
						System.out.println(diceBoardController);
						playerModel.setScore(i, diceBoardController.getPoints(i));
						label.setText(""+playerModel.getScore(i));
						view.getModel().setPointsSet(true);
					}
				
			}
		}
		else if(view.getModel().isPointsSet()) JOptionPane.showMessageDialog(view, "Punkte schon gesetzt!");
		else if(!view.getModel().isActivePlayer()) JOptionPane.showMessageDialog(view, "Bitte im eigenen Feld eintragen");
		
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
