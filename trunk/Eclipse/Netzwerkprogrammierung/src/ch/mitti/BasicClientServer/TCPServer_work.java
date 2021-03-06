package ch.mitti.BasicClientServer;



import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

/**
 * 
 * @author Marcel Egloff
 * @version 1.0
 *
 * stellt einen TCP-Server zur Verf�gung, welcher eine einzige Anfrage 
 * eines Clients beantworten kann
 * 
 */
public class TCPServer_work extends JFrame
{
	static int port = 60006;
	
	JPanel panel;
	JTextArea text;

	public static void main(String args[])
	{
		TCPServer_work wnd = new TCPServer_work();
	}
	
	public TCPServer_work()
	{
		super("TCP Server");
		this.setSize(1000,800);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		panel = new JPanel();
		text = new JTextArea(50,50);
		text.setEditable(false);
		
		panel.add(text);
		this.add(panel);
		
		this.setVisible(true);
		
		
		startServer();
	}
	
	
	private void startServer()
	{	
		BufferedReader input;
		PrintStream output;

		try
		{	// ServerSocket erzeugen	
			ServerSocket socket = new ServerSocket(port);

			// Warten auf Verbindung mit Client und akzeptieren
			Socket client = socket.accept();
			

			//console.append("Verbunden mit Rechner: " + client.getInetAddress().getHostName() + " Port: " + client.getPort() + "\n");
			//text.append("Verbunden mit Rechner: " + client.getInetAddress().getHostName() + " Port: " + client.getPort() + "\n");
		
			// BufferedReader zum Lesen verwenden
			BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
			
			text.append("BufferedReader erzeugt\n");
			
			boolean exit = false;
			
			while(!exit) {
			// Ankommende Daten lesen		
			text.append(reader.readLine() + "\n");
			
		
			// Dem Client antworten
			PrintWriter writer = new PrintWriter(client.getOutputStream(), true);
			writer.println("Hallo Client\n");
			}
		
			// Verbindungen beenden
			socket.close();
					
		}
		catch (UnknownHostException e)
		{
			text.append("Rechenername unbekannt:\n" + e.getMessage() + "\n");
		}
		catch (IOException e)
		{
			text.append("Fehler w�hrend der Kommunikation:\n" + e.getMessage() + "\n");
		}
	}
	
	class MyWindowListener extends WindowAdapter
	{
		public void windowClosing(WindowEvent e)
		{
			System.exit(0);
		}
	}
	
}

