package ch.mitti.tetris;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class GameFrame extends JFrame{
	
	JPanel panBackground;
	JPanel panGame;
	JPanel panScore;
	int blocksH;
	int blocksW;
	GridBagLayout layBackground;
	GridBagConstraints c;
	BoxLayout layScore;
	JLabel score;
	JLabel next;
	
	public GameFrame(){
		//Initializing Background Panel
		layBackground = new GridBagLayout();
		panBackground = new JPanel(layBackground);
		panBackground.addComponentListener(new ComponentAdapter(){
			@Override
			public void componentResized(ComponentEvent e){
				resizePreview(panGame, panBackground);
			}
		});
		
		
		//Amount of Blocks in GameField
		blocksH = 20;
		blocksW = 10;
		
		//Gridbaglayount and basic Contraint Setup
		
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1.0;
		c.insets = new Insets(10,10,10,10);
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		
		//Score and Preview Panel
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 4;
		c.gridwidth = 10;
		score = new JLabel("Score");
		next = new JLabel("Next");
		panScore = new JPanel();
		panScore.setLayout(new BoxLayout(panScore, BoxLayout.Y_AXIS));
		panScore.add(score);
		panScore.add(next);
		panBackground.add(panScore);
		
		//Create Game Panel and fill it with fields
		panGame = new JPanel(new GridLayout(blocksH, blocksW));		
		for(int i=0; i<(blocksH*blocksW);i++){
			JLabel label = new JLabel("Label");
		    label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		    panGame.add(label);
		}
		c.gridy = 0;
		c.gridx = 10;
		c.gridwidth = 50;
		c.gridheight = 100;
		panBackground.add(panGame);
		
		//Create Frame
		this.getContentPane().add(panBackground);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(800,800);
		this.setVisible(true);
		this.setResizable(false);
		
	}
	
	
	//Resize so Field is always same size
	public void resizePreview(JPanel panGame, JPanel panBackground){
		int w = this.panBackground.getWidth();
		int field = (w/100*50)/blocksW;
		int dimW = field*blocksW;
		int dimH = field*blocksH;
		this.panGame.setPreferredSize(new Dimension(dimW, dimH));
		this.panBackground.revalidate();
	}

	public static void main(String[] args) {
		GameFrame frame = new GameFrame();

	}

}
