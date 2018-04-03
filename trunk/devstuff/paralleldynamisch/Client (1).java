import java.net.*;

public class Client {
	public static void main(String[] args)
	{
		if (args.length < 2)
		{
			System.out.println("Client:Notwendige Kommandozeilenparameter: <Servername> <Sekundenzahl1> <SekundenzahlN>");
			return;
		}
		// Erzeuge Socketverbindung
		System.out.println("Aufbau Verbindung");
		try(TCPSocket tcpSocket = new TCPSocket(args[0], 2500))	
		{
			// Sleep auf Server anfordern
			for (int i= 1; i < args.length; i++)
			{
				tcpSocket.sendLine(args[i]);
				String result = tcpSocket.receiveLine();
				System.out.println(result);
			}
		}
		catch (Exception e)
		{
			System.out.println(e);;
		}
		System.out.println("Client:TCP-Verbindung geschlossen");
	}

}
