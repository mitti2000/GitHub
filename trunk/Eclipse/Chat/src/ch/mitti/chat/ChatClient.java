package ch.mitti.chat;

import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatClient extends Thread{
	
	private ClientGui gui;
	private String hostname;
	private int port;
	private boolean running;
	private Socket server;
	//private String username;
	private BufferedReader inputStream;
	private PrintStream outputStream;
	public static final String CONNECTED_MESSAGE = "-connected-";
	private String[] sendMessageContainer;
	private String[] recieveMessageContainer;
	
	public ChatClient( String hostname, int port, String username, ClientGui gui) {
		super(username);
		//this.username = username;
		this.hostname = hostname;
		this.port = port;
		this.gui = gui;
		running = false;
		sendMessageContainer = new String[3];
		sendMessageContainer[0] = username; //Username
		sendMessageContainer[1] = " ";		//Message
		sendMessageContainer[2] = "0";		//First Connected
		
		recieveMessageContainer = new String[5];
		recieveMessageContainer[0] = "";	//Username
		recieveMessageContainer[1] = "";	//Message
		recieveMessageContainer[2] = "";	//Bold
		recieveMessageContainer[3] = "";	//Italic
		recieveMessageContainer[4] = "";	//Color r-g-b


		
		try {
			server = new Socket(this.hostname,this.port);
			inputStream = new BufferedReader(new InputStreamReader(server.getInputStream ()));
			outputStream = new PrintStream(server.getOutputStream ());	
		    running = true;
		    sendMessageContainer[2] = "1";
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void run() {
		sendMessage(compileMessage());
		sendMessageContainer[2] = "0";
		gui.addToConsole("You are connected to " + server.getInetAddress().getHostName() + " on Port " + server.getPort(), Color.BLACK, new Font("ownerFont", Font.PLAIN, 12));
		while(running) {
			try {
				while(true) {
					String message = inputStream.readLine();
					addMessageToGui(message);
				}
				} catch(IOException ex){
					ex.printStackTrace();
				} finally {
					try {
						server.close();
					} catch (IOException ex) {
						ex.printStackTrace();
					}
				}
		}
	}
	
	public void sendMessage(String message) {
		outputStream.println(message);
		if(sendMessageContainer[2]!="1") {
			gui.addToConsole("Me: " + sendMessageContainer[1], Color.BLACK, new Font("ownerFont", Font.BOLD + Font.ITALIC, 12));
		}
	}
	
	public String compileMessage() {
		String message = sendMessageContainer[0] + "//" +
				sendMessageContainer[1] + "//" +
				sendMessageContainer[2];
		return message;
	}
	
	public String compileMessage(String message) {
		sendMessageContainer[1] = message;
		return compileMessage();
	}
	
	public void addMessageToGui(String message) {
		String[] messageContainer = message.split("//");
		int style = Font.PLAIN;
		int size = 12;
		if(messageContainer[2].equals("1") && messageContainer[3].equals("0")) {
			style = Font.BOLD;
		}
		else if(messageContainer[2].equals("1") && messageContainer[3].equals("1")) {
			style = Font.BOLD + Font.ITALIC;
		}
		else if(messageContainer[2].equals("0") && messageContainer[3].equals("1")){
			style = Font.ITALIC;
		}
		Font font = new Font("ClientFont", style, size);
		String[] colorRGB =  messageContainer[4].split("-");
		Color color = new Color(Integer.parseInt(colorRGB[0]), Integer.parseInt(colorRGB[1]), Integer.parseInt(colorRGB[2]));
		gui.setFont(color, font);
		gui.addToConsole(messageContainer[0] + ": " + messageContainer[1], color, font);
	}
}
	

