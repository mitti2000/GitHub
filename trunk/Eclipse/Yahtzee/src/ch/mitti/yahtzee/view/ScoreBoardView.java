package ch.mitti.yahtzee.view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ch.mitti.yahtzee.controller.PlayerController;
import ch.mitti.yahtzee.model.ScoreBoardModel;

public class ScoreBoardView extends JPanel{
	
	private GridBagLayout gbl;
	private GridBagConstraints gbc;
	private ArrayList<JLabel> labels;
	private ScoreBoardModel sbm;
	private PlayerController playerController;
	
	
	public ScoreBoardView(PlayerController playercontroller){
		this.playerController = playerController;
		gbl = new GridBagLayout();
		gbc = new GridBagConstraints();
		sbm = new ScoreBoardModel();
		labels = new ArrayList<JLabel>();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.insets = new Insets(0,0,0,0);
		this.setLayout(gbl);
		this.init();
	}
	
	public void init(){
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		
		for(int i=0;i<sbm.modelLength();i++){
			labels.add(new JLabel());
		}
		fillMain();
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		fillPlayers();
	}
	
	public void fillMain(){
		int counter = 0;
		for(int i=0; i<labels.size(); i++){
			gbc.gridy = counter;
			gbl.setConstraints(labels.get(counter), gbc);
			labels.get(counter).setText(sbm.getValue(counter));
			labels.get(counter).setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
			if(counter==11 || counter ==21){
				labels.get(counter).setOpaque(true);
				labels.get(counter).setBackground(Color.GRAY);
			}
			this.add(labels.get(counter));
			counter++;
		}
		
	}
	
	public void fillPlayers(){
		
	}
	
	
}
