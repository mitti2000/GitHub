import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class SleepImpl extends UnicastRemoteObject implements Sleep {
	
	public SleepImpl() throws RemoteException
	{
		
	}

	public synchronized void sleep(int secs)throws RemoteException
	{
		System.out.println("Server:Beginn von sleep(" + secs + ")");
		try
		{
			Thread.sleep(secs * 1000);
			
		}
		catch (InterruptedException e)
		{
			System.out.println(e);
		}
		System.out.println("Server:Ende von sleep(" + secs + ")");
	}
}
