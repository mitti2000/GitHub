
public class TCP_Server_Slave extends Thread{
	
	private TCPSocket socket;
	
	public TCP_Server_Slave(TCPSocket socket)
	{
		this.socket = socket;
		System.out.println("TCP_Server_Slave:Salve started");
		this.start();
	}
	
	public void run()
	{
		try(TCPSocket s = socket)
		{
			while (true)
			{
				String request = s.receiveLine();
				// Client Anfrage ausführen
				if (request != null)
				{
					
					try
					{
						int secs = Integer.parseInt(request);
						Thread.sleep(secs * 1000);
					}
					catch (InterruptedException e)
					{
						System.out.println(e);
					}
					s.sendLine(request);
				}
				else
				{
					break;
				}
			}
		}
		catch (Exception e)
		{
			System.out.println(e);;
		}
		System.out.println("TCP_Server_Slave: Verbindung geschlossen");
	}

}
