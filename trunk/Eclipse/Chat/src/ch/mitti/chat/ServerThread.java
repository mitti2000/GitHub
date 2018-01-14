package ch.mitti.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ServerThread extends Thread{
	
	private Socket client;
	private TCPServer server;
	private boolean running;
	private BufferedReader inputStream;
	private PrintStream outputStream;
	public static final String CONNECTED_MESSAGE = "-connected-";
	
	public ServerThread(Socket client, TCPServer server) throws IOException{
		this.client = client;
		this.server = server;
		inputStream = new BufferedReader(new InputStreamReader(client.getInputStream ()));
	    outputStream = new PrintStream(client.getOutputStream ());
		running = true;
	}
	
	public void run(){
		while(running) {
			try {
				server.addServerThread(this);
				sleep(100);
				while(true) {
					String[] message = inputStream.readLine().split("//");
					server.notifyClients(message, this);
				}
				} catch(IOException ex){
					ex.printStackTrace();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					server.removeServerThread(this);
					try {
						client.close();
					} catch (IOException ex) {
						ex.printStackTrace();
					}
				}
		}
	}
	
	public PrintStream getOutputStream() {
		return outputStream;
	}
}
	
