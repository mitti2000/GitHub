
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
public class TCPServer extends JFrame
{
	static int port = 2000;
	private JTextArea console;

	public static void main(String args[])
	{
		TCPServer wnd = new TCPServer();
	}
	
	public TCPServer()
	{
		super("TCP Server");
		
		setLayout(new FlowLayout());
		console = new JTextArea(20,60);
		console.setEditable(false);
		add(console);
		this.addWindowListener(new MyWindowListener());
		pack();
		setVisible(true);
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

			console.append("Verbunden mit Rechner: " + client.getInetAddress().getHostName() + " Port: " + client.getPort() + "\n");
		
			// BufferedReader zum Lesen verwenden
			input = new BufferedReader(new InputStreamReader(client.getInputStream()));//			input = client.getInputStream();
			System.out.println("BufferedReader erzeugt");

			// Ankommende Daten lesen		
			String line = null;
			line = input.readLine();		
			console.append("Nachricht empfangen: " + line + "\n");
			
		
			// Dem Client antworten
			output = new PrintStream(client.getOutputStream());
			output.println("Hallo Client");
			output.close();
		
			// Verbindungen beenden
			client.close();
			socket.close();			
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

