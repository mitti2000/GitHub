import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			Registry registry = LocateRegistry.createRegistry(1099);
		
			KontoManagerImpl server;
			server = new KontoManagerImpl();
			registry.rebind("rmi://localhost/Bank",server);
		}
		catch (Exception e)
		{
			System.out.println(e);
			e.printStackTrace();
		}

	}

}
