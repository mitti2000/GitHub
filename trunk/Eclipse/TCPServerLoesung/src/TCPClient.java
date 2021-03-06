

import java.net.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class TCPClient extends JFrame implements ActionListener
{
	static String hostname = "localhost";

	static int port = 2000;

	private JTextField message;
	private JTextField servername;
	private JTextField antwort;
	private JButton send;

	public static void main(String args[])
	{

		TCPClient wnd = new TCPClient();
		wnd.setVisible(true);
	}

	public TCPClient()
	{
		super("TCP Client");

		setLayout( new GridLayout(3,1));
		message = new JTextField(60);
		servername = new JTextField(20);
		servername.setText(hostname);
		antwort = new JTextField(60);
		antwort.setEditable(false);
		send = new JButton("send");
		send.addActionListener(this);

		add(message);
		Panel panel = new Panel();
		panel.setLayout(new FlowLayout());
		panel.add(new Label("Host"));
		panel.add(servername);
		panel.add(send);
		add(panel);
		add(antwort);

		pack();
	}

	public void actionPerformed(ActionEvent event)
	{

		PrintStream output;
		BufferedReader reader = null;

		try
		{
			
			// Verbindung aufbauen
			Socket socket = new Socket (servername.getText(), port);
	//		Socket socket = new Socket ("172.16.4.125", port);
			
			System.out.println("Socket Verbindung "+ port);

			// BufferredReader und Printstream zum Lesen und Schreiben erzeugen
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			output = new PrintStream(socket.getOutputStream());
			
			// Senden einer Nachricht �ber einen Stream		
			output.println(message.getText());

			// Antwort �ber einen Stream lesen
			String line = reader.readLine();
			System.out.println("Von Server empfangen: " + line);
			antwort.setText(line);
		

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