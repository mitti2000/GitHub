import java.rmi.Remote;
import java.rmi.RemoteException;

interface Konto extends Remote
{
	public double getKontostand() throws RemoteException;
	public String getName() throws RemoteException;
	public void abheben(double betrag) throws RemoteException;
	public void einzahlen(double betrag) throws RemoteException;

}
