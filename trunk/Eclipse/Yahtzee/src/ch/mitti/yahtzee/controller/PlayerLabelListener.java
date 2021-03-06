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
		if(view.getModel().isActivePlayer() && view.getModel().isPointsSet()==false){ //Wenn AktiverSpieler und Punkte schon gesetzt
			JLabel[] labels = view.getLabels(); //Hole die Labels
			for(int i=0; i<labels.length; i++){ //iterierte durch alle Labels
				if(labels[i].equals(label)) //Wenn das Label dem angeklickten entspricht
					if(label.getText() != " "){ //und der Text nicht " " ist
						JOptionPane.showMessageDialog(view, "Feld schon Voll"); // ist das Feld schon voll
					}
					else{
						playerModel.setScore(i, diceBoardController.getPoints(i)); //Wenn nicht, setze Punkte im PlayerModel
						gameBoardView.getGameBoardController().setScores(); //Setze die Punkte im Feld
						label.setText(""+playerModel.getScore(i)); //Setzte den Textim Feld
						view.getModel().setPointsSet(true); //Punkte sind gesetzt ist true
						//TEST
						//playerModel.setIsDone(true);
						//
						if(playerModel.isAllSet()){ //Wenn alle Werte gesetzt sind, ist der Player Fertig
							playerModel.setIsDone(true);
						}
						gameBoardView.getButtonController().setNextPlayer(); //Setzte den Button auf "n�chster Spieler"
						gameBoardView.getGameBoardController().setRollsToZero(); //Setze w�rfel auf 0
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
