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
 * stellt einen TCP-Server zur Verfügung, welcher eine einzige Anfrage 
 * eines Clients beantworten kann
 * 
 */
public class TCPServer_work extends JFrame
{
	static int port = 67076;

	public static void main(String args[])
	{
		TCPServer_work wnd = new TCPServer_work();
	}
	
	public TCPServer_work()
	{
		super("TCP Server");
		// GUI erstellen
		
		startServer();
	}
	
	
	private void startServer()
	{	
		BufferedReader input;
		PrintStream output;

		try
		{	// ServerSocket erzeugen	
			

			// Warten auf Verbindung mit Client und akzeptieren
			
			

		//	console.append("Verbunden mit Rechner: " + client.getInetAddress().getHostName() + " Port: " + client.getPort() + "\n");
		
			// BufferedReader zum Lesen verwenden
			
			
			System.out.println("BufferedReader erzeugt");

			// Ankommende Daten lesen		
			
			
		
			// Dem Client antworten
			
			
		
			// Verbindungen beenden
					
		}
		catch (UnknownHostException e)
		{
			console.append("Rechenername unbekannt:\n" + e.getMessage() + "\n");
		}
		catch (IOException e)
		{
			console.append("Fehler während der Kommunikation:\n" + e.getMessage() + "\n");
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

