package ch.mitti.chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;

public class TCPServer extends Thread {
	ServerSocket serverSocket;
	private ArrayList<Socket> clients;
	private ChatServerGui gui;
	private boolean running;
	private ArrayList<ServerThread> serverThreads;
	private ArrayList<String> colorStrings;
	private Random randomColor;
	
	public TCPServer(int port, ChatServerGui gui){
		this.gui = gui;
		running = true;
		randomColor = new Random();
		clients = new ArrayList<Socket>();
		serverThreads = new ArrayList<ServerThread>();
		colorStrings = new ArrayList<String>();
		
		try {
			serverSocket = new ServerSocket(port);
		} catch (IOException e) {
			gui.connectionFailed();
		}
	}
	
	public void run(){
		try {
			while(running==true){
				Socket client = serverSocket.accept();
				gui.addToConsole("Client Connected: " + client.getInetAddress().getHostName() + " on Port: " + client.getPort() + "\n");
				ServerThread thread = new ServerThread(client, this);
				clients.add(client);
				thread.start();
			}
			serverSocket.close();
		
		} catch (IOException e) {
			this.interrupt();
		}
	}
	
	public void closeServer() {
		running = false;
		try {
			closeClients();
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void closeClients() {
		for(ServerThread thread : serverThreads) {
			thread.closeConnection();
		}
	}

	public void notifyClients(String[] message, ServerThread sendingThread) {
		for(int i = 0; i<serverThreads.size(); i++) {
			if(serverThreads.get(i) != sendingThread) {
				synchronized (serverThreads.get(i).getOutputStream()) {
					if(message[2].equals("1")) {
						message[1] = " has Connected. Welcome";
						serverThreads.get(i).getOutputStream().println(compileMessage(message, i));
					}
					else {
						serverThreads.get(i).getOutputStream().println(compileMessage(message, i));
					}
				}
			}
			serverThreads.get(i).getOutputStream().flush();		
		}
		if(message[2].equals("1")) {
			gui.addToConsole(message[0] + " has connected.\n");
		}
		else if(message[2].equals("2")) {
			gui.addToConsole(message[0] + " has disconnected.\n");
		}		
	}
	
	public void addServerThread(ServerThread thread) {
		serverThreads.add(thread);
		colorStrings.add(Integer.toString(randomColor.nextInt(256)) + "-" + Integer.toString(randomColor.nextInt(256)) + "-" + Integer.toString(randomColor.nextInt(256)));
	}
	
	public void removeServerThread(ServerThread thread) {
		serverThreads.remove(thread);
	}
	
	public String compileMessage(String message[], int index) {
		String compiledMessage = message[0] + "//" + message[1] + "//0//0//" + colorStrings.get(index);
		return compiledMessage;
	}
	
}

