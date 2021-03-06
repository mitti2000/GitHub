package ch.mitti.tetris;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Testklasse extends JFrame {
	
	private JButton button;
	private JPanel panel;
	private int size;
	
	private Testklasse(){
		size = 20;
	}
	
	private void initGui(){		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		panel = new JPanel();
		button = new JButton("Testtext");
		panel.add(button);
		resize();
		this.add(panel, BorderLayout.CENTER);
		setSize(400,400);	
		setVisible(true);	
	}
	
	public void resize(){
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		size = (int) Math.round(dim.getWidth()/50.0);
		button.setFont(new Font("Arial", Font.PLAIN, size));
	}
	
	public static void main(String[] args){
		Testklasse test = new Testklasse();
		test.initGui();
	}
	
}
