package ch.mitti.chat;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JButton;


public class ChatServerGui extends JFrame implements ActionListener, ClosableGui{
	
	private static final long serialVersionUID = 1L;

	TCPServer server;
	
	private JTextArea console;
	private JButton startButton;
	private JButton stopButton;
	private JPanel buttonPanel;
	private int port;
	
	public ChatServerGui(){
		super("ChatServer");
		port = 61616;
		initGui();
	}
	
	public void initGui(){
		this.addWindowListener(new ChatWindowListener(this));
		
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		startButton = new JButton("Start Server");
		stopButton = new JButton("Stop Server");
		stopButton.setEnabled(false);
		setLayout(new BorderLayout());
		console = new JTextArea(20,60);
		console.setEditable(false);
		buttonPanel.add(startButton);
		buttonPanel.add(stopButton);
		this.add(console, BorderLayout.CENTER);
		this.add(buttonPanel, BorderLayout.NORTH);
		pack();
		setVisible(true);
		
		startButton.addActionListener(this);
		stopButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.startButton) {
			startButton.setEnabled(false);
			stopButton.setEnabled(true);
			server = new TCPServer(port, this);
			server.start();
			console.append("Server started on Port: " + port + "\n");
		}
		
		else if(e.getSource() == this.stopButton) {
			stopButton.setEnabled(false);
			startButton.setEnabled(true);
			server.closeServer();
		}
	}
	
	public void addToConsole(String message) {
		console.append(message);
	}
	
	public void connectionFailed() {
		addToConsole("Connection failed!");
		stopButton.setEnabled(false);
		startButton.setEnabled(true);
	}

	@Override
	public void closeWindow() {
		stopButton.setEnabled(false);
		startButton.setEnabled(true);
		if(server != null) server.closeServer();
		System.exit(0);
	}
	
	public static void main(String[] args){
		new ChatServerGui();
	}
}

