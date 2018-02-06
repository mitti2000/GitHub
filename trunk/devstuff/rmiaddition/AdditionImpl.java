import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class AdditionImpl extends UnicastRemoteObject implements Addition {
	
	public AdditionImpl() throws RemoteException
	{
		
	}

	public synchronized int addition(int a, int b)throws RemoteException
	{
		System.out.println("Addiere "+a+" und "+b);
		return a+b;
	}
}
