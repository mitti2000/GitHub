import java.net.ServerSocket;

public class StaticSlave extends Thread{
	private ServerSocket serverSocket;
	private Counter counter;
	
	public StaticSlave(ServerSocket serverSocket, Counter counter)
	{
		this.serverSocket = serverSocket;
		this.counter = counter;
	}
	
	public void run()
	{
		// wait for connection then create stream
		try(TCPSocket tcpSocket = new TCPSocket(serverSocket.accept()))
		{
			while (true)
			{		

				String request = tcpSocket.receiveLine();
				// execute client requets
				int result;
				if(request != null)
				{
					if (request.equals("increment"))
					{
						// increment operation
						result = counter.increment();	
					}
					else if (request.equals("reset"))
					{
						//reset operations
						result = counter.reset();
						System.out.println("Zähler wurde zurückgesetzt");
					}
					else
					{
						result = counter.getCounter();
					}
					tcpSocket.sendLine("" + result);
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
			System.out.println(e);
			System.out.println("-> Schliessen der Verbindung");
		}
	}
}
