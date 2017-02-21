package ch.mitti.tetris.testing;

import java.awt.FlowLayout;
import java.awt.LayoutManager;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestFrame extends JFrame {
	
	private JPanel panel;
	
	public TestFrame(){
		initGui();
	}
	
	private void drawGui(){
		panel = new JPanel();
		panel.setLayout(););
	}
	
	private void initGui(){		
		// Frame initialisieren
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(768,1024);
		setVisible(true);		
	}

}
