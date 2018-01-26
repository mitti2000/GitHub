import java.net.ServerSocket;

public class ParallelStaticServer {

	private static final int NUMBER_OF_SLAVES = 20;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ServerSocket serverSocket = null;
		Counter counter = new Counter();
		
		try
		{
			// create socket
			serverSocket = new ServerSocket(2500);
		}
		catch(Exception e)
		{
			System.out.println("ParallelStaticServer:Fehler beim Erzeugen des ServerSockets");
			return;
		}
		for(int i = 0; i < NUMBER_OF_SLAVES; i++)
		{
			Thread t = new StaticSlave(serverSocket, counter);
			t.start();
		}
	}
}
