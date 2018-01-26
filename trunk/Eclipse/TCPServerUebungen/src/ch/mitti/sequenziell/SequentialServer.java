package ch.mitti.sequenziell;

import java.net.ServerSocket;
public class SequentialServer {
	
	public static void main(String[] args)
	{
		int counter = 0;
		
		// create socket
		try(ServerSocket serversocket = new ServerSocket(2500))
		{
			while (true)
			{
				// warte auf Verbindungsaufnahme
				System.out.println("Warten auf Verbindungsaufbau");
				try(TCPSocket tcpSocket = new TCPSocket(serversocket.accept()))
				{
					// Clients ausführen
					while (true)
					{
						String request = tcpSocket.receiveLine();
						if (request != null)
						{
							// Sleep
							try
							{
								int secs = Integer.parseInt(request);
								Thread.sleep(secs * 1000);
							}
							catch (Exception e)
							{
								System.out.println(e);
							}
							tcpSocket.sendLine(request);
						}
						else
						{
							System.out.println("Schliessen der Verbindung");
							break;
						}
					}
				}
				catch(Exception e)
				{
					System.out.println("Verbindung geschlossen");
					System.out.println(e);
				}
			}
		}
		catch (Exception e)
		{
			System.out.println("Fehler beim Erzeugen oder Nutzen des ServerSockets");
			return;
		}
	}

}
