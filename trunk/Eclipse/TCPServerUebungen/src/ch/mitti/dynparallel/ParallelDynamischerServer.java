package ch.mitti.dynparallel;

import java.net.ServerSocket;

public class ParallelDynamischerServer {
	
	public static void main(String[] args)
	{
		int counter = 0;
		
		// create socket
		try(ServerSocket serversocket = new ServerSocket(2500))
		{
			while (true)
			{
				// warte auf Verbindungsaufnahme
				System.out.println("ParalleDynamischerServer:Warten auf Verbindungsaufbau");
				try
				{
					TCPSocket tcpSocket = new TCPSocket(serversocket.accept());
					
					new TCP_Server_Slave(tcpSocket);
				}
				catch(Exception e)
				{
					System.out.println("ParalleDynamischerServer:Verbindung geschlossen");
					System.out.println(e);
				}
			}
		}
		catch (Exception e)
		{
			System.out.println("ParalleDynamischerServer:Fehler beim Erzeugen oder Nutzen des ServerSockets");
			return;
		}
	}

}
