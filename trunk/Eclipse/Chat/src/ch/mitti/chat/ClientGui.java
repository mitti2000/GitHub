package ch.mitti.chat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.*;

public class ClientGui extends JFrame implements ActionListener, ClosableGui{
	
	private static final long serialVersionUID = 1L;

	ChatClient chatClient;
	boolean isDisconnected = true;
	
	JPanel infoPanel;
	JPanel messagePanel;
	JPanel controlPanel;
	JPanel consolePanel;
	JTextPane console;
	JScrollPane consoleScrollBar;
	DefaultCaret consoleCaret;
	
	JLabel hostNameLabel;
	JLabel portLabel;
	JLabel userNameLabel;
	JTextField hostNameField;
	JTextField portField;
	JTextField userNameField;
	JButton connectButton;
	JButton disconnectButton;
	
	JLabel messageLabel;
	JTextField messageField;
	JButton sendButton;
	
	String username;
	
	public ClientGui(){
		super("Chat Client");
		initGui();
	}
	
	public ClientGui(String username){
		super("Chat Client");
		this.username = username;
		initGui();
	}
	
	public void initGui(){
		
		this.addWindowListener(new ChatWindowListener(this));
		
		controlPanel = new JPanel();
		controlPanel.setLayout(new BorderLayout());
		consolePanel = new JPanel();
		consolePanel.setLayout(new BorderLayout());
		infoPanel = new JPanel();
		infoPanel.setLayout(new FlowLayout());
		messagePanel = new JPanel();
		messagePanel.setLayout(new FlowLayout());
		console = new JTextPane();
		consoleScrollBar = new JScrollPane(console);
		consoleCaret = (DefaultCaret) console.getCaret();
		consoleCaret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		
		
		hostNameLabel = new JLabel("Host:");
		portLabel = new JLabel("Port:");
		userNameLabel = new JLabel("Username:");
		hostNameField = new JTextField(8);
		portField = new JTextField(8);
		userNameField = new JTextField(20);
		connectButton = new JButton("connect");
		connectButton.addActionListener(this);
		disconnectButton = new JButton("disconnect");
		disconnectButton.addActionListener(this);
		disconnectButton.setEnabled(false);
		
		messageLabel = new JLabel("Message:");
		messageField = new JTextField(50);
		messageField.setText("");
		sendButton = new JButton("send");
		sendButton.setEnabled(false);
		sendButton.addActionListener(this);
		sendButton.setEnabled(false);
		
		infoPanel.add(hostNameLabel);
		infoPanel.add(hostNameField);
		infoPanel.add(portLabel);
		infoPanel.add(portField);
		infoPanel.add(userNameLabel);
		infoPanel.add(userNameField);
		infoPanel.add(connectButton);
		infoPanel.add(disconnectButton);
		
		messagePanel.add(messageLabel);
		messagePanel.add(messageField);
		messagePanel.add(sendButton);
		
		controlPanel.add(infoPanel,BorderLayout.NORTH);
		controlPanel.add(messagePanel, BorderLayout.CENTER);
		
		consolePanel.add(consoleScrollBar);
		
		this.setLayout(new BorderLayout());
		this.add(controlPanel, BorderLayout.NORTH);
		this.add(consolePanel, BorderLayout.CENTER);
		
		pack();
		this.setSize(this.getWidth(), (int) (this.getWidth()*0.5));
		setLocationRelativeTo(null);
		setVisible(true);
		
		
		//**** for testing ***///
		hostNameField.setText("localhost");
		portField.setText("61616");
		userNameField.setText(username);
		//*********************
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.connectButton) {
			sendButton.setEnabled(true);
			connectButton.setEnabled(false);
			disconnectButton.setEnabled(true);
			chatClient = new ChatClient(hostNameField.getText(), Integer.parseInt(portField.getText()), userNameField.getText(), this);
			
		}
		
		else if(e.getSource() == this.sendButton) {
			if(!messageField.getText().equals("")) {
				chatClient.sendMessage(chatClient.compileMessage(messageField.getText()));
				messageField.setText("");
			}
		}
		
		else if(e.getSource() == this.disconnectButton) {
			chatClient.disconnect();
		}
		
	}
	
	public void addToConsole(String message, Color color, Font font) {
		SimpleAttributeSet attributeSet = new SimpleAttributeSet();
	    boolean italic = false;
	    boolean bold = false;
	    if(font.isItalic()) italic = true;
	    if(font.isBold()) bold = true;
	    
	    StyleConstants.setBold(attributeSet, bold);
	    StyleConstants.setItalic(attributeSet, italic);
	    StyleConstants.setForeground(attributeSet, color);

	    int len = console.getDocument().getLength();
	    console.setCaretPosition(len);
	    console.setCharacterAttributes(attributeSet, false);
	    console.replaceSelection(message + "\n");
	}
	
	public void setDisconnected() {
		disconnectButton.setEnabled(false);
		connectButton.setEnabled(true); 
		addToConsole("Disconnected from Server", Color.BLACK, new Font("ownerFont", Font.BOLD + Font.ITALIC, 12));
	}
	
	public void connectionFailed() {
		disconnectButton.setEnabled(false);
		connectButton.setEnabled(true);
		sendButton.setEnabled(false);
		addToConsole("Connection Failed!", Color.BLACK, new Font("ownerFont", Font.BOLD + Font.ITALIC, 12));
	}
	
	@Override
	public void closeWindow() {
		if(chatClient != null) chatClient.disconnect();
		System.exit(0);
	}
	
	public static void main(String[] args) {
		new ClientGui();
	}
}
