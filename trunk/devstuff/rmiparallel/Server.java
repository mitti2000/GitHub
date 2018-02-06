import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			Registry registry = LocateRegistry.createRegistry(1099);
		
			SleepImpl server;
			server = new SleepImpl();
//			Naming.rebind("SleepServer1",server);
			registry.rebind("SleepServer1",server);
			server = new SleepImpl();
//			Naming.rebind("SleepServer2",server);
			registry.rebind("SleepServer2",server);

		}
		catch (Exception e)
		{
			System.out.println(e);
			e.printStackTrace();
		}

	}

}
