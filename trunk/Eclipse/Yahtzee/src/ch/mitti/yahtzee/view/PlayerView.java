package ch.mitti.yahtzee.view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import ch.mitti.yahtzee.controller.PlayerController;
import ch.mitti.yahtzee.controller.PlayerLabelListener;
import ch.mitti.yahtzee.model.PlayerModel;

public class PlayerView extends JPanel {
	private JLabel[] labels;
	private PlayerModel playerModel;
	private String name;
	private GridBagLayout gbl;
	private GridBagConstraints gbc;
	private boolean activePlayer;
	private PlayerController playerController;
	
	public PlayerView(String name, boolean activePlayer, PlayerController playerController){
		this.playerController = playerController;
		this.activePlayer = activePlayer;
		this.name = name;
		labels = new JLabel[23];
		gbl = new GridBagLayout();
		gbc = new GridBagConstraints();
		playerModel = new PlayerModel(name,activePlayer);
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.insets = new Insets(0,0,0,0);
		this.setLayout(gbl);
		init();
	}
	
	public void init(){
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.fill = GridBagConstraints.BOTH;
		
		labels[0]= new JLabel(playerModel.getName());
		
		labels[0].setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
		labels[0].setHorizontalAlignment(SwingConstants.CENTER);
		gbl.setConstraints(labels[0], gbc);
		this.add(labels[0]);
		
		for(int i=1;i<labels.length;i++){
			
			gbc.gridy = i;
			labels[i] = new JLabel(" ");
			if(i!=1 && i!=8 && i!=9 && i!=10 && i!=11 && i!=12 && i!=20 && i!=21 && i!=22){
				labels[i].setOpaque(true);
				labels[i].setBackground(Color.WHITE);
				labels[i].addMouseListener(new PlayerLabelListener(playerModel, playerController));
			}
			else if (i==1 || i==11 || i==12 || i==21){
				labels[i].setOpaque(true);
				labels[i].setBackground(Color.GRAY);
			}
			labels[i].setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
			labels[i].setHorizontalAlignment(SwingConstants.CENTER);
			
			switch(i){
				case 8:
					labels[i].setText(Integer.toString(0));
					break;
				case 9:
					labels[i].setText("-");
					break;
				case 10:
					labels[i].setText(Integer.toString(0));
					break;
				case 20:
					labels[i].setText(Integer.toString(0));
					break;
				case 22:
					labels[i].setText(Integer.toString(0));
					break;
				default:
					labels[i].setText(" ");
					break;
			}
			
			gbl.setConstraints(labels[i], gbc);
			this.add(labels[i]);
		}
	}
	
	public PlayerModel getModel(){
		return playerModel;
	}
	
	public JLabel[] getLabels(){
		return labels;
	}
	
	public boolean getActivePlayer(){
		return activePlayer;
	}
	
	public void setSums(){
		labels[8].setText(""+playerModel.getPoints());
		System.out.println(playerModel.getPoints());
		if (playerModel.getBonus()) labels[9].setText("35");
		labels[10].setText(""+playerModel.getUpperScore());
		labels[20].setText(""+playerModel.getLowerScore());
		labels[22].setText(""+playerModel.getTotalScore());
	}
	
	public String getName(){
		return name;
	}
}
