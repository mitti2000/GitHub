
import java.net.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class TCPClient_work extends JFrame implements ActionListener
{
	static String hostname = " ";

	static int port =  67676;

	

	public static void main(String args[])
	{

		TCPClient_work wnd = new TCPClient_work();
		wnd.setVisible(true);
	}

	public TCPClient_work()
	{
		super("TCP Client");

		// GUI erstellen

		pack();
	}

	public void actionPerformed(ActionEvent event)
	{

		PrintStream output;
		BufferedReader reader = null;

		try
		{
			
			// Verbindung aufbauen
			
			
			System.out.println("Socket Verbindung "+ port);

			// BufferredReader und Printstream zum Lesen und Schreiben erzeugen
			
			
			
			// Senden einer Nachricht �ber einen Stream		
			

			// Antwort �ber einen Stream lesen
			
		

			// Beenden der Kommunikationsverbindung
			socket.close();
		}
		catch (UnknownHostException e)
		{
			System.out.println("Rechenername unbekannt:\n" + e.getMessage());
		}
		catch (IOException e)
		{
			System.out.println("Fehler w�hrend der Kommunikation:\n" + e.getMessage());
		}
		catch (Exception e)
		{
			System.out.println("Fehler w�hrend der Kommunikation:\n" + e.getMessage());
		}
	
	}
}