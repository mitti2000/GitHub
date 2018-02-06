import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.Remote;

interface KontoManager extends Remote
{
	public Konto eroeffnen(String name, double startKapital)throws RemoteException;
	
	
}