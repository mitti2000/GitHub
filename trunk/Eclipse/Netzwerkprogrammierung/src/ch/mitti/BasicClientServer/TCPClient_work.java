package ch.mitti.BasicClientServer;


import java.net.*;
import java.io.*;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;


public class TCPClient_work extends JFrame implements ActionListener
{
	static String hostname = "localhost";

	static int port = 60006;
	
	JPanel panel;
	JTextArea enterMessage;
	JTextArea enterTarget;
	JButton send;
	JTextArea answer;
	JPanel sending;

	

	public static void main(String args[])
	{

		TCPClient_work wnd = new TCPClient_work();
		wnd.setVisible(true);
	}

	public TCPClient_work()
	{
		super("TCP Client");
		
		this.setSize(1000,800);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		enterMessage = new JTextArea(1,50);
		enterMessage.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		enterMessage.setEditable(true);
		
		sending = new JPanel();
		send = new JButton("send");
		send.addActionListener(this);
		enterTarget = new JTextArea(1,20);
		enterTarget.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		enterTarget.setText("localhost");
		sending.add(enterTarget);
		sending.add(send);
		
		answer = new JTextArea(5,50);
		answer.setEditable(false);
		answer.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		
		
		panel.add(enterMessage);
		panel.add(sending);
		panel.add(answer);
		this.add(panel);
		
		this.setVisible(true);
		pack();
	}

	public void actionPerformed(ActionEvent event)
	{

		PrintStream output;
		BufferedReader reader = null;
		String message;
		if(enterMessage.getText()==null) {
			message="no message";
		}
		
		else message = enterMessage.getText(); 

		try
		{
			
			// Verbindung aufbauen
			Socket socket = new Socket(hostname,port);
			
			System.out.println("Socket Verbindung "+ port);

			// BufferredReader und Printstream zum Lesen und Schreiben erzeugen
			output = new PrintStream(socket.getOutputStream());
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			boolean exit = false;
			// Senden einer Nachricht über einen Stream		
			output.println(message);

			// Antwort über einen Stream lesen
			answer.append(reader.readLine());
		
			// Beenden der Kommunikationsverbindung
			socket.close();
		}
		catch (UnknownHostException e)
		{
			System.out.println("Rechenername unbekannt:\n" + e.getMessage());
		}
		catch (IOException e)
		{
			System.out.println("Fehler während der Kommunikation:\n" + e.getMessage());
		}
		catch (Exception e)
		{
			System.out.println("Fehler während der Kommunikation:\n" + e.getMessage());
		}
	
	}
}