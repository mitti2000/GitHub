package ch.mitti.chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class TCPServer extends Thread {
	//braucht Liste von Clients Socket verbindungen 
	//run ruft ServerThread auf welche dannd ie Kommunikation regelt
	//braucht methode WriteAnsewers
	
	ServerSocket socket;
	private ArrayList<Socket> clients;
	private ChatServerGui gui;
	
	public TCPServer(int port, ChatServerGui gui){
		this.gui = gui;
		clients = new ArrayList<Socket>();
		try {
			socket = new ServerSocket(port);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void run(){
		while(true){
			try {
				Socket client = socket.accept();
				clients.add(client);
				ServerThread st = new ServerThread(client, this);
				st.start();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
