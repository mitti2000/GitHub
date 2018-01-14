package ch.mitti.chat;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class LoggerGui extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	JTextArea console;
	
	public LoggerGui(String name) {
		super(name);
		console = new JTextArea(20,60);
		this.setLayout(new FlowLayout());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.add(console);
		this.pack();
		this.setVisible(true);
	}
	
	public void addMessage(String message) {
		console.append(message + "\n");
	}

}
