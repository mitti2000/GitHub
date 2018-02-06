import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDateTime;

public class TimeServiceImpl extends UnicastRemoteObject implements TimeService {
	
	public TimeServiceImpl() throws RemoteException
	{
		
	}

	public synchronized LocalDateTime getTime()throws RemoteException
	{
		System.out.println("Give Time");
		return LocalDateTime.now();
	}
}
