package ch.mitti.tetris;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUITest extends JFrame {
	JLabel label1;
	JLabel label2;
	JLabel label3;
	JPanel panel;
	
	public void initGUI(){
		label1 = new JLabel("Label 1");
		label2 = new JLabel("Label 2");
		label3 = new JLabel("Label 3");
		JPanel panel = new JPanel();
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));		
		
		panel.add(label1);
		panel.add(label2);
		panel.add(label3);
		
		this.add(panel);
		
		this.setSize(800, 800);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public static void main(String[] args){
		GUITest test = new GUITest();
		test.initGUI();
	}
}
