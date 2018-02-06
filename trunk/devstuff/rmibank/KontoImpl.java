import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.Remote;

public class KontoImpl implements Konto {
    private String name;
    private double kapital;
    public KontoImpl(String name, double kapital) throws RemoteException{
        this.name = name;
        this.kapital = kapital;
    }

    public double getKontostand() throws RemoteException{
        return kapital;
    }

	public String getName() throws RemoteException{
        return name;
    }
	public void abheben(double betrag) throws RemoteException{
        kapital -= betrag;
    }
	public void einzahlen(double betrag) throws RemoteException{
        kapital += betrag;
    }
}