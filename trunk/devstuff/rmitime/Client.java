import java.rmi.Naming;

public class Client {

	public static void main(String[] args)
	{
		System.out.println(args[0]);
		if (args.length < 2)
		{
			System.out.println("Benötigte Kommandozeilenargumente: <Name des Servers> <Name des Objektes>");
			return;
		}
		try
		{
			TimeService server = (TimeService) Naming.lookup("rmi://" + args[0] + "/" + args[1]);
			System.out.println("Kontakt zum Server hergestellt");
			System.out.println("Get Time");
			System.out.println(server.getTime());
		}
		catch(Exception e)
		{
			System.out.println(e);
			e.printStackTrace();
		}
	}
}
