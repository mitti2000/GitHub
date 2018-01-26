import java.net.*;

public class Client {
	public static void main(String[] args)
	{
		if (args.length != 2)
		{
			System.out.println("Notwendige Kommandozeilenparameter: <Servername> <Anzahl>");
			return;
		}
		// Erzeuge Socketverbindung
		System.out.println("Aufbau Verbindung");
		try(TCPSocket tcpSocket = new TCPSocket(args[0], 2500))	
		{
			// Reset counter
			System.out.println("Zähler zurücksetzten");
			tcpSocket.sendLine("reset");
			
			String reply = tcpSocket.receiveLine();
			
			//
			System.out.println("Zähler erhöhen");
			int count = new Integer(args[1]).intValue();
			long startTime = System.currentTimeMillis();
			
			// count-Anzahl mal incrementieren
			for (int i = 0; i < count; i++)
			{
				tcpSocket.sendLine("increment");
				reply = tcpSocket.receiveLine();
			}
			
			// Zeitdauer anzeigen
			long stopTime = System.currentTimeMillis();
			long duration = stopTime - startTime;
			System.out.println("Gesamtzeit =" + duration + " ms");
			
			if (count > 0)
			{
				System.out.println("Durchschnittzeit =" + ((duration) / (float) count) + " ms");
			}
			System.out.println("Zählerstand =" + count);
		}
		catch (Exception e)
		{
			System.out.println(e);;
		}
		System.out.println("TCP-Verbindung geschlossen");
	}

}
