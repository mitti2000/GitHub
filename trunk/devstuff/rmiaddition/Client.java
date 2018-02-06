import java.rmi.Naming;

public class Client {

	public static void main(String[] args)
	{
		System.out.println(args[0]);
		if (args.length < 4)
		{
			System.out.println("Benötigte Kommandozeilenargumente: <Name des Servers> <Name des Objektes> <int a> <int b>");
			return;
		}
		try
		{
			Addition server = (Addition) Naming.lookup("rmi://" + args[0] + "/" + args[1]);
			System.out.println("Kontakt zum Server hergestellt");
			System.out.println("Addiere "+Integer.parseInt(args[2])+" und "+Integer.parseInt(args[3]));
			System.out.println(server.addition(Integer.parseInt(args[2]), +Integer.parseInt(args[3])));
		}
		catch(Exception e)
		{
			System.out.println(e);
			e.printStackTrace();
		}
	}
}
