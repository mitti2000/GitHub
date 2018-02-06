import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.rmi.Remote;

public class KontoManagerImpl implements KontoManager{
    private ArrayList<Konto> konti;
    public KontoManagerImpl() throws RemoteException
	{
		konti = new ArrayList<Konto>();
	}

    public Konto eroeffnen(String name, double startKapital)throws RemoteException{
        Konto konto = new KontoImpl(name, startKapital);
        konti.add(konto);
        return konto;
    }
}